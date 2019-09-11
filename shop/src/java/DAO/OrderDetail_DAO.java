/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.OrderDetails;
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
public class OrderDetail_DAO {

    public static void insertBillDetail(OrderDetails bill) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "INSERT INTO orderdetails VALUES(NULL,'" + bill.getIDOrder() + "',"
                + "'" + bill.getProductName() + "','" + bill.getQuantity() + "',"
                + "'" + bill.getPrice() + "','" + bill.getTotal() + "')";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.executeUpdate();
    }

    public static ArrayList<OrderDetails> getOrderDetailByOrderID(int ID) {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM orderdetails where ID_Order = " + ID;
        ArrayList<OrderDetails> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderDetails pro = new OrderDetails(rs.getInt("ID"), rs.getInt("ID_Order"), rs.getString("ProductName"), rs.getInt("Quantity"), rs.getFloat("Price"), rs.getFloat("ToTal"));
                list.add(pro);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<OrderDetails> getOrders() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM orderdetails ";
        ArrayList<OrderDetails> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderDetails pro = new OrderDetails(rs.getInt("ID"), rs.getInt("ID_Order"), rs.getString("ProductName"), rs.getInt("Quantity"), rs.getFloat("Price"), rs.getFloat("ToTal"));
                list.add(pro);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int Delete(int ID) {
        String sql = "Delete from orderdetails where ID = " + ID;
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
        System.out.println(OrderDetail_DAO.Delete(1));
    }
}
