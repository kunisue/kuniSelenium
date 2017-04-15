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
public class KuniSeleniumGoogle extends TestCase {

	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.ie.driver", "C:\\app\\IEDriverServer\\IEDriverServer.exe");

		InternetExplorerDriverService.Builder builder = new InternetExplorerDriverService.Builder();

		InternetExplorerDriverService service = builder.usingPort(5555).withHost("127.0.0.1").build();

		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

		driver = new InternetExplorerDriver(service, caps);
	}

	@After
	public void quit() throws Exception {
		driver.quit();
	}
	
	public void driverWait(){
		new WebDriverWait(driver, 10);
	}

	public void screenShot(String folder, String fileName) throws Exception {
		FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
				new File("target\\image\\" + folder + "\\" + fileName));
	}

	@Test
	public void test001() throws Exception {

		driver.get("https://www.google.co.jp/");
		this.driverWait();

		this.screenShot("test001", "KuniSeleniumGoogle-test001-001.png");

		driver.findElement(By.id("lst-ib")).sendKeys("jenkins");
		this.screenShot("test001", "KuniSeleniumGoogle-test001-002.png");
		
		//driver.findElement(By.name("btnK")).click();
		driver.findElement(By.id("lst-ib")).submit();
		this.driverWait();
		this.screenShot("test001", "KuniSeleniumGoogle-test001-003.png");
		
	}

	/*
	 * public interface WebDriverFactory {
	 * 
	 * public WebDriver create();
	 * 
	 * }
	 * 
	 * public static Iterable<WebDriverFactory> getDriverFactories() {
	 * ArrayList<WebDriverFactory> factories = new
	 * ArrayList<WebDriverFactory>(); factories.add(new WebDriverFactory() {
	 * 
	 * @Override public WebDriver create() { return new FirefoxDriver(); } });
	 * factories.add(new WebDriverFactory() {
	 * 
	 * @Override public WebDriver create() { return new ChromeDriver(); } });
	 * return factories; }
	 * 
	 * // おためし：コードに直接書くべきではない・・・ private static final String url =
	 * "https://..."; private static final String id = "hogehoge"; private
	 * static final String password = "fugafuga";
	 * 
	 * @Test public void testXXX() throws Exception { for (WebDriverFactory
	 * factory : getDriverFactories()) { WebDriver driver = factory.create();
	 * try { driver.get(url); Wait<WebDriver> wait = new WebDriverWait(driver,
	 * 30);
	 * 
	 * // Login page WebElement button =
	 * wait.until(ExpectedConditions.elementToBeClickable(By.className(
	 * "btn-primary")));
	 * assertTrue(driver.getTitle().contains("YYY Dashboard"));
	 * assertTrue(driver.getTitle().contains("Login") ||
	 * driver.getTitle().contains("ログイン"));
	 * driver.findElement(By.id("id_username")).sendKeys(id);
	 * driver.findElement(By.id("id_password")).sendKeys(password);
	 * button.submit();
	 * 
	 * // Top page WebElement linkElement = wait
	 * .until(ExpectedConditions.elementToBeClickable(By.xpath(
	 * "//a[@href='/path/to/xxx']"))); linkElement.sendKeys(Keys.ENTER);
	 * 
	 * // XXX page
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("xxx")));
	 * assertTrue(driver.getTitle().contains("YYY Dashboard"));
	 * assertTrue(driver.getTitle().contains("XXX"));
	 * 
	 * FileUtils.copyFile(((TakesScreenshot)
	 * driver).getScreenshotAs(OutputType.FILE), new
	 * File(driver.getClass().getName() + "-xxx.png")); } finally {
	 * driver.quit(); } } }
	 */
}
