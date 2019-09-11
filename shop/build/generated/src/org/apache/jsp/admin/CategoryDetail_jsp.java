package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAO.Category_DAO;
import Classes.Category;
import DAO.Order_DAO;
import Classes.Orders;

public final class CategoryDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "head.jsp", out, false);
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write('\n');
      out.write('\n');

    if (request.getParameter("CatID") == null) {

      out.write("\n");
      out.write("\n");
      out.write("<div class=\"content-wrapper\">\n");
      out.write("    <!-- Content Header (Page header) -->\n");
      out.write("    <section class=\"content-header\">\n");
      out.write("        <h1>\n");
      out.write("            Dashboard\n");
      out.write("            <small>Quản lý danh mục</small>\n");
      out.write("        </h1>\n");
      out.write("        <ol class=\"breadcrumb\">\n");
      out.write("            <li><a href=\"#\"><i class=\"fa fa-dashboard\"></i> Quản lý danh mục</a></li>\n");
      out.write("            <li class=\"active\">Dashboard</li>\n");
      out.write("        </ol>\n");
      out.write("    </section>\n");
      out.write("    <section class=\"content\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-xs-12\">\n");
      out.write("                <div class=\"panel panel-danger\">\n");
      out.write("                    <div class=\"panel-heading\" style=\"text-transform: uppercase\"><b id=\"Title\">Tạo mới danh mục</b></div>\n");
      out.write("                    <div class=\"panel-body\" >\n");
      out.write("                        <form action=\"/shop/CatAdd\" method=\"post\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"hidden\" value=\"\" name=\"ID\"/>\n");
      out.write("                                <label for=\"usr\">Tiêu đề:</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"TieuDe\" value=\"\" required>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"pwd\">Miêu tả:</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"MoTa\" value=\"\">\n");
      out.write("                            </div>\n");
      out.write("                          \n");
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
    int ID = Integer.parseInt(request.getParameter("CatID"));
    Category cat = Category_DAO.GetCategoryByID(ID);

      out.write("\n");
      out.write("<div class=\"content-wrapper\">\n");
      out.write("    <!-- Content Header (Page header) -->\n");
      out.write("    <section class=\"content-header\">\n");
      out.write("        <h1>\n");
      out.write("            Dashboard\n");
      out.write("            <small>Quản lý danh mục</small>\n");
      out.write("        </h1>\n");
      out.write("        <ol class=\"breadcrumb\">\n");
      out.write("            <li><a href=\"#\"><i class=\"fa fa-dashboard\"></i> Quản lý danh mục</a></li>\n");
      out.write("            <li class=\"active\">Dashboard</li>\n");
      out.write("        </ol>\n");
      out.write("    </section>\n");
      out.write("    <section class=\"content\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-xs-12\">\n");
      out.write("                <div class=\"panel panel-danger\">\n");
      out.write("                    <div class=\"panel-heading\" style=\"text-transform: uppercase\"><b id=\"Title\">Sửa đổi thông tin</b></div>\n");
      out.write("                    <div class=\"panel-body\" >\n");
      out.write("                        <form action=\"/shop/CatEdit\" method=\"POST\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"hidden\" value=\"");
      out.print(cat.getID());
      out.write("\" name=\"ID\"/>\n");
      out.write("                                <label for=\"usr\">Tiêu đề:</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"TieuDe\" value=\"");
      out.print(cat.getName());
      out.write("\" required>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"pwd\">Miêu tả:</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"MoTa\" value=\"");
      out.print(cat.getDescription());
      out.write("\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"pwd\">Miêu tả:</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"MoTa\" value=\"[quote]");
      out.print(cat.getLogo());
      out.write("[/quote]\">\n");
      out.write("                            </div>\n");
      out.write("                            <input type=\"submit\" value=\"Thay đổi thông tin\" style=\"margin-left: 0\" class=\"btn btn-danger form-control\"/>  \n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
