package com.gmail;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailEx {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Please Enter Your EmailId : ");
		String user = sc.nextLine();

		System.out.println("Please Enter Your Password : ");
		String pass = sc.nextLine();

		System.setProperty("webdriver.chrome.driver", "E:\\Java By Kiran\\Gmail\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.gmail.com");

		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, 20);

		Actions action = new Actions(driver);
		
		// ===================================================================================================================

		//first Login with Chrome
		
		WebElement email = wait.ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));

		email.clear();

		email.sendKeys(user);

		WebElement emailNext = wait.ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ZFr60d CeoRYc']")));

		action.moveToElement(emailNext).click().build().perform();

		WebElement password = wait.ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));

		password.sendKeys(pass);

		WebElement passwordNext = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));

		action.moveToElement(passwordNext).click().build().perform();

		// ===================================================================================================================

		//Second Login with Firefox
		
		WebDriver ff = new FirefoxDriver();

		ff.get("https://www.gmail.com");

		System.out.println("Please Enter Your EmailId : ");
		String newUser = sc.nextLine();

		System.out.println("Please Enter Your Password : ");
		String newPass = sc.nextLine();

		ff.manage().window().maximize();

		email.sendKeys(newUser);

		action.moveToElement(emailNext).click().build().perform();

		password.sendKeys(newPass);

		action.moveToElement(passwordNext).click().build().perform();

		// ===================================================================================================================

		while (user.equalsIgnoreCase(newUser)) {

			System.out.println("User is already logged in..!!");
			break;
		}

		// ===================================================================================================================

		// ===================================================================================================================

		WebElement gmailDp = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='gb_yagbii']")));

		gmailDp.click();

		WebElement signOut = driver.findElement(By.id("gb_71"));

		signOut.click();

	}

}
