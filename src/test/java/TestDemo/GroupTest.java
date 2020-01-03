package TestDemo;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * Created by xiaofenShentu on 2020/1/3 14:45
 */
public class GroupTest {

}
class GroupTest1{
    @BeforeGroups({"group1"})
    public void beforeGroups(){
        System.out.println("beforeGroups");
    }
    @Test(groups = "group1")
    public void testGroup1(){
        System.out.println("GroupTest1=group1");
    }

    @Test(groups = "group2")
    public void testGroup2(){
        System.out.println("GroupTest1=group2");
    }

    @Test(groups = {"group1","group2"})
    public void testGroup12(){
        System.out.println("GroupTest1=group1+group2");
    }
}

class GroupTest2{
    @org.testng.annotations.AfterGroups({"group1"})
    public void afterGroups() {
        System.out.println("AfterGroups");
    }

    @org.testng.annotations.Test(groups = "group1")
    public void testGroup1() {
        System.out.println("GroupTest2=group2");
    }

    @org.testng.annotations.Test(groups = "group2")
    public void testGroup2() {
        System.out.println("GroupTest2=group2");
    }

    @org.testng.annotations.Test(groups = {"group1","group2"})
    public void testGroup12() {
        System.out.println("GroupTest2=group1+group2");
    }
}