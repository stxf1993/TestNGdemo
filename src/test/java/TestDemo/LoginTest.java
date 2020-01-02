package TestDemo;

import CommonsCsvGetData.GetCsvData;
import Demo.Login;
import LoginData.LoginParams;
import MysqlData.getTestData;
import org.testng.annotations.Test;

import java.util.Map;


public class LoginTest {

   // @Parameters({"name", "pwd", "expect"})  //会从xml中取参数值，赋给下面的方法

    //要从getUser方法中取数据，方法所属类为LoginParams
    @Test(dataProvider = "getUser",dataProviderClass = LoginParams.class )
    void testLogin(String loginame,String password,String expect){
        Login login=new Login();
        String ac=login.userLogin(loginame,password);
         //Assert.assertEquals(expect,ac);
    }


    /**从excel中取值,利用pio
     *返回一个参数，参数类型是Map
     * */

    @Test(dataProvider = "dataMethod",dataProviderClass = LoginParams.class )

    public void testLogin2(Map<Object,Object> param){
       System.out.println(param.get("name"));
        System.out.println(param.get("pwd"));
         String loginname=param.get("name").toString();
         String password=param.get("pwd").toString();
        Login login=new Login();
        String ac=param.get("exp").toString();
        String ss=login.userLogin(loginname,password);
        System.out.println("期望结果为："+ac);
        System.out.println("实际结果为"+ss);

    }


    /*测试是否能从DB中直接获取测试数据*/

    @Test(dataProvider = "getDate" ,dataProviderClass = getTestData.class)

    void testMysql(String loginname,String password){
        System.out.println("loginname="+loginname);
        System.out.println("password="+password);
    }


    /*从excel中取值,利用common-csv*/

    @Test(dataProvider = "getData" ,dataProviderClass = GetCsvData.class)

    void test111(String loginname,String password,String exp){
        System.out.println("loginname="+loginname);
        System.out.println("password="+password);
        System.out.println("exp="+exp);
    }



}

