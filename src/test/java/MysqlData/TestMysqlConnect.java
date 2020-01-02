package MysqlData;

import java.sql.*;

/**
 * Created by xiaofenShentu on 2019/12/23 21:39
 */
public class TestMysqlConnect {
    static String url = "jdbc:mysql://localhost:3306/mysql?useSSL=false&serverTimezone=UTC";
    static String user = "root";
    static String password = "root";
    static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    /**
     * *测试mysql数据库是否可以连接成功
     */
    public static void main(String[] args) {
        Connection conn=null;
        Statement statement=null;
        try {
            //注册JDBC驱动
            //Class.forName(xxx.xx.xx)的作用是要求JVM查找并加载指定的类，也就是说JVM会执行该类的静态代码段。
            Class.forName(JDBC_DRIVER);
            //打开链接
            System.out.println("连接数据库...");
            conn= DriverManager.getConnection(url,user,password);

            //执行查询
            System.out.println("实例化statement对象...");
            statement=conn.createStatement();
            String sql="select id, loginname, password from USER ";

            ResultSet resultSet = statement.executeQuery(sql);
            statement.executeUpdate(sql);

            //展开结果集数据库
            while (resultSet.next()){
                //通过字段检索
                int id=resultSet.getInt("id");
                String loginname=resultSet.getString("loginname");
                String password=resultSet.getString("password");
                //输出数据
                System.out.print("id:"+id+",");
                System.out.print("loginame:"+loginname+",");
                System.out.print("password:"+password+",");
                System.out.println("");
            }
            //完成后关闭
            resultSet.close();
            statement.close();
            conn.close();

        }catch (ClassNotFoundException e){
            //  处理 Class.forName 错误
            e.printStackTrace();
        }catch (SQLException E){
            //// 处理 JDBC 错误
            E.printStackTrace();
        }finally {
            //关闭资源
            try {
                if (statement!=null) statement.close();
            }catch (SQLException se2){}
        }try {if (conn!=null)conn.close();
        }catch (SQLException E){
            E.printStackTrace();
        }

        System.out.println("操作完成！");
    }



}
