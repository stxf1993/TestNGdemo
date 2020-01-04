import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaofenShentu on 2020/1/4 21:18
 * 用java代码虚拟化xml文件，来跑测试用例
 */
public class JavaScripRunTestng {

    public static void main(String[] args) {

        XmlSuite suite=new XmlSuite();
        suite.setName("测试java脚本跑suite");
        XmlTest test=new XmlTest(suite);
        test.setName("20200104test");
        List<XmlClass> classes=new ArrayList<XmlClass>();
        classes.add(new XmlClass("SimpleDemo.class1"));
        test.setClasses(classes);
        TestNG testNG=new TestNG();

        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        testNG.setXmlSuites(suites);
        testNG.run();

    }

}
