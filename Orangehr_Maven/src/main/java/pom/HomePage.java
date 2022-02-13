package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	private Actions act;
	@FindBy (xpath = "//b[text()='Dashboard']")
	private WebElement dashboard;
	
	@FindBy (xpath = "(//a[@class='firstLevelMenu'])[7]")
	private WebElement performance;

	@FindBy (xpath = "//b[text() = 'My Info']")
	private WebElement myinfo;

	@FindBy (xpath = "//b[text()='Admin']")
	private WebElement admin;
	
	@FindBy (xpath = "//img[@height='56']")
	private WebElement orangeHrImage;
	
    @FindBy (xpath = "//a[@id='welcome']")
	private WebElement userOption;
	

	public  HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		act = new Actions(driver);
	}
	
	public void clickOnMyInfo() {
		myinfo.click();
	}
	
	public void clickOnAdmin() {
		admin.click();
	}
	
	public void moveOnPerformance() {
		act.moveToElement(performance).build().perform();
	}
	
	public void clickOnOrangeHrImage() {
		orangeHrImage.click();
	}
	
	public void clickOnUserOption(){
		userOption.click();
	}

	
}
