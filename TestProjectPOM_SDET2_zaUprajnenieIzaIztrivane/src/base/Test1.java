package base;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

public class Test1 extends base{

	 
	
	
	@Test
	public void t1 () throws IOException {
		
		System.out.println("Test 1");
		//driver.get("https://www.way2automaiton.com/angularjs-protractor/banking/#/manager");
		
		super.get("http://www.way2automation.com/angularjs-protractor/banking/#/login");
		//String browser_name = System.getenv("BROWSER_NAME");
		//System.out.println(browser_name);
		
		double height = super.getHeight(findElement("xpath", or.getProperty("BankManagerLogin_btn_XPATH")));
		double width = super.getWidth(findElement("xpath", or.getProperty("BankManagerLogin_btn_XPATH")));
		String webElmentTxt = findElement("xpath", or.getProperty("BankManagerLogin_btn_XPATH")).getText();
		System.out.println(webElmentTxt + "  Height is : " +height + ",  Width is :  " + width);
		
		super.verifyDimentions(findElement("xpath", or.getProperty("BankManagerLogin_btn_XPATH")), 46.0, 201.0);
		
		System.out.println(" JavaScript Body is :  " +super.getJavaScriptBody());
		
		//super.findElement("xpath", or.getProperty("BankManagerLogin_btn_XPATH")).click();
		//driver.findElement(By.xpath(or.getProperty("BankManagerLogin_btn_XPATH"))).click();
		  
		
		
	}
	
	
	
	final public BufferedImage getScreenshot() throws IOException {
		if (!(driver instanceof TakesScreenshot))
			throw new IOException("This browser driver does not support screenshot");
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		byte[] data = takesScreenshot.getScreenshotAs(OutputType.BYTES);
		return ImageIO.read(new ByteArrayInputStream(data));
	}
	
}
