package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

public class base {

	public static WebElement element = null;
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fis;
	public static Logger Log = Logger.getLogger(base.class);
	public static WebDriverWait wait;
	public ExtentReports extentTest;
	
	public static double startTime;
	public static double endTime; 
	public static double duration ;
	
	@BeforeSuite
	public void setUp() {
		
		/*
		 * Chrome options - set the browser optiosn
		 * Desired Capabilities - accept the Oprtions as parameter
		 * Driver - accept the options 
		 */
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		
		
		startTime = System.nanoTime();
		if (driver == null) {
			String orFile = System.getProperty("user.dir") + "\\or.properties";
			String configFile = System.getProperty("user.dir") + "\\or.properties";
			try {
				fis = new FileInputStream(orFile);
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			try {
				or.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(configFile);
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String browser = null;
			if (or.getProperty("browser").equalsIgnoreCase("chrome")) {
				browser = "chrome";
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Drivers\\chromedriver79.exe");

//				Map<String, Object> prefs = new HashMap<String, Object>();
//				prefs.put("profile.default_content_setting_values.notifications", 2);
//				prefs.put("credentials_enable_service", false);
//				prefs.put("profile.password_manager_enabled", false);
				
				
				//options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");
				//options.addArguments("--headless");
				
				desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
				LoggingPreferences logPrefs = new LoggingPreferences();
			    logPrefs.enable(LogType.BROWSER, Level.ALL);
			    desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
			    desiredCapabilities.setBrowserName(or.getProperty("browser"));
			    desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			    desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, "Windows 10");
			    desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, or.getProperty("browser"));
			    desiredCapabilities.setCapability(CapabilityType.VERSION, or.getProperty("80"));
			    /*
				 *  Merging DesiredCapabilities for chrome
				 */
				options.merge(desiredCapabilities);
				
				driver = new ChromeDriver(options);
				
				 

			}
			
			else if (or.getProperty("browser").equalsIgnoreCase("firefox")) {
				browser = "firefox";
				System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				
			}
			
			
//			switch (browser) {
//			case "chrome":
//				desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
//				break;
//
//			case "firefox":
//				desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, "Firefox");
//				break;
//				
//				
//			default:
//				break;
//			}
		    
		    
		    
		    
		    
		    driver.manage().window().maximize();
		    
		     
			
		}
	}
	
	
	
	@AfterSuite(alwaysRun = true)
	public static void jdiTearDown() throws IOException {
		endTime = System.nanoTime();
		duration = startTime - endTime  ; 
		System.out.println(" Total Run Time :  "  + duration/ 1000000000.0 + " sec. ");
		
		
		
		if (driver!= null) {
			driver.quit();
		}
		
	}
	

}
