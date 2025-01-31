package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class MavrnParameterTest {
	@Test
	public void launch() {
		String url = System.getProperty("url");
		Reporter.log(url,true);
		String email = System.getProperty("email");
		String pwd = System.getProperty("password");
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
	}

}
