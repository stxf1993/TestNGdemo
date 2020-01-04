import org.testng.annotations.Test;

/**
 * Created by xiaofenShentu on 2020/1/4 19:59
 */
public class ExceptionDemo {
    /*捕捉到期望的数学异常，且异常信息符合正则表达式，用例通过*/

    @Test(expectedExceptions = ArithmeticException.class,expectedExceptionsMessageRegExp = ".*zero")
    void case1(){
        int c=1/0;
    }

    /*捕捉到空指针异常*/
    @Test(expectedExceptions = NullPointerException.class)
    void case2(){
        String s=null;
        s.length();
    }

}
