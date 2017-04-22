package com.cdoss.selenium.template;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import ru.stqa.selenium.factory.WebDriverPool;

/**
 * 
 */

/**
 * @author chand
 *
 */
public class SeleniumTestCase {
	
	private WebDriver driver;
	
	private String url = "http://www.google.com/";
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SystemProperty props = new SystemProperty();
		props.setSystemProperty(SeleniumTestConstants.BROWSER_CHROME);
		props.setSystemProperty(SeleniumTestConstants.BROWSER_FIREFOX);
		props.setSystemProperty(SeleniumTestConstants.BROWSER_IE);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Capabilities chrome = DesiredCapabilities.chrome();
		driver = WebDriverPool.DEFAULT.getDriver(chrome);
		driver.get(url);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		WebDriverPool.DEFAULT.dismissAll();
	}

	@Test
	public void test() {
		
	}

}
