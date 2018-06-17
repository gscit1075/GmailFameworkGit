package utilityPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import atu.testng.reports.ATUReports;

public class ParentTestPage {

	protected WebDriver driver= null;
	String testName = this.getClass().getSimpleName();
	Properties dataProperty = null;
	
	
	static
	{
		String s = System.getProperty("user.dir")+"\\src\\test\\Config\\atu.properties";
		System.setProperty("atu.reporter.config", s);		
		System.out.println("in static block");		
	}
	// to launch browser
	@BeforeClass
	public void setUP()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Desktop\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		ATUReports.setWebDriver(driver);
		driver.get("https://accounts.google.com/signin/v2/identifier");
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public String getData(String key)
	{
		if(dataProperty==null)
		{
			String filePath = System.getProperty("user.dir")+"\\src\\test\\DataFiles\\"+testName+".properties";
			dataProperty = new Properties();
			try {
				dataProperty.load(new FileInputStream(new File(filePath)));
			} 
			catch (FileNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return dataProperty.getProperty(key);


	}
}
