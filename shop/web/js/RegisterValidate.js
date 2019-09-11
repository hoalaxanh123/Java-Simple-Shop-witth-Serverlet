
        $("#UserNameDK").on('input', function () {
    if ($(this).val().length <= 5) {
        $(this).css("border-color", "#FF0000");
        //  $('#submit').addClass("btn-info disabled");
        $('#submit').addClass("btn-info disabled");
        $("#error_nameDK").text("*Tên đăng nhập ít nhất 6 ký tự");
    } else {

        $(this).css("border-color", "#2eb82e");
        $('#submit').removeClass("btn-info disabled");
        $('#submit').removeClass("btn-info disabled");
        $("#error_nameDK").text("");

    }
});

$("#UserNameDK").focusout(function () {
    if ($("#UserNameDK").val().length >= 6) {
        $.post("/shop/CheckUserNameExist", {TenDN: $("#UserNameDK").val()}, function (cc) {
            alert(cc);
            if (cc == "false") {
                $("#error_nameDK").text("");
            } else {
                $("#error_nameDK").text("*Tên đăng nhập đã có người dùng, vui lòng chọn tên khác");
                $(this).css("border-color", "#2eb82e");
                $('#submit').addClass("btn-info disabled");
            }
        });
    }
});

$("#EmailDK").focusout(function () {
    if ($("#EmailDK").val().length >= 6) {
        $.post("/shop/CheckEmailExist", {Email: $("#EmailDK").val()}, function (cc) {
            if (cc == "false") {
                $("#error_EmailDK").text("");
            } else {
                $("#error_EmailDK").text("*Email đã có người dùng, vui lòng chọn tên khác");
                $(this).css("border-color", "#2eb82e");
                $('#submit').addClass("btn-info disabled");
            }
        });
    }
});

$("#PassFirtDK").on('input', function () {
    if ($(this).val().length <= 5) {
        $(this).css("border-color", "#FF0000");
        $('#submit').addClass("btn-info disabled");
        $("#error_passfirtDK").text("*Nhập ít nhất 6 ký tự");
    } else {
        $(this).css("border-color", "#2eb82e");
        $('#submit').removeClass("btn-info disabled");
        $("#error_passfirtDK").text("");

    }
});
$("#FullNameDK").on('input', function () {
    if ($(this).val().length == 0) {
        $(this).css("border-color", "#FF0000");
        $('#submit').addClass("btn-info disabled");
        $("#error_fullnameDK").text("*Vui lòng nhập tên bạn");
    } else {
        $(this).css("border-color", "#2eb82e");
        $('#submit').removeClass("btn-info disabled");
        $("#error_fullnameDK").text("");

    }
});
$("#PassSecondDK").on('input', function () {
    if ($(this).val() != $("#PassFirtDK").val()) {
        $(this).css("border-color", "#FF0000");
        $('#submit').addClass("btn-info disabled");
        $("#error_passsecondDK").text("*Không khớp mật khẩu");
    } else {
        $(this).css("border-color", "#2eb82e");
        $('#submit').removeClass("btn-info disabled");
        $("#error_passsecondDK").text("");

    }
});
$("#EmailDK").on('input', function () {
    if ($(this).val() == "") {
        $(this).css("border-color", "#FF0000");
        $('#submit').addClass("btn-info disabled");
        $("#error_EmailDK").text("*Hãy nhập email hợp lệ , nó rất quan trọng!");
    } else {
        $(this).css("border-color", "#2eb82e");
        $('#submit').removeClass("btn-info disabled");
        $("#error_EmailDK").text("");
    }
});

$("#AddressDK").on('input', function () {
    if ($(this).val() == '') {
        $(this).css("border-color", "#FF0000");
        $('#submit').addClass("btn-info disabled");
        $("#error_addressDK").text("* Bạn chưa nhập địa chỉ");
    } else {
        $(this).css({"border-color": "#2eb82e"});
        $('#submit').removeClass("btn-info disabled");
        $("#error_addressDK").text("");
    }
});

