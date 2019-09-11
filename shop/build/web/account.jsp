<%@page import="Classes.Orders"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Order_DAO"%>
<%@page import="Classes.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Users usr = (Users) session.getAttribute("user");
    if (usr == null) {
        response.sendRedirect("index.jsp");
    }
%>

<jsp:include page="head.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>

    <div class="container">
        <div class="row">
            <div class="col-md-4" >
                <div class="panel panel-default">
                    <div class="panel-heading" style="text-transform: uppercase"><b>Thông tin tài khoản</b></div>
                    <div class="panel-body">
                        <ul class="list-group" >
                            <li class="list-group-item"><a href="/shop/account.jsp"  style="display: block;">Thông tin cá nhân</a></li>
                            <li class="list-group-item"><a href="/shop/account.jsp?command=myorder"  style="display: block;">Đơn hàng của tôi</a></li>
                            <li class="list-group-item"><a href="/shop/account.jsp?command=changepass"  style="display: block;">Đổi mật khẩu</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <div class="panel panel-default">
                <%
                    Users user = (Users) session.getAttribute("user");
                    String command = request.getParameter("command");
                    ArrayList<Orders> lstOrder = Order_DAO.getListOrdersByUserName(user.getUserName());
                    if (command == null) {
                %>
                <div class="panel-heading" style="text-transform: uppercase"><b id="Title">Thông tin tài khoản</b></div>
                <div class="panel-body" >
                    <form action="/shop/ChangeInfo" method="post">
                        <div class="form-group">
                            <input type="hidden" value="<%=user.getID()%>" id="ID"/>
                            <label for="usr">Tên đăng nhập:</label>
                            <input type="text" class="form-control" name="UserNameDK" id="UserNameDK" readonly value="<%=user.getUserName()%>">
                            <span style="color: red" id="error_nameDK"></span>
                        </div>
                        <div class="form-group">
                            <label for="pwd">Mật khẩu:</label>
                            <input type="password" class="form-control" id="PassFirtDK" name="PassFirtDK" value="">
                            <span style="color: red" id="error_passfirtDK"></span>
                        </div>
                        <div class="form-group">
                            <label for="usr">Email :</label>
                            <input type="email" class="form-control" id="EmailDK" name="EmailDK" value="<%=user.getEmail()%>">
                            <span style="color: red" id="error_EmailDK"></span>
                        </div>
                        <div class="form-group">
                            <label for="usr">Tên thật :</label>
                            <input type="text" class="form-control" id="FullNameDK" name="FullNameDK" value="<%=user.getRealName()%>">
                            <span style="color: red" id="error_fullnameDK"></span>
                        </div>
                        <div class="form-group">
                            <label for="usr">Địa chỉ:</label>
                            <input type="text" class="form-control" id="AddressDK" name="AddressDK" value="<%=user.getAddress()%>">
                            <span style="color: red" id="error_addressDK"></span>
                        </div>
                        <input type="button" id="submit"  value="Thay đổi thông tin" style="margin-left: 0" class="btn btn-danger form-control"/>  
                    </form>
                    <script src="js/ChangeInfoValidate.js" type="text/javascript"></script>
                </div>
                <%} else if (command.equals("myorder")) {%>
                <div class="panel-heading" style="text-transform: uppercase"><b id="Title">Đơn hàng của tôi</b></div>
                <div class="panel-body" >
                    <table class="table table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>STT</th>
                                <th style="max-width: 80px">Mã đơn hàng</th>
                                <th>Tên khách hàng</th>
                                <th>Tổng tiền</th>
                                <th>Chức năng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int i = 1;
                                for (Orders order : lstOrder) {
                            %>
                            <tr>
                                <td><%=i%></td>
                                <td><%=order.getID()%></td>
                                <td><%=order.getCreator()%></td>
                                <td>$ <%=order.getTotal()%></td>
                                <td><a href="/shop/OrderDetail?OrderID=<%=order.getID()%>">>>Xem đơn hàng</a></td>
                            </tr>
                            <%
                                    i++;
                                }%>
                        </tbody>
                    </table>
                </div>

            </div>
            <%} else if (command.equals("changepass")) {%>
            <div class="panel-heading" style="text-transform: uppercase"><b id="Title">Đổi mật khẩu</b></div>
            <div class="panel-body" >
                <form method="post" action="#">
                    <div class="form-group">
                        <input type="hidden" value="<%=user.getID()%>" id="ID"/>
                        <label for="pwd">Mật khẩu:</label>
                        <input type="password" class="form-control" id="oldPass" name="oldPass" value="" required>
                        <span style="color: red" id="error_oldPass"></span>
                    </div>
                    <div class="form-group">
                        <label for="pwd">Mật khẩu mới:</label>
                        <input type="password" class="form-control" id="newPass" name="newPass" value="" required>
                        <span style="color: red" id="error_newPass"></span>
                    </div>
                    <div class="form-group">
                        <label for="pwd">Xác nhận mật khẩu:</label>
                        <input type="password" class="form-control" id="newPass2" name="newPass2" value="" required>
                        <span style="color: red" id="error_newPass2"></span>
                    </div>
                    <button type="button" class="btn btn-danger " id="submit">Đổi mật khẩu</button>

                </form>
                <script src="js/ChangePassValidate.js" type="text/javascript"></script>
            </div>
            <%} else {
                    response.sendRedirect("404.jsp");
                }%>
        </div>
    </div>
</div>


<jsp:include page="footer.jsp"></jsp:include>