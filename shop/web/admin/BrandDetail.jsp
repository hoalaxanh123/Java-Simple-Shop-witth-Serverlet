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
    if (request.getParameter("BrandID") == null) {
%>

<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Dashboard
            <small>Quản lý danh mục</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Quản lý nhà sản xuất</a></li>
            <li class="active">Dashboard</li>
        </ol>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="panel panel-danger">
                    <div class="panel-heading" style="text-transform: uppercase"><b id="Title">Tạo mới nhà sản xuất</b></div>
                    <div class="panel-body" >
                        <form action="/shop/BrandAdd" method="post">
                            <div class="form-group">
                                <input type="hidden" value="" name="ID"/>
                                <label for="usr">Tên hãng:</label>
                                <input type="text" class="form-control" name="Name" value="" required>
                            </div>
                            <div class="form-group">
                                <label for="pwd">Mô tả:</label>
                                <input type="text" class="form-control" name="Des" value="">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Hình ảnh:</label>
                                <input type="text" class="form-control" name="Logo" value="">
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
    int ID = Integer.parseInt(request.getParameter("BrandID"));
    Brands br = Brand_DAO.GetByID(ID);
%>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Dashboard
            <small>Quản lý nhà sản xuất</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Quản lý nhà sản xuất</a></li>
            <li class="active">Dashboard</li>
        </ol>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="panel panel-danger">
                    <div class="panel-heading" style="text-transform: uppercase"><b id="Title">Sửa đổi thông tin</b></div>
                    <div class="panel-body" >
                        <form action="/shop/BrandEdit" method="POST">
                            <div class="form-group">
                                <input type="hidden" value="<%=br.getID()%>" name="ID"/>
                                <label for="usr">Tên NSX :</label>
                                <input type="text" class="form-control" name="Name" value="<%=br.getName()%>" required>
                            </div>
                            <div class="form-group">
                                <label for="pwd">Miêu tả:</label>
                                <input type="text" class="form-control" name="Des" value="<%=br.getDescription()%>">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Logo:</label>
                                <input type="text" class="form-control" name="Logo" value="<%=br.getLogo()%>">
                            </div>

                            <input type="submit" value="Thay đổi thông tin" style="margin-left: 0" class="btn btn-danger form-control"/>  
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<%}%>
<jsp:include page="footer.jsp"></jsp:include>