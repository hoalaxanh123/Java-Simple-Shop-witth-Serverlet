/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Orders;
import Connector.DBConnect;
import Controller.Order.OrderDetail;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Order_DAO {

    public static int insertBill(Orders bill) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "INSERT INTO Orders VALUES(NULL,'" + bill.getCreator() + "','" + (Date) bill.getDateCreate() + "',"
                + "'" + bill.getAddress() + "','" + bill.getEmail() + "','" + bill.getNote() + "','" + bill.getUserName() + "',"
                + "'" + bill.getPayMethod() + "','" + bill.getTotal() + "')";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        int generatedKey = 0;
        if (rs.next()) {
            generatedKey = rs.getInt(1);
        }
        System.out.println(generatedKey);
        return generatedKey;

    }

    public static ArrayList<Orders> getListOrdersByUserName(String userName) {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM Orders where UserName = '" + userName + "'";
        System.out.println(sql);
        ArrayList<Orders> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //    public Products(int ID, String Name, String DES, long Price, String releasedate, 
                //String screenresolution, String cpu, String ram, String internalmemory, String GPU, int ID_CAT, int ID_BRAND, boolean InHome) {
                Orders order = new Orders(rs.getInt("ID"), rs.getString("Creator"), rs.getDate("DateCreate"), rs.getString("Address"), rs.getString("Email"), rs.getString("Note"), rs.getString("UserName"), rs.getString("PayMethod"), rs.getFloat("Total"));
                list.add(order);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Orders> getListOrders() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM Orders ";
        System.out.println(sql);
        ArrayList<Orders> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //    public Products(int ID, String Name, String DES, long Price, String releasedate, 
                //String screenresolution, String cpu, String ram, String internalmemory, String GPU, int ID_CAT, int ID_BRAND, boolean InHome) {
                Orders order = new Orders(rs.getInt("ID"), rs.getString("Creator"), rs.getDate("DateCreate"), rs.getString("Address"), rs.getString("Email"), rs.getString("Note"), rs.getString("UserName"), rs.getString("PayMethod"), rs.getFloat("Total"));
                list.add(order);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Orders GetOrderByID(int ID) {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM Orders where ID ='" + ID + "'";
        ArrayList<Orders> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orders pro = new Orders(rs.getInt("ID"), rs.getString("Creator"), rs.getDate("DateCreate"), rs.getString("Address"), rs.getString("Email"), rs.getString("Note"), rs.getString("UserName"), rs.getString("PayMethod"), rs.getFloat("Total"));
                list.add(pro);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list.get(0);
    }

    public static int Delete(int ID) {
        String sql = "Delete from Orders where ID = " + ID;
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

    public static void main(String[] args) throws SQLException {
        Order_DAO.Delete(1);
    }

}
