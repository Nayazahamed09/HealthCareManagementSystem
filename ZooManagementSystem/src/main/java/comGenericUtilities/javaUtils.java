package comGenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class javaUtils  {
	
	public int getRandomNo()
	{
		Random R=new Random();
		
		int random=R.nextInt(100);
		return random;
		
				
	}
	
	public String getSystemDate() {
		Date D=new Date();
		
		String Date=D.toString();
		return Date;
	}
	
	public String getSystemdateFormat() {
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-/MM/yyyy  HH-mm-ss");
		Date D=new Date();
		 
		String SystemDateFormat = dateFormat.format(D);
		return SystemDateFormat;
	}

	
	}

