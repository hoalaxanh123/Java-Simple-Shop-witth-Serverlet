/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class Category_DAO {

    public static ArrayList<Category> getListCategory() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM category";
        ArrayList<Category> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"), rs.getString("Logo"), rs.getInt("ID_Parent"));
                list.add(category);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //Category pro = new Category(0, Name, Description, Logo, 0)
    public static Category GetCategoryByID(int ID) {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM Category where ID ='" + ID + "'";
        ArrayList<Category> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Category pro = new Category(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"), rs.getString("Logo"), rs.getInt("ID_Parent"));
                list.add(pro);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list.get(0);
    }

    public static int Delete(int ID) {
        String sql = "Delete from category where ID = " + ID;
        return UpdateDeleteChange(sql);
    }

    public static int Edit(Category cat) {
        String sql = "UPDATE category set Name ='" + cat.getName() + "' , Description = '" + cat.getDescription() + "', Logo = '" + cat.getLogo()+ "' where ID = " + cat.getID();
        return UpdateDeleteChange(sql);
    }

    public static int Add(Category cat) {
        //INSERT INTO `category` VALUES (NULL, '1', '1', '1', NULL);
        String sql = "INSERT INTO `category` VALUES (NULL,'" + cat.getName() + "' , '" + cat.getDescription() + "','"+cat.getLogo()+"',NULL)";
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
        //System.out.println(Delete(8));
        System.out.println(Add(new Category(4, "Điện thoại", "Điện thoại các loại", "<i class=\"fas fa-hand-holding-usd\"></i>", -1)));
        //System.out.println(Add(new Category(10, "Name", "Description", "Logo", -1)));

    }
}
