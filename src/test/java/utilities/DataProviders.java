package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	
	public String[][] getData() throws IOException
	{
		
		String path = ".\\testdata\\Opencart_LoginData.xlsx"; //taking xl file from test data
		
		ExcelUtility eu = new ExcelUtility(path);
		
		int totalrows = eu.getRowCount("Sheet1");
		int totalcols = eu.getCellCount("Sheet1", 1);
		
		String [][]loginData = new String[totalrows][totalcols];
		
		for(int i = 1; i<=totalrows; i++)
		{
			for (int j = 0 ; j<totalcols;j++)
			{
				loginData[i-1][j]= eu.getCellData("Sheet1", i, j);
			}
		}
		return loginData;
		
		
	}

}
