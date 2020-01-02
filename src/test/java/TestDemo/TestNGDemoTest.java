package TestDemo;

import org.testng.annotations.*;

/**
 * Created by xiaofenShentu on 2019/12/22 16:58
 * 测试TestNG的组件执行顺序
 */
public class TestNGDemoTest {

    @BeforeClass
        //在调用当前类的第一个测试方法之前运行，注释方法仅运行一次
    void testBeforeClass() {
        System.out.println("testBeforeClass");
    }

    @AfterClass
        //在调用当前类的第一个测试方法之后运行，注释方法仅运行一次
    void testAfterClass() {
        System.out.println("testAfterClass");
    }

    @BeforeTest
        //注释的方法将在属于test标签内的类的所有测试方法运行之前运行
    void testBeforeTest() {
        System.out.println("testBeforeTest");
    }

    @AfterTest
        //注释的方法将在属于test标签内的类的所有测试方法运行之前运行
    void testAfterTest() {
        System.out.println("testAfterTest");
    }


    @BeforeMethod
        //注释方法将在每个测试方法之前运行
    void testBeforeMethod() {
        System.out.println("testBeforeMethod");

    }

    @AfterMethod
        //注释方法将在每个测试方法之后运行
    void testAfterMethod() {
        System.out.println("testAfterMethod");

    }

    @BeforeSuite
        //在该套件的所有测试都运行在注释的方法之前，仅运行一次
    void testBeforeSuite() {
        System.out.println("testBeforeSuite");
    }

    @AfterSuite
        //在该套件的所有测试都运行在注释方法之后，仅运行一次
    void testAfterSuite() {
        System.out.println("testAfterSuite");
    }


    @BeforeGroups
        //配置方法将在之前运行组列表。 此方法保证在调用属于这些组中的任何一个的第一个测试方法之前不久运行
    void testBeforeGroups() {
        System.out.println("testBeforeGroups");
    }

    @AfterGroups
        //此配置方法将在之后运行组列表。该方法保证在调用属于任何这些组的最后一个测试方法之后不久运行
    void testAfterGroups() {
        System.out.println("testAfterGroups");
    }

    @Test
    void test1() {
        System.out.println("test1");
    }


    @Test
    void test2() {
        System.out.println("test2");
    }

    @Test(groups = "group1")
    void test3() {
        System.out.println("test3,group1");
    }

    @Test(groups = "group1",timeOut = 4000)  //花费时间超过4000毫秒，将其标记为失败
    void test4() {
        System.out.println("test4,group1");
        try{
        Thread.sleep(1000);
         }catch (Exception E){

        }
    }

    @Test(groups = "group2")
    void test5() {
        System.out.println("test5,group1");


    }

    @Test //test6不会被执行
    void test6() {
        System.out.println("test6,group1");


    }
}