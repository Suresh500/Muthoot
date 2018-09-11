package com.Cogniphy.Protection.Muthoot.Reports;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Cogniphy.Protection.Muthoot.Utility.BaseClass;

public class ERT_Performance_Page extends BaseClass {
	/*
	 * @FindBy(how = How.XPATH , using =
	 * "//*[@class='sidebar-menu menu-open']/li[1]")
	 * 
	 * @CacheLookup WebElement ertPerformance ;
	 */

	public static void navi_To_ERTPerfmnce() {
		driver.findElement(By.xpath(reader.get("ertPerformance_xpath"))).click();
	}

	public static void verify_Page_Title() {
		String text = driver.findElement(By.xpath(reader.get("tab_title_xpath"))).getText();
		Assert.assertEquals("ERT PERFORMANCE", text, "Does not match");
		System.out.println("Title verified Succesfully");
	}

	// It is returning date Perfectly for FUTURE USE
	public static String DayBefore() {
		String DayBefore = "";
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, -1);
		Date before = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MM");
		DayBefore = formatter.format(before);
		//System.out.println(DayBefore);
		return DayBefore;
	}
	public static void select_Yestreday_Date() {
		 WebDriverWait wait = new WebDriverWait(driver, 300);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(reader.get("dateFilter_css"))));
		 driver.findElement(By.cssSelector(reader.get("dateFilter_css"))).click();
		 System.out.println("clicked on date filter");
		 WebElement ele = driver.findElement(By.xpath(reader.get("per_date_xpath")));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.get("per_date_xpath"))));
		 List<WebElement> dates = ele.findElements(By.tagName("td"));
		 for (WebElement element : dates) {
			if(element.getText().equals(DayBefore()))
			 
			 {
				System.out.println(element.getText());
				 element.click();
			 }	
		}
		new Select(driver.findElement(By.id("sessionId"))).selectByVisibleText("Morning ERT");
		driver.findElement(By.xpath(reader.get("button_xpath"))).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public static void Verify_Tab_status_column() {
		if(driver.findElement(By.xpath(reader.get("tabStatus_xpath"))).isDisplayed()) {
			Boolean check = driver.findElement(By.xpath(reader.get("chargeStatus_xpath"))).isDisplayed();
			System.out.println("Tab status Contains charge status column "+ check );
		}
	}
	
	public static void Verify_ManualAttend_for_eachERT() {
		List<WebElement> erts = driver.findElements(By.xpath(reader.get("erts_xpath")));
		for(WebElement text : erts) {
			System.out.println(text.getText());
		}
		
		
	}
}
	    



