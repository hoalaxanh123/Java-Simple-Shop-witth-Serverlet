<%-- 
    Document   : product
    Created on : May 10, 2016, 7:41:53 PM
    Author     : TUNGDUONG
--%>
<%@page import="Classes.Products"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <jsp:include page="head.jsp"></jsp:include>
        <jsp:include page="header.jsp"></jsp:include>
        <%
            for (Products pro : Controller.Products.GetProducts.lst_pro) {
            }%>
        <!---->
        <br/>
        <div class="container">
            <div class="content">
                <div class="content-top">
                    <h3 class="future">Danh sách sản phẩm</h3>

                    <div class="content-top-in">
                        <%for (Products pro : Controller.Products.GetProducts.lst_pro) {
                                String Price = String.valueOf(pro.getPrice());

                        %>
                        <div class="col-md-3 md-col" style="margin-top: 3%;height: 280px">
                            <div class="col-md">
                                <a href="/shop/GetOneProduct?proID=<%=pro.getID()%>" title="<%=pro.getFullName()%>"><img  src="images/Products/<%=pro.getID()%>.jpg" alt="<%=pro.getFullName()%>" height="180" /></a>	
                                <div class="top-content">
                                    <h5><a href="/shop/GetOneProduct?proID=<%=pro.getID()%>" title="<%=pro.getFullName()%>"><%=pro.getName()%></a></h5>
                                    <div class="white">
                                        <a href="/shop/GetOneProduct?proID=<%=pro.getID()%>" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 " title="Thêm <%=pro.getFullName()%> vào giỏ hàng">Thêm vào G.Hàng</a>
                                        <p class="dollar"><span class="in-dollar">$</span>
                                            <%
                                                out.print("<span>" + pro.getPrice() + "</span>");
                                            %>
                                        <div class="clearfix"></div>
                                    </div>

                                </div>							
                            </div>
                        </div>
                        <%}%>

                        <div class="clearfix"></div>
                    </div>
                </div>
                <!---->
                <center>
                    <ul class="start">
                        <%
                            int soTrang = Integer.parseInt(request.getParameter("pages"));
                            int BrandID = 0, CatID = 0;
                            if (request.getParameter("BrandID") != null && request.getParameter("CatID") != null) {
                                BrandID = Integer.parseInt(request.getParameter("BrandID"));
                                CatID = Integer.parseInt(request.getParameter("CatID"));
                                for (int i = 1; i <= soTrang; i++) {
                                    String URL = "<li class='arrow'><a href='/shop/GetProducts?CatID=" + CatID + "&BrandID=" + BrandID + "&page=" + i + "'>" + i + "</a></li>";
                                    out.print(URL);
                                }

                            } else if (request.getParameter("BrandID") == null && request.getParameter("CatID") != null) {
                                CatID = Integer.parseInt(request.getParameter("CatID"));
                                for (int i = 1; i <= soTrang; i++) {
                                    String URL = "<li class='arrow'><a href='/shop/GetProducts?CatID=" + CatID + "&page=" + i + "'>" + i + "</a></li>";
                                    out.print(URL);
                                }
                            } else if (request.getParameter("BrandID") != null) {
                                BrandID = Integer.parseInt(request.getParameter("BrandID"));
                                for (int i = 1; i <= soTrang; i++) {
                                    String URL = "<li class='arrow'><a href='/shop/GetProducts?BrandID=" + BrandID + "&page=" + i + "'>" + i + "</a></li>";
                                    out.print(URL);
                                }
                            } else {
                                response.sendRedirect("404.jsp");
                            }
                        %>
                    </ul>
                </center>
            </div>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
