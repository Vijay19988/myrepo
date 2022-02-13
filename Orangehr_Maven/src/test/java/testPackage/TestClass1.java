 package testPackage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.AddUserPage;
import pom.AdminPage;
import pom.HomePage;
import pom.LoginPage;
import pom.NewHomePageTab;
import pom.PerformancePage;
import pom.ReviewListPage;
import pom.UserOption;

public class TestClass1 {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vijay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		//LoginPage Object
		LoginPage loginPage = new LoginPage(driver);
     	loginPage.sendUserName();
		loginPage.sendPassword();
		loginPage.clickOnLoginButton();
		
		// HomePage object
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyInfo();
		homePage.clickOnAdmin();
		
		//AdminPage object9
		AdminPage adminPage = new AdminPage(driver);
		adminPage.sendUserNameInAdmin();
		adminPage.selectUserRole();
		adminPage.sendEmpName();
		adminPage.selectStatus();
		adminPage.clickOnAddButton();
		
		//AddUserPage object
		AddUserPage addUserPage = new AddUserPage(driver);
		addUserPage.selectUserRole2();
		addUserPage.sendEmpName2();
		addUserPage.getempName2Text();
		addUserPage.clearEmpName2();
		addUserPage.sendEmpName2again();
		
		homePage.clickOnOrangeHrImage();
		
		ArrayList<String> orangeHr = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(orangeHr.get(1));
        
        //NewHomePageTab object
        NewHomePageTab newHomePageTab = new NewHomePageTab(driver);
        newHomePageTab.clickOnCompany();
        newHomePageTab.clickOnAboutUs();
        newHomePageTab.getAboutUsText();
        
        driver.switchTo().window(orangeHr.get(0));
        
        //PerformancePage object
        PerformancePage performancePage= new PerformancePage(driver);
        homePage.moveOnPerformance();
        performancePage.moveOnManageReviews();
        performancePage.clickOnReviewList();
        
        //ReviewListPage object
        ReviewListPage reviewListPage = new ReviewListPage(driver);
        reviewListPage.getDataFromTable();
        reviewListPage.clickOnCalenderImage();
        reviewListPage.selectMonthName();
        reviewListPage.selectDate();
        reviewListPage.clickOnsearchButton();
        
        homePage.clickOnUserOption();
        
        //UserOption object
        UserOption userOption = new UserOption(driver);
        
        homePage.clickOnUserOption();
        
        homePage.clickOnAdmin();
        adminPage.scrollDownScreen();
        adminPage.selectAllCheckBoxes();
        adminPage.selectAllCheckBoxes();
        userOption.clickOnLogOutOption();
        
        
    }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

