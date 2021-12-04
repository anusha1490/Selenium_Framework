package utils;

import org.testng.annotations.DataProvider;

public class SampleDataProvider {
	
	
	@DataProvider(name = "testadataastwodimensionarray")
	public static String[][] getData(){
		
		String [][] testdata  = new String[2][3];
		
		testdata[0][0] = "testusername";
		testdata[0][1] = "testpassword";
		testdata[0][2] = "testusername";
		testdata[0][3] = "testpassword";
		testdata[0][4] = "testusername";
		testdata[1][1] = "testpassword";
		testdata[1][1] = "testpassword";
		testdata[1][2] = "testusername";
		testdata[1][3] = "testpassword";
		testdata[1][4] = "testusername";
		testdata[2][0] = "testpassword";
		testdata[2][1] = "testpassword";
		testdata[2][2] = "testusername";
		testdata[2][3] = "testpassword";
		testdata[2][4] = "testusername";
		
		return testdata;

	}

}
