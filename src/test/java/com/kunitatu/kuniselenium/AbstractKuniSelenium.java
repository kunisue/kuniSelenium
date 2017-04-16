package com.kunitatu.kuniselenium;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractKuniSelenium {

	public WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.ie.driver", "C:\\app\\IEDriverServer\\IEDriverServer.exe");

		InternetExplorerDriverService.Builder builder = new InternetExplorerDriverService.Builder();

		InternetExplorerDriverService service = builder.usingPort(5555).withHost("127.0.0.1").build();

		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

		driver = new InternetExplorerDriver(service, caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	public void screenShot(String folder, String fileName) throws Exception {
		FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
				new File("target\\image\\" + folder + "\\" + fileName));
	}
}
