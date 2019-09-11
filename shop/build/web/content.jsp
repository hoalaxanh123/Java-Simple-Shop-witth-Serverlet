
<%@page import="Classes.Products"%>
<%@page import="Classes.Brands"%>
<%@page import="DAO.Brand_DAO"%>
<%@page import="DAO.Product_DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Brand_DAO brandDAO = new Brand_DAO();
    Product_DAO proDAO = new Product_DAO();
%>
<div class="container">
    <div class="content">
        <div class="content-bottom">
            <h3 class="future">SẢN PHẨM MỚI</h3>
            <div class="content-bottom-in">
                <ul id="flexiselDemo2a">	
                    <%
                        for (Products pro : proDAO.getListProduct()) {
                            String Price = String.valueOf(pro.getPrice());
                    %>
                    <li>
                        <div class="col-md men">
                            <a href="/shop/GetOneProduct?proID=<%=pro.getID()%>" class="compare-in " title="<%=pro.getName()%>"><img  src="images/Products/<%=pro.getID()%>.jpg" style="max-width: 95%" alt="<%=pro.getName()%>" />
                                <div class="compare in-compare">
                                    <span>Thêm vào so sánh</span>
                                    <span>Thêm vào danh sách yêu thích</span>
                                </div>
                            </a>
                            <div class="top-content bag">
                                <h5><a href="/shop/GetOneProduct?proID=<%=pro.getID()%>" title="<%=pro.getFullName()%>"><%=pro.getFullName()%></a></h5>
                                <div class="white">
                                    <a href="/shop/GetOneProduct?proID=<%=pro.getID()%>" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2" title="buy <%=pro.getFullName()%>">Thêm vào G.Hàng</a>
                                    <p class="dollar"><span class="in-dollar">$ <%=pro.getPrice()%></span>
                                    </p>
                                    <div class="clearfix"></div>
                                </div>
                            </div>							
                        </div>
                    </li>
                    <%}%>
                </ul>
                <script type="text/javascript">
                    $(window).load(function () {
                        $("#flexiselDemo2a").flexisel({
                            visibleItems: 4,
                            animationSpeed: 1000,
                            autoPlay: true,
                            autoPlaySpeed: 3000,
                            pauseOnHover: true,
                            enableResponsiveBreakpoints: true,
                            responsiveBreakpoints: {
                                portrait: {
                                    changePoint: 480,
                                    visibleItems: 1
                                },
                                landscape: {
                                    changePoint: 640,
                                    visibleItems: 2
                                },
                                tablet: {
                                    changePoint: 768,
                                    visibleItems: 3
                                }
                            }
                        });

                    });
                </script>
            </div>
        </div>

        <!---->
        <div class="content-middle">
            <h3 class="future">THƯƠNG HIỆU</h3>
            <div class="content-middle-in">
                <ul id="flexiselDemo1">	
                    <%
                        for (Brands br : brandDAO.getListBrands()) {
                    %>
                    <li>
                        <a href="/shop/GetProducts?BrandID=<%=br.getID()%>&page=1" title="<%=br.getName()%>">
                            <img src="images/BrandsLogo/<%=br.getLogo()%>" style="max-width: 80px"/>
                        </a>
                    </li>
                    <% }%>
                </ul>
                <script type="text/javascript">
                    $(window).load(function () {
                        $("#flexiselDemo1").flexisel({
                            visibleItems: 4,
                            animationSpeed: 1000,
                            autoPlay: true,
                            autoPlaySpeed: 3000,
                            pauseOnHover: true,
                            enableResponsiveBreakpoints: true,
                            responsiveBreakpoints: {
                                portrait: {
                                    changePoint: 480,
                                    visibleItems: 1
                                },
                                landscape: {
                                    changePoint: 640,
                                    visibleItems: 2
                                },
                                tablet: {
                                    changePoint: 768,
                                    visibleItems: 3
                                }
                            }
                        });

                    });
                </script>
                <script type="text/javascript" src="js/jquery.flexisel.js"></script>

            </div>
        </div>
        <!---->
        
        </div>
       <%for (Products pro : Controller.Products.   GetProducts.lst_pro) {
            }%>
        <!---->
        <br/>
        <div class="container">
            <div class="content">
                <div class="content-top">
                    <h3 class="future">SẢN PHẨM HOT</h3>

                    <div class="content-top-in">
                        <%for (Products pro : proDAO.getListProductHome()) {
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
            </div>
        </div>
    </div>