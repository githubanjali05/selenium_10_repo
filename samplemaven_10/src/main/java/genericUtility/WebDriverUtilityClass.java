package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtilityClass {
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void dragAndDrop(WebDriver driver, WebElement element, WebElement element1) {
		Actions act = new Actions(driver);
		act.dragAndDrop(element, element1).perform();;
	}
	
	public void clickAndHold(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element);
	}
	public void scroll(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element);
	}
	
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	public void selectByIndex(WebElement dropdownEle, int index) {
		Select list= new Select(dropdownEle);
		list.selectByIndex(index);
	}
	
	public void selectByValue(WebElement dropdownEle, String value) {
		Select sel= new Select(dropdownEle);
		sel.selectByValue(value);
	}
	
	public void selectByVisibleText(WebElement dropdownEle, String visibleText) {
		Select sel= new Select(dropdownEle);
		sel.selectByValue(visibleText);
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchToFrame(WebDriver driver, WebElement frameEle) {
		driver.switchTo().frame(frameEle);
	}
	public Timeouts implicitWait(WebDriver driver) {
		return driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public WebDriverWait explictWait(WebDriver driver) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait;
	}
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void switchToAlertAndSendKeys(WebDriver driver) {
		driver.switchTo().alert().sendKeys(null);;
	}
	public void switchToAlertAndGetText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	// Or
	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}
	
	public void switchToWindow(WebDriver driver, String expUrl) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String id:allWindowIds) {
			driver.switchTo().window(id);
			String actUrl= driver.getCurrentUrl();
			if(actUrl.contains(expUrl))
				break;
		}
	}
	
	public void getScreenshot(WebDriver driver) throws IOException {
		JavaUtilityClass jUtil= new JavaUtilityClass();
		TakesScreenshot ts= (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest= new File("./Screenshots/"+jUtil.getSystemDateTime()+".png");
		FileHandler.copy(temp, dest);
	}
	public void jsscrolling(WebDriver driver, int x, int y) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,500)");
		
	}
}


