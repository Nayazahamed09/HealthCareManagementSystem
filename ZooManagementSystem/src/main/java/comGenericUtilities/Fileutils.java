package comGenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Fileutils  {
	/*
	 * This method is used to read the data from property File
	 */
	
	public String readdata(String Key) throws IOException 
	{
		FileInputStream fis=new FileInputStream(IpathConstants.Commondata);
	 Properties OBJ = new Properties();
	 OBJ.load(fis);
	 String value=OBJ.getProperty(Key);
	 return value;
	}
	
	
	

}
