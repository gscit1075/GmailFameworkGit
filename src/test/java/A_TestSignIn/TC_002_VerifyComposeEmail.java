package A_TestSignIn;


import org.testng.Assert;
import org.testng.annotations.Test;
import A_SignIn.A_SignInPage;
import A_SignIn.B_HomePage;
//import pageClasses.HomePage;
import utilityPackage.ParentTestPage;

public class TC_002_VerifyComposeEmail extends ParentTestPage 
{

	@Test	
	public void Test()
	{
		try
		{
			B_HomePage ob2 = new B_HomePage(driver);	
			A_SignInPage ob1 = new A_SignInPage(driver);
			ob1.setEmailID(getData("username"));
			ob1.clickNext();
			ob1.setPassword(getData("password"));
			//ob2.ob1.clickSignIn();
			
			boolean status = ob2.doesTitalConatain(getData("username"));
			Assert.assertTrue(status == true,"User is not logged in");
			
			
			
			
			
			ob2.clickCompose();
		}

		catch (Exception e) {

			System.out.println(e.getMessage());
			Assert.fail(e.getMessage());

		}
		catch (AssertionError e) {

			System.out.println(e.getMessage());
			Assert.fail(e.getMessage());
		}

	}


}
