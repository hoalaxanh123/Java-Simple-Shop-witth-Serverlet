<%@page import="DAO.Product_DAO"%>
<%@page import="Classes.Products"%>
<%@page import="Classes.Products"%>
<%@page import="DAO.User_DAO"%>
<%@page import="Classes.Users"%>
<%@page import="DAO.Brand_DAO"%>
<%@page import="Classes.Brands"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="Classes.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Category_DAO"%>

<jsp:include page="head.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>

<%
    ArrayList<Products> lstUser = Product_DAO.getListProduct();
%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Dashboard
            <small>Quản lý người dùng</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i>Quản lý người dùng</a></li>
            <li class="active">Dashboard</li>
        </ol>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">Quản lý người dùng</h3>
                        <br/>
                        <a href="ProductDetail.jsp" class="btn btn-info" style="float:right">Thêm mới</a>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <table id="example1" class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th style="width: 5%">STT</th>
                                    <th>Tên SP</th>
                                    <th>Mô tả ngắn</th>
                                    <th>Giá tiền</th>
                                    <th>Ngày phát hành</th>
                                    <th style="width: 10%">Chức năng</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    int i = 1;
                                    for (Products pro : lstUser) {%>
                                <tr>
                                    <td><%=i%></td>
                                    <td><%=pro.getFullName()%></td>
                                    <td><%=pro.getShortDes()%></td>
                                    <td>$ <%=pro.getPrice()%></td>
                                    <td><%=pro.getReleasedate()%></td>
                                    <td>
                                        <form style="display: inline-block" action="ProductDetail.jsp" method="GET">
                                            <input type="hidden" name="ProID" value="<%=pro.getID()%>"/>
                                            <input type="hidden" name="Command" value="Edit"/>
                                            <input type="submit" value="Sửa" class="btn btn-link"/>
                                        </form>
                                        |
                                        <form style="display: inline-block" action="/shop/ManageProduct" method="POST">
                                            <input type="hidden" name="ProID" value="<%=pro.getID()%>"/>
                                            <input type="hidden" name="Command" value="Delete"/>
                                            <input type="submit" value="Xóa" class="btn btn-link"/>
                                        </form>
                                    </td>
                                </tr>
                                <%i++;
                                }%>
                            </tbody>

                        </table>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
        </div>
</div>

<!-- /.content-wrapper -->
<jsp:include page="footer.jsp"></jsp:include>