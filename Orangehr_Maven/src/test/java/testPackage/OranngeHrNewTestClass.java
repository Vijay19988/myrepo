package testPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Browser;
import pom.AddUserPage;
import pom.AdminPage;
import pom.HomePage;
import pom.LoginPage;
import pom.NewHomePageTab;
import pom.PerformancePage;
import pom.ReviewListPage;
import pom.UserOption;
import utils.Utility;

public class OranngeHrNewTestClass extends Browser{
	private int testID;
	private WebDriver driver;
	private AddUserPage addUserPage;
	private HomePage homePage ;
	private AdminPage adminPage;
	private NewHomePageTab newHomePageTab;
//	private ArrayList<String> orangeHr ;
	private PerformancePage performancePage;
	private ReviewListPage reviewListPage;
	private UserOption userOption;
	private SoftAssert softAssert;
	private LoginPage loginPage;
	
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")){
			driver = launchChromeBrowser();
		}
		
		if(browser.equalsIgnoreCase("Edge")){
			driver = launchEdgeBrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@BeforeClass
	public void createPomObjects()
	{
	    driver = new ChromeDriver();
	    homePage = new HomePage(driver);
	    loginPage = new LoginPage(driver);
		driver.manage().window().maximize();
		adminPage = new AdminPage(driver);
		addUserPage = new AddUserPage(driver);
		newHomePageTab = new NewHomePageTab(driver);
		performancePage = new PerformancePage(driver);
    	reviewListPage = new ReviewListPage(driver);
    	userOption = new UserOption(driver);
    	

	}
	
	@BeforeMethod
	public void loginToApplication() throws EncryptedDocumentException, IOException 
	{
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String userName = Utility.getDataDFromExcelSheet("Sheet2", 0, 0);
		String password = Utility.getDataDFromExcelSheet("Sheet2", 0, 1);
	    loginPage.sendUserName(userName);
		loginPage.sendPassword(password);
		loginPage.clickOnLoginButton();
	}
	
	@Test
	public void toVerifyMyInfoButton()                           //  0 pass  
	{
	    testID = 000;
	    softAssert = new SoftAssert();
		homePage.clickOnMyInfo();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		softAssert.assertEquals(url, "https://opensource-demo.orangehrmlive.com/index.php/pim/viewMyDetails");
		softAssert.assertEquals(title, "OrangeHRM");
		softAssert.assertAll();
	}
	
	@Test
	public void verifyAdminButton()                                     //  1 pass
	{
	    testID = 001;
		softAssert = new SoftAssert();
		homePage.clickOnAdmin();
		String title= driver.getTitle();
		adminPage.sendUserNameInAdmin();
		adminPage.selectUserRole();
		adminPage.selectStatus();
		adminPage.sendEmpName();
		adminPage.clickOnAddButton();
		String url1 = driver.getCurrentUrl();
		softAssert.assertNotEquals(url1, "saveSystemUser");
		//softAssert.assertEquals(url1, "saveSystemUser");
		softAssert.assertEquals(title, "OrangeHRM");
		softAssert.assertAll();	
		Assert.fail();
	}
	
	@Test  
	public void verifyEmpNameTextBoxInAdminPageIsClickable()              // 2  pass 
	{
	    testID = 002;
		softAssert = new SoftAssert();
		homePage.clickOnAdmin();
		adminPage.clickOnAddButton();
		addUserPage.sendEmpName2();
		String text = addUserPage.getempName2Text();
		softAssert.assertEquals(text, "Employee does not exist");
		softAssert.assertAll();
		softAssert.fail();
	}
		
    @Test
    public void verifyNewTabOpenAfterclickOnOrangeHRImage()                // 3 pass 
    {
    	testID = 003;
    	softAssert = new SoftAssert();
    	homePage.clickOnOrangeHrImage();
    	ArrayList<String> orangeHr = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(orangeHr.get(1));
        String url = driver.getCurrentUrl();
        softAssert.assertEquals(url, "https://www.orangehrm.com/");
		softAssert.assertAll();
    }
    
    @Test
    public void getTextOfComapanyOptionInNewtab()                            // 4 pass
    {
    	testID = 004;
    	softAssert = new SoftAssert();
    	homePage.clickOnOrangeHrImage();
    	ArrayList<String> orangeHr = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(orangeHr.get(1));
        newHomePageTab.clickOnCompany();
    	newHomePageTab.clickOnAboutUs();
    	newHomePageTab.getAboutUsText();
    	
    	System.out.println("text is get and stored");
    	
    	driver.close();
    	
    	driver.switchTo().window(orangeHr.get(0));
    	
    }
    
    @Test 
    public void selectDateInPerformanceInReviewList()                             //5  pass
    {
        testID = 005;
    	homePage.moveOnPerformance();
    	performancePage.moveOnManageReviews();
    	performancePage.clickOnReviewList();
    	reviewListPage.clickOnCalenderImage();
    	reviewListPage.selectMonthName();
    	reviewListPage.selectDate();
    	reviewListPage.clickOnsearchButton();
    }
    
    @Test 
    public void getdataFromTable()                                         // 6  pass
    {
        testID = 006;
    	softAssert = new SoftAssert();
    	String text = reviewListPage.getDataFromTable();
        softAssert.assertNotEquals(text, "");
 		softAssert.assertAll();
    	
    	//.equals("reviewListPage --> 	HR Associate")
    }
    
    @Test
    public void verifyCheckBoxesInAdminAreClickable()                             //  7 pass
    {
        testID = 007;
    	homePage.clickOnAdmin();
    	adminPage.selectAllCheckBoxes();
    	boolean result =adminPage.checkLastCheckBoxIsSelected();
    	softAssert.assertEquals(result, true);
    	softAssert.assertAll();
    }
    
    
	
	@AfterMethod
	public void logOutFromApplication(ITestResult result) throws IOException                                
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.takeScreenshotHere(driver, testID);
		}
			
		homePage.clickOnUserOption();
		userOption.clickOnLogOutOption();
	}
	
	@AfterClass
	public void clearPomObjects()
	{
		addUserPage = null;
		adminPage = null;
		homePage  = null;
		loginPage = null;
		newHomePageTab = null;
		performancePage = null;
		reviewListPage = null;
		userOption = null;
		softAssert  = null;
	}
	
	@AfterTest()
	public void closeBrowser()
	{
		driver.quit();
		driver = null;
		System.gc();
	}
	

}
