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
    if (check == 4) {
        $.post("/shop/ChangeInfo", {TenDN: $("#UserNameDK").val(), MatKhau: $("#PassFirtDK").val(), Ten: $("#FullNameDK").val(), Email: $("#EmailDK").val(), DiaChi: $("#AddressDK").val(), ID: $("#ID").val()}, function (data) {
            switch (data) {
                case "1":
                    alert("Thay đổi thành công");
                    window.location.href = "/shop/account.jsp";
                    break;
                case "2":
                    alert("Thay đổi không thành công , vui lòng thử lại sau");
                    break;
                case "3":
                    alert("Thay đổi không thành công , vui lòng nhập đủ thông tin");
                    break;
                default:

                    break;
            }

        });
    }
});
