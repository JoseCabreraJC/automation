package Informatorio.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AutomationLoginPage extends BasePage{

	public AutomationLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(id="email_create")
	private WebElement NewAccountEmailBox;
	
	@FindBy(id="SubmitCreate")
	private WebElement CreateAnAccountButtom;

	@FindBy(id="uniform-id_gender1")
	private WebElement RadioButtom;
	
	@FindBy(id="customer_firstname")
	private WebElement FirstNameBox;
	
	@FindBy(id="customer_lastname")
	private WebElement LastNameBox;
	
	@FindBy(id="passwd")
	private WebElement PasswordBox;
	
	@FindBy(id="address1")
	private WebElement AddressBox;
	
	@FindBy(id="city")
	private WebElement CityBox;
	
	@FindBy(id="postcode")
	private WebElement PostCodeBox;
	
	@FindBy(id="submitAccount")
	private WebElement RegisterButon;
	
	@FindBy(name="id_state")
	private WebElement StateList;
	
	@FindBy(id="email")
	private WebElement LoginEmail;
	
	@FindBy(id="passwd")
	private WebElement LoginPassword;
	
	@FindBy(id="phone")
	private WebElement PhoneNumberBox;
	
	@FindBy(id="SubmitLogin")
	private WebElement SignInButton;
	
	public void loginTypeKeys(String emailtext) {
		NewAccountEmailBox.sendKeys(emailtext);
	}
	public void clickCreateAnAccount() {
		CreateAnAccountButtom.click();
	}
	public void clickRadioButtom() {
		RadioButtom.click();
	}
	public void firstNameTypeKeys(String firstname) {
		FirstNameBox.sendKeys(firstname);
	}
	public void lastNameTypeKeys(String lastname) {
		LastNameBox.sendKeys(lastname);
	}
	public void passwordTypeKeys(String password) {
		PasswordBox.sendKeys(password);
	}
	public void addressTypeKeys(String address) {
		AddressBox.sendKeys(address);
	}
	public void cityTypeKeys(String city) {
		CityBox.sendKeys(city);
	}
	public void postalCodeTypeKeys(String postcode) {
		PostCodeBox.sendKeys(postcode);
	}
	public void clickRegisterButon() {
		RegisterButon.click();
	}
	public void phoneNumberTypeKeys(String phonenumber) {
		PhoneNumberBox.sendKeys(phonenumber);
	}
	public void selectState(String opcion){
		Select stateSelect = new Select(StateList);
		stateSelect.selectByVisibleText(opcion);
		
	}
	//	public void stateListOptionClick() {
	//	StateList1.click();
	//}
	public void loginEmailTypeKeys(String loginemail) {
		LoginEmail.sendKeys(loginemail);		
	} 
	public void loginPasswordTypeKeys(String loginpassword) {
		LoginPassword.sendKeys(loginpassword);
	}
	public void signInButonClick() {
		SignInButton.click();
	}
		
}
