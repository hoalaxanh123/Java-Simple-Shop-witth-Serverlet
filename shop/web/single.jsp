<%@page import="DAO.Product_DAO"%>
<%@page import="Classes.Products"%>
<%@page import="Classes.Brands"%>
<%@page import="Classes.Category"%>
<%@page import="DAO.Brand_DAO"%>
<%@page import="DAO.Category_DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>My shop | <%=Controller.Products.GetOneProduct.SanPham.getFullName()%></title>
        <link href="css/dropdown.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <!-- Custom Theme files -->
        <!--theme-style-->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
        <!--//theme-style-->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!--fonts-->
        <link href='http://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

        <!--//fonts-->
        <script type="text/javascript" src="js/move-top.js"></script>
        <script type="text/javascript" src="js/easing.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                });
            });
        </script>
        <link rel="stylesheet" href="css/etalage.css">
        <script src="js/jquery.etalage.min.js"></script>
        <script>
            jQuery(document).ready(function ($) {

                $('#etalage').etalage({
                    thumb_image_width: 300,
                    thumb_image_height: 400,
                    source_image_width: 900,
                    source_image_height: 1200,
                    show_hint: true,
                    click_callback: function (image_anchor, instance_id) {
                        alert('Callback example:\nYou clicked on an image with the anchor: "' + image_anchor + '"\n(in Etalage instance: "' + instance_id + '")');
                    }
                });

            });
        </script>
        <script>$(document).ready(function (c) {
                $('.alert-close').on('click', function (c) {
                    $('.message').fadeOut('slow', function (c) {
                        $('.message').remove();
                    });
                });
            });
        </script>
        <script>$(document).ready(function (c) {
                $('.alert-close1').on('click', function (c) {
                    $('.message1').fadeOut('slow', function (c) {
                        $('.message1').remove();
                    });
                });
            });
        </script>

        <!-- Load Facebook SDK for JavaScript -->
        <script>
            (function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id))
                    return;
                js = d.createElement(s);
                js.id = id;
                js.src = 'https://connect.facebook.net/vi_VN/sdk/xfbml.customerchat.js#xfbml=1&version=v2.12&autoLogAppEvents=1';
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));</script>
    </head>
    <body>

        <!--header-->
        <jsp:include page="header.jsp"></jsp:include>
            <!---->
            <div class="container">
                <div class="single">
                    <div class="col-md-9 top-in-single">
                        <div class="col-md-5 single-top">	
                            <ul id="etalage" >
                                <li>
                                    <a href="optionallink.html">
                                        <img class="etalage_thumb_image img-responsive" src="images/Products/<%=Controller.Products.GetOneProduct.SanPham.getID()%>.jpg" alt="" >
                                    <img class="etalage_source_image img-responsive" src="images/Products/<%=Controller.Products.GetOneProduct.SanPham.getID()%>.jpg" alt="" >
                                </a>
                            </li>
                            <li>
                                <a href="optionallink.html">
                                    <img class="etalage_thumb_image img-responsive" src="images/Products/<%=Controller.Products.GetOneProduct.SanPham.getID()%>.jpg" alt="" >
                                    <img class="etalage_source_image img-responsive" src="images/Products/<%=Controller.Products.GetOneProduct.SanPham.getID()%>.jpg" alt="" >
                                </a>
                            </li>
                            <li>
                                <a href="optionallink.html">
                                    <img class="etalage_thumb_image img-responsive" src="images/Products/<%=Controller.Products.GetOneProduct.SanPham.getID()%>.jpg" alt="" >
                                    <img class="etalage_source_image img-responsive" src="images/Products/<%=Controller.Products.GetOneProduct.SanPham.getID()%>.jpg" alt="" >
                                </a>
                            </li>
                            <li>
                                <a href="optionallink.html">
                                    <img class="etalage_thumb_image img-responsive" src="images/Products/<%=Controller.Products.GetOneProduct.SanPham.getID()%>.jpg" alt="" >
                                    <img class="etalage_source_image img-responsive" src="images/Products/<%=Controller.Products.GetOneProduct.SanPham.getID()%>.jpg" alt="" >
                                </a>
                            </li>
                        </ul>

                    </div>	
                    <div class="col-md-7 single-top-in">
                        <div class="single-para">
                            <h4><%=Controller.Products.GetOneProduct.SanPham.getFullName()%></h4>
                            <div class="para-grid">
                                <span  class="add-to">Giá : $<%=Controller.Products.GetOneProduct.SanPham.getPrice()%></span>
                                <a href="/shop/Cart?command=add&proID=<%=Controller.Products.GetOneProduct.SanPham.getID()%>" class="hvr-shutter-in-vertical cart-to">Thêm vào giỏ hàng</a>					
                                <div class="clearfix"></div>
                            </div>
                            <h5 style="color:red">Tình trạng : Còn hàng !!!</h5>
                            <div class="available">

                            </div>
                            <h6 style="margin-top: 5px  ">
                                <b> - CPU : </b>
                                <%=Controller.Products.GetOneProduct.SanPham.getCpu()%>
                            </h6>
                            <h6 style="margin-top: 5px  ">
                                <b>- RAM : </b>
                                <%=Controller.Products.GetOneProduct.SanPham.getRam()%>
                            </h6>
                            <h6 style="margin-top: 5px  ">
                                <b>- Đồ họa : </b>
                                <%=Controller.Products.GetOneProduct.SanPham.getGPU()%>
                            </h6>
                            <h6 style="margin-top: 5px  ">
                                <b>- Bộ nhớ : </b>
                                <%=Controller.Products.GetOneProduct.SanPham.getInternalmemory()%>
                            </h6>
                            <h6 style="margin-top: 5px  ">
                                <b>- Màn hình : </b>
                                <%=Controller.Products.GetOneProduct.SanPham.getScreenresolution()%>
                            </h6>
                            <h6 style="margin-top: 5px  ">
                                <b>- Ngày ra mắt : </b>
                                <%=Controller.Products.GetOneProduct.SanPham.getReleasedate()%>
                            </h6>

                            <br/>
                            <h6 style="margin-top: 5px  ">
                                <%=Controller.Products.GetOneProduct.SanPham.getShortDes()%>
                            </h6>
                        </div>
                    </div>
                    <div class="clearfix"> </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">Phản hồi của khách hàng</div>
                        <div class="panel-body">
                            <div class="fb-comments" data-href="http://localhost:8084/shop/single.jsp?SanPham=LaptopHPEnvy13ah0027TUi78550U/8GB/256GB/Win10" data-width="100%" data-numposts="5"></div>
                        </div>
                    </div>
                    <div class=" panel panel-default" style="font-size: 15px;text-align: left;margin: 0 auto;">
                        <div class="panel-heading" style="text-transform: uppercase;color: red">
                            <b>Thông tin về : <%=Controller.Products.GetOneProduct.SanPham.getFullName()%></b>
                        </div>
                        <div class="panel-body" >
                            <%=Controller.Products.GetOneProduct.SanPham.getDES()%>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <%
                    Category_DAO catDAO = new Category_DAO();
                    Brand_DAO brandDAO = new Brand_DAO();
                %>
                <div class="col-md-3">
                    <div class="single-bottom">
                        <h4>Danh mục</h4>
                        <ul> 
                            <%
                                for (Category c : catDAO.getListCategory()) {
                            %>
                            <li><a href="/shop/GetProducts?CatID=<%=c.getID()%>"><i> </i><%=c.getName()%></a></li>
                                <% }%>
                        </ul>

                    </div>
                    <div class="single-bottom">
                        <h4>Thương hiệu</h4>
                        <ul style="margin-left: 2%">
                            <%
                                for (Brands br : brandDAO.getListBrands()) {
                            %>
                            <li>
                                <a href="/shop/GetProducts?BrandID=<%=br.getID()%>&page=1">
                                    <img src="images/BrandsLogo/<%=br.getLogo()%>" width="20"/> &nbsp;
                                    <%=br.getName()%>
                                </a>
                            </li>
                            <% }%>
                        </ul>
                    </div>
                    <div class="single-bottom">
                        <h4>Các sản phẩm mới</h4>
                        <%
                            for (Products pro : Product_DAO.getProductsLastest(3)) {
                        %>
                        <div class="product">
                            <img class="img-responsive fashion" src="images/Products/<%=pro.getID()%>.jpg" alt="" width="80">
                            <div class="grid-product">
                                <a href="/shop/GetOneProduct?proID=<%=pro.getID()%>" class="elit"><%=pro.getFullName()%></a>
                                <span class="price price-in"><small >$<%=pro.getPrice() - 10%></small>&nbsp;<label style="color: red">$<%=pro.getPrice()%></label> </span>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <% }%>
                    </div>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
        <!---->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>