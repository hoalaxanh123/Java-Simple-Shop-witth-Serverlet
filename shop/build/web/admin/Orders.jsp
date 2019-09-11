<%@page import="Classes.Orders"%>
<%@page import="Classes.Orders"%>
<%@page import="DAO.Order_DAO"%>
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
    ArrayList<Orders> lstOrder = Order_DAO.getListOrders();
%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Dashboard
            <small>Quản lý hóa đơn</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i>Quản lý hóa đơn</a></li>
            <li class="active">Dashboard</li>
        </ol>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">Quản lý hóa đơn</h3>
                        <br/>
                        <a href="UserDetail.jsp" class="btn btn-info disabled" style="float:right">Thêm mới</a>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <table id="example1" class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th style="width: 5%">STT</th>
                                    <th>Người tạo</th>
                                    <th>Ngày tạo</th>
                                    <th>Đại chỉ</th>
                                    <th>Ghi chú</th>
                                    <th>Số tiền</th>
                                    <th style="width: 10%">Chức năng</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    int i = 1;
                                    for (Orders order : lstOrder) {%>
                                <tr>
                                    <td><%=i%></td>
                                    <td><%=order.getCreator()%></td>
                                    <td><%=order.getDateCreate()%></td>
                                    <td><%=order.getAddress()%></td>
                                    <td><%=order.getNote()%></td>
                                     <td>$ <%=order.getTotal()%></td>
                                    <td>
                                        <form style="display: inline-block" action="/shop/OrderDelete" method="POST">
                                            <input type="hidden" name="OrderID" value="<%=order.getID()%>"/>
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