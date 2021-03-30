package by.tc.finalproject.controller.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import by.tc.finalproject.dao.pool.ConnectionPool;
import by.tc.finalproject.dao.pool.exception.ConnectionPoolException;

public class WebListener implements ServletContextListener {
	private final static Logger log = Logger.getLogger(ConnectionPool.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ConnectionPool.getInstance();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		try {
			ConnectionPool.getInstance().destroy();
		} catch (ConnectionPoolException e) {
			log.error("Error while closing connection pool");
		}
	}
}
