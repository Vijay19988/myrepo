package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewListPage {
	WebDriverWait wait;
	
	private WebDriver driver;
	@FindBy (xpath = "//a[text()='Review List']")
	private WebElement reviewListTable;
	
	@FindBy (xpath = "//input[@id='toDate']")
	private WebElement calenderImage;
	
	@FindBy (xpath = "//select[@data-handler='selectMonth']")
	private WebElement selectMonth;
	
	@FindBy (xpath = "//a[text()='14']")
	private WebElement selectDate;
	
	@FindBy (xpath = "//input[@value='Search']")
	private WebElement searchButton;
	
	@FindBy (xpath = "//table[@class='table hover']//td")
	private WebElement Table;
	
	public ReviewListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait= new WebDriverWait(driver,20);
	}
	
	public void clickOnCalenderImage() {
		wait.until(ExpectedConditions.visibilityOf(calenderImage));
		   calenderImage.click();
	}
		
	public void selectMonthName() {
		Select sp = new Select(selectMonth);
	       sp.selectByVisibleText("May");
	}
	
	public void selectDate() {
		   selectDate.click();
	}
	
	public void clickOnsearchButton() {
		   searchButton.click();
	}
	
	public String getDataFromTable() {
		List<WebElement> ar = driver.findElements(By.xpath("//table[@class='table hover']//tr//td"));
		
		String  data = null;
		for(int i =0;i<ar.size()-1;i++)
		{
			data= data +( ar.get(i).getText()+"-->");
		}
		return data;
		
	
		
       
	}

	
	
	

}
