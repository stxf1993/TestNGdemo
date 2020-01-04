import org.testng.annotations.Test;

/**
 * Created by xiaofenShentu on 2020/1/3 15:16
 */
public class DenpendOnMethodTest {
    @Test
    void login(){
        System.out.println("登陆成功");
        //Assert.fail();
    }
    @Test(dependsOnMethods = "login")
    void getOrder(){
        System.out.println("下单");
    }

  /*  ignoreMissingDependencies属性
    如果为true，找不到依赖也继续执行。*/
    @Test(dependsOnGroups = "xxx",ignoreMissingDependencies = true)
    void getOrder3(){
        System.out.println("下单");
    }
}
