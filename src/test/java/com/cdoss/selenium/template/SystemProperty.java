package com.cdoss.selenium.template;

import com.cdoss.selenium.template.exceptions.SystemPropertyException;

public class SystemProperty {

	public SystemProperty() {
		this.os = System.getProperty("os.name").toLowerCase();
	}

	private String os;

	public String getOs() {
		return os;
	}

	public void setSystemProperty(String webDriver) throws SystemPropertyException {
		switch (webDriver) {
			case SeleniumTestConstants.BROWSER_CHROME:
				System.setProperty(SeleniumTestConstants.WEB_DRIVER_PROP_CHROME,
						getWebDriverPath(SeleniumTestConstants.WEB_DRIVER_FILE_CHROME));
				break;
			case SeleniumTestConstants.BROWSER_FIREFOX:
				System.setProperty(SeleniumTestConstants.WEB_DRIVER_PROP_FIREFOX,
						getWebDriverPath(SeleniumTestConstants.WEB_DRIVER_FILE_FIREFOX));
				break;
			case SeleniumTestConstants.BROWSER_IE:
				System.setProperty(SeleniumTestConstants.WEB_DRIVER_PROP_IE,
						getWebDriverPath(SeleniumTestConstants.WEB_DRIVER_FILE_IE));
				break;
			default:
				throw new SystemPropertyException(webDriver);
		}
	}

	private String getWebDriverPath(String webDriverName) {
		String path = buildWebDriverPath(webDriverName);
		String driverPath = SystemProperty.class.getClassLoader().getResource(path).getPath().toString();

		return driverPath;
	}

	private String buildWebDriverPath(String file) {
		String path;
		if (os.contains(SeleniumTestConstants.WIN)) {
			path = SeleniumTestConstants.WEB_DRIVER_FOLDER + SeleniumTestConstants.FORWARD_SLASH
					+ SeleniumTestConstants.WIN + SeleniumTestConstants.FORWARD_SLASH + file
					+ SeleniumTestConstants.PERIOD + SeleniumTestConstants.WIN_FILE_EXTEN_EXE;
		} else {
			path = SeleniumTestConstants.WEB_DRIVER_FOLDER + SeleniumTestConstants.FORWARD_SLASH
					+ SeleniumTestConstants.MAC + SeleniumTestConstants.FORWARD_SLASH + file;
		}
		return path;
	}
}
