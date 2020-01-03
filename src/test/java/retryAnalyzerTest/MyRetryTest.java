package retryAnalyzerTest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by xiaofenShentu on 2020/1/3 21:03
 */
public class MyRetryTest implements IRetryAnalyzer {
    private int tryCount=0;
    private static final int maxRetyCount=3;

    public boolean retry(ITestResult iTestResult){
        if(tryCount<maxRetyCount){
            tryCount++;
            return true;
        }
        return false;
    }

}
