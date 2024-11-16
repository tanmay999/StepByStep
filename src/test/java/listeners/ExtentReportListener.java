package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.internal.http.Status;
import jdk.jfr.internal.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.LogManager;


public class ExtentReportListener implements ITestListener {

    private static final String OUTPUT_FOLDER="C:\\Users\\tanma\\Documents\\StepByStep\\src\\test\\resources\\utils";
    private static final String FILE_NAME="TestExcecutionReport.html";

    private static ExtentReports extentReports ;
    private ThreadLocal<ExtentTest> test =new ThreadLocal<ExtentTest>();

    private static ExtentReports extent= init();

    private Date getTime(long millis){
        Calendar calendar =  Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }



    private static ExtentReports init(){
        extentReports = new ExtentReports();
        Path path = Paths.get(OUTPUT_FOLDER);
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(OUTPUT_FOLDER+FILE_NAME);
        extentSparkReporter.config().setReportName("Api SomeTest Report");
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("System","MAC");
        extentReports.setSystemInfo("Author","TANMAY");
        extentReports.setSystemInfo("Build","1.1");
        extentReports.setSystemInfo("Customer name","NAL");

        return  extentReports;


    }


    public synchronized void  onTestStart(ITestResult result) {


          String methodName = result.getMethod().getMethodName();
          String qualifiedName = result.getMethod().getQualifiedName();



        System.out.println("started");
        ExtentTest extentTest =  extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        extentTest.assignCategory(result.getTestContext().getSuite().getName());
        test.set(extentTest);
         test.get().getModel().setStartTime(getTime(result.getStartMillis()));

    }

    public  synchronized void onTestSuccess(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        System.out.printf(methodName+"passed");
        test.get().pass("test passed");
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));


    }

    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        test.get().fail(methodName+ Status.FAILURE);
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }

    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+"skipped");
        test.get().skip("skipped");
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {

        this.onTestFailure(result);
    }

    public synchronized void onStart(ITestContext context) {
        System.out.printf("Test suite started");
    }

    public synchronized void  onFinish(ITestContext context) {
        System.out.println("Test suite is end");
        extent.flush();
        test.remove();
    }
}
