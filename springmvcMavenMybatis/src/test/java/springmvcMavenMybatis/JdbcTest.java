package springmvcMavenMybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTest {
    public static void main(String[] args) {
        // 数据库连接
        Connection con = null;
        // 执行sql
        ResultSet res = null;
        // 封装sql
        PreparedStatement pre = null;
        // 加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 创建连接
            // 创建连接
            String url = "jdbc:mysql://192.168.1.111:3306/test";
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(url, username, password);

            // 获取PreparedStatement对象
            String sql = "select * from user_t u  where  u.user_name=?";
            pre = con.prepareStatement(sql);

            // 封装查询的参数
            pre.setString(1, "yuexw");
            // 执行
            res = pre.executeQuery();
            // 打印结果集,
            while (res.next()) {
                System.out.println("username : " + res.getString("user_name"));
                System.out.println("password : " + res.getString("password"));
                System.out.println("age : " + res.getInt("age"));
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (pre != null) {
                    pre.close();
                }
                if (res != null) {
                    res.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

}
