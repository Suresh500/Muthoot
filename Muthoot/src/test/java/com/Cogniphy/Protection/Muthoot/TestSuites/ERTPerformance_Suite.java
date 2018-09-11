package com.Cogniphy.Protection.Muthoot.TestSuites;

import org.testng.annotations.Test;

import com.Cogniphy.Protection.Muthoot.Reports.ERT_Performance_Page;
import com.Cogniphy.Protection.Muthoot.Reports.Reports;
import com.Cogniphy.Protection.Muthoot.Utility.BaseClass;
import com.Cogniphy.Protection.Muthoot.Utility.LogIn;

public class ERTPerformance_Suite extends BaseClass{
	@Test
	  public void TC_0001_Login() throws Exception {
		  LogIn.chrome_LogIn();
		  Reports.navigate_To_Reports();
	}
	@Test
	public void TC_003_Verify_the_Performance_Report_in_the_submenu() {
		ERT_Performance_Page.navi_To_ERTPerfmnce();
		ERT_Performance_Page.verify_Page_Title();
	}
	@Test
	public void TC_006_verify_Tab_Status() {
		ERT_Performance_Page.select_Yestreday_Date();
		//ERT_Performance_Page.validate_Date_Picker();
		//Reports.validate_Date_Picker();
		//ERT_Performance_Page.DayBefore();
		ERT_Performance_Page.Verify_Tab_status_column();
	}
	@Test
	public void TC_011_verify_ManualAtendance_column() {
		ERT_Performance_Page.Verify_ManualAttend_for_eachERT();
	}
}
