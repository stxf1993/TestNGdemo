import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xiaofenShentu on 2020/1/3 18:53
 */
public class AssertTest {
    @Test
    void test1(){
        Assert.assertTrue(true);
    }

    @Test
    void test2(){
        Assert.assertTrue(false,"设置断言失败");
    }

    @Test
    void test3(){
        //直接设置用例失败
        Assert.fail("失败");
    }

    @Test
    void test4(){
        int i=10;
        Assert.assertEquals(i,10);
    }

}
