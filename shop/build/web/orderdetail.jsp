<%@page import="Classes.Users"%>
<%@page import="Classes.OrderDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Classes.Orders"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Orders order = (Orders) session.getAttribute("order");
    ArrayList<OrderDetails> lstdetail = (ArrayList<OrderDetails>) session.getAttribute("lstdetail");
    Users usr = (Users) session.getAttribute("user");
%>
<jsp:include page="head.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>
    <div class="container">
        <div class="container">

        <%
            if (usr != null) {
                if (usr.getRole() == 0 || usr.getUserName().equals(order.getUserName())) {
        %>
        <div style="margin: 2% 10% 0% 14%" class="panel panel-default">
            <div class="panel-heading">Thông tin khách hàng</div>
            <div class="panel-body">
                <h5>Mã hóa đơn : <%=order.getID()%></h5>
                <h5>Người tạo : <%=order.getCreator()%></h5>
                <h5>Thời gian tạo : <%=order.getDateCreate()%></h5>
                <h5>Địa chỉ : <%=order.getAddress()%></h5>
                <h5>Email : <%=order.getEmail()%></h5>
                <h5>Ghi chú : <%=order.getNote()%></h5>
                <h5>Phương thức thanh toán : <%=order.getPayMethod()%></h5>
            </div>
            <%}
            } else {%>
            <div style="margin: 2% 10% 0% 14%" class="panel panel-default">
                <div class="panel-heading">Thông tin khách hàng</div>
                <div class="panel-body">
                    <h5>Mã hóa đơn : <%=order.getID()%></h5>
                    <h5 >Người tạo :<span class="text-muted"> Thông tin bị ẩn</span></h5>
                    <h5>Thời gian tạo : <%=order.getDateCreate()%></h5>
                    <h5>Địa chỉ<span class="text-muted"> : Thông tin bị ẩn</span></h5>
                    <h5>Email<span class="text-muted"> : Thông tin bị ẩn</span></h5>
                    <h5>Ghi chú<span class="text-muted"> : Thông tin bị ẩn</span></h5>
                    <h5>Phương thức thanh toán : <%=order.getPayMethod()%></h5>
                    <%}%>
                </div>
            </div>

            <center>
                <bR/>
                <h1 style="text-transform: uppercase;color: red">Danh sách sản phẩm </h1>
                <bR/>   
                <table class="table table-bordered table-striped table-responsive table-hover" style="width: 80%;margin-left: 5%    ">
                    <thead>
                    <th>STT</th>
                    <th>Tên SP</th>
                    <th>Đơn giá</th>
                    <th>Số lượng</th>
                    <th>Thành tiền</th  >
                    </thead>
                    <%
                        int i = 1;
                        for (OrderDetails item : lstdetail) {

                    %>
                    <tr>
                        <td style="text-align: center"><%=i%></td>
                        <td><%=item.getProductName()%></td>
                        <td>$ <%=item.getPrice()%></td>
                        <td style="text-align: center"><%=item.getQuantity()%></td>
                        <td style="text-align: center">$ <%=item.getPrice() * item.getQuantity()%></td>
                    </tr>
                    <% i++;
                        }
                    %>
                </table>
            </center>

            <div style="float:right;margin-right: 10%">
                <br/>
                <label>Tổng số sản phẩm : <%=lstdetail.size()%></label>
                <br/>
                <label>Tổng tiền : $ <%=order.getTotal()%></label>
                <br/>   
                <a href="index.jsp" class="btn btn-danger">Quay lại trang chủ</a>
                <br/>   
            </div>
        </div>
        <bR/>
        <jsp:include page="footer.jsp"></jsp:include>