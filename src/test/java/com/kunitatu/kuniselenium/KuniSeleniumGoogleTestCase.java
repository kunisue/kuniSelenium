package com.kunitatu.kuniselenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * test code.
 * 
 * @author kunit
 *
 */
public class KuniSeleniumGoogleTestCase extends AbstractKuniSelenium {

	@Test
	public void test001() throws Exception {

		driver.get("https://www.google.co.jp/");

		this.screenShot("test001", "KuniSeleniumGoogleTestCase-test001-001.png");

		driver.findElement(By.id("lst-ib")).sendKeys("jenkins");
		this.screenShot("test002", "KuniSeleniumGoogleTestCase-test001-002.png");

		driver.findElement(By.id("lst-ib")).submit();
		// 特別にタイムアウトを指定する場合
		new WebDriverWait(driver, 30).until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				return d.findElement(By.id("lst-ib"));
			}
		});
		this.screenShot("test003", "KuniSeleniumGoogleTestCase-test001-003.png");

	}

}
