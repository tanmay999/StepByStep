package listeners;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestListeners  implements ITestListener {

   List<Map<String,Object>> testCases = new ArrayList<Map<String,Object>>();
    public  static  Object[] getTestParams(ITestResult iTestResult){
        return iTestResult.getParameters();
    }

    public static String getTestMethodName(ITestResult iTestResult){
        return  iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public void onTestStart(ITestResult result) {
        System.out.println("test started "+getTestMethodName(result));
    }

    public void onTestSuccess(ITestResult result) {
        Map<String,Object> testCase = new HashMap<String,Object>();
        testCase.put("name",getTestMethodName(result));
        testCase.put("result", Status.PASS);
        testCase.put("params",getTestParams(result));
        testCases.add(testCase);
    }

    public void onTestFailure(ITestResult result) {
        Map<String,Object>  testCase = new HashMap<>();
         testCase.put("name",getTestMethodName(result));
         testCase.put("result", Status.FAIL);
         testCase.put("params",getTestParams(result));
         testCases.add(testCase);
    }

    public void onTestSkipped(ITestResult result) {
         Map<String,Object>  testCase = new HashMap<>();
          testCase.put("name",getTestMethodName(result));
          testCase.put("result", Status.SKIP);
          testCase.put("params",getTestParams(result));
          testCases.add(testCase);

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }


    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
        

    }

}
