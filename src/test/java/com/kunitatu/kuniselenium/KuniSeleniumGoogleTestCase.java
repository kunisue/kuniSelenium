package com.kunitatu.kuniselenium;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
/**
 * @author kunit
 *
 */
public class KuniSeleniumGoogleTestCase extends AbstractKuniSelenium {

	@Test
	public void test001() throws Exception {

		driver.get("https://www.google.co.jp/");
		this.driverWait();

		this.screenShot("test001", "KuniSeleniumGoogleTestCase-test001-001.png");

		driver.findElement(By.id("lst-ib")).sendKeys("jenkins");
		this.screenShot("test001", "KuniSeleniumGoogleTestCase-test001-002.png");

		// driver.findElement(By.name("btnK")).click();
		driver.findElement(By.id("lst-ib")).submit();
		this.driverWait();
		this.screenShot("test001", "KuniSeleniumGoogleTestCase-test001-003.png");

	}

}
