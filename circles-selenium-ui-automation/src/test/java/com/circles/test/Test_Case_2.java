package com.circles.test;

import java.text.BreakIterator;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import com.circles.pages.HomePageObjet;
import com.driver.base.DriverBase;

public class Test_Case_2 extends DriverBase {

	private boolean assertPassed;

	@Test(priority = 1)
	public void loadPage() {

		driver.navigate().to(url);

		driver.manage().window().maximize();
	}

	@Test(priority = 2)
	public void goToSubMenu() {

		HomePageObjet home = new HomePageObjet(driver);

		home.hoverCategoryItem("TV & Home Appliances", "TV Accessories");

		String[] expectedMenu = new String[] { "TV & Video Devices", "Home Audio", "TV Accessories", "Large Appliances",
				"Small Kitchen Appliances", "Cooling & Air Treatment", "Vacuums & Floor Care",
				"Personal Care Appliances", "Parts & Accessories"

		};

		for (WebElement element : driver.findElements(By.xpath("//*[contains(@data-cate,'cate_3')]"))) {
			System.out.println("Element Text: " + element.getText());
			assertPassed = false;

			for (int i = 0; i < expectedMenu.length; i++) {

				if (element.getText().equals(expectedMenu[i])) {
					assertPassed = true;
					break;
				}

			}

			if (!assertPassed) {
				Assert.fail();
				return;
			}

		}

		home.hoverCategoryItem("TV Accessories", "TV Remote Controllers");

		String[] expectedLeafMenu = new String[] { "Antennas", "TV Receivers", "TV Remote Controllers", "Cables",
				"Wall Mounts & Protectors", "TV Adapters", "3D Glasses" };

		List<WebElement> anchors = driver.findElements(By.className("lzd-site-menu-grand-item"));

		Iterator<WebElement> iterator = anchors.iterator();

		while (iterator.hasNext()) {

			WebElement anchor = iterator.next();

			if (anchor.getText() != null && !anchor.getText().isEmpty()) {

				System.out.println("Leaf Element Text: " + anchor.getText().toString().trim());

				assertPassed = false;

				for (int i = 0; i < expectedLeafMenu.length; i++) {

					if (anchor.getText().toString().trim().contentEquals(expectedLeafMenu[i].toString())) {
						assertPassed = true;
						break;
					}
				}

				if (!assertPassed) {
					Assert.fail();
					return;
				}
			}

		}

	}

}
