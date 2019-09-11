/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Brands;
import Classes.Users;
import Connector.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class User_DAO {

    public static ArrayList<Users> getListUsers() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM Users";
        ArrayList<Users> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //public Users(int _ID, String _UserName, String _PassWord, String _Email, int _Role, String _RealName, String _Address) {
                Users usr = new Users(rs.getInt("ID"), rs.getString("UserName"), rs.getString("Password"), rs.getString("Email"), rs.getInt("Role"), rs.getString("Realname"), rs.getString("Address"));
                list.add(usr);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Users GetByID(int ID) {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM Users where ID ='" + ID + "'";
        ArrayList<Users> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Users pro = new Users(rs.getInt("ID"), rs.getString("UserName"), rs.getString("Password"),
                        rs.getString("Email"), rs.getInt("Role"), rs.getString("Realname"), rs.getString("Address"));
                list.add(pro);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list.get(0);
    }

    public static boolean CheckExit(int Type, String key) {
        Connection cons = DBConnect.getConnection();
        String sql = "";
        if (Type == 0) {
            sql = "SELECT * FROM users where username = '" + key + "'";
        } else {
            sql = "SELECT * FROM users where email = '" + key + "'";
        }
        System.out.println(sql);
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cons.close();
                return true;

            } else {
                return false;

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static boolean Register(Users usr) {
        Connection cons = DBConnect.getConnection();
        String sql = "INSERT INTO users VALUES (NULL, '" + usr.getUserName() + "', '" + usr.getPassWord() + "', '" + usr.getEmail() + "', '" + usr.getRealName() + "', '" + usr.getAddress() + "', '1');";
        //INSERT INTO users VALUES (NULL, '1', '1', '1', '1', '1', '1');
        System.out.println(sql);
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ps.executeUpdate();
            cons.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static int ChangeInfo(Users usr) {
        Connection cons = DBConnect.getConnection();
        String sql = "Update users set Email= '" + usr.getEmail() + "',Realname = '"
                + usr.getRealName() + "',Address= '" + usr.getAddress() + "' where ID=" + usr.getID() + " and Password = '" + usr.getPassWord() + "'";
        System.out.println(sql);
        int result = -1;
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            result = ps.executeUpdate();
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int ChangePass(String OldPass, String Pass, int ID) {
        Connection cons = DBConnect.getConnection();
        String sql = "Update users set Password='" + Pass + "' where ID=" + ID + " and Password='" + OldPass + "'";
        System.out.println(sql);
        int result = -1;
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            result = ps.executeUpdate();
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int Delete(int ID) {
        String sql = "Delete from users where ID = " + ID;
        return UpdateDeleteChange(sql);
    }

    public static int Edit(Users usr) {
        String sql = "UPDATE users set UserName ='" + usr.getUserName()+ "' , Password = '" + usr.getPassWord() + "' , Email = '" + usr.getEmail() + "', Realname = '" + usr.getRealName()
                + "' , Address = '" + usr.getAddress() + "' , Role = " + usr.getRole() + " where ID = " + usr.getID();
        return UpdateDeleteChange(sql);
    }

    public static int Add(Users usr) {
        //INSERT INTO `category` VALUES (NULL, '1', '1', '1', NULL);
        String sql = "INSERT INTO users VALUES (NULL,'" + usr.getUserName() + "' , '" + usr.getPassWord() + "','"
                + usr.getEmail() + "' , '" + usr.getRealName() + "' , '" + usr.getAddress() + "'," + usr.getRole() + ")";
        return UpdateDeleteChange(sql);
    }

    private static int UpdateDeleteChange(String query) {
        Connection cons = DBConnect.getConnection();
        System.out.println(query);
        int result = -1;
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(query);
            result = ps.executeUpdate();
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Users Login(String UserName, String PassWord) {
        Connection cons = DBConnect.getConnection();
        String sql = "Select * from Users where UserName = '" + UserName + "' and Password = '" + PassWord + "'";
        System.out.println(sql);
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Users usr = new Users();
                usr.setAddress(rs.getString("Address"));
                usr.setPassWord(rs.getString("PassWord"));
                usr.setEmail(rs.getString("Email"));
                usr.setID(rs.getInt("ID"));
                usr.setRealName(rs.getString("Realname"));
                usr.setRole(rs.getInt("Role"));
                usr.setUserName(rs.getString("UserName"));
                cons.close();
                return usr;
            }
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void main(String[] args) {
        //System.out.println(ChangePass("1510289", "admin", 12));
        //System.out.println(GetByID(1).getUserName());
        System.out.println(Add(new Users(15, "_UserName1", "_PassWord1", "_Email1", 1, "_RealName1"," _Address1")));
        //System.out.println(Delete(15));
    }
}
