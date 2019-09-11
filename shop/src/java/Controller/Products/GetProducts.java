/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Products;

import Classes.MyClass;
import Classes.Products;
import DAO.Product_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "GetProducts", urlPatterns = {"/GetProducts"})
public class GetProducts extends HttpServlet {

    public static int Count = 0;
    int SoTrang = 0;
    int soSanPhanTrenMotTrang = 16;
    public static ArrayList<Products> lst_pro = new ArrayList<>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetProductByCatID</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetProductByCatID at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        if (request.getParameter("BrandID") != null && request.getParameter("CatID") != null) {
            try {
                int catID = Integer.parseInt(request.getParameter("CatID"));
                int BrandID = Integer.parseInt(request.getParameter("BrandID"));
                int Count = Product_DAO.CountProductByCatIDandBrandID(catID, BrandID);

                int page = Integer.parseInt(request.getParameter("page"));
                int start = 0, end = 0, SoTrang = 0;

                if (Count <= soSanPhanTrenMotTrang) {
                    start = 1;
                    end = soSanPhanTrenMotTrang;
                    SoTrang = 1;
                } else {
                    start = (page - 1) * soSanPhanTrenMotTrang;
                    end = soSanPhanTrenMotTrang * 2;
                    SoTrang = MyClass.TinSoTrang(Count, soSanPhanTrenMotTrang);
                }

                lst_pro = Product_DAO.getListProductByCatIDAndBrandID(catID, BrandID, start, end);
                if (lst_pro.isEmpty()) {
                    response.sendRedirect("404.jsp");
                } else {
                    response.sendRedirect("product.jsp?BrandID=" + BrandID + "&CatID=" + catID + "&page=" + page + "&limit=" + soSanPhanTrenMotTrang + "&pages=" + SoTrang);
                }
            } catch (Exception e) {
                out.print(e);
                //response.sendRedirect("404.jsp");
            }
        } else if (request.getParameter("BrandID") == null && request.getParameter("CatID") != null) {
            {
                try {
                    int catID = Integer.parseInt(request.getParameter("CatID"));
                    int Count = Product_DAO.CountProductByCatID(catID);

                    int page = Integer.parseInt(request.getParameter("page"));
                    int start = 0, end = 0, SoTrang = 0;

                    if (Count <= soSanPhanTrenMotTrang) {
                        start = 1;
                        end = soSanPhanTrenMotTrang;
                        SoTrang = 1;
                    } else {
                        start = (page - 1) * soSanPhanTrenMotTrang;
                        end = soSanPhanTrenMotTrang * 2;
                        SoTrang = MyClass.TinSoTrang(Count, soSanPhanTrenMotTrang);
                    }
                    lst_pro = Product_DAO.getListProductByCatIDandPages(catID, start, end);
                    if (lst_pro.isEmpty()) {
                        response.sendRedirect("404.jsp");
                    } else {
                        response.sendRedirect("product.jsp?CatID=" + catID + "&page=" + page + "&limit=" + soSanPhanTrenMotTrang + "&pages=" + SoTrang);
                    }
                } catch (Exception e) {
                    out.print(e);
                    //response.sendRedirect("404.jsp");
                }
            }

        } else if (request.getParameter("BrandID") != null) {
            try {
                int brandID = Integer.parseInt(request.getParameter("BrandID"));
                int Count = Product_DAO.CountProductByBrandID(brandID);

                int page = Integer.parseInt(request.getParameter("page"));
                int start = 0, end = 0, SoTrang = 0;

                if (Count <= soSanPhanTrenMotTrang) {
                    start = 1;
                    end = soSanPhanTrenMotTrang;
                    SoTrang = 1;
                } else {
                    start = (page - 1) * soSanPhanTrenMotTrang;
                    end = soSanPhanTrenMotTrang * 2;
                    SoTrang = MyClass.TinSoTrang(Count, soSanPhanTrenMotTrang);
                }
                lst_pro = Product_DAO.getListProductByBrandIDandPage(brandID, start, end);
                if (lst_pro.isEmpty()) {
                    response.sendRedirect("404.jsp");
                } else {
                    response.sendRedirect("product.jsp?BrandID=" + brandID + "&page=" + page + "&limit=" + soSanPhanTrenMotTrang + "&pages=" + SoTrang);
                }
            } catch (Exception e) {
                out.print(e);
                //response.sendRedirect("404.jsp");
            }
        } else {
            response.sendRedirect("404.jsp");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print(request.getParameter("CatID"));
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
