package com.amazon.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.amazon.base.Base;

public class TestCase extends Base {

	String ProductTitle;
	
	@Test(priority = 1)
	public void LoginTest() throws InterruptedException {
		System.out.println("----Login----");
		// WebElement SignIn=driver.findElement(By.xpath("//span[contains(text(),'Hello,
		// Sign in')]"));
		WebElement SignIn = driver.findElement(By.xpath("//span[@class='nav-line-2'][contains(text(),'Account & Lists')]"));
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.moveToElement(SignIn).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][contains(text(),'Sign in')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("ap_email")).sendKeys("gojek.test23@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("Abc@1234");
		driver.findElement(By.id("signInSubmit")).click();
		System.out.println("Login Successful");
		Thread.sleep(5000);
	}

	@Test(priority = 4)
	public void LogoutTest() throws InterruptedException {
		System.out.println("----Logout----");
		WebElement Signout = driver
				.findElement(By.xpath("//span[@class='nav-line-2'][contains(text(),'Account & Lists')]"));
		Actions action = new Actions(driver);
		action.moveToElement(Signout).perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(text(),'Sign Out')]")).click();
		System.out.println("Sign out Successfully");

	}

	@Test(priority = 2)
	public void AddHeadPhone() throws InterruptedException {
		// driver.navigate().to(config.getProperty("testsiteurl"));
		WebElement Dept = driver.findElement(By.xpath("//span[contains(text(),'Departments')]"));
		Actions action = new Actions(driver);
		action.moveToElement(Dept).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Electronics')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'HEADPHONES')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='s-result-list s-search-results sg-row']/div[1]//div[2]//h2//span"))
				.click();
		Thread.sleep(5000);
		System.out.println("Clicked on first headphone");
		String ProductTitle=driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void SearchMacbook() throws InterruptedException {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Macbook Pro");
		driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='s-result-list s-search-results sg-row']/div[2]//div[2]//h2//span"))
				.click();
		Thread.sleep(3000);

		Select dropdown = new Select(
				driver.findElement(By.xpath("//*[@class=\"a-dropdown-container\"]//*[@id='quantity']")));
		dropdown.selectByValue("2");
		System.out.println("Dropdown Selected");
		Thread.sleep(2000);
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(3000);

	}

	@Test(priority = 4)
	public void DeleteItem() throws InterruptedException {
		 driver.get(config.getProperty("testsiteurl"));
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//span[@class='nav-cart-icon nav-sprite']")).click();
		

	}

}
