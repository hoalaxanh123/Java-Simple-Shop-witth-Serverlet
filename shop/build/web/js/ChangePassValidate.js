
$("#oldPass").on('input', function () {
    if ($(this).val().length <= 5) {
        $(this).css("border-color", "#FF0000");
        $('#submit').addClass("btn-info disabled");
        $("#error_oldPass").text("*Nhập ít nhất 6 ký tự");
    } else {
        $(this).css("border-color", "#2eb82e");
        $('#submit').removeClass("btn-info disabled");
        $("#error_oldPass").text("");
    }
});
$("#newPass").on('input', function () {
    if ($(this).val().length <= 5) {
        $(this).css("border-color", "#FF0000");
        $('#submit').addClass("btn-info disabled");
        $("#error_newPass").text("*Nhập ít nhất 6 ký tự");
    } else {
        $(this).css("border-color", "#2eb82e");
        $('#submit').removeClass("btn-info disabled");
        $("#error_newPass").text("");
    }
});
$("#newPass2").on('input', function () {
    if ($(this).val() != $("#newPass").val()) {
        $(this).css("border-color", "#FF0000");
        $('#submit').addClass("btn-info disabled");
        $("#error_newPass2").text("*Không khớp mật khẩu");
    } else {
        $(this).css("border-color", "#2eb82e");
        $('#submit').removeClass("btn-info disabled");
        $("#error_newPass2").text("");
    }
});
$("#submit").click(function () {
    var check = 0;
    if ($("#oldPass").val().length <= 5) {
        $(this).css("border-color", "#FF0000");
        $('#submit').addClass("btn-info disabled");
        $("#error_oldPass").text("*Nhập ít nhất 6 ký tự");
        check--;
    } else {
        $(this).css("border-color", "#2eb82e");
        $('#submit').removeClass("btn-info disabled");
        $("#error_oldPass").text("");
        check++;
    }

    if ($("#newPass").val().length <= 5) {
        $(this).css("border-color", "#FF0000");
        $('#submit').addClass("btn-info disabled");
        $("#error_newPass").text("*Nhập ít nhất 6 ký tự");
        check--;
    } else {
        $(this).css("border-color", "#2eb82e");
        $('#submit').removeClass("btn-info disabled");
        $("#error_newPass").text("");
        check++;
    }
    if ($("#newPass2").val() != $("#newPass").val()) {
        $(this).css("border-color", "#FF0000");
        $('#submit').addClass("btn-info disabled");
        $("#error_newPass2").text("*Không khớp mật khẩu");
        check--;
    } else {
        $(this).css("border-color", "#2eb82e");
        $('#submit').removeClass("btn-info disabled");
        $("#error_newPass2").text("");
        check++;
    }
    if (check == 3) {
        $.post("/shop/ChangePass", {MatKhauCu: $("#oldPass").val(), MatKhauMoi: $("#newPass").val(), ID: $("#ID").val()}, function (data) {
            alert(data);
            switch (data)
            {
                case "1":
                    alert("Thay đổi mật khẩu thành công, vui lòng đăng nhập lại");
                    window.location.href = "/shop/login.jsp";
                    break;
                default:
                    alert("Thay đổi mật khẩu thất bại, vui lòng thử lại sau");
                    break;
            }

        });
    }
});
