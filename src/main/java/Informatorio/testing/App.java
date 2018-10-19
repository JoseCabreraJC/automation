package Informatorio.testing;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;

/**
 * Hello world!
 *
 */
public class App {
	WebDriver driver = null;
    @BeforeClass
	public void Setup(){
		ChromeDriverManager.getInstance().forceCache().setup();
		//abro chrome
		driver = new ChromeDriver();
		}
    	
    @Test
    public void Test() {
	driver.get("http://automationpractice.com/index.php");
    	
        
    		Random rand = new Random();
    		int RandomNumber = rand.nextInt(1000000000);
    		String useremail = RandomNumber + "@gmail.cm";
    		System.out.println(useremail);
    		System.out.println("123456789");
    		AutomationHomePage homePage = new AutomationHomePage(driver);
    		AutomationLoginPage loginPage = homePage.clickLoginButtom();
    		loginPage.loginTypeKeys(useremail);
    		loginPage.clickCreateAnAccount();
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		loginPage.clickRadioButtom();
    		loginPage.firstNameTypeKeys("Pepe");
    		loginPage.lastNameTypeKeys("Grillo");
    		loginPage.passwordTypeKeys("123456789");
    		loginPage.addressTypeKeys("Avenida Siempreviva 7894");
    		loginPage.cityTypeKeys("Argentina");
    		loginPage.postalCodeTypeKeys("00000");
    		loginPage.phoneNumberTypeKeys("123456789");
    		loginPage.selectState("Alaska");
    		// loginPage.stateListOptionClick();
    		loginPage.clickRegisterButon();
    		homePage.clickSignOutButom();
    		
    		//driver.get("http://automationpractice.com/index.php");
    		//AutomationHomePage homePage2 = new AutomationHomePage(driver);
    		//clickSignOutButom
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		AutomationLoginPage loginPage2 = homePage.clickLoginButtom();
    		loginPage2.loginEmailTypeKeys(useremail);
    		loginPage2.loginPasswordTypeKeys("123456789");
    		loginPage2.signInButonClick();
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		
    
    }	
    @AfterMethod
    public void CloseUp() {
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.quit();
    }

    }

