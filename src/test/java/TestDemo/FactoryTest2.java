package TestDemo;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 * Created by xiaofenShentu on 2020/1/4 20:34
 */
public class FactoryTest2 {
        @Factory
        public Object[] test(){

            System.out.println(this);
            return new Object[]{new TestData(),new TestData()};
        }
}


class TestData{
    @Test
    public void case1(){
        System.out.println("登陆");
    }

    @Test
    public void case2(){
        System.out.println("退出");
    }
}