package com.Cogniphy.Protection.Muthoot.Reports;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Cogniphy.Protection.Muthoot.Utility.BaseClass;
import com.Cogniphy.Protection.Muthoot.Utility.WebTable;

public class Reports extends BaseClass{
	static int i;
	static int j;
	static int dRow_counr;
	static int dCol_counr;
	
	public static void navigate_To_Reports() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(reader.get("report_xpath"))).click();
		driver.manage().window().maximize();
	}
	public static void navigate_To_Daily_Reports() {
		driver.findElement(By.xpath(reader.get("daily_Reportt"))).click();
	}
	
	public static void fetch_Daily_report() throws Exception {
		 WebDriverWait wait = new WebDriverWait(driver, 300);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(reader.get("dateFilter_css"))));
		 driver.findElement(By.cssSelector(reader.get("dateFilter_css"))).click();
		 System.out.println("clicked on date filter");
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.get("datePickerPreviousButton_xpath"))));
		 driver.findElement(By.xpath(reader.get("datePickerPreviousButton_xpath"))).click();
		 System.out.println("clicked on previous button");
		 driver.findElement(By.xpath(reader.get("6th_dec_xpath"))).click();
		 System.out.println("selected date");
		 driver.findElement(By.xpath(reader.get("apply_Xpath"))).click();
		 new Select(driver.findElement(By.xpath(reader.get("sessionFilter_xpath")))).selectByVisibleText("Morning ERT");
		 System.out.println("clicked on apply button");
		 driver.findElement(By.xpath(reader.get("submit_xpaht"))).click();
		 System.out.println("clicked submitt button");
		 
	}
	static String[][] appData = null ;
	public static void fetch_Data_From_Daily_Report() {
		 String first_part = "//table[@id='RptTable']/tbody/tr[";
		 String second_part = "]/td[";
		 String third_part = "]";
		 dRow_counr=driver.findElements(By.xpath("//table[@id='RptTable']/tbody/tr[.]")).size()+1;
		 dCol_counr=driver.findElements(By.xpath("//table[@id='RptTable']/tbody/tr[1]/td[.]")).size()+1;
		
		
		System.out.println("row count is "+dRow_counr +"col count is "+dCol_counr);
		
		appData=new String[dRow_counr][dCol_counr];
		
		for (i = 1; i < dRow_counr; i++) {
		for (j = 1; j < dCol_counr; j++) {
		String final_xpath = first_part+i+second_part+j+third_part;
		appData[i][j]=driver.findElement(By.xpath(final_xpath)).getText();
	    System.out.println(appData[i][j]);
		}
		
		}
		
	}
	static String[][] dates = null ;
	static int DPRowcount;
	static int DPcolcount;
	static int counter = 0;
	public static void validate_Date_Picker() {
		
		 WebDriverWait wait = new WebDriverWait(driver, 300);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(reader.get("dateFilter_css"))));
		 driver.findElement(By.cssSelector(reader.get("dateFilter_css"))).click();
		 System.out.println("clicked on date filter");
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.get("per_date_xpath"))));
		 driver.findElement(By.xpath(reader.get("per_date_xpath")));
		 String first_part = "//div[10]/div[1]/div/table/tbody/tr[";
		 String second_part = "]/td[" ;
		 String third_part = "]" ;
		 DPRowcount=driver.findElements(By.xpath("//div[10]/div[1]/div/table/tbody/tr")).size();
		 DPcolcount=driver.findElements(By.xpath("//div[10]/div[1]/div/table/tbody/tr[1]/td")).size();
		 
		
		System.out.println("row count is "+ DPRowcount +"col count is "+ DPcolcount);
		
		appData=new String[DPRowcount][DPcolcount];
		
		for (i = 1; i < DPRowcount; i++) {
		for (j = 1; j < DPcolcount; j++) {
		String final_xpath = first_part+i+second_part+j+third_part;
		if(driver.findElement(By.xpath(final_xpath)).isEnabled()) {
		appData[i][j]=driver.findElement(By.xpath(final_xpath)).getText();
		System.out.println(appData[i][j]);
		}else {
			System.out.println();
		}
		}
		
		}
	}
	
	
	
	
	
	
	
	
	//--------------------------------ERTSummary Page-------------------------------------------------------------
	
	public static void navigate_to_ERTSummary_Report() {
    	driver.findElement(By.xpath(reader.get("ertsummary_xpath"))).click();
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
	public static void fetchSummuryRepot() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 300);
		driver.findElement(By.cssSelector(reader.get("dateFilter_css"))).click();
		System.out.println("clicked on datefilter to fetch valid summary");
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(reader.get("datePickerPreviousButton_xpath"))));
		 driver.findElement(By.xpath(reader.get("datePickerPreviousButton_xpath"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(reader.get("6th_dec_xpath"))));
		driver.findElement(By.xpath(reader.get("6th_dec_xpath"))).click();
		System.out.println("clicked on date");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(reader.get("apply_Xpath"))));
		driver.findElement(By.xpath(reader.get("apply_Xpath"))).click();
		System.out.println("clicked on apply");
		WebElement element = driver.findElement(By.xpath(reader
				.get("clientFilter_xpath")));
		element.click();
		List<WebElement> list = element.findElements(By.xpath(reader
				.get("clientFilterText_xpath")));
		for (WebElement droptext : list) {
			if (droptext.getText().equals("ALL")) {
				droptext.click();
			}
		}
		System.out.println("selected all client");
		new Select(driver.findElement(By.xpath(reader.get("sessionFilter_xpath")))).selectByVisibleText("Morning ERT");
		driver.findElement(By.xpath(reader.get("submit_xpaht"))).click();
		System.out.println("Clicked on submit Button");
	}
	static String[][] summData = null ;
	static int k;
	static int l;
	static int sRow_counr;
	static int sCol_counr;
	public static void fetch_Data_From_summ_Report() throws Exception {
		  
		 sRow_counr=driver.findElements(By.xpath("//table[@class='innermaintable cell-border ']/tbody/tr[.]")).size();
		 sCol_counr=driver.findElements(By.xpath("//table[@class='innermaintable cell-border ']/tbody/tr[1]/td[.]")).size();
		 String first_part = "//table[@class='innermaintable cell-border ']/tbody/tr[.][";
		 String second_part = "]/td[";
		 String third_part = "]";
		
		System.out.println("row count is "+sRow_counr +"col count is "+sCol_counr);
		
		summData =new String[sRow_counr][sCol_counr];
		System.out.println("entering into loop");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		for (k = 1; k < sRow_counr; k++) {
		for (l = 1; l < sCol_counr; l++) {
		String final_xpath1 = first_part+k+second_part+l+third_part;
		summData[k][l]=driver.findElement(By.xpath(final_xpath1)).getText();
		//System.out.println("Summary Report is :"+summData[k][l]);
		}
		System.out.println(summData[k][l-19]);
		}
		
	}
	static int count =0;
	static String summtext;
	public static void validate_No_of_Branches_Visited_Bn_Summ_ND_Daily(){
		

		for (i = 1; i < dRow_counr; i++) {
             if(appData[i][j-19].equals("KL/KCH/02")) {
            	 count++;
             }
		}
		/*for (k = 1; k < sRow_counr; k++) {
		System.out.println(summtext);
		 summtext = summData[k][l-19];
		}*/
		summtext = driver.findElement(By.xpath(reader.get("reportAt_xpath"))).getText();
	int count2 = Integer.parseInt(summtext);
	System.out.println("Visited Branch count is" + count);
	if(count == count2) {
		System.out.println("NO Of Branches Successfully verified");
	} else {
		System.out.println("NO Of Branches Not verified");
	}
	
		}

	public static void validate_RepoAtTm_Bn_Daily_nd_Summary() throws Exception {
		
		for (i = 1; i < dRow_counr; i++) {
			for (k = 1; k < sRow_counr; k++) {
		if(appData[i][j-15].equals(summData[k][l-16])) {
			System.out.println("ERT ReportAt Time is same in both Daily and Summary Reports");
		}	
		}
		}
	}
	
	
	
	
	
	
	//-----------------------------------------Incident Room-----------------------
	public static void navigate_to_Incident_room() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(reader.get("sla_xpath"))).click();
		driver.findElement(By.xpath(reader.get("list_Incident_xpath")))
				.click();
		new Select(driver.findElement(By.xpath(reader
				.get("list_drop_xpath")))).selectByValue("ADT Alarm");
		System.out.println("clicked on ADT");
		driver.findElement(By.xpath(reader.get("list_button_xpath")))
				.click();
		Thread.sleep(20000);
		driver.findElement(By.xpath(reader.get("show_drop_xpath")))
				.click();
		driver.findElement(By.xpath(reader.get("showdrop_All_xpath")))
				.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(reader.get("creation_xpath"))).click();
		System.out.println("clicked on creation");
		driver.findElement(By.xpath(reader.get("creation_xpath"))).click();
		Thread.sleep(2000);
	}
	static String[][] IncRoomData = null ;
	static int m;
	static int n;
	static int IRow_counr;
	static int ICol_counr;
	public static void incident_Room_Data() {
		
		 IRow_counr =driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr[.]")).size();
		 ICol_counr =driver.findElements(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr[1]/td[.]")).size();
		 String first_part = "//table[@id='DataTables_Table_0']/tbody/tr[.][";
		 String second_part = "]/td[";
		 String third_part = "]";
		
		System.out.println("row count is "+IRow_counr +"col count is "+ICol_counr);
		
		IncRoomData =new String[IRow_counr][ICol_counr];
		System.out.println("entering into loop");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		for (m = 1; m < IRow_counr; m++) {
		for (n = 1; n < ICol_counr; n++) {
		String final_xpath1 = first_part+m+second_part+n+third_part;
		IncRoomData[m][n]=driver.findElement(By.xpath(final_xpath1)).getText();
		
		}
		//System.out.println("Summary Report is :"+IncRoomData[i][j-3]);
		if(IncRoomData[m][n-3].contains("2018-01-06")) {
			System.out.println(m);
			System.out.println(IncRoomData[m][n-2]);
		}
		else if(!IncRoomData[m][n-3].contains("2018-01-06")) {
			break;
		}
		}

	}
	public static void Validate_Branch_Names_BN_Incident_nd_Summ() {
		for (k = 1; k < sRow_counr; k++) {
			if(IncRoomData[i][j-3].contains("2018-01-06")) {
				System.out.println(i);
				System.out.println(IncRoomData[i][j-2]);
			}
			else if(!IncRoomData[i][j-3].contains("2018-01-06")) {
				break;
			}
			for (m = 1; m < IRow_counr; m++) {
			if(IncRoomData[m][n-2].equals(summData[k][l-15])) {
				System.out.println("Branch Names Succefully verified");
			}
	}
		}
	}
	
	
	
	
	
	
	
	
	
	public static void navigate_to_Gaurd_CheckList() {
		
		WebDriverWait wait = new WebDriverWait(driver, 300);
		driver.findElement(
				By.cssSelector(reader.get("date_filter_css"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(reader.get("datePickerPreviousButton_xpath"))));
		driver.findElement(
				By.xpath(reader.get("datePickerPreviousButton_xpath")))
				.click();
		driver.findElement(By.xpath(reader.get("5date_xpath"))).click();
		new Select(driver.findElement(By.xpath(reader
				.get("dropdown_xpth")))).selectByValue("AM");
		driver.findElement(By.xpath(reader.get("5date_xpath"))).click();
		driver.findElement(
				By.xpath(reader.get("datePicker_2nd_previous_xpath")))
				.click();
		driver.findElement(By.xpath(reader.get("2nd_5th_dec_xpath")))
				.click();
		new Select(driver.findElement(By.xpath(reader
				.get("2nd_dropdown_xpath")))).selectByValue("PM");
		
		new Select(driver.findElement(By.xpath(reader
				.get("2nd_hour_xpath")))).selectByValue("10");
		driver.findElement(By.xpath(reader.get("ApplyButtonDateERT")))
				.click();
		driver.findElement(By.xpath(reader.get("vehicleFilter_xpath")))
				.click();
		driver.findElement(By.xpath(reader.get("ERT_VH_02"))).click();
		System.out.println("trying to click client filter");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(reader.get("Br_cFilter_xpath"))));
		new Select(driver.findElement(By.xpath(reader
				.get("Br_cFilter_xpath")))).selectByValue("MFL");
		driver.findElement(By.xpath(reader.get("Br_submit_xpath")))
				.click();
	}
	

	public static boolean isElementPresent(By locator, int waitTime) {
		  boolean bFlag=false;
		  try {
			WebDriverWait wait=new WebDriverWait(driver, waitTime);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			if(driver.findElement(locator).isDisplayed()){
				bFlag=true;
				System.out.println("Element "+locator+" Is displayed");
				
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element "+locator+"Was Not found in DOM in Time"+waitTime+"Seconds-NoSuchElementException");
		}
		return bFlag;  
	  }
	}