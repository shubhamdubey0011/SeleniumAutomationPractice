package utility;

import org.testng.IInvokedMethod;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.InvokedMethod;

public class Listners implements ITestListener
{
	public static String value;
	
	public void onTestStart(ITestResult result) {
		IInvokedMethod method = new InvokedMethod(result.getTestClass(), result.getMethod(),null,
				System.currentTimeMillis(), result);
		
		value = method.getTestMethod().getXmlTest().getLocalParameters().get("platform");
		
		System.out.println(value+"=========");		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}


	
}
