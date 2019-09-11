<%@page import="Classes.Item"%>
<%@page import="Classes.Carts"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Carts cart = (Carts) session.getAttribute("cart");
    if (cart == null) {
        cart = new Carts();
        session.setAttribute("cart", cart);
    }
%>
<jsp:include page="head.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>
    <div class="container">
        <center>
            <bR/>
            <h1 style="text-transform: uppercase;color: red">Các sản phẩm đã chọn    </h1>
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
                for (Item item : cart.getCartItems()) {

            %>
            <tr>
                <td style="text-align: center"><%=i%></td>
                <td><%=item.getProduct().getFullName()%></td>
                <td>$ <%=item.getProduct().getPrice()%></td>
                <td style="text-align: center"><%=item.getQuantity()%></td>
                <td style="text-align: center">$ <%=item.getProduct().getPrice() * item.getQuantity()%></td>
            </tr>
            <% i++;
                }
            %>
        </table>
    </center>

    <div style="float:right;margin-right: 10%">
        <br/>
        <label>Tổng số sản phẩm : <%=cart.countItem()%></label>
        <br/>
        <label>Tổng tiền : $ <%=cart.total()%></label>
        <br/>   
        <a href="CheckOut.jsp" class="btn btn-danger">Tiến hành thanh toán</a>
        <br/>   
    </div>
    <br/>   
</div>
<br/>   
<jsp:include page="footer.jsp"></jsp:include>