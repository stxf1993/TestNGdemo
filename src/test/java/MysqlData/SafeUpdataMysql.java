package MysqlData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Created by xiaofenShentu on 2019/12/24 12:43
 * 从根本上解决问题还有一种写法  在SQL语句中，
 * 不确定的条件用?代替，PreparedStatement（sql） 容器来装  setString（ n ，m）
 * 来赋值n是第几个问号的位置，m是赋的值
 * 增删改查都可以用这种方式
 */
public class SafeUpdataMysql {
    static String url = "jdbc:mysql://localhost:3306/mysql?useSSL=false&serverTimezone=UTC";
    static String user = "root";
    static String password = "root";
    static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) {

        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(url,user,password);

            //String sql2="selet * from USER WHERE loginame=? and password=?";

            String sql="insert into USER(ID, loginname, password) values(?,?,?)";
            PreparedStatement statement=connection.prepareStatement(sql);  //容器
            statement.setInt(1,9);
            statement.setString(2,"sunny");
            statement.setString(3,"123456");
            statement.executeUpdate();
            connection.close();

        }catch (Exception E){

        }

    }
}
