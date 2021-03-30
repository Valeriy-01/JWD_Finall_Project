package by.tc.finalproject.dao.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.apache.log4j.Logger;
import by.tc.finalproject.dao.pool.exception.ConnectionPoolException;
import by.tc.finalproject.dao.pool.manager.DBParameter;
import by.tc.finalproject.dao.pool.manager.DBResourceManager;

public final class ConnectionPool {

	private BlockingQueue<Connection> connectionQueue;
	private final static Logger log = Logger.getLogger(ConnectionPool.class);

	private final String driverName;
	private final String url;
	private final String user;
	private final String password;
	private int poolSize;
	private static volatile ConnectionPool instance;

	private ConnectionPool() {
		DBResourceManager databaseManager = DBResourceManager.getInstance();
		this.driverName = databaseManager.getValue(DBParameter.DB_DRIVER);
		this.url = databaseManager.getValue(DBParameter.DB_URL);
		this.user = databaseManager.getValue(DBParameter.DB_USER);
		this.password = databaseManager.getValue(DBParameter.DB_PASSWORD);
		try {
			this.poolSize = Integer.parseInt(databaseManager.getValue(DBParameter.DB_POLL_SIZE));
		} catch (NumberFormatException e) {
			this.poolSize = 10;
		}
		init();
	}

	public static ConnectionPool getInstance() {
		if (instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}

	public void init() {
		connectionQueue = new ArrayBlockingQueue<>(poolSize);
		try {
			registerDriver();
			for (int i = 0; i < poolSize; i++) {
				connectionQueue.add(createConnection());
			}
		} catch (ConnectionPoolException e) {
			log.error("Can't create ConnectionPool");
		}

	}

	private Connection createConnection() throws ConnectionPoolException {
		try {
			log.info("DataBase connection created");
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			log.error("Can't create database connection", e);
			throw new ConnectionPoolException("Can't create database connection", e);
		}
	}

	public Connection getConnection() throws ConnectionPoolException {
		try {
			return connectionQueue.take();
		} catch (InterruptedException e) {
			log.error("Can't take connection");
			throw new ConnectionPoolException("Can't take connection", e);
		}
	}

	public void releaseConnection(final Connection connection) {
		connectionQueue.add(connection);
	}

	public int getAvailableConnections() {
		return connectionQueue.size();
	}

	private void registerDriver() throws ConnectionPoolException {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			log.fatal("Can't register Driver dataBase ", e);
			throw new ConnectionPoolException("Database driver connection failed", e);
		}
	}

	public void destroy() throws ConnectionPoolException {
		try {
			for (Connection connection : connectionQueue) {
				connection.close();
			}
			instance = null;
		} catch (SQLException e) {
			throw new ConnectionPoolException("Can't destroy connection pool ", e);
		}
	}

	public void closeConnection(Connection connection, PreparedStatement preparedStatement) {
		try {
			connection.close();
		} catch (SQLException e) {
			log.error("Can't destroy close connection ", e);
		}
		try {
			preparedStatement.close();
		} catch (SQLException e) {
			log.error("Can't destroy close statement ", e);
		}

	}

	public void closeConnection(PreparedStatement preparedStatement) {
		try {
			preparedStatement.close();
		} catch (SQLException e) {
			log.error("Can't destroy close statement ", e);
		}

	}

}