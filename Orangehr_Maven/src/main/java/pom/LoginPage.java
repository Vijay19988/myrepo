package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy (xpath = "//input[@name='txtUsername']")
	private WebElement userName;
	
	@FindBy (xpath = "//input[@name='txtPassword']")
	private WebElement password;

	@FindBy (xpath = "//input[@type='submit']")
	private WebElement loginButton;

	@FindBy (xpath = "//a[text()='Forgot your password?']")
	private WebElement forgotPasswordButton;

	
	public LoginPage(WebDriver driver123)
	{
		PageFactory.initElements(driver123, this);
	}
	
	public void sendUserName(String data) {
		userName.sendKeys(data);
	}
	
	public void sendPassword(String data) {
		password.sendKeys(data);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public void clickOnForgotPasswordButton() {
		forgotPasswordButton.click();
	}
	
}
