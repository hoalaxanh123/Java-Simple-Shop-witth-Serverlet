<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="head.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>

    <div class="container">
        <div class="account panel panel-default" style="margin-top: 2%">
            <center>
                <h2 class="account-in " style="text-transform: uppercase"><b>Đăng ký tài khoản</b></h2>

                <form action="#" method="post" class="panel-body">
                    <div class="form-group">
                        <label for="usr">Tên đăng nhập:</label>
                        <input type="text" class="form-control" name="UserNameDK" id="UserNameDK">
                        <label style="color: red" id="error_nameDK"></label>
                    </div>
                    <div class="form-group">
                        <label for="pwd">Mật khẩu:</label>
                        <input type="password" class="form-control" id="PassFirtDK" name="PassFirtDK">
                        <label style="color: red" id="error_passfirtDK"></label>
                    </div>
                    <div class="form-group">
                        <label for="pwd">Nhập lại mật khẩu:</label>
                        <input type="password" class="form-control" id="PassSecondDK" name="PassSecondDK">
                        <label style="color: red" id="error_passsecondDK"></label>
                    </div>
                    <div class="form-group">
                        <label for="usr">Email :</label>
                        <input type="text" class="form-control" id="EmailDK" name="EmailDK">
                        <label style="color: red" id="error_EmailDK"></label>
                    </div>
                    <div class="form-group">
                        <label for="usr">Tên thật :</label>
                        <input type="text" class="form-control" id="FullNameDK" name="FullNameDK">
                        <label style="color: red" id="error_fullnameDK"></label>
                    </div>
                    <div class="form-group">
                        <label for="usr">Địa chỉ:</label>
                        <input type="text" class="form-control" id="AddressDK" name="AddressDK">
                        <label style="color: red" id="error_addressDK"></label>
                    </div>
                    <input type="button" id="submit"  value="Đăng ký" style="margin-left: 0" class="btn btn-info "/>  
                </form>
            </center>
        </div>
    </div>
    <script src="js/RegisterValidate.js" type="text/javascript"></script>

<jsp:include page="footer.jsp"></jsp:include>
