import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Z_DataControllerClass {

	public static void main(String[] args) {

		Properties prop = new Properties();

		try
		{

			prop.load(new FileInputStream(new File("C:\\Users\\hp\\eclipse-workspace\\GmailFramework\\Data.proerties")));

		}
		
		catch (IOException e) {
			e.getMessage();
		}

		String uname = prop.get("userName").toString();// since get method return type is object so we have to convert it into the String
				String pwd = prop.get("password").toString(); // search the value of userName in data proerties file.
		String msg = prop.get("message").toString();
		
		//System.out.println(uname, pwd, msg);
		System.out.println("Out Put = "+uname +" "+ pwd +" " + msg);

	}

}
