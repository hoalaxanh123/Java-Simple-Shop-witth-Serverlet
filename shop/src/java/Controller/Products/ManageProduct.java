/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Products;

import Classes.Products;
import DAO.Product_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ManageProduct", urlPatterns = {"/ManageProduct"})
public class ManageProduct extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManageProduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageProduct at " + request.getContextPath() + "</h1>");
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
        doGet(request, response);
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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String Command = request.getParameter("Command");
        int result = -1;
        int ID = -1;
        try {
            ID = Integer.parseInt(request.getParameter("ProID"));
        } catch (Exception e) {
        }

        if ("Delete".equals(Command)) {
            Product_DAO.Delete(ID);
            response.sendRedirect("/shop/admin/Products.jsp");
            return;
        }

        try {
            String Name = request.getParameter("Name");
            String ShortDes = request.getParameter("ShortDes");
            String Des = request.getParameter("Des");
            long Price = Long.parseLong(request.getParameter("Price"));
            String Date = request.getParameter("Date");
            String Screen = request.getParameter("Resolution");
            String CPU = request.getParameter("CPU");
            String RAM = request.getParameter("RAM");
            String Storage = request.getParameter("Storage");
            String GPU = request.getParameter("GPU");
            int CatID = Integer.parseInt(request.getParameter("CatID"));
            int BrandID = Integer.parseInt(request.getParameter("BrandID"));
            Products pro = new Products(ID, Name, Des, Price, Date, Screen, CPU, RAM, Storage, GPU, CatID, BrandID, false, ShortDes);

            switch (Command) {
                case "Edit":
                    result = Product_DAO.Edit(pro);
                    if (result == -1) {
                        out.print("ERROR");
                    } else {
                        response.sendRedirect("/shop/admin/Products.jsp");
                    }
                    break;

                case "Add":
                    result = Product_DAO.Add(pro);
                    if (result == -1) {
                        out.print("ERROR");
                    } else {
                        response.sendRedirect("/shop/admin/Products.jsp");
                    }
                default:
                    response.sendRedirect("/shop/admin/Products.jsp");
            }
        } catch (Exception e) {
        }

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
