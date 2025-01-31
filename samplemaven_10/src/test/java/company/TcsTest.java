package company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TcsTest {
	@Test
	public void tcsLaunch() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.tcs.com/");
	}

}
