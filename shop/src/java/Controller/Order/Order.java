/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Order;

import Classes.Carts;
import Classes.Item;
import static Classes.MyClass.sendMail;
import Classes.OrderDetails;
import Classes.Orders;
import DAO.OrderDetail_DAO;
import DAO.Order_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Order", urlPatterns = {"/Order"})
public class Order extends HttpServlet {

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
            out.println("<title>Servlet Order</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Order at " + request.getContextPath() + "</h1>");
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
        doPost(request, response);
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
        HttpSession session = request.getSession();

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        out.print(request.getParameter("RealName"));
        out.print(request.getParameter("Email"));
        out.print(request.getParameter("Address"));
        out.print(request.getParameter("Note"));
        out.print(request.getParameter("PayMethod"));
        out.print(request.getParameter("UserName"));

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        System.out.println(formatter.format(date));
        String UserName = request.getParameter("UserName");

        Carts cart = (Carts) session.getAttribute("cart");
        if (cart == null) {
            cart = new Carts();
        }

        float ToTal = (float) cart.total();

        int ID = 1;
        int OrdeID = 0;
        try {

            Orders order = new Orders(ID, request.getParameter("RealName"), date, request.getParameter("Address"), request.getParameter("Email"), request.getParameter("Note"), UserName, request.getParameter("PayMethod"), ToTal);
            OrdeID = Order_DAO.insertBill(order);
            out.print("<br/>+OrdeID+<br/>");
            for (Item it : cart.getCartItems()) {
                OrderDetails detail = new OrderDetails(ID, OrdeID, it.getProduct().getFullName(), it.getQuantity(), it.getProduct().getPrice(), it.getProduct().getPrice() * it.getQuantity());
                OrderDetail_DAO.insertBillDetail(detail);
            }
            session.setAttribute("cart", null);
            String link = "http://localhost:8084/shop/OrderDetail?OrderID=" + OrdeID;
            sendMail(request.getParameter("Email"), "Bạn có đơn đặt hàng mới !!!", "My shop | 1510289 \n Bạn có đơn đặt hàng mới , vui lòng vào liên kết sau để xem chi tiết : \n " + link + "\nCông ty trách nhiệm 1 thành viên My shop.");
            response.sendRedirect("/shop/OrderDetail?OrderID=" + OrdeID);
        } catch (SQLException e) {
            e.printStackTrace();
            out.print(e.getMessage());
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
