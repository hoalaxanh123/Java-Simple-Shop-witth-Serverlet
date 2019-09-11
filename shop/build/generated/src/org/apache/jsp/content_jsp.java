package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Classes.Products;
import Classes.Brands;
import DAO.Brand_DAO;
import DAO.Product_DAO;

public final class content_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    Brand_DAO brandDAO = new Brand_DAO();
    Product_DAO proDAO = new Product_DAO();

      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("    <div class=\"content\">\n");
      out.write("        <div class=\"content-bottom\">\n");
      out.write("            <h3 class=\"future\">SẢN PHẨM MỚI</h3>\n");
      out.write("            <div class=\"content-bottom-in\">\n");
      out.write("                <ul id=\"flexiselDemo2a\">\t\n");
      out.write("                    ");

                        for (Products pro : proDAO.getListProduct()) {
                            String Price = String.valueOf(pro.getPrice());
                    
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <div class=\"col-md men\">\n");
      out.write("                            <a href=\"/shop/GetOneProduct?proID=");
      out.print(pro.getID());
      out.write("\" class=\"compare-in \" title=\"");
      out.print(pro.getFullName());
      out.write("\"><img  src=\"images/Products/");
      out.print(pro.getID());
      out.write(".jpg\" style=\"max-width: 95%\" alt=\"");
      out.print(pro.getName());
      out.write("\" />\n");
      out.write("                                <div class=\"compare in-compare\">\n");
      out.write("                                    <span>Thêm vào so sánh</span>\n");
      out.write("                                    <span>Thêm vào danh sách yêu thích</span>\n");
      out.write("                                </div></a>\n");
      out.write("                            <div class=\"top-content bag\">\n");
      out.write("                                <h5><a href=\"/shop/GetOneProduct?proID=");
      out.print(pro.getID());
      out.write("\" title=\"");
      out.print(pro.getFullName());
      out.write('"');
      out.write('>');
      out.print(pro.getName());
      out.write("</a></h5>\n");
      out.write("                                <div class=\"white\">\n");
      out.write("                                    <a href=\"/shop/GetOneProduct?proID=");
      out.print(pro.getID());
      out.write("\" class=\"hvr-shutter-in-vertical hvr-shutter-in-vertical2\" title=\"buy ");
      out.print(pro.getFullName());
      out.write("\">Thêm vào G.Hàng</a>\n");
      out.write("                                    <p class=\"dollar\"><span class=\"in-dollar\">$</span>\n");
      out.write("                                        ");

                                            for (int i = 1; i < Price.length(); i++) {
                                                out.print("<span style='text-align:center'>" + Price.charAt(i) + "</span>");
                                            }
                                        
      out.write("\n");
      out.write("                                    </p>\n");
      out.write("                                    <div class=\"clearfix\"></div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\t\t\t\t\t\t\t\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </ul>\n");
      out.write("                <script type=\"text/javascript\">\n");
      out.write("                    $(window).load(function () {\n");
      out.write("                        $(\"#flexiselDemo2a\").flexisel({\n");
      out.write("                            visibleItems: 4,\n");
      out.write("                            animationSpeed: 1000,\n");
      out.write("                            autoPlay: true,\n");
      out.write("                            autoPlaySpeed: 3000,\n");
      out.write("                            pauseOnHover: true,\n");
      out.write("                            enableResponsiveBreakpoints: true,\n");
      out.write("                            responsiveBreakpoints: {\n");
      out.write("                                portrait: {\n");
      out.write("                                    changePoint: 480,\n");
      out.write("                                    visibleItems: 1\n");
      out.write("                                },\n");
      out.write("                                landscape: {\n");
      out.write("                                    changePoint: 640,\n");
      out.write("                                    visibleItems: 2\n");
      out.write("                                },\n");
      out.write("                                tablet: {\n");
      out.write("                                    changePoint: 768,\n");
      out.write("                                    visibleItems: 3\n");
      out.write("                                }\n");
      out.write("                            }\n");
      out.write("                        });\n");
      out.write("\n");
      out.write("                    });\n");
      out.write("                </script>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!---->\n");
      out.write("        <div class=\"content-middle\">\n");
      out.write("            <h3 class=\"future\">THƯƠNG HIỆU</h3>\n");
      out.write("            <div class=\"content-middle-in\">\n");
      out.write("                <ul id=\"flexiselDemo1\">\t\n");
      out.write("                    ");

                        for (Brands br : brandDAO.getListBrands()) {
                    
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"/shop/GetProducts?BrandID=");
      out.print(br.getID());
      out.write("&page=1\" title=\"");
      out.print(br.getName());
      out.write("\">\n");
      out.write("                            <img src=\"images/BrandsLogo/");
      out.print(br.getLogo());
      out.write("\" style=\"max-width: 80px\"/>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("                </ul>\n");
      out.write("                <script type=\"text/javascript\">\n");
      out.write("                    $(window).load(function () {\n");
      out.write("                        $(\"#flexiselDemo1\").flexisel({\n");
      out.write("                            visibleItems: 4,\n");
      out.write("                            animationSpeed: 1000,\n");
      out.write("                            autoPlay: true,\n");
      out.write("                            autoPlaySpeed: 3000,\n");
      out.write("                            pauseOnHover: true,\n");
      out.write("                            enableResponsiveBreakpoints: true,\n");
      out.write("                            responsiveBreakpoints: {\n");
      out.write("                                portrait: {\n");
      out.write("                                    changePoint: 480,\n");
      out.write("                                    visibleItems: 1\n");
      out.write("                                },\n");
      out.write("                                landscape: {\n");
      out.write("                                    changePoint: 640,\n");
      out.write("                                    visibleItems: 2\n");
      out.write("                                },\n");
      out.write("                                tablet: {\n");
      out.write("                                    changePoint: 768,\n");
      out.write("                                    visibleItems: 3\n");
      out.write("                                }\n");
      out.write("                            }\n");
      out.write("                        });\n");
      out.write("\n");
      out.write("                    });\n");
      out.write("                </script>\n");
      out.write("                <script type=\"text/javascript\" src=\"js/jquery.flexisel.js\"></script>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!---->\n");
      out.write("        \n");
      out.write("        </div>\n");
      out.write("       ");
for (Products pro : Controller.Products.   GetProducts.lst_pro) {
            }
      out.write("\n");
      out.write("        <!---->\n");
      out.write("        <br/>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"content\">\n");
      out.write("                <div class=\"content-top\">\n");
      out.write("                    <h3 class=\"future\">SẢN PHẨM HOT</h3>\n");
      out.write("\n");
      out.write("                    <div class=\"content-top-in\">\n");
      out.write("                        ");
for (Products pro : proDAO.getListProductHome()) {
                                String Price = String.valueOf(pro.getPrice());

                        
      out.write("\n");
      out.write("                        <div class=\"col-md-3 md-col\" style=\"margin-top: 3%;height: 280px\">\n");
      out.write("                            <div class=\"col-md\">\n");
      out.write("                                <a href=\"/shop/GetOneProduct?proID=");
      out.print(pro.getID());
      out.write("\" title=\"");
      out.print(pro.getFullName());
      out.write("\"><img  src=\"images/Products/");
      out.print(pro.getID());
      out.write(".jpg\" alt=\"");
      out.print(pro.getFullName());
      out.write("\" height=\"180\" /></a>\t\n");
      out.write("                                <div class=\"top-content\">\n");
      out.write("                                    <h5><a href=\"/shop/GetOneProduct?proID=");
      out.print(pro.getID());
      out.write("\" title=\"");
      out.print(pro.getFullName());
      out.write('"');
      out.write('>');
      out.print(pro.getName());
      out.write("</a></h5>\n");
      out.write("                                    <div class=\"white\">\n");
      out.write("                                        <a href=\"/shop/GetOneProduct?proID=");
      out.print(pro.getID());
      out.write("\" class=\"hvr-shutter-in-vertical hvr-shutter-in-vertical2 \" title=\"Thêm ");
      out.print(pro.getFullName());
      out.write(" vào giỏ hàng\">Thêm vào G.Hàng</a>\n");
      out.write("                                        <p class=\"dollar\"><span class=\"in-dollar\">$</span>\n");
      out.write("                                            ");

                                                out.print("<span>" + pro.getPrice() + "</span>");
                                            
      out.write("\n");
      out.write("                                        <div class=\"clearfix\"></div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                </div>\t\t\t\t\t\t\t\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"clearfix\"></div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!---->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>");
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
