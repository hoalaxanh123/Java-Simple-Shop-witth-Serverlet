package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAO.User_DAO;
import Classes.Users;
import DAO.Brand_DAO;
import Classes.Brands;
import Classes.Category;
import java.util.ArrayList;
import DAO.Category_DAO;

public final class Statistics_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "head.jsp", out, false);
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- Content Wrapper. Contains page content -->\n");
      out.write("    <div class=\"content-wrapper\">\n");
      out.write("        <!-- Content Header (Page header) -->\n");
      out.write("        <section class=\"content-header\">\n");
      out.write("            <h1>\n");
      out.write("                Dashboard\n");
      out.write("                <small>Thống kê</small>\n");
      out.write("            </h1>\n");
      out.write("            <ol class=\"breadcrumb\">\n");
      out.write("                <li><a href=\"#\"><i class=\"fa fa-dashboard\"></i>Thống kê</a></li>\n");
      out.write("                <li class=\"active\">Dashboard</li>\n");
      out.write("            </ol>\n");
      out.write("        </section>\n");
      out.write("        <!-- Main content -->\n");
      out.write("        <section class=\"content\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                    <!-- AREA CHART -->\n");
      out.write("                    <div class=\"box box-primary\">\n");
      out.write("                        <div class=\"box-header with-border\">\n");
      out.write("                            <h3 class=\"box-title\">Area Chart</h3>\n");
      out.write("\n");
      out.write("                            <div class=\"box-tools pull-right\">\n");
      out.write("                                <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"collapse\"><i class=\"fa fa-minus\"></i>\n");
      out.write("                                </button>\n");
      out.write("                                <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"remove\"><i class=\"fa fa-times\"></i></button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"box-body\">\n");
      out.write("                            <div class=\"chart\">\n");
      out.write("                                <canvas id=\"areaChart\" style=\"height:250px\"></canvas>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /.box-body -->\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box -->\n");
      out.write("\n");
      out.write("                    <!-- DONUT CHART -->\n");
      out.write("                    <div class=\"box box-danger\">\n");
      out.write("                        <div class=\"box-header with-border\">\n");
      out.write("                            <h3 class=\"box-title\">Donut Chart</h3>\n");
      out.write("\n");
      out.write("                            <div class=\"box-tools pull-right\">\n");
      out.write("                                <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"collapse\"><i class=\"fa fa-minus\"></i>\n");
      out.write("                                </button>\n");
      out.write("                                <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"remove\"><i class=\"fa fa-times\"></i></button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"box-body\">\n");
      out.write("                            <canvas id=\"pieChart\" style=\"height:250px\"></canvas>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /.box-body -->\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box -->\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <!-- /.col (LEFT) -->\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                    <!-- LINE CHART -->\n");
      out.write("                    <div class=\"box box-info\">\n");
      out.write("                        <div class=\"box-header with-border\">\n");
      out.write("                            <h3 class=\"box-title\">Line Chart</h3>\n");
      out.write("\n");
      out.write("                            <div class=\"box-tools pull-right\">\n");
      out.write("                                <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"collapse\"><i class=\"fa fa-minus\"></i>\n");
      out.write("                                </button>\n");
      out.write("                                <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"remove\"><i class=\"fa fa-times\"></i></button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"box-body\">\n");
      out.write("                            <div class=\"chart\">\n");
      out.write("                                <canvas id=\"lineChart\" style=\"height:250px\"></canvas>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /.box-body -->\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box -->\n");
      out.write("\n");
      out.write("                    <!-- BAR CHART -->\n");
      out.write("                    <div class=\"box box-success\">\n");
      out.write("                        <div class=\"box-header with-border\">\n");
      out.write("                            <h3 class=\"box-title\">Bar Chart</h3>\n");
      out.write("\n");
      out.write("                            <div class=\"box-tools pull-right\">\n");
      out.write("                                <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"collapse\"><i class=\"fa fa-minus\"></i>\n");
      out.write("                                </button>\n");
      out.write("                                <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"remove\"><i class=\"fa fa-times\"></i></button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"box-body\">\n");
      out.write("                            <div class=\"chart\">\n");
      out.write("                                <canvas id=\"barChart\" style=\"height:230px\"></canvas>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /.box-body -->\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.box -->\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <!-- /.col (RIGHT) -->\n");
      out.write("            </div>\n");
      out.write("            <!-- /.row -->\n");
      out.write("\n");
      out.write("        </section>\n");
      out.write("        <!-- /.content -->\n");
      out.write("    </div>\n");
      out.write("    <!-- /.content-wrapper -->\n");
      out.write("\n");
      out.write("    <!-- /.content-wrapper -->\n");
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
