/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Brands;
import Classes.Category;
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
public class Brand_DAO {

    public static ArrayList<Brands> getListBrands() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM Brands";
        ArrayList<Brands> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Brands brand = new Brands(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"), rs.getString("logo"));
                list.add(brand);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Brands GetByID(int ID) {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM Brands where ID ='" + ID + "'";
        ArrayList<Brands> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Brands pro = new Brands(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"), rs.getString("Logo"));
                list.add(pro);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list.get(0);
    }

    public static int Delete(int ID) {
        String sql = "Delete from brands where ID = " + ID;
        return UpdateDeleteChange(sql);
    }

    public static int Edit(Brands br) {
        String sql = "UPDATE brands set Name ='" + br.getName() + "' , Description = '" + br.getDescription() + "' , Logo = '" + br.getLogo() + "' where ID = " + br.getID();
        return UpdateDeleteChange(sql);
    }

    public static int Add(Brands br) {
        //INSERT INTO `category` VALUES (NULL, '1', '1', '1', NULL);
        String sql = "INSERT INTO brands VALUES (NULL,'" + br.getName() + "' , '" + br.getDescription() + "','" + br.getLogo() + "')";
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

    public static void main(String[] args) {
        //System.out.println(Add(new Brands(0, "Name", "Des", "Logo")));
   System.out.println(Edit(new Brands(1, "Name1", "SAMSUNG là hãng điện tử hàng đầu", "Logo1")));
        //System.out.println(Delete(8));
         //System.out.println(GetByID(5).getName());
    }
}
