package TestDemo;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 * Created by xiaofenShentu on 2020/1/3 14:24
 * @Factory是用来创建一个测试类的多个实例，每个实例的属性不同，以执行不同的测试。
 */
public class FactoryTest {
    @Factory
    public  Object[] FactoryTest1(){
        return new Object[]{new Test1(1),new Test1(2)};
    }
}

 class Test1{
    private int count;
    public Test1(int count){
        this.count=count;
    }

    @Test
    public void test(){
        System.out.println("tEST1-不同实例地址"+this);
        for (int i = 0; i <count ; i++) {
            System.out.println("Test1-test-"+i);

        }
    }

}