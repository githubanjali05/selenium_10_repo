package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(linkText="Log out")
	private WebElement logoutLink;
	
	@FindBy(linkText="BOOKS")
	private WebElement booksLink;
	
	@FindBy(linkText="COMPUTERS")
	private WebElement computersLink;
	
	@FindBy(linkText="ELECTRONICS")
	private WebElement electronicsLink;
	
	@FindBy(xpath ="//a[text()='14.1-inch Laptop']/../..//input[@value='Add to cart']")
	private WebElement laptop;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLaptop() {
		return laptop;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getBooksLink() {
		return booksLink;
	}

	public WebElement getComputersLink() {
		return computersLink;
	}

	public WebElement getElectronicsLink() {
		return electronicsLink;
	}
	
	
}


