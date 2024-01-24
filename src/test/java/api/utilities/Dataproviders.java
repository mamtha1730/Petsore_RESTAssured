package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataproviders
{
	@DataProvider(name="data")
	public String[][] getalldata() throws IOException
	{
		
		String path=".\\testdata\\userdata.xlsx";//taking xl file from testData
		//String path=System.getProperty("user.dir"+"\\testdata\\userdata.xlsx");
		ExcelUtility xl=new ExcelUtility(path);
		
		int rownum=xl.getRowCount("Sheet1");
		int colnum=xl.getCellCount("Sheet1", 1);
		
		String apidata[][]=new String [rownum][colnum];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				apidata[i-1][j]=xl.getCellData("Sheet1",i,j);
			}
		}
		return apidata;
	}
	
	@DataProvider(name="usernames")
	public String[] getusernames() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testdata//userdata.xlsx";
		ExcelUtility xl=new ExcelUtility(path);
		
		int rownum=xl.getRowCount("Sheet1");
		
		String apidata[]=new String[rownum];
		
		for(int i=1;i<=rownum;i++)
		{
			apidata[i-1]=xl.getCellData("Sheet1", i, 1);
		}
		return apidata;
	}
}



