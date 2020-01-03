package retryAnalyzerTest2;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xiaofenShentu on 2020/1/3 22:22
 */
public class testcase {
    @Test
    void case1(){
        System.out.println("SUCCESS");
    }

    @Test
    void case2(){
        Assert.fail("fail");
    }
}
