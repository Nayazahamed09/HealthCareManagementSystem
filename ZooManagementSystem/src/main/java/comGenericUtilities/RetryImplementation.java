package comGenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementation implements IRetryAnalyzer {
	
	int count=0;
	int retrycount=1;

	@Override
	public boolean retry(ITestResult result) {
		
		if(count<=retrycount)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
