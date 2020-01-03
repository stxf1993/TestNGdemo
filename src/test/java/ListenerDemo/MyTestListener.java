package ListenerDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * Created by xiaofenShentu on 2020/1/3 17:40
 * ITestListener  测试运行的监听器。
 * 实现ITestListener接口的类在加入TestNG后，
 * 会在用例执行期间，测试类加载后，每个测试方法@Test之前前后调用执行。
 */
public class MyTestListener implements ITestListener {
    //用例执行成功后调用
    public void onTestSuccess(ITestResult tr){
        logTestEnd(tr,"执行成功——success");
    }
    //用例执行结束后，用例执行失败时调用
    public void onTestFailure(ITestResult tr) {
        logTestEnd(tr, "执行失败——Failed");
    }
    //用例执行结束后，用例执行skip时调用
    public void onTestSkipped(ITestResult tr) {
        logTestEnd(tr, "执行跳过——Skipped");
    }

    //每次方法失败但是已经使用successPercentage进行注释时调用，并且此失败仍保留在请求的成功百分比之内。
    public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
        logTestEnd(tr, "FailedButWithinSuccessPercentage");
    }

    //每次调用测试@Test之前调用
    public void onTestStart(ITestResult result) {
        logTestStart(result);
    }
    //在测试类被实例化之后调用，并在调用任何配置方法之前调用。
    public void onStart(ITestContext context) {
        return;
    }

    //在所有测试运行之后调用，并且所有的配置方法都被调用
    public void onFinish(ITestContext context) {
        return;
    }

    // 在用例执行结束时，打印用例的执行结果信息
    protected void logTestEnd(ITestResult tr, String result) {
        Reporter.log(String.format("======Result: %s======", result), true);
    }

    // 在用例开始时，打印用例的一些信息，比如@Test对应的方法名，用例的描述等等
    protected void logTestStart(ITestResult tr) {
        Reporter.log(String.format("========Run: %s=========", tr.getMethod()), true);
        Reporter.log(String.format("用例描述: %s, 优先级: %s", tr.getMethod().getDescription(), tr.getMethod().getPriority()),
                true);
        return;
    }
}
