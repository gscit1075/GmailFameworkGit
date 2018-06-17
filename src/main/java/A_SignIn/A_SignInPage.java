package A_SignIn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import utilityPackage.ParentJavaPage;


public class A_SignInPage extends ParentJavaPage 
{
	WebDriver pageDriver;

	@FindBy(name="identifier")
	WebElement emailIdTextBox;

	@FindBy(name="password")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement NextButton;




	public A_SignInPage(WebDriver d)
	{
		super(d);
		pageDriver =d;
		PageFactory.initElements(pageDriver, this);
	}



	public void setEmailID(String unam)
	{
		//emailIdTextBox.sendKeys(unam);

		enterText(emailIdTextBox, unam);
		ATUReports.add("UserName", unam, LogAs.PASSED, null);
	}

	public String getemailID()
	{
		return emailIdTextBox.getText();
	}


	public void clickNext()
	{
		//loginNextButton.click();

		clickButton(NextButton);
		ATUReports.add("Click","",LogAs.PASSED,null);
	}

	public void setPassword(String pwd)
	{
		//passwordTextBox.sendKeys(pwd);

		enterText(passwordTextBox, pwd);
		ATUReports.add("Enter Password", pwd, LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}

	public String getPassword()
	{
		return passwordTextBox.getText();
	}
	
	// Directly access the home page
	
	
	public B_HomePage clickSignIn() {
		clickButton(NextButton);
		return new B_HomePage(pageDriver);
	}
	
}

