/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Products;
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
public class Product_DAO {

    public static ArrayList<Products> getListProduct() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM products ";
        ArrayList<Products> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //    public Products(int ID, String Name, String DES, long Price, String releasedate, 
                //String screenresolution, String cpu, String ram, String internalmemory, String GPU, int ID_CAT, int ID_BRAND, boolean InHome) {

                Products pro = new Products(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"),
                        rs.getLong("Price"), rs.getString("releasedate"), rs.getString("screenresolution"), rs.getString("cpu"),
                        rs.getString("ram"), rs.getString("internalmemory"), rs.getString("GPU"), rs.getInt("ID_CAT"), rs.getInt("ID_BRAND"),
                        rs.getBoolean("InHome"), rs.getString("ShortDes"));
                list.add(pro);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Products> getListProductByCatIDandPages(long categoryID, int firstResult, int maxResult) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM products WHERE ID_CAT = '" + categoryID + "' limit ?,?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, firstResult);
        ps.setInt(2, maxResult);
        ResultSet rs = ps.executeQuery();
        ArrayList<Products> list = new ArrayList<>();
        while (rs.next()) {
            Products product = new Products(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"),
                    rs.getLong("Price"), rs.getString("releasedate"), rs.getString("screenresolution"), rs.getString("cpu"),
                    rs.getString("ram"), rs.getString("internalmemory"), rs.getString("GPU"), rs.getInt("ID_CAT"), rs.getInt("ID_BRAND"),
                    rs.getBoolean("InHome"), rs.getString("ShortDes"));
            list.add(product);
        }
        return list;
    }

    public static int CountProductByCatID(int catID) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT COUNT(ID) FROM PRODUCTS WHERE ID_CAT=" + catID + "";
        System.out.println(sql);
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int count = 0;
        while (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }

    public static int CountProductByCatIDandBrandID(int catID, int BrandID) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT COUNT(ID) FROM PRODUCTS WHERE ID_CAT=" + catID + " and ID_BRAND=" + BrandID;
        System.out.println(sql);
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int count = 0;
        while (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }

    public static int CountProductByBrandID(int brandID) throws SQLException {
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT COUNT(ID) FROM PRODUCTS WHERE ID_BRAND=" + brandID + "";
        System.out.println(sql);
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int count = 0;
        while (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }

    public static ArrayList<Products> getListProductHome() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM products where InHome = 1 LIMIT 30";
        ArrayList<Products> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //    public Products(int ID, String Name, String DES, long Price, String releasedate, 
                //String screenresolution, String cpu, String ram, String internalmemory, String GPU, int ID_CAT, int ID_BRAND, boolean InHome) {

                Products pro = new Products(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"),
                        rs.getLong("Price"), rs.getString("releasedate"), rs.getString("screenresolution"), rs.getString("cpu"),
                        rs.getString("ram"), rs.getString("internalmemory"), rs.getString("GPU"), rs.getInt("ID_CAT"), rs.getInt("ID_BRAND"),
                        rs.getBoolean("InHome"), rs.getString("ShortDes"));
                list.add(pro);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Products> getListProductByCatID(int CatID) {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM products where ID_CAT ='" + CatID + "' LIMIT 30";
        ArrayList<Products> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //    public Products(int ID, String Name, String DES, long Price, String releasedate, 
                //String screenresolution, String cpu, String ram, String internalmemory, String GPU, int ID_CAT, int ID_BRAND, boolean InHome) {

                Products pro = new Products(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"),
                        rs.getLong("Price"), rs.getString("releasedate"), rs.getString("screenresolution"), rs.getString("cpu"),
                        rs.getString("ram"), rs.getString("internalmemory"), rs.getString("GPU"), rs.getInt("ID_CAT"), rs.getInt("ID_BRAND"),
                        rs.getBoolean("InHome"), rs.getString("ShortDes"));
                list.add(pro);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Products> getListProductByBrandID(int BrandID) {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM products where ID_BRAND ='" + BrandID + "' LIMIT 30";
        ArrayList<Products> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Products pro = new Products(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"),
                        rs.getLong("Price"), rs.getString("releasedate"), rs.getString("screenresolution"), rs.getString("cpu"),
                        rs.getString("ram"), rs.getString("internalmemory"), rs.getString("GPU"), rs.getInt("ID_CAT"), rs.getInt("ID_BRAND"),
                        rs.getBoolean("InHome"), rs.getString("ShortDes"));
                list.add(pro);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Products> getListProductByBrandIDandPage(int BrandID, int firstResult, int maxResult) {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM products where ID_BRAND ='" + BrandID + "' LIMIT ?,?";
        ArrayList<Products> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ps.setInt(1, firstResult);
            ps.setInt(2, maxResult);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //    public Products(int ID, String Name, String DES, long Price, String releasedate, 
                //String screenresolution, String cpu, String ram, String internalmemory, String GPU, int ID_CAT, int ID_BRAND, boolean InHome) {

                Products pro = new Products(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"),
                        rs.getLong("Price"), rs.getString("releasedate"), rs.getString("screenresolution"), rs.getString("cpu"),
                        rs.getString("ram"), rs.getString("internalmemory"), rs.getString("GPU"), rs.getInt("ID_CAT"), rs.getInt("ID_BRAND"),
                        rs.getBoolean("InHome"), rs.getString("ShortDes"));
                list.add(pro);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Products> FindProducts(String keyWord) {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM products where Name like  '%" + keyWord + "%'";
        System.out.println(sql);
        ArrayList<Products> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //    public Products(int ID, String Name, String DES, long Price, String releasedate, 
                //String screenresolution, String cpu, String ram, String internalmemory, String GPU, int ID_CAT, int ID_BRAND, boolean InHome) {

                Products pro = new Products(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"),
                        rs.getLong("Price"), rs.getString("releasedate"), rs.getString("screenresolution"), rs.getString("cpu"),
                        rs.getString("ram"), rs.getString("internalmemory"), rs.getString("GPU"), rs.getInt("ID_CAT"), rs.getInt("ID_BRAND"),
                        rs.getBoolean("InHome"), rs.getString("ShortDes"));
                list.add(pro);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Products> getProductsLastest(int SL) {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM products ORDER BY id DESC LIMIT " + SL + "";
        System.out.println(sql);
        ArrayList<Products> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //    public Products(int ID, String Name, String DES, long Price, String releasedate, 
                //String screenresolution, String cpu, String ram, String internalmemory, String GPU, int ID_CAT, int ID_BRAND, boolean InHome) {

                Products pro = new Products(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"),
                        rs.getLong("Price"), rs.getString("releasedate"), rs.getString("screenresolution"), rs.getString("cpu"),
                        rs.getString("ram"), rs.getString("internalmemory"), rs.getString("GPU"), rs.getInt("ID_CAT"), rs.getInt("ID_BRAND"),
                        rs.getBoolean("InHome"), rs.getString("ShortDes"));
                list.add(pro);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Products> getListProductByCatIDAndBrandID(int CatID, int BrandID) {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM products where ID_CAT ='" + CatID + "' and ID_BRAND = '" + BrandID + "'";
        ArrayList<Products> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //    public Products(int ID, String Name, String DES, long Price, String releasedate, 
                //String screenresolution, String cpu, String ram, String internalmemory, String GPU, int ID_CAT, int ID_BRAND, boolean InHome) {

                Products pro = new Products(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"),
                        rs.getLong("Price"), rs.getString("releasedate"), rs.getString("screenresolution"), rs.getString("cpu"),
                        rs.getString("ram"), rs.getString("internalmemory"), rs.getString("GPU"), rs.getInt("ID_CAT"), rs.getInt("ID_BRAND"),
                        rs.getBoolean("InHome"), rs.getString("ShortDes"));
                list.add(pro);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Products> getListProductByCatIDAndBrandID(int CatID, int BrandID, int firstResult, int maxResult) {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM products where ID_CAT ='" + CatID + "' and ID_BRAND = '" + BrandID + "' limit ?,?";
        ArrayList<Products> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ps.setInt(1, firstResult);
            ps.setInt(2, maxResult);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //    public Products(int ID, String Name, String DES, long Price, String releasedate, 
                //String screenresolution, String cpu, String ram, String internalmemory, String GPU, int ID_CAT, int ID_BRAND, boolean InHome) {

                Products pro = new Products(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"),
                        rs.getLong("Price"), rs.getString("releasedate"), rs.getString("screenresolution"), rs.getString("cpu"),
                        rs.getString("ram"), rs.getString("internalmemory"), rs.getString("GPU"), rs.getInt("ID_CAT"), rs.getInt("ID_BRAND"),
                        rs.getBoolean("InHome"), rs.getString("ShortDes"));
                list.add(pro);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Products GetProductByID(int ID) {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM products where ID ='" + ID + "'";
        ArrayList<Products> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //    public Products(int ID, String Name, String DES, long Price, String releasedate, 
                //String screenresolution, String cpu, String ram, String internalmemory, String GPU, int ID_CAT, int ID_BRAND, boolean InHome) {

                Products pro = new Products(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"),
                        rs.getLong("Price"), rs.getString("releasedate"), rs.getString("screenresolution"), rs.getString("cpu"),
                        rs.getString("ram"), rs.getString("internalmemory"), rs.getString("GPU"), rs.getInt("ID_CAT"), rs.getInt("ID_BRAND"),
                        rs.getBoolean("InHome"), rs.getString("ShortDes"));
                list.add(pro);
            }
            cons.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list.get(0);
    }

    public static int Delete(int ID) {
        String sql = "Delete from Products where ID = " + ID;
        return UpdateDeleteChange(sql);
    }

    public static int Edit(Products pro) {
        String sql = "UPDATE Products set Name ='" + pro.getName() + "' , Description = '" + pro.getDES() + "' , ShortDes = '" + pro.getShortDes() + "', Price = '" + pro.getPrice() + "', releasedate = '" + pro.getReleasedate() + "', screenresolution = '" + pro.getScreenresolution() + "', cpu = '" + pro.getCpu() + "', ram = '" + pro.getRam() + "', internalmemory = '" + pro.getInternalmemory() + "', GPU = '" + pro.getGPU() + "', ID_CAT = '" + pro.getID_CAT() + "', ID_BRAND = '" + pro.getID_BRAND() + "' where ID = " + pro.getID();
        return UpdateDeleteChange(sql);
    }

    public static int Add(Products pro) {
        //INSERT INTO `category` VALUES (NULL, '1', '1', '1', NULL);
        String sql = "INSERT INTO products (ID,Name,ShortDes,Description,Price,releasedate,screenresolution,cpu,ram,internalmemory,"
                + "GPU ,ID_CAT,ID_BRAND) VALUES (NULL,'" + pro.getName() + "' ,'" + pro.getShortDes() + "' ,'" + pro.getDES() + "' ,'" + pro.getPrice() + "' ,'" + pro.getReleasedate()
                + "' ,'" + pro.getScreenresolution() + "' ,'" + pro.getCpu() + "' ,'" + pro.getRam() + "' , '" + pro.getInternalmemory() + "','" + pro.getGPU() + "', '" + pro.getID_CAT() + "',"
                + "'" + pro.getID_BRAND() + "')";
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
        Products pro = new Products(26, "Name1", "DES2", 11110, "13/4", "screenresolution3", "cpu4", "ram5", "6", "7", 8, 9, false, "Short");
        Product_DAO.Add(pro);
    }
}
