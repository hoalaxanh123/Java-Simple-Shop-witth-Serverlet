package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Classes.Users;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>login</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            if (session.getAttribute("user") != null) {
                response.sendRedirect("account.jsp");
            }
        
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "head.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("            <script>\n");
      out.write("                function Login() {\n");
      out.write("                    var usr = $(\"#UserName\").val();\n");
      out.write("                    var pass = $(\"#Password\").val();\n");
      out.write("                    $.post(\"/shop/Login\", {UserName: usr, Password: pass}, function (data) {\n");
      out.write("                        alert(data);\n");
      out.write("                        if (data == \"OK\")\n");
      out.write("                        {\n");
      out.write("                            window.location.href = \"index.jsp\";\n");
      out.write("                        } else\n");
      out.write("                        {\n");
      out.write("                            $(\"#Error\").val(\"Sai tên đăng nhập hoặc mật khẩu\");\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                }\n");
      out.write("            </script>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"account\">\n");
      out.write("                    <h2 class=\"account-in\">Đăng nhập hệ thống</h2>\n");
      out.write("                    <form method=\"post\" action=\"/shop/Login\">\n");
      out.write("                        <label id=\"Error\"></label>\n");
      out.write("                        <div>\n");
      out.write("                            <span>Tài khoản :  *</span>\n");
      out.write("                            <input type=\"text\" name=\"UserName\" id=\"UserName\" value=\"admin\" required>\n");
      out.write("                        </div> \t\n");
      out.write("                        <div> \n");
      out.write("                            <span class=\"word\">Mật khẩu :  *</span>\n");
      out.write("                            <input type=\"password\" name=\"Password\" id=\"Password\" value=\"huynhvade\" required>\n");
      out.write("                        </div>\t\t\t\t\n");
      out.write("                        <input type=\"button\" value=\"Đăng nhập\" onclick=\"Login()\"> \n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
