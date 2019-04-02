package com.utils;

import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    private static Connection conn;
    private static Statement stmt;
    private static Gson gson;

    public static Gson gson(){
        if(gson==null){
            synchronized (DB.class){
                if(gson==null){
                    gson=new Gson();
                }
            }
        }
        return gson;

    }
    public static Connection getConn() {
        if (conn == null) {
            synchronized (DB.class) {
                if (conn == null) {
                    try {
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        //mysql数据库的端口默认是3306；characterEncoding的指编码格式,这个一定要加，不然存到数据库的数据会乱码;最后面的两个参数是mysql数据库的用户名和密码,我的是用户名是root密码是root,连接你自己的时候,你改成你自己的就可以了
                        //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bio_member_system?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull", "root", "root");
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bio_member_system?useUnicode=true&characterEncoding=utf8&useOldAliasMetadataBehavior=true&useSSL=false&serverTimezone=GMT"
                                , "root", "root");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return conn;
    }

    public static Statement getStmt() {
     if(stmt==null){

         synchronized (DB.class){
             if(stmt==null){
                 try {
                     stmt = getConn().createStatement();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
             }
         }
     }

        return stmt;
    }

    public static PreparedStatement getPrepareStmt(String sql) {
        try {
           return getConn().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static ResultSet executeQuery(String sql) {

        try {
          return getStmt().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet executeQuery(PreparedStatement preparedstmt) {

        try {
           return preparedstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}