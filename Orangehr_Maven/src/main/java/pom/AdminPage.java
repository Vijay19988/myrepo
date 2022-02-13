package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {
	private WebDriver driver;

	@FindBy (xpath = "(//input[@type='text'])[1]")
	private WebElement userNameInAdmin;
	
	@FindBy (xpath = "//select[@name='searchSystemUser[userType]']")
	private WebElement userRole;

	@FindBy (xpath = "(//input[@type='text'])[2]")
	private WebElement empName;
	
	@FindBy (xpath = "//select[@name='searchSystemUser[status]']")
	private WebElement status;
	
	@FindBy (xpath = "//input[@id='btnAdd']")
	private WebElement addButton;
	
	@FindBy (xpath = "(//input[@type='checkbox'])[48]")
	private WebElement lastCheckBox;
    public  AdminPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void sendUserNameInAdmin() {
		userNameInAdmin.sendKeys("richard");
	}
	
	public void selectUserRole() {
		Select s  = new Select(userRole);
        s.selectByVisibleText("ESS");
	}
	
	public void sendEmpName() {
		empName.sendKeys("paul");
	}

	
	public void selectStatus() {
		Select ss  = new Select(status);
        ss.selectByVisibleText("Enabled");
	}

	public void scrollDownScreen() {
		 JavascriptExecutor js = (JavascriptExecutor)driver;
	       js.executeScript("window.scrollBy(0,2000)");
	       
	}
	
	public void scrollUpScreen() {
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,-2000)");
	       
	}
	
	public void selectAllCheckBoxes() {
		List<WebElement> lii = (driver.findElements(By.xpath("//div[@id='tableWrapper']//tbody//td//input")));
	      for(int o = 0;o<lii.size();o++)
	      {
	    	  lii.get(o).click();
	       }
	}
	
	public void deSelectAllCheckBoxes() {
		List<WebElement> lii = (driver.findElements(By.xpath("//div[@id='tableWrapper']//tbody//td//input")));
		for(int o = lii.size()-1;o>=0;o--)
	      {
	    	  lii.get(o).click();
	      }
	}
	
	public void clickOnAddButton() {
		addButton.click();
	}
	
	public boolean checkLastCheckBoxIsSelected() {
		return lastCheckBox.isSelected();
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

