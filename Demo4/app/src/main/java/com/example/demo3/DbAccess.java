package com.example.demo3;

import java.sql.*;

public class DbAccess {

//    public static boolean checkUsername(String tempUsername)
//    {
//        return true;
//    }

    public static boolean loginUserToDB(User tempUser) throws ClassNotFoundException, SQLException, ArithmeticException {
        Connection conn =null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String URL="jdbc:mysql://10.0.2.2/recipe_collection?autoReconnect=true";
        //Connection conn = DriverManager.getConnection(URL, "root", "");
        conn = DriverManager.getConnection
                ("jdbc:mysql://127.0.0.1:3306/recipe_collection","root","");

//        conn = DriverManager.getConnection
//                ("jdbc:mysql://10.0.2.2:3306/recipe_collection?autoReconnect=true&useSSL=false", "root", "");

        PreparedStatement sel = conn.prepareStatement("select username from users where username=? AND password=?");
        ResultSet rs = null;
        sel.setString(1, tempUser.getUsername());
        sel.setString(2, tempUser.getPwd());
        rs = sel.executeQuery();
        if (!rs.next()) {
            throw new ArithmeticException("username or password is wrong");
        }
       return true;
    }

//    public static boolean registerUserToDB(User tempUser) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe_collection?autoReconnect=false&useSSL=false", "root", "");
//        PreparedStatement sel = conn.prepareStatement("select username from users where username=?");
//        ResultSet rs = null;
//        sel.setString(1, tempUser.getUsername());
//        rs = sel.executeQuery();
//        if (rs.next())
//            throw new ArithmeticException("username already exists");
//        PreparedStatement ps = conn.prepareStatement("insert into users (username,password,secretQuestion,secretAnswer)  values (?,?,?,?)");
//        ps.setString(1, tempUser.getUsername());
//        ps.setString(2, tempUser.getPwd());
//        ps.setString(3, tempUser.getSecretQuestion());
//        ps.setString(4, tempUser.getSecretAnswer());
//        int updateFlag = ps.executeUpdate();
//        if (updateFlag > 0) {
//
//            return true;
//
//        } else {
//            throw new ArithmeticException("registration failed");
//        }
//    }





}



