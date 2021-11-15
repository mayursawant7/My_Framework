package utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.google.common.io.Files;

import common.BaseTest;

public class SuiteListener implements ITestListener, IAnnotationTransformer{
	
	@Override		
    public void onFinish(ITestContext iTestContext) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onStart(ITestContext iTestContext) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailure(ITestResult iTestResult) {					
        String fileName= System.getProperty("C:\\Users\\sawantm\\eclipse-workspace\\YT_FrameW\\screenshots"+iTestResult.getMethod().getMethodName());
        File f=((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
        try {
			Files.copy(f,new File(fileName + ".png"));  ///Need to review
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        		
    }		

    @Override		
    public void onTestSkipped(ITestResult iTestResult) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestStart(ITestResult iTestResult) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestSuccess(ITestResult iTestResult) {					
        // TODO Auto-generated method stub				
        		
    }	
    @Override		
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyser.class);			
        
    }	

}
