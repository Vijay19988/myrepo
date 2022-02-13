package pom;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewHomePageTab {
	@FindBy (xpath = "(//a[@class='link'])[4]")
	private WebElement company;
	
	@FindBy (xpath = "(//a[text()='About Us'])[1]")
	private WebElement aboutUs;

	@FindBy (xpath = "//p[contains(text(),'Def')]")
	private WebElement aboutUsText;

	public  NewHomePageTab(WebDriver driver123)
	{
		PageFactory.initElements(driver123, this);
	}
	
	public void clickOnCompany() {
		company.click();
        
	}
	
	public void clickOnAboutUs() {
		aboutUs.click();
	}
	
	public void getAboutUsText() {
	   System.out.println(aboutUsText.getText());
	}
	
	

	
	
}
