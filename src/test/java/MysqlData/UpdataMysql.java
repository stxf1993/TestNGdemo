package MysqlData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by xiaofenShentu on 2019/12/24 12:25
 * executeUpdate可以用来增加 删除 修改数据库数据
 * 但是这种方式容易产生sql注入攻击
 * 例如用户名字段传入 stxf'or 1=1 #
 */
public class UpdataMysql {
    static String url = "jdbc:mysql://localhost:3306/mysql?useSSL=false&serverTimezone=UTC";
    static String user = "root";
    static String password = "root";
    static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) {
        Connection conn=null;
        Statement statement=null;
        try {
            Class.forName(JDBC_DRIVER);
            conn= DriverManager.getConnection(url,user,password);
            statement=conn.createStatement();
            //String sql="insert into USER values(9,'sunny',123456) ";
            //String sql="Delete from USER where ID=9";
            String sql="UPDATE USER SET password=12345678 WHERE loginname='stxf'";
            statement.executeUpdate(sql);

        }catch (Exception E){

        }  try {
            conn.close();
        }catch (SQLException E){

        }

    }
}
