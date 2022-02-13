package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserOption {
	
    private WebDriver driver;
	@FindBy (xpath = "//a[text()='Support']")
	private WebElement supportOption;

	@FindBy (xpath = "//a[text()='Logout']")
	private WebElement logOutOption;
	
	public UserOption(WebDriver driver123)
	{
		PageFactory.initElements(driver123, this);
		this.driver = driver123;
	}
	
	public void clickOnSupportOption(){
		supportOption.click();
	}
	
	public void clickOnLogOutOption(){
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(logOutOption));
		logOutOption.click();
	}
}
