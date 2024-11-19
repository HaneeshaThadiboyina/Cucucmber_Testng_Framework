package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Collection;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;



public class TestBase {
	public WebDriver driver;
	public Properties properties;
	
	
	public WebDriver webDriverManager() throws IOException
	{
	  FileInputStream propfile = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//config.properties");
			//FileReader file = new FileReader("Opencart_Hybrid_Framework\\src\\test\\resources\\config.properties");
		  properties = new Properties();
		  properties.load(propfile);
			
				String br = properties.getProperty("browser");
				//String url = properties.getProperty("appURL");
				
				
				if(driver==null)
				{
				if(br.equalsIgnoreCase("chrome"))
				{
					driver = new ChromeDriver();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					driver.manage().window().maximize();
				}
				else if(br.equalsIgnoreCase("edge"))
				{
					driver = new EdgeDriver();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					driver.manage().window().maximize();
				}
				//driver.get(url);
				}
				return driver;
	}
	
//	@After
	public String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot)webDriverManager();
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir")+"/ScreenShots/"+tname+"_"+timeStamp+".PNG";
		File targetFile = new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}


}
