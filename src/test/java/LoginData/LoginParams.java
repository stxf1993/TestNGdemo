package LoginData;

import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.Map;

/**
 *
 * @Description:
 */
public class LoginParams {


    /**
     * 提供用户登陆测试方法数据
     * @return
     */
    @DataProvider
    public Object[][] getUsers(){
        return new Object[][]{
                {"zhangsan","123456","欢迎zhangsan"},
                {"lisi","","用户名或密码不能为空"},
                {"","","用户名或密码不能为空"},
                {"admin","123456","欢迎管理员"}
        };
    }

    @DataProvider
    public Object[][] buy(){
        return new Object[][]{
                {"lisi","","用户名或密码不能为空",1,1,-2},
                {"admin","123456","欢迎管理员",1,-1,-1},
                {"zhangsan","123456","欢迎zhangsan",2,2,1}
        };
    }

    @DataProvider
    public Object[][] dataMethod(){
        List<Map<String, String>> result = ReadExcelUtil.getExcuteList("D:\\IDEA\\Workspace\\com.TestNG\\src\\test\\java\\LoginData\\bug.xlsx");
        Object[][] files = new Object[result.size()][];
        for(int i=0; i<result.size(); i++){
            //把map存入二位数组，共result.size行，每一行只有一个Object（一个map）
            files[i] = new Object[]{result.get(i)};
        }


        return files;
    }



   /* public static void main(String[] args) {

        List<Map<String, String>> result = ReadExcelUtil.getExcuteList("D:\\IDEA\\Workspace\\com.TestNG\\src\\test\\java\\LoginData\\bug.xlsx");
     *//*   Object[][] files = new Object[result.size()][];
        for(int i=0; i<result.size(); i++){
            files[i] = new Object[]{result.get(i)};
            //System.out.println(result.get(i));
        }
*//*
        Object[][] files2 = new Object[result.size()][];
        System.out.println("用例条数为："+result.size());
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
            files2[i][0]=result.get(i).get("name");
            files2[i][1]=result.get(i).get("pwd");
            files2[i][2]=result.get(i).get("exp");
        }




    }*/
}

