package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Classes.Orders;
import Classes.Orders;
import DAO.Order_DAO;
import DAO.User_DAO;
import Classes.Users;
import DAO.Brand_DAO;
import Classes.Brands;
import Classes.Category;
import java.util.ArrayList;
import DAO.Category_DAO;

public final class Orders_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "head.jsp", out, false);
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write('\n');
      out.write('\n');

    ArrayList<Orders> lstOrder = Order_DAO.getListOrders();

      out.write("\n");
      out.write("\n");
      out.write("<!-- Content Wrapper. Contains page content -->\n");
      out.write("<div class=\"content-wrapper\">\n");
      out.write("    <!-- Content Header (Page header) -->\n");
      out.write("    <section class=\"content-header\">\n");
      out.write("        <h1>\n");
      out.write("            Dashboard\n");
      out.write("            <small>Quản lý hóa đơn</small>\n");
      out.write("        </h1>\n");
      out.write("        <ol class=\"breadcrumb\">\n");
      out.write("            <li><a href=\"#\"><i class=\"fa fa-dashboard\"></i>Quản lý hóa đơn</a></li>\n");
      out.write("            <li class=\"active\">Dashboard</li>\n");
      out.write("        </ol>\n");
      out.write("    </section>\n");
      out.write("    <section class=\"content\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-xs-12\">\n");
      out.write("                <div class=\"box\">\n");
      out.write("                    <div class=\"box-header\">\n");
      out.write("                        <h3 class=\"box-title\">Quản lý hóa đơn</h3>\n");
      out.write("                        <br/>\n");
      out.write("                        <a href=\"UserDetail.jsp\" class=\"btn btn-info\" style=\"float:right\">Thêm mới</a>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box-header -->\n");
      out.write("                    <div class=\"box-body\">\n");
      out.write("                        <table id=\"example1\" class=\"table table-bordered table-striped\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th style=\"width: 5%\">STT</th>\n");
      out.write("                                    <th>Người tạo</th>\n");
      out.write("                                    <th>Ngày tạo</th>\n");
      out.write("                                    <th>Đại chỉ</th>\n");
      out.write("                                    <th>Ghi chú</th>\n");
      out.write("                                    <th>Số tiền</th>\n");
      out.write("                                    <th style=\"width: 10%\">Chức năng</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                                ");

                                    int i = 1;
                                    for (Orders order : lstOrder) {
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>");
      out.print(i);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(order.getCreator());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(order.getDateCreate());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(order.getAddress());
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(order.getNote());
      out.write("</td>\n");
      out.write("                                     <td>$ ");
      out.print(order.getTotal());
      out.write("</td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <form style=\"display: inline-block\" action=\"UserDetail.jsp\" method=\"GET\">\n");
      out.write("                                            <input type=\"hidden\" name=\"OrderID\" value=\"");
      out.print(order.getID());
      out.write("\"/>\n");
      out.write("                                            <input type=\"submit\" value=\"Sửa\" class=\"btn btn-link\"/>\n");
      out.write("                                        </form>\n");
      out.write("                                        |\n");
      out.write("                                        <form style=\"display: inline-block\" action=\"/shop/UserDelete\" method=\"POST\">\n");
      out.write("                                            <input type=\"hidden\" name=\"OrderID\" value=\"");
      out.print(order.getID());
      out.write("\"/>\n");
      out.write("                                            <input type=\"submit\" value=\"Xóa\" class=\"btn btn-link\"/>\n");
      out.write("                                        </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                ");
i++;
                                }
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box-body -->\n");
      out.write("                </div>\n");
      out.write("                <!-- /.box -->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- /.content-wrapper -->\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
