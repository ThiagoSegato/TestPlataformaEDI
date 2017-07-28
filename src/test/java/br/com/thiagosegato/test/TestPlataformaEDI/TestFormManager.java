package br.com.thiagosegato.test.TestPlataformaEDI;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


	
public class TestFormManager {

	private WebDriver driver;
	
	@Before	
	public void init() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void part1() {
		driver.get("http://localhost/iprede/");
		WebElement user = driver.findElement(By.id("user"));
		WebElement pass = driver.findElement(By.id("pass"));
		user.sendKeys("admin");
		pass.sendKeys("123");
		
		driver.findElement(By.className("btn-success")).click();
		
		System.out.println(driver.getPageSource());
		assertTrue(driver.getPageSource().contains("<b>USUÁRIO ADMINISTRADOR</b>"));
	}
	
	@After
	public void finish() {
		driver.close();
	}
	
}
