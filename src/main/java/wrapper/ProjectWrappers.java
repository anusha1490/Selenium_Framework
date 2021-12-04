package wrapper;

import org.testng.annotations.BeforeMethod;

public class ProjectWrappers extends GenericWrappers{
	
	
	@BeforeMethod
	public void beforeMentiod(){
		invokeApp("Chrome", "https://www.irctc.co.in/nget/train-search");
		ThreadWait(3000);
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button");
	}

}
