package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestProperties  extends base{
	
	public static void main(String[] args) throws IOException {
		
		String propFile = System.getProperty("user.dir")+"\\or.properties";
		FileInputStream fis = new FileInputStream(propFile);
		or.load(fis);
		
		System.out.println(or.getProperty("browser"));
		System.out.println(System.getProperty("user.dir"));
		
		
//		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\Drivers\\chromedriver79.exe");
//		
//		driver = new ChromeDriver(); 
//		
//		driver.get("https://github.com/MaBlaGit/LearningSeleniumWebDriver/blob/master/csv_file_reader/read_data_from_csv_file.py");
		
		
	}

	
	
	
}
