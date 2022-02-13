package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PerformancePage {
	
	private Actions act;
	@FindBy (xpath = "(//a[text()='Manage Reviews'])[1]")
	private WebElement manageReviews;

	@FindBy (xpath = "//a[text()='Review List']")
	private WebElement reviewList;
	
	
	public PerformancePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		 act = new Actions(driver);
	}
	
	public void moveOnManageReviews() {
	   act.moveToElement(manageReviews).build().perform();
	}
	
	public void clickOnReviewList() {
		reviewList.click();
	}
	
	

}
