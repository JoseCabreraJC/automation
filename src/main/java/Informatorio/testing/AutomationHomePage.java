package Informatorio.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutomationHomePage extends BasePage{

	public AutomationHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="/html//header[@id='header']//nav//a[@title='Log in to your customer account']")
	private WebElement LoginButtom;
	
	@FindBy(xpath="(//div//a)[3]")
	private WebElement SignOutButom;
	
	public AutomationLoginPage clickLoginButtom() {
		LoginButtom.click();
		return new AutomationLoginPage(driver);
	}
	public AutomationHomePage clickSignOutButom() {
		SignOutButom.click();
		return new AutomationHomePage(driver);
	}
	
}
