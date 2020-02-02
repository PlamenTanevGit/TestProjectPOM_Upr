package base;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Test1 extends base{

	 
	
	
	@Test
	public void t1 () {
		
		System.out.println("1");
		//driver.get("https://www.way2automaiton.com/angularjs-protractor/banking/#/manager");
		
		driver.get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
		//String browser_name = System.getenv("BROWSER_NAME");
		//System.out.println(browser_name);
		driver.findElement(By.xpath(or.getProperty("BankManagerLogin_btn_XPATH"))).click();
		
	}
	
}
