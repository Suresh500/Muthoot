package com.Cogniphy.Protection.Muthoot.Reports;

import org.testng.annotations.Test;

import com.Cogniphy.Protection.Muthoot.Utility.BaseClass;
import com.Cogniphy.Protection.Muthoot.Utility.LogIn;

public class TestCheck extends BaseClass{
  @Test
  public void TC_0001() throws Exception {
	  LogIn.chrome_LogIn();
	  Reports.navigate_To_Reports();
	  Reports.validate_Date_Picker();
  }
}
