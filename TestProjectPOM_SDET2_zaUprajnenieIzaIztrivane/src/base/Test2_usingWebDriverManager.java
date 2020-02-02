package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2_usingWebDriverManager {
	
	
	
	 private WebDriver driver;

	    @BeforeClass
	    public static void setupClass() {
	        WebDriverManager.chromedriver().setup();
	       
	    }

	    @Before
	    public void setupTest() {
	    	//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\Drivers\\chromedriver79.exe");
	        driver = new ChromeDriver();
	    }

	    @After
	    public void teardown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

	    @Test
	    public void test() {
	        driver.get("https://www.youtube.com/watch?v=OVoIdourNw8");
	    }

}
