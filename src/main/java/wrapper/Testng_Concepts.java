package wrapper;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testng_Concepts {
	@BeforeMethod(groups={"smoke","Regression","Functional"})
	public void bfmetod(){
		System.out.println("Before Method");
	}
	@AfterMethod(groups={"smoke","Regression","Functional"})
	public void afmetod(){
		System.out.println("after Method");
	}
	
@Test(priority=-1,groups="smoke")
	public void method1() {
		System.out.println("method 1");
	}
@Test(priority=-2,enabled=true,groups="regression")
	public void method2() {
		System.out.println("method 2");

	}
@Test(priority=-3,groups={"smoke","Regression","Functional"})
	public void method3() {
		System.out.println("method 3");

	}
@Test(priority=1)
	public void dmethod4() {
		System.out.println("method 4");

	}
@Test(priority=2)
	public void cmethod5() {
		System.out.println("method 5");

	}
@Test(priority=3)
	public void bmethod6() {
		System.out.println("method 6");

	}
@Test(priority=4)
	public void amethod7() {
		System.out.println("method 7");
	}

}
