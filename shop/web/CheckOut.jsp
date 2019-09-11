<%@page import="Classes.Carts"%>
<%@page import="Classes.Carts"%>
<%@page import="Classes.Users"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    Carts cart = (Carts) session.getAttribute("cart");
    if (cart == null) {
        cart = new Carts();
        session.setAttribute("cart", cart);
    }
    if (cart.countItem() == 0) {
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Shop | Thanh toán</title>

    </head>
    <body>
        <jsp:include page="head.jsp"></jsp:include>
        <jsp:include page="header.jsp"></jsp:include>


            <div class="container">
                <div class="panel panel-danger " style="margin-top: 2%">
                    <div class="panel-heading" style="text-transform: uppercase">Thanh toán đơn hàng</div>
                    <div class="panel-body">
                        <center>
                            <div class="account">
                            <%
                                if (session.getAttribute("user") == null) {
                            %>
                            <form action="/shop/Order" method="post">
                                <form action="/shop/Order" method="post">
                                    <input type="hidden" name="UserName" value="">
                                    <div class="form-group">
                                        <label >Họ và tên:</label>
                                        <input type="text" class="form-control"  name="RealName" required value="" />
                                    </div>
                                    <div class="form-group">
                                        <label >Email:</label>
                                        <input type="text" class="form-control" name="Email" required value="" />
                                    </div>
                                    <div class="form-group">
                                        <label >Địa chỉ:</label>
                                        <input type="text" class="form-control"  name="Address" required value="" />
                                    </div>
                                    <div class="form-group">
                                        <label >Ghi chú :</label>
                                        <br/>
                                        <textarea cols="12" rows="5" name="Note"></textarea>
                                    </div>
                                    <div class="form-group">
                                        <select class="form-control" name="PayMethod" style="width: 60%">
                                            <option value="Chuyển phát nhanh ( có tính phí vận chuyển )">Chuyển phát nhanh ( có tính phí vận chuyển )</option>
                                            <option value="Chuyển thường ( không tính phí vận chuyển )">Chuyển thường ( không tính phí vận chuyển )</option>
                                        </select>
                                    </div>
                                    <input type="submit" id="submit"  value="Thanh toán" style="margin-left: 0" class="btn btn-info "/>  
                                </form>
                                <%} else {
                                    Users usr = (Users) session.getAttribute("user");
                                %>
                                <form action="/shop/Order" method="post">
                                    <input type="hidden" name="UserName" value="<%=usr.getUserName()%>">
                                    <div class="form-group">
                                        <label >Họ và tên:</label>
                                        <input type="text" class="form-control"  name="RealName" required value="<%=usr.getRealName()%>" />
                                    </div>
                                    <div class="form-group">
                                        <label >Email:</label>
                                        <input type="text" class="form-control" name="Email" required value="<%=usr.getEmail()%>" />
                                    </div>
                                    <div class="form-group">
                                        <label >Địa chỉ:</label>
                                        <input type="text" class="form-control"  name="Address" required value="<%=usr.getAddress()%>" />
                                    </div>
                                    <div class="form-group">
                                        <label >Ghi chú :</label>
                                        <br/>
                                        <textarea cols="12" rows="5" name="Note"></textarea>
                                    </div>
                                    <div class="form-group">
                                        <select class="form-control" name="PayMethod" style="width: 60%">
                                            <option value="Chuyển phát nhanh ( có tính phí vận chuyển )">Chuyển phát nhanh ( có tính phí vận chuyển )</option>
                                            <option value="Chuyển thường ( không tính phí vận chuyển )">Chuyển thường ( không tính phí vận chuyển )</option>
                                        </select>
                                    </div>
                                    <input type="submit" id="submit"  value="Thanh toán" style="margin-left: 0" class="btn btn-info "/>  
                                </form>
                                <%}%>
                        </div>
                    </center>
                </div>

            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>


    </body>
</html>
