package retryAnalyzerTest;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by xiaofenShentu on 2020/1/3 21:07
 */
public class caseTest {
    @BeforeTest
    public void bfTest(){
        System.out.println("beforeTest");
    }

    @Test(expectedExceptions = ArithmeticException.class,expectedExceptionsMessageRegExp = ".*zero")
    public void Test1(){
        System.out.println("CASE1");
        int c=1/0;
        Assert.assertEquals("1","1");
    }

    @Parameters("browser")
    @Test(retryAnalyzer = MyRetryTest.class) //失败重跑
    //@optional("chrome")的意思是：如果在testng.xml文件中没有找到名为"browser"的参数，测试方法将接受在@Optional注解中指定的默认值
    public void Test2(@Optional("2") int browser){
      Assert.assertEquals(browser,1);
    }
}
