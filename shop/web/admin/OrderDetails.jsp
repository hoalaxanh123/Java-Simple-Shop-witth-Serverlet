<%@page import="Classes.OrderDetails"%>
<%@page import="DAO.OrderDetail_DAO"%>
<%@page import="Controller.Order.OrderDetail"%>
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
    ArrayList<OrderDetails> lstDetail = OrderDetail_DAO.getOrders();
%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Dashboard
            <small>Quản lý chi tiết hóa đơn</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i>Quản lý chi tiết hóa đơn</a></li>
            <li class="active">Dashboard</li>
        </ol>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">Quản lý chi tiết hóa đơn</h3>
                        <br/>
                        <a href="UserDetail.jsp" class="btn btn-info disabled" style="float:right">Thêm mới</a>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <table id="example1" class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th style="width: 5%">STT</th>
                                    <th>Mã hóa đơn</th>
                                    <th>Tên sản phẩm</th>
                                    <th>Số lượng</th>
                                    <th>Giá tiền</th>
                                    <th>Thành tiền</th>
                                    <th style="width: 10%">Chức năng</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    int i = 1;
                                    for (OrderDetails detail : lstDetail) {%>
                                <tr>
                                    <td><%=i%></td>
                                    <td><%=detail.getIDOrder()%></td>
                                    <td><%=detail.getProductName()%></td>
                                    <td><%=detail.getQuantity()%></td>
                                    <td>$ <%=detail.getPrice()%></td>
                                    <td>$ <%=detail.getTotal()%></td>
                                    <td>
                                        <form style="display: inline-block" action="/shop/OrderDetailDelete" method="POST">
                                            <input type="hidden" name="DetailID" value="<%=detail.getID()%>"/>
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