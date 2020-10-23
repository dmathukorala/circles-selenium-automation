package com.circles.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import com.circles.pages.HomePageObjet;
import com.driver.base.DriverBase;

public class Test_Case_1 extends DriverBase {

	@Test(priority = 1)
	public void loadPage() {

		driver.navigate().to(url);

		driver.manage().window().maximize();
	}

	@Test(priority = 2)
	public void goToSubMenu() {

		try {

			HomePageObjet home = new HomePageObjet(driver);

			home.hoverCategoryItem("TV & Home Appliances", "TV Accessories");

			home.hoverCategoryItem("TV Accessories", "TV Remote Controllers");

			home.clickCategoryItem("TV Remote Controllers");

			Thread.sleep(5000);

			Assert.assertTrue(driver.findElement(By.xpath("//span[text()='TV Remote Controllers']")).isDisplayed());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}

	}

}
