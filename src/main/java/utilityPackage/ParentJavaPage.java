package utilityPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ParentJavaPage {

	WebDriver parentDriver;
	WebDriverWait wait=null;


	//Parent Constructor
	public ParentJavaPage(WebDriver d)
	{
		parentDriver = d;
		wait = new WebDriverWait(parentDriver, 30);
	}

	//Enum
	public enum Condition
	{
		visibility, clickability;
	}


	// generic Enter Text Method(Like User Name and PassWord)
	public void enterText(WebElement element, String text)
	{
		WebElement eneterElement = waitForElement(element, Condition.visibility);
		eneterElement.sendKeys(text);
	}


	//Generic Click Method
	public void clickButton(WebElement element)
	{
		WebElement clickElement = waitForElement(element, Condition.clickability);
		clickElement.click();

	}

	// Select Methods----------

	//Select by visible text

	public void selectByVisibleText(WebElement element, String text)
	{
		element = waitForElement(element, Condition.visibility);

		Select select = new Select(element);

		select.selectByVisibleText(text);

	}

	// Select by index

	public void selectByIndex(WebElement element, int index)
	{
		element = waitForElement(element, Condition.visibility); 
		Select select = new Select(element);

		select.selectByIndex(index);
	}

	// Select by value

	public void selectByValue(WebElement element, String value)
	{

		element = waitForElement(element, Condition.visibility);
		Select select = new Select (element);
		select.selectByValue(value);
	}



	//Generic Wait Method 
	public WebElement waitForElement(WebElement element, Condition condition)
	{
		//WebDriverWait wait = new WebDriverWait(parentDriver, 30);

		switch (condition)
		{
		case visibility:

			wait.until(ExpectedConditions.visibilityOf(element));

			break;

		case clickability:

			wait.until(ExpectedConditions.elementToBeClickable(element));

			break;	

		default:
			break;
		}
		return element;
	}


	//Generic verification Methods

	// Generic Titalcontain Method

	public boolean doesTitalConatain(String text)
	{
		try
		{
			return wait.until(ExpectedConditions.titleContains(text));
		}
		catch (Exception e) {
			return false;
		}

	}
	// Generic method for messagedisplay
	
		public boolean isMessageDisaplay(String message)
		{
			String finalxpath=getDynamicXpath("//*[contains(text(),'replaceThis')]", "replaceThis", message);

			try {
				 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("finalxpath")));
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		
		public String getDynamicXpath(String rawXpath,String replace,String with) 
		{
			return rawXpath.replace(replace, with);
		}
// Generic drag and drop method
		
		public void dargAndDropElement(WebElement dragElement, WebElement dropElement)
		{
			WebElement dragableElement= waitForElement(dragElement, Condition.clickability);
			WebElement dropableElement= waitForElement(dropElement, Condition.clickability);
			Actions action = new Actions(parentDriver);
			action.clickAndHold(dragableElement).moveToElement(dropableElement).release(dropableElement).build().perform();
			
		}
		
		
	}
