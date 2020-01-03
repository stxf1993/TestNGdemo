package ListenerDemo;

import org.testng.SkipException;
import org.testng.annotations.Test;

/**
 * Created by xiaofenShentu on 2020/1/3 17:57
 */
public class TestCase {

    @Test(description = "成功的用例")
    void Test1(){
        System.out.println("success case");
    }

    @Test(description = "超时失败的用例",timeOut = 2000)
    void Test2(){
        System.out.println("fail case");
        try {
            Thread.sleep(3000);
        }catch (Exception E){

        }

    }

    @Test(description = "跳过的用例1",dependsOnMethods = "Test2")
    void Test3(){

        System.out.println("skip case");
    }


    @Test(description = "跳过的用例2",priority = 2)
    void Test4(){

        System.out.println("skip case");
        throw new SkipException("skip the case!");
    }

}
