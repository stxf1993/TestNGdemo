package Demo;

import lombok.Data;

/**
 * 模拟一个登陆校验方法
 * @loginname 登录名
 * @password  密码
 *返回String，登陆状态
 */
@Data
public class Login {


    public static boolean isLogin=false;

    public String userLogin(String loginname,String password){

        if (loginname.equals("stxf")&&password.equals("123456")){

            System.out.println("账号密码正确"+loginname+"登陆成功！");
            isLogin=true;
            return "LoginSuccess";

        }else if (null==loginname||loginname.equals("")||null==password||password.equals("")){


            System.out.println("账号/密码为空！");
            isLogin=false;
            return "LoginnameOrPasswordIsEmpty";
        }else if (loginname.equals("admin")&&password.equals("admin")){

            System.out.println("账号密码正确，管理员登陆！");
            isLogin=true;
            return "LoginSuccesAdmin";
        }else {
            System.out.println("账号密码错误！");
            return "LoginnameOrPasswordIsError";
        }


    }


}



