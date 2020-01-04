package IAnnotationTransformerDemo;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by xiaofenShentu on 2020/1/4 21:39
 * IAnnotationTransformer继承了ITestNGListener接口，其要求实现transform方法。
 */
public class IAnnotationTransformerTest implements IAnnotationTransformer {

    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setInvocationCount(5); //执行5次
    }
}
