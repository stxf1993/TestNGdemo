package retryAnalyzerTest2;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by xiaofenShentu on 2020/1/3 21:38
 * IAnnotationTransformer 注解转换器
 */
public class overrideTransformer implements IAnnotationTransformer {



    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        IRetryAnalyzer iRetryAnalyzer=annotation.getRetryAnalyzer();

        if (iRetryAnalyzer==null){
            annotation.setRetryAnalyzer(OverideRetry.class);
        }

    }

}
