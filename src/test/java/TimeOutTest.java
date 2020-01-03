import org.testng.annotations.Test;

/**
 * Created by xiaofenShentu on 2020/1/3 15:37
 * 测试异步操作，可以使用timeOut，invocationCount调用次数
 * invocationTimeout调用超时总时间
 */

public class TimeOutTest {
    @Test(timeOut = 5000)
    void testTimeOut(){
        try{
            Thread.sleep(3000);
        }catch (Exception E){

        }
    }

    /*执行失败，因为总时间大于5s*/
    @Test(invocationCount = 3,invocationTimeOut = 5000)
    void testTimeOut2(){
        System.out.println("WAIT");
        try{
            Thread.sleep(2000);
        }catch (Exception E){

        }
    }

    /*用例成功，因为每次时间小于5s*/
  @Test(invocationCount = 10,timeOut = 5000,threadPoolSize = 5)
  void testTimeOut3(){
      System.out.println("WAIT");
      System.out.println(Thread.currentThread().getId());
      try{
          Thread.sleep(2000);
      }catch (Exception E){

      }

  }

}
