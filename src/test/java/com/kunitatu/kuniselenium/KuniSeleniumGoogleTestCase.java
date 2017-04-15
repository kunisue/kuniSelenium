package com.kunitatu.kuniselenium;

import org.junit.Test;
import org.openqa.selenium.By;

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
