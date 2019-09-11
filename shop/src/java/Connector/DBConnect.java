package Connector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DBConnect {

    public static Connection getConnection() {
        Connection cns;
        cns = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cns =  DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useUnicode=yes&characterEncoding=UTF-8","root","");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return cns;
    }
    public static void main(String[] args) {
            System.out.println(getConnection());
    }
   
}
