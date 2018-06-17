import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class GetDATAProperties {

	public static void main(String[] args) {
		Properties pro=new Properties();

		// load in data file with try and catch
		
		try {
			pro.load(new FileInputStream(new File("C:\\Users\\hp\\eclipse-workspace\\GmailFramework\\Data.proerties")));
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.getMessage();
		}

		//Now get the property from data file

		String unm = pro.getProperty("userName");
		String pass = pro.get("password").toString();

		System.out.println(unm);
		System.out.println(pass);

	}



}
