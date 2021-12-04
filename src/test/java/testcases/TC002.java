package testcases;

import org.testng.annotations.Test;


import utils.DataProviderCLass1;
import wrapper.ProjectWrappers;

public class TC002  extends ProjectWrappers{

	
	@Test(dataProvider="TC002",dataProviderClass = DataProviderCLass1.class)
	public void IRCTC_Accommodations(String city,String loungecity, String passenger, String checkin, String checkout, String email,
			String mobile, String name1, String age1, String gender1, String name2, String age2, String gender2, String name3,String age3,
			String gender3,String State)
	
	{
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[2]/nav/ul/li[7]/a");
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[2]/nav/ul/li[7]/a");
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[2]/nav/ul/li[7]/ul/li[3]/a/span[1]");
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[2]/nav/ul/li[7]/ul/li[3]/ul/li[2]/a/span");
		switchToLastWindow();
		selectIndexByName("city", Integer.parseInt(city));
		
		selectvisibletextByName("laungecity", loungecity);
		selectIndexByName("selPassangers",Integer.parseInt( passenger));
		clickByName("acservicecheckindate");
		clickByXpath("/html/body/app-root/accommodation/div[2]/div[2]/div/form/div[4]/div/div/table/tbody/tr[4]/td[6]");
		selectByvalueName("checkInTime", checkin);
		selectByvalueName("checkOutTime", checkout);
		ThreadWait(2000);
		clickByXpath("/html/body/app-root/accommodation/div[2]/div[2]/div/form/div[11]/button[2]");
		ThreadWait(3000);
		clickById("profile-tab");
		ThreadWait(3000);
		enterById("modalLRInput12", email);
		enterByName("mobileNo", mobile);
		clickByXpath("/html/body/app-root/login/div/div/div/div/div/div[2]/div/form/div[3]/button");
		ThreadWait(3000);
		enterByXpath("/html/body/app-root/acpassangers/div/form/div/div/div/div/div[1]/div/table/tbody/tr[1]/td[2]/input", name1);
		enterByXpath("/html/body/app-root/acpassangers/div/form/div/div/div/div/div[1]/div/table/tbody/tr[1]/td[3]/input", age1);
		selectByvalue("/html/body/app-root/acpassangers/div/form/div/div/div/div/div[1]/div/table/tbody/tr[1]/td[4]/select", gender1);
		enterByXpath("/html/body/app-root/acpassangers/div/form/div/div/div/div/div[1]/div/table/tbody/tr[2]/td[2]/input", name2);
		enterByXpath("/html/body/app-root/acpassangers/div/form/div/div/div/div/div[1]/div/table/tbody/tr[2]/td[3]/input", age2);
		selectvisibletextByxpath("/html/body/app-root/acpassangers/div/form/div/div/div/div/div[1]/div/table/tbody/tr[2]/td[4]/select", gender2);
		enterByXpath("/html/body/app-root/acpassangers/div/form/div/div/div/div/div[1]/div/table/tbody/tr[3]/td[2]/input", name3);
		enterByXpath("/html/body/app-root/acpassangers/div/form/div/div/div/div/div[1]/div/table/tbody/tr[3]/td[3]/input", age3);
		selectByvalue("/html/body/app-root/acpassangers/div/form/div/div/div/div/div[1]/div/table/tbody/tr[3]/td[4]/select", gender3);
		selectByvalueName("state", State);
		ThreadWait(3000);
		clickByXpath("/html/body/app-root/acpassangers/div/form/div/div/div/div/div[4]/button[2]");
		ThreadWait(3000);
		clickByXpath("/html/body/app-root/acsummery/div/div[2]/div/div/div/div[3]/div[1]/div[5]/div/label/span");
		clickByXpath("/html/body/app-root/acsummery/div/div[2]/div/div/div/div[3]/div[2]/button");
		String a=getTextByXpath("/html/body/app-root/acsummery/div/div[2]/div/div/div/div[3]/div[1]/div[4]/span");
		System.out.println(a);
		clickByXpath("/html/body/app-root/acsummery/div/div[2]/div/div/div/div[3]/div[1]/div[5]/div/label/span");
		clickByXpath("/html/body/app-root/acsummery/div/div[2]/div/div/div/div[3]/div[2]/button");
	}
}
