package com.circles.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObjet {

	private static WebDriver driver;
	private static WebElement categoryElement;
	private static Actions action;
	private WebDriverWait wait;

	public HomePageObjet(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}

	public void hoverCategoryItem(String parent, String child) {

		action = new Actions(driver);

		categoryElement = driver.findElement(By.xpath("//span[text()='" + parent + "']"));

		action.moveToElement(categoryElement).perform();

		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(categoryElement,
				By.xpath("//span[text()='" + child + "']")));
	}

	public void clickCategoryItem(String name) {

		categoryElement = driver.findElement(By.xpath("//span[text()='" + name + "']"));

		categoryElement.click();

	}

}
