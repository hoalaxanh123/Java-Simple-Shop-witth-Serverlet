package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAO.User_DAO;
import Classes.Users;
import DAO.Brand_DAO;
import Classes.Brands;
import DAO.Category_DAO;
import Classes.Category;
import DAO.Order_DAO;
import Classes.Orders;

public final class UserDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "head.jsp", out, false);
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write('\n');
      out.write('\n');

    if (request.getParameter("UserID") == null) {

      out.write("\n");
      out.write("\n");
      out.write("<div class=\"content-wrapper\">\n");
      out.write("    <!-- Content Header (Page header) -->\n");
      out.write("    <section class=\"content-header\">\n");
      out.write("        <h1>\n");
      out.write("            Dashboard\n");
      out.write("            <small>Quản lý người dùng</small>\n");
      out.write("        </h1>\n");
      out.write("        <ol class=\"breadcrumb\">\n");
      out.write("            <li><a href=\"#\"><i class=\"fa fa-dashboard\"></i> Quản lý nhà người dùng</a></li>\n");
      out.write("            <li class=\"active\">Dashboard</li>\n");
      out.write("        </ol>\n");
      out.write("    </section>\n");
      out.write("    <section class=\"content\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-xs-12\">\n");
      out.write("                <div class=\"panel panel-danger\">\n");
      out.write("                    <div class=\"panel-heading\" style=\"text-transform: uppercase\"><b id=\"Title\">Tạo mới người dùng</b></div>\n");
      out.write("                    <div class=\"panel-body\" >\n");
      out.write("                        <form action=\"/shop/UserAdd\" method=\"post\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"hidden\" value=\"\" name=\"ID\"/>\n");
      out.write("                                <label for=\"usr\">Tên đăng nhập :</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"UserName\" value=\"\" required>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"hidden\" value=\"\" name=\"ID\"/>\n");
      out.write("                                <label for=\"usr\">Mật khẩu :</label>\n");
      out.write("                                <input type=\"password\" class=\"form-control\" name=\"Pass1\" value=\"\" required>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"hidden\" value=\"\" name=\"ID\"/>\n");
      out.write("                                <label for=\"usr\">Nhập lại mật khẩu :</label>\n");
      out.write("                                <input type=\"password\" class=\"form-control\" name=\"Pass2\" value=\"\" required>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"pwd\">Email :</label>\n");
      out.write("                                <input type=\"email\" class=\"form-control\" name=\"Email\" value=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"pwd\">Tên thật :</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"Realname\" value=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"pwd\">Địa chỉ :</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"Address\" value=\"\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"pwd\">Phân quyền :</label>\n");
      out.write("                                <select name=\"PhanQuyen\"  class=\"form-control\">\n");
      out.write("                                    <option value=\"1\">\n");
      out.write("                                        Người dùng\n");
      out.write("                                    </option>\n");
      out.write("                                    <option value=\"0\">\n");
      out.write("                                        Quản trị viên\n");
      out.write("                                    </option>\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            <input type=\"submit\" id=\"submit\"  value=\"Thêm mới\" style=\"margin-left: 0\" class=\"btn btn-danger form-control\"/>  \n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("</div>\n");
      out.write("\n");
} else {
    int ID = Integer.parseInt(request.getParameter("UserID"));
    Users usr = User_DAO.GetByID(ID);

      out.write("\n");
      out.write("<div class=\"content-wrapper\">\n");
      out.write("    <!-- Content Header (Page header) -->\n");
      out.write("    <section class=\"content-header\">\n");
      out.write("        <h1>\n");
      out.write("            Dashboard\n");
      out.write("            <small> Quản lý người dùng</small>\n");
      out.write("        </h1>\n");
      out.write("        <ol class=\"breadcrumb\">\n");
      out.write("            <li><a href=\"#\"><i class=\"fa fa-dashboard\"></i> Quản lý người dùng</a></li>\n");
      out.write("            <li class=\"active\">Dashboard</li>\n");
      out.write("        </ol>\n");
      out.write("    </section>\n");
      out.write("    <section class=\"content\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-xs-12\">\n");
      out.write("                <div class=\"panel panel-danger\">\n");
      out.write("                    <div class=\"panel-heading\" style=\"text-transform: uppercase\"><b id=\"Title\">Sửa đổi thông tin</b></div>\n");
      out.write("                    <div class=\"panel-body\" >\n");
      out.write("                        <form action=\"/shop/BrandEdit\" method=\"POST\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"hidden\" value=\"\" name=\"ID\"/>\n");
      out.write("                                <label for=\"usr\">Tên đăng nhập :</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"UserName\" value=\"");
      out.print(usr.getRealName());
      out.write("\" required readonly>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"hidden\" value=\"\" name=\"ID\"/>\n");
      out.write("                                <label for=\"usr\">Mật khẩu :</label>\n");
      out.write("                                <input type=\"password\" class=\"form-control\" name=\"Pass1\" value=\"");
      out.print(usr.getPassWord());
      out.write("\" required readonly>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"pwd\">Email :</label>\n");
      out.write("                                <input type=\"email\" class=\"form-control\" name=\"Email\" value=\"");
      out.print(usr.getEmail());
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"pwd\">Tên thật :</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"Realname\" value=\"");
      out.print(usr.getRealName());
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"pwd\">Địa chỉ :</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"Address\" value=\"");
      out.print(usr.getAddress());
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"pwd\">Phân quyền :</label>\n");
      out.write("                                <select name=\"PhanQuyen\"  class=\"form-control\">\n");
      out.write("                                    ");

                                        if (usr.getRole() == 0) {
                                    
      out.write("\n");
      out.write("                                    <option value=\"1\" >\n");
      out.write("                                        Người dùng\n");
      out.write("                                    </option>\n");
      out.write("                                    <option value=\"0\" selected>\n");
      out.write("                                        Quản trị viên\n");
      out.write("                                    </option>\n");
      out.write("                                    ");
} else {
      out.write("\n");
      out.write("                                    <option value=\"1\" selected>\n");
      out.write("                                        Người dùng\n");
      out.write("                                    </option>\n");
      out.write("                                    <option value=\"0\" >\n");
      out.write("                                        Quản trị viên\n");
      out.write("                                    </option>\n");
      out.write("                                    ");
}
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                                <br/>\n");
      out.write("                                <input type=\"submit\" class=\"form-control btn btn-danger\"  value=\"Thay đổi thông tin\">\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("    </section>\n");
      out.write("</div>\n");
}
      out.write('\n');
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
