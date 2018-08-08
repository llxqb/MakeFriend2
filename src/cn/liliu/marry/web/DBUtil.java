package cn.liliu.marry.web;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DBUtil {
    //JDBC驱动程序名
    private static String driverName;
    //数据库名称
    private static String dateBaseName;
    //用户名
    private static String username;
    //密码
    private static String password;
    private static String url;
//    private static Connection conn;
    private static Statement sm;

    static {
        Properties p = new Properties();
        InputStream io = DBUtil.class
                .getClassLoader().getResourceAsStream("db.properties");
        try {
            p.load(io);
            driverName = p.getProperty("driverName");
            dateBaseName = p.getProperty("dateBaseName");
            url = p.getProperty("url") + dateBaseName;
            username = p.getProperty("username");
            password = p.getProperty("pwd");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //建立连接
    public static Connection connectDB() {
        try {
            try {
                Class.forName(driverName).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Connection conn = DriverManager.getConnection(url, username, password);
            sm = conn.createStatement();
            return conn;
        } catch (SQLException e) {
            System.out.println("数据库连接失败！"+e.toString());
            return null;
        }
    }

//    //释放连接
//    public static void closeDB() {
//        try {
//            if (sm != null) {
//                sm.close();
//            }
//        } catch (SQLException e) {
//            System.out.println("关闭Statement失败！");
//        }
//        try {
//            if (conn != null) {
//                conn.close();
//            }
//        } catch (SQLException e) {
//            System.out.println("关闭Connection失败！");
//        }
//    }

    public Statement getStatement() {
        return sm;
    }

    public void setStatement(Statement sm) {
        this.sm = sm;
    }

}
