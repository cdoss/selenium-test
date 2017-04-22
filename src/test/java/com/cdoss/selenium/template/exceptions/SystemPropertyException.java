package com.cdoss.selenium.template.exceptions;

@SuppressWarnings("serial")
public class SystemPropertyException extends Exception {

	public SystemPropertyException() {
		super();
	}

	public SystemPropertyException(String webDriver) {
		super("There is no property for " + webDriver);
	}

}
