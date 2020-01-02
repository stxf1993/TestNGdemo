package MysqlData;

import org.testng.annotations.DataProvider;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaofenShentu on 2019/12/24 12:58
 */
public class getTestData {

    static String url = "jdbc:mysql://localhost:3306/mysql?useSSL=false&serverTimezone=UTC";
    static String user = "root";
    static String password = "root";
    static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    /**
     * *测试mysql数据库是否可以连接成功
     */

    @DataProvider
    public static Object[][] getDate( ) {
        List<Object[]> list=new LinkedList<Object[]>();
        Connection conn=null;
        Statement statement=null;
        try {
            Class.forName(JDBC_DRIVER);
            conn= DriverManager.getConnection(url,user,password);
            statement=conn.createStatement();
            String sql="select loginname, password from USER ";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Object[] S=new Object[2];
                S[0]=resultSet.getString("loginname");
                S[1]=resultSet.getString("password");
                list.add(S);
            }
            conn.close();

        }catch (Exception e){
            //  处理 Class.forName 错误
            e.printStackTrace();
        }

         //把list存放进二维数组
         Object[][] Ob=new Object[list.size()][];
        for (int i = 0; i <list.size() ; i++) {
            Ob[i]=list.get(i);
        }

        return Ob;
    }


}
