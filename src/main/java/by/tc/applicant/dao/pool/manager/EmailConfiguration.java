package by.tc.applicant.dao.pool.manager;

import java.util.Properties;

public class EmailConfiguration {
	private static EmailConfiguration instance;

	private final String MAIL_SMTP_AUTH = "mail.smtp.auth";
	private final String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
	private final String MAIL_SMTP_HOST = "mail.smtp.host";
	private final String MAIL_SMTP_PORT = "mail.smtp.port";
	private final String MAIL_USERNAME = "mail.username";
	private final String MAIL_PASSWORD = "mail.password";
	private final String MAIL_PROTOCOL = "mail.protocol";

	private final Properties propertiesSessionDefaultInstance = new Properties();
	private String adminName;
	private String password;

	public static EmailConfiguration getInstance() {
		if (instance == null) {
			instance = new EmailConfiguration();
		}
		return instance;
	}

	private EmailConfiguration() {
		EmailResourceManager emailResourceManager = EmailResourceManager.getInstance();
		this.propertiesSessionDefaultInstance.put(MAIL_PROTOCOL, emailResourceManager.getValue(MAIL_PROTOCOL));
		this.propertiesSessionDefaultInstance.put(MAIL_SMTP_AUTH, emailResourceManager.getValue(MAIL_SMTP_AUTH));
		this.propertiesSessionDefaultInstance.put(MAIL_SMTP_STARTTLS_ENABLE,
				emailResourceManager.getValue(MAIL_SMTP_STARTTLS_ENABLE));
		this.propertiesSessionDefaultInstance.put(MAIL_SMTP_HOST, emailResourceManager.getValue(MAIL_SMTP_HOST));
		this.propertiesSessionDefaultInstance.put(MAIL_SMTP_PORT, emailResourceManager.getValue(MAIL_SMTP_PORT));
		this.adminName = emailResourceManager.getValue(MAIL_USERNAME);
		this.password = emailResourceManager.getValue(MAIL_PASSWORD);
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Properties getPropertiesSessionDefaultInstance() {
		return propertiesSessionDefaultInstance;
	}

}
