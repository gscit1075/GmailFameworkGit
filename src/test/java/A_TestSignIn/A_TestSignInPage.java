package A_TestSignIn;


import org.testng.Assert;
import org.testng.annotations.Test;
import A_SignIn.A_SignInPage;
import utilityPackage.ParentTestPage;

public class A_TestSignInPage extends ParentTestPage 
{
	@Test	
	public void Test()
	{
		try
		{
			A_SignInPage ob1 = new A_SignInPage(driver);
			ob1.setEmailID(getData("username"));
			ob1.clickNext();
			ob1.setPassword(getData("password"));
			ob1.clickNext();
			boolean status = ob1.doesTitalConatain(getData("username"));
			Assert.assertTrue(status == true,"User is not logged in");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail(e.getMessage());
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			Assert.fail(e.getMessage());
		}
}  }
