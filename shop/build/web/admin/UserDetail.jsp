<%@page import="DAO.User_DAO"%>
<%@page import="Classes.Users"%>
<%@page import="DAO.Brand_DAO"%>
<%@page import="Classes.Brands"%>
<%@page import="DAO.Category_DAO"%>
<%@page import="Classes.Category"%>
<%@page import="DAO.Order_DAO"%>
<%@page import="Classes.Orders"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="head.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>

<%
    if (request.getParameter("UserID") == null) {
%>

<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Dashboard
            <small>Quản lý người dùng</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Quản lý nhà người dùng</a></li>
            <li class="active">Dashboard</li>
        </ol>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="panel panel-danger">
                    <div class="panel-heading" style="text-transform: uppercase"><b id="Title">Tạo mới người dùng</b></div>
                    <div class="panel-body" >
                        <form action="/shop/UserAdd" method="post">
                            <div class="form-group">
                                <input type="hidden" value="" name="ID"/>
                                <label for="usr">Tên đăng nhập :</label>
                                <input type="text" class="form-control" name="UserName" value="" required>
                            </div>
                            <div class="form-group">
                                <input type="hidden" value="" name="ID"/>
                                <label for="usr">Mật khẩu :</label>
                                <input type="password" class="form-control" name="Pass1" value="" required>
                            </div>
                            <div class="form-group">
                                <input type="hidden" value="" name="ID"/>
                                <label for="usr">Nhập lại mật khẩu :</label>
                                <input type="password" class="form-control" name="Pass2" value="" required>
                            </div>
                            <div class="form-group">
                                <label for="pwd">Email :</label>
                                <input type="email" class="form-control" name="Email" value="">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Tên thật :</label>
                                <input type="text" class="form-control" name="Realname" value="">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Địa chỉ :</label>
                                <input type="text" class="form-control" name="Address" value="">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Phân quyền :</label>
                                <select name="PhanQuyen"  class="form-control">
                                    <option value="1">
                                        Người dùng
                                    </option>
                                    <option value="0">
                                        Quản trị viên
                                    </option>
                                </select>
                            </div>
                            <input type="submit" id="submit"  value="Thêm mới" style="margin-left: 0" class="btn btn-danger form-control"/>  
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

<%} else {
    int ID = Integer.parseInt(request.getParameter("UserID"));
    Users usr = User_DAO.GetByID(ID);
%>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Dashboard
            <small> Quản lý người dùng</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Quản lý người dùng</a></li>
            <li class="active">Dashboard</li>
        </ol>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="panel panel-danger">
                    <div class="panel-heading" style="text-transform: uppercase"><b id="Title">Sửa đổi thông tin</b></div>
                    <div class="panel-body" >
                        <form action="/shop/UserEdit" method="POST">
                            <div class="form-group">
                                <input type="hidden" value="<%=usr.getID()%>" name="ID"/>
                                <label for="usr">Tên đăng nhập :</label>
                                <input type="text" class="form-control" name="UserName" value="<%=usr.getUserName()%>" required readonly>
                            </div>
                            <div class="form-group">
                                <input type="hidden" value="" name="ID"/>
                                <label for="usr">Mật khẩu :</label>
                                <input type="password" class="form-control" name="Pass1" value="<%=usr.getPassWord()%>" required readonly>
                            </div>
                            <div class="form-group">
                                <label for="pwd">Email :</label>
                                <input type="email" class="form-control" name="Email" value="<%=usr.getEmail()%>">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Tên thật :</label>
                                <input type="text" class="form-control" name="Realname" value="<%=usr.getRealName()%>">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Địa chỉ :</label>
                                <input type="text" class="form-control" name="Address" value="<%=usr.getAddress()%>">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Phân quyền :</label>
                                <select name="PhanQuyen"  class="form-control">
                                    <%
                                        if (usr.getRole() == 0) {
                                    %>
                                    <option value="1" >
                                        Người dùng
                                    </option>
                                    <option value="0" selected>
                                        Quản trị viên
                                    </option>
                                    <%} else {%>
                                    <option value="1" selected>
                                        Người dùng
                                    </option>
                                    <option value="0" >
                                        Quản trị viên
                                    </option>
                                    <%}%>
                                </select>
                                <br/>
                                <input type="submit" class="form-control btn btn-danger"  value="Thay đổi thông tin">
                                </form>
                            </div>
                    </div>
                </div>
            </div>
    </section>
</div>
<%}%>
<jsp:include page="footer.jsp"></jsp:include>