$("#submit").click(function () {
    var check = 0;
    if ($("#UserNameDK").val().length >= 6) {
        $.post("/shop/CheckUserNameExist", {TenDN: $("#UserNameDK").val()}, function (cc) {
            if (cc == "false") {
                $("#error_nameDK").text("");
                check++;
            } else {
                $("#error_nameDK").text("*Tên đăng nhập đã có người dùng, vui lòng chọn tên khác");
                $(this).css("border-color", "#2eb82e");
                $('#submit').addClass("btn-info disabled");
                check--;
            }
        });
    }
    if ($("#UserNameDK").val().length <= 5) {
        $(this).css("border-color", "#FF0000");
        //  $('#submit').addClass("btn-info disabled");
        $('#submit').addClass("btn-info disabled");
        $("#error_nameDK").text("*Tên đăng nhập ít nhất 6 ký tự");
        check--;
    } else {
        $(this).css("border-color", "#2eb82e");
        $('#submit').removeClass("btn-info disabled");
        $('#submit').removeClass("btn-info disabled");
        $("#error_nameDK").text("");
        check++;
    }

    if ($("#PassFirtDK").val().length <= 5) {
        $(this).css("border-color", "#FF0000");
        $('#submit').addClass("btn-info disabled");
        $("#error_passfirtDK").text("*Nhập ít nhất 6 ký tự");
        check--;
    } else {
        $(this).css("border-color", "#2eb82e");
        $('#submit').removeClass("btn-info disabled");
        $("#error_passfirtDK").text("");
        check++;
    }

    if ($("#FullNameDK").val().length == 0) {
        $(this).css("border-color", "#FF0000");
        $('#submit').addClass("btn-info disabled");
        $("#error_fullnameDK").text("*Vui lòng nhập tên bạn");
        check--;
    } else {
        $(this).css("border-color", "#2eb82e");
        $('#submit').removeClass("btn-info disabled");
        $("#error_fullnameDK").text("");
        check++;
    }

    if ($("#PassSecondDK").val() != $("#PassFirtDK").val()) {
        $(this).css("border-color", "#FF0000");
        $('#submit').addClass("btn-info disabled");
        $("#error_passsecondDK").text("*Không khớp mật khẩu");
        check--;
    } else {
        $(this).css("border-color", "#2eb82e");
        $('#submit').removeClass("btn-info disabled");
        $("#error_passsecondDK").text("");
        check++;

    }

    if ($("#EmailDK").val().length == 0) {
        $(this).css("border-color", "#FF0000");
        $('#submit').addClass("btn-info disabled");
        $("#error_EmailDK").text("*Hãy nhập email hợp lệ , nó rất quan trọng!");
        check--;
    } else {
        $(this).css("border-color", "#2eb82e");
        $('#submit').removeClass("btn-info disabled");
        $("#error_emailDK").text("");
        check++;
    }


    if ($("#AddressDK").val() == '') {
        $(this).css("border-color", "#FF0000");
        $('#submit').addClass("btn-info disabled");
        $("#error_addressDK").text("* Bạn chưa nhập địa chỉ");
        check--;
    } else {
        $(this).css({"border-color": "#2eb82e"});
        $('#submit').removeClass("btn-info disabled");
        $("#error_addressDK").text("");
        check++;

    }

    if (check == 6) {
        $.post("/shop/Register", {TenDN: $("#UserNameDK").val(), MatKhau: $("#PassFirtDK").val(), Ten: $("#FullNameDK").val(), Email: $("#EmailDK").val(), DiaChi: $("#AddressDK").val()}, function (data) {
//            if (data == "true") {
//                Mess("Đăng ký thành công , chúc bạn có những phút giây vui vẻ");
//                $.ajax({
//                    url: '/User/LoginResult',
//                    type: 'POST',
//                    data: {
//                        TenDN: $("#UserNameDK").val(),
//                        MatKhau: $("#PassFirtDK").val()
//                    },
//                    success: function (data) {
//                        window.location.replace("/quan-ly-tai-khoan");
//                        console.log("Done");
//                    },
//                    error: function () {
//                        $("#KetQuaDangNhap").text("Đăng nhập không thành công , vui lòng kiểm tra lại thông tin");
//                    }
//                });
//            }
//            else {
//                Mess("Hiện tại không thể đăng ký , vui lòng thử lại sau");
//            }
            window.location.replace("/shop/index.jsp");
        });
    }
});
