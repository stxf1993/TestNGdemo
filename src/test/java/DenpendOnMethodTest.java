import org.testng.annotations.Test;

/**
 * Created by xiaofenShentu on 2020/1/3 15:16
 */
public class DenpendOnMethodTest {
    @Test
    void login(){
        System.out.println("登陆成功");
    }
    @Test(dependsOnMethods = "login")
    void getOrder(){
        System.out.println("下单");
    }
}
