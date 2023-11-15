package com.inetBankingV1.testCases;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBankingV1.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger=Logger.getLogger("ebanking");
		//PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
            System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
            driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", readconfig.getEdgepath());
			driver = new EdgeDriver();
		}
		
		driver.get(baseURL);
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver,String tname) throws IOException
	{
	  TakesScreenshot ts=(TakesScreenshot) driver;
	  File source =ts.getScreenshotAs(OutputType.FILE);
	  File target =new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
	  FileUtils.copyFile(source, target);
	  System.out.println("Screenshot taken");
	}

}
