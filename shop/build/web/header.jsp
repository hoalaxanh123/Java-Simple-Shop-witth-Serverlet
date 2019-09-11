<%@page import="java.util.Map"%>
<%@page import="Classes.Item"%>
<%@page import="Classes.Carts"%>
<%@page import="Controller.Cart.Cart"%>
<%@page import="Classes.Users"%>
<%@page import="Classes.Brands"%>
<%@page import="DAO.Brand_DAO"%>
<%@page import="DAO.Category_DAO"%>
<%@page import="Classes.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    Category_DAO catDAO = new Category_DAO();
    Brand_DAO brandDAO = new Brand_DAO();

    Carts cart = (Carts) session.getAttribute("cart");
    if (cart == null) {
        cart = new Carts();
        session.setAttribute("cart", cart);
    }
%>
<style>
    .MenuHeader{
        text-transform: uppercase;
    }
</style>
<!--header-->
<div class="header">
    <div class="header-top">
        <div class="container">	
            <div class="header-top-in">			
                <div class="logo">
                    <a href="index.jsp"><img src="images/logo.png" alt="1510289 | My shop" width="150px"></a>
                </div>
                <div class="header-in">
                    <ul class="icon1 sub-icon1">

                        <%     if (session.getAttribute("user") != null) {
                                Users usr = (Users) session.getAttribute("user");
                        %>
                        <li>
                            <div class="dropdownMenu">
                                <span class="dropbtnMenu"><i class="fas fa-user-alt"></i>&nbsp;Xin chào , <%=usr.getRealName()%></span>
                                <div class="dropdown-contentMenu">
                                    <a href="/shop/account.jsp" class="MenuHeader"><i class="fas fa-user-alt"></i>&nbsp;T.Tin tài khoản</a>
                                    <a href="/shop/LogOut" class="MenuHeader"><i class="fas fa-sign-out-alt"></i>&nbsp;Đăng xuất</a>
                                    <%if (usr.getRole() == 0) {%>
                                    <a href="/shop/admin" class="MenuHeader"><i class="fas fa-unlock-alt"></i>&nbsp;Quản trị</a>
                                    <%}%>
                                </div>
                            </div>
                        </li>

                        <%} else {%>
                        <li  ><a href="login.jsp" class="MenuHeader"><i class="fas fa-user-alt"></i>&nbsp;Đăng nhập </a></li>
                        <li  ><a href="register.jsp" class="MenuHeader"><i class="fas fa-user-alt"></i>&nbsp;Đăng ký </a></li>
                            <%}%>
                        <li class="MenuHeader" ><a href="FindOrder.jsp" ><i class="fas fa-clipboard-list"></i>&nbsp; Tra cứu hóa đơn </a> </li>
                        <li > <a href="CheckOut.jsp" class="MenuHeader"><i class="fas fa-money-check-alt"></i>&nbsp; Thanh toán       </a> </li>	
                        <li><div class="cart">
                                <a href="Cart.jsp" class="cart-in"> </a>
                                <span><%=cart.countItem()%></span>
                            </div>
                            <ul class="sub-icon1 list">
                                <h3>Giỏ hàng(<%=cart.countItem()%>)</h3>
                                <div class="shopping_cart">
                                    <%for (Item item
                                                : cart.getCartItems()) {%>
                                    <div class="cart_box">
                                        <div class="message">
                                            <div class="alert-close"> </div> 
                                            <div class="list_img"><img src="images/Products/<%=item.getProduct().getID()%>.jpg" class="img-responsive" alt=""></div>
                                            <div class="list_desc">
                                                <h4>
                                                    <a href="Cart?command=remove&proID=<%=item.getProduct().getID()%>" title="Xóa <%=item.getProduct().getFullName()%>">
                                                        <%=item.getProduct().getName()%>
                                                    </a>

                                                </h4>
                                                <%=item.getQuantity()%> x<span class="actual"> $<%=item.getProduct().getPrice()%></span>
                                            </div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                    <%}%>

                                </div>
                                <div class="total">
                                    <div class="total_left">Tổng : </div>
                                    <div class="total_right">$<%=cart.total()%></div>
                                    <div class="clearfix"> </div>
                                </div>
                                <div class="login_buttons">
                                    <div class="check_button"><a href="CheckOut.jsp">Thanh toán</a></div>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="clearfix"></div>
                            </ul>
                        </li>
                    </ul>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
    </div>
    <div class="header-bottom">
        <div class="container">
            <div class="h_menu4">
                <a class="toggleMenu" href="#">Menu</a>
                <ul class="nav">
                    <li class="active"><a href="index.jsp"><i class="fas fa-home"></i> Trang chủ</a></li>
                        <%
                            for (Category c
                                    : catDAO.getListCategory()) {
                        %>
                    <li class="MenuHeader"><a href="/shop/GetProducts?CatID=<%=c.getID()%>&page=1" style="width: 100%;height: 100%"> 
                            <%out.print(c.getLogo());%>
                            <%=c.getName()%>
                        </a>
                        <ul class="drop">
                            <%
                                for (Brands br : brandDAO.getListBrands()) {
                            %>
                            <li><a href="/shop/GetProducts?CatID=<%=c.getID()%>&BrandID=<%=br.getID()%>&page=1" title="<%=br.getDescription()%>"><%=br.getName()%></a></li>
                                <% }%>
                        </ul>
                        <% }%>
                </ul>
                <script type="text/javascript" src="js/nav.js"></script>
            </div>
        </div>
    </div>
    <div class="header-bottom-in">
        <div class="container">
            <div class="header-bottom-on">
                <%     if (session.getAttribute("user") != null) {
                        Users usr = (Users) session.getAttribute("user");
                %>
                <p class="wel"><a href="/shop/login.jsp">Hi <%=usr.getRealName()%> , chúc bạn có những giây phút mua hàng thoải mái.</a></p>
                <%} else {%>
                <p class="wel"><a href="/shop/login.jsp">Chào mừng bạn tới với shop, bạn có thể đăng nhập hoặc đăng ký tại đây.</a></p>
                <%}%>
                <div class="header-can">
                    <div class="col-md-3"> </div>
                    <ul class="social-in">
                        <li><a href="#"><i> </i></a></li>
                        <li><a href="#"><i class="facebook"> </i></a></li>
                        <li><a href="#"><i class="twitter"> </i></a></li>					
                        <li><a href="#"><i class="skype"> </i></a></li>
                    </ul>	

                    <div class="search">
                        <form method="get" action="/shop/FindProducts">
                            <input type="text" name="KeyWord" value="Nhập từ khóa" onfocus="this.value = '';" onblur="if (this.value == '') {
                                        this.value = '';
                                    }" >
                            <input type="submit" value="">
                        </form>
                    </div>

                    <div class="clearfix"> </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>