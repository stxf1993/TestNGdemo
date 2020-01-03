package retryAnalyzerTest2;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by xiaofenShentu on 2020/1/3 21:36
 */
public class OverideRetry implements IRetryAnalyzer {
    private int count=1;
    private int maxcount=5;

    public boolean retry(ITestResult iTestResult) {
        if (count<maxcount){
            count++;
            return true;
        }
        return false;
    }
}
