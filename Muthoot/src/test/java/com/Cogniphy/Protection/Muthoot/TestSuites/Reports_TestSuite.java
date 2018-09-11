package com.Cogniphy.Protection.Muthoot.TestSuites;

import org.testng.annotations.Test;
import com.Cogniphy.Protection.Muthoot.Reports.Reports;
import com.Cogniphy.Protection.Muthoot.Utility.BaseClass;
import com.Cogniphy.Protection.Muthoot.Utility.LogIn;

public class Reports_TestSuite extends BaseClass{
	
  @Test
  public void TC_0001_Login() throws Exception {
	  LogIn.chrome_LogIn();
	  Reports.navigate_To_Reports();
	  Reports.fetch_Daily_report();
	  Reports.fetch_Data_From_Daily_Report();
	 
  }
  @Test
  public void TC_0019_Validate_ERTReported_At_Time_with_Daily_Report() throws Exception{
	  //Assert.assertTrue(false);
	  Reports.navigate_to_ERTSummary_Report();
	  Reports.fetchSummuryRepot();
	  Reports.fetch_Data_From_summ_Report();
	  Reports.validate_RepoAtTm_Bn_Daily_nd_Summary();
	 
	 
  }
  @Test
  public void TC_0021_22_Validate_No_of_Branches_Visted() {
	 Reports.validate_No_of_Branches_Visited_Bn_Summ_ND_Daily();
  }
  @Test
  public void TC_0023_0024_IncidentRoom_BranchNames_Validation() throws Exception {
	  Reports.navigate_to_Incident_room();
	  Reports.incident_Room_Data();
	  Reports.Validate_Branch_Names_BN_Incident_nd_Summ();
  }
 @Test
 public void TC_0025_0026_ADT_AlarmTime_Vrfction_BN_Summ_ND_IncRoom() {
	 
 }
 @Test
 public void TC_0027_0028_ADT_RecievedTime_Vrfction_BN_Summ_ND_IncRoom() {
	 
 }
 

}

