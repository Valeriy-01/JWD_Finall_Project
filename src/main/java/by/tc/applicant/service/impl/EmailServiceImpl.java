package by.tc.applicant.service.impl;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import by.tc.applicant.dao.pool.ConnectionPool;
import by.tc.applicant.dao.pool.manager.EmailConfiguration;
import by.tc.applicant.service.EmailService;

public class EmailServiceImpl implements EmailService {

	private static EmailServiceImpl instance;
	private final EmailConfiguration emailConfiguration = EmailConfiguration.getInstance();
	private final static Logger log = Logger.getLogger(ConnectionPool.class);

	private static final String THEME = "Приёмная кампания";
	private static final String TEXT_CONTENT = "Списки зачисленных были сформированны! "
			+ "Вы можете ознакомиться с результатами поступления в личном кабинете!";

	public static EmailServiceImpl getInstance() {
		if (instance == null) {
			instance = new EmailServiceImpl();
		}
		return instance;
	}

	@Override
	public void sendMessage(String userEmail) {
		Transport transport = null;
		try {

			Session mailSession = Session.getDefaultInstance(emailConfiguration.getPropertiesSessionDefaultInstance());
			MimeMessage message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress(emailConfiguration.getAdminName()));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));

			message.setSubject(THEME);
			message.setText(TEXT_CONTENT);

			transport = mailSession.getTransport();
			transport.connect(emailConfiguration.getAdminName(), emailConfiguration.getPassword());

			transport.sendMessage(message, message.getAllRecipients());
		} catch (MessagingException e) {
			log.error("Error sending letter", e);
		} finally {
			try {
				if (transport != null) {
					transport.close();
				}
			} catch (MessagingException e) {
				log.error("Error close mail transport", e);
			}
		}

	}
}