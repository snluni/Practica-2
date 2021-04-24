package es.urjc.code.daw.library.web;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;

class TestWebInterface {
	WebDriver driver;
	@BeforeAll
	static void setUpBeforeClass(){
		WebDriverManager.firefoxdriver().setup();
	}

	@BeforeEach
	void setUp() {
		driver = new FirefoxDriver();
	}

	@AfterEach
	void tearDown(){
		if(driver != null)
			driver.quit();
	}

	@Test
	void addBookAndCheckIfItWasCreated() throws InterruptedException {
		WebElement newBookButton;
		WebElement bookTitleForm;
		WebElement bookDescriptionForm;
		WebElement saveButton;
		WebElement allBooksButton;
		WebDriverWait wait = new WebDriverWait(driver,15);
		driver.get("localhost:8080");
	
		newBookButton = wait.until(presenceOfElementLocated(By.id("newBookButton")));
		newBookButton.click();
		bookTitleForm = wait.until(presenceOfElementLocated(By.name("title")));
		bookTitleForm.sendKeys("A wolf in the sky");
		bookDescriptionForm = wait.until(presenceOfElementLocated(By.name("description")));
		bookDescriptionForm.sendKeys("About a wolf which lives incredible adventures through the sky");
		saveButton = wait.until(presenceOfElementLocated(By.id("Save")));
		saveButton.click();
		allBooksButton = wait.until(presenceOfElementLocated(By.id("allBooksButton")));
		allBooksButton.click();
		assertNotNull(driver.findElement(By.linkText("A wolf in the sky")));
		
		
		
	}
	
	@Test
	void removeBookAndCheckIfItDoesNotExist()  {
		WebElement bookLink;
		WebElement removeButton;
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.get("localhost:8080");
		bookLink = wait.until(presenceOfElementLocated(By.linkText("SUEÑOS DE ACERO Y NEON")));
		bookLink.click();
		removeButton= wait.until(presenceOfElementLocated(By.id("removeButton")));
		removeButton.click();
		assertThrows(NoSuchElementException.class,()->{
			driver.findElement(By.linkText("SUEÑOS DE ACERO Y NEON"));
		});
	}
}
