<%@page import="Classes.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
    </head>
    <body>
        <%
            if (session.getAttribute("user") != null) {
                response.sendRedirect("account.jsp");
            }
        %>
        <jsp:include page="head.jsp"></jsp:include>
        <jsp:include page="header.jsp"></jsp:include>

            <div class="container">
                <div class="account">
                    <h2 class="account-in">Đăng nhập hệ thống</h2>
                    <form method="post" action="/shop/Login">
                        <label id="LoginError" class="hidden" style="color:red;display: block"></label>
                        <div>
                            <span>Tài khoản :  *</span>
                            <input type="text" name="UserName" id="UserName" value="admin" required>
                        </div> 	
                        <div> 
                            <span class="word">Mật khẩu :  *</span>
                            <input type="password" name="Password" id="Password" value="123456" required>
                        </div>	
                        <input type="button" value="Đăng nhập" onclick="Login()" class="btn btn-primary" style="margin-left: 10.8%"> 
                    </form>
                </div>
            </div>
            <script>
                function Login() {
                    var usr = $("#UserName").val();
                    var pass = $("#Password").val();
                    $.post("/shop/Login", {UserName: usr, Password: pass}, function (data) {
                        if (data == "OK")
                        {
                            window.location.href = "index.jsp";
                        } else
                        {
                            $("#LoginError").removeClass("hidden");
                            $("#LoginError").text("Thông báo : Sai tên đăng nhập hoặc mật khẩu");
                        }
                    });
                }
            </script>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
