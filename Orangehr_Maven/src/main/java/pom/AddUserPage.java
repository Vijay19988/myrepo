package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddUserPage {
	@FindBy (xpath = "//select[@id='systemUser_userType']")
	private WebElement userRole2;
	
	@FindBy (xpath = "(//input[@type='text'])[1]")
	private WebElement empName2;
	
	@FindBy (xpath = "//span[@class='validation-error']")
	private WebElement empName2Text;

	public  AddUserPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void selectUserRole2() {
		Select sss= new Select(userRole2);
        sss.selectByVisibleText("Admin");	
    }
	
	public void sendEmpName2() {
		empName2.sendKeys("Alan");
	}

	public String getempName2Text() {
		return empName2Text.getText();
		
	}


	public void clearEmpName2() {
		empName2.clear();
	}

	public void sendEmpName2again() {
		empName2.sendKeys("jenner");
	}
}
