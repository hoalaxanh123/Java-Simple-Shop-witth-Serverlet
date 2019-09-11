<%@page import="Classes.Item"%>
<%@page import="Classes.Carts"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="head.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>
 <br/>
    <div class="container">
        <div class="panel panel-danger"> 
            <div class=" panel-heading">Tìm kiếm</div>
            <div class="panel-body">
                <form action="/shop/OrderDetail" method="post">
                    <h5>Nhập từ khóa</h5>
                    <input type="number" required class="form-control" name="OrderID" placeholder="Vui lòng nhập mã hóa đơn"/>
                    <br/>
                    <input type="submit" value="Tìm" class="form-control btn-info"/>
                </form>
            </div>
        </div>

        <br/>   
        <br/> 
        <br/>   

    </div>
<jsp:include page="footer.jsp"></jsp:include>