<%@page import="DAO.Category_DAO"%>
<%@page import="Classes.Category"%>
<%@page import="DAO.Order_DAO"%>
<%@page import="Classes.Orders"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="head.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>

<%
    if (request.getParameter("CatID") == null) {
%>

<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Dashboard
            <small>Quản lý danh mục</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Quản lý danh mục</a></li>
            <li class="active">Dashboard</li>
        </ol>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="panel panel-danger">
                    <div class="panel-heading" style="text-transform: uppercase"><b id="Title">Tạo mới danh mục</b></div>
                    <div class="panel-body" >
                        <form action="/shop/CatAdd" method="post">
                            <div class="form-group">
                                <input type="hidden" value="" name="ID"/>
                                <label for="usr">Tiêu đề:</label>
                                <input type="text" class="form-control" name="TieuDe" value="" required>
                            </div>
                            <div class="form-group">
                                <label for="pwd">Miêu tả:</label>
                                <input type="text" class="form-control" name="MoTa" value="">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Logo:</label>
                                <input type="text" class="form-control" name="Logo" value="">
                                <label>Vui lòng lấy mã logo <a href="https://fontawesome.com/icons?d=gallery" target="_blank">tại đây</a></label>
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
    int ID = Integer.parseInt(request.getParameter("CatID"));
    Category cat = Category_DAO.GetCategoryByID(ID);
%>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Dashboard
            <small>Quản lý danh mục</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Quản lý danh mục</a></li>
            <li class="active">Dashboard</li>
        </ol>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="panel panel-danger">
                    <div class="panel-heading" style="text-transform: uppercase"><b id="Title">Sửa đổi thông tin</b></div>
                    <div class="panel-body" >
                        <form action="/shop/CatEdit" method="POST">
                            <div class="form-group">
                                <input type="hidden" value="<%=cat.getID()%>" name="ID"/>
                                <label for="usr">Tiêu đề:</label>
                                <input type="text" class="form-control" name="TieuDe" value="<%=cat.getName()%>" required>
                            </div>
                            <div class="form-group">
                                <label for="pwd">Miêu tả:</label>
                                <input type="text" class="form-control" name="MoTa" value="<%=cat.getDescription()%>">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Logo (Vui lòng lấy mã logo <a href="https://fontawesome.com/icons?d=gallery"  target="_blank">tại đây</a>):</label>
                                <input type="text" class="form-control" name="Logo" value='<%=cat.getLogoHtml()%>'>
                                <label></label>
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