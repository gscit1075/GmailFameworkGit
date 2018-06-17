package A_SignIn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityPackage.ParentJavaPage;

public class B_HomePage extends ParentJavaPage {

	WebDriver homePageDriver;
	
	@FindBy(xpath = "//*[text() = 'COMPOSE']") WebElement composeButton;
	@FindBy(name="to") WebElement toTexbox;
	@FindBy(name="subjectbox") WebElement subjectTexbox;
	@FindBy(xpath="//div[@aria-label='Message Body']") WebElement bodyTextbox;
	@FindBy(xpath="//div[text()='Send']") WebElement sendButton;
	

	public B_HomePage(WebDriver d)
	{
		super(d);
		homePageDriver =d;

		PageFactory.initElements(homePageDriver, this);

	}
	
	public void verifiedTital(String text)
	{
		doesTitalConatain(text);
	}


	public void clickCompose()
	{
		//loginNextButton.click();
		clickButton(composeButton);
		System.out.println("Click On Compose");

	}
	
	public void enterTo(String to) {
		enterText(toTexbox, to);
	}

	public void enterSubject(String subject) {
		enterText(subjectTexbox, subject);
	}
	
	public void enterBody(String body) {
		enterText(bodyTextbox, body);
	}
	
	public void clickSend() {
		clickButton(sendButton);
	}


}
