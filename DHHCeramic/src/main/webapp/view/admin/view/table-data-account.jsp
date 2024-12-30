<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/admin/static" var="url"></c:url>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Cài đặt tài khoản | Quản trị Admin</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="${url}/css/main.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <!-- or -->
    <link rel="stylesheet" href=https://unpkg.com/boxicons@latest/css/boxicons.min.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css"
          href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
    <script>
        function readURL(input, thumbimage) {
            if (input.files && input.files[0]) { //Sử dụng  cho Firefox - chrome
                var reader = new FileReader();
                reader.onload = function (e) {
                    $("#thumbimage").attr('src', e.target.result);
                }
                reader.readAsDataURL(input.files[0]);
            } else { // Sử dụng cho IE
                $("#thumbimage").attr('src', input.value);

            }
            $("#thumbimage").show();
            $('.filename').text($("#uploadfile").val());
            $('.Choicefile').css('background', '#14142B');
            $('.Choicefile').css('cursor', 'default');
            $(".removeimg").show();
            $(".Choicefile").unbind('click');

        }

        $(document).ready(function () {
            $(".Choicefile").bind('click', function () {
                $("#uploadfile").click();

            });
            $(".removeimg").click(function () {
                $("#thumbimage").attr('src', '').hide();
                $("#myfileupload").html('<input type="file" id="uploadfile"  onchange="readURL(this);" />');
                $(".removeimg").hide();
                $(".Choicefile").bind('click', function () {
                    $("#uploadfile").click();
                });
                $('.Choicefile').css('background', '#14142B');
                $('.Choicefile').css('cursor', 'pointer');
                $(".filename").text("");
            });
        })
    </script>
</head>
<body class="app sidebar-mini rtl">
<style>
    #modal1{
        position: fixed;
        top: 0;
        right:0;
        bottom: 0;
        left:0;
        display: flex;
        animation: fadeIn linear 0.1s;
        overflow-y: hidden;
        z-index: 100;
        display: none;
    }
    #modal__body1 .form-group label:hover{
        color: black;
        cursor: default;
    }
    #modal__body1{
        width: 600px;
        height:550px;
        margin: auto;
        margin-top: 100px;
    }
    .submit-btn {
        background-color: rgb(255 197 197);
        color: rgb(190, 40, 40);
        font-weight: 600;
        letter-spacing: 1px;
    }
    #changePasswordBtn {
        border: 2px solid transparent;
        background-color: rgb(255 197 197);
        color: rgb(190, 40, 40);
        padding: 5px;
        /* width: 100px; */
        margin-top: 10px !important;
        font-weight: 600;
        letter-spacing: 1px;
        border-radius: 0.357rem;
    }
    .Choicefile {
        display: block;
        background: #14142B;
        border: 1px solid #fff;
        color: #fff;
        width: 150px;
        text-align: center;
        text-decoration: none;
        cursor: pointer;
        padding: 5px 0px;
        border-radius: 5px;
        font-weight: 500;
        align-items: center;
        justify-content: center;
    }

    .Choicefile:hover {
        text-decoration: none;
        color: white;
    }

    #uploadfile,
    .removeimg {
        display: none;
    }

    #thumbbox {
        position: relative;
        width: 100%;
        margin-bottom: 20px;
    }

    .removeimg {
        height: 25px;
        position: absolute;
        background-repeat: no-repeat;
        top: 5px;
        left: 5px;
        background-size: 25px;
        width: 25px;
        /* border: 3px solid red; */
        border-radius: 50%;

    }

    .removeimg::before {
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
        content: '';
        border: 1px solid red;
        background: red;
        text-align: center;
        display: block;
        margin-top: 11px;
        transform: rotate(45deg);
    }

    .removeimg::after {
        /* color: #FFF; */
        /* background-color: #DC403B; */
        content: '';
        background: red;
        border: 1px solid red;
        text-align: center;
        display: block;
        transform: rotate(-45deg);
        margin-top: -2px;
    }
</style>
<!-- Navbar-->
<jsp:include page="/view/admin/view/mainbar.jsp"></jsp:include>
<main class="app-content">
    <div class="app-title">
        <ul class="app-breadcrumb breadcrumb">
            <li class="breadcrumb-item">Cài đặt tài khoản</li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <h3 class="tile-title">Tài khoản</h3>
                <div class="tile-body">
                    <form class="row">
                        <div class="form-group  col-md-4">
                            <label class="control-label">Tên đăng nhập</label>
                            <input class="form-control" type="text" value="Admin">
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Họ và tên</label>
                            <input class="form-control" type="text" value="Nguyễn Văn Hùng">
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Số điện thoại admin</label>
                            <input class="form-control" type="number" value="0123456789">
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Email</label>
                            <input class="form-control" type="text" value="dhhceramic@gmail.vom">
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Địa chỉ</label>
                            <input class="form-control" type="text" value="DH Nông Lâm HCM">
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Sinh nhật</label>
                            <input class="form-control" type="date" value="19/10/2023">
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Facebook</label>
                            <input class="form-control" type="text" value="Admin">
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Password</label>
                            <input class="form-control" type="text" value="*******">
                            <input type="button" id="changePasswordBtn" class="change__password-btn"
                                   style="margin-top: 6px;" onclick="showChangePassword()"
                                   value="Thay đổi mật khẩu">
                        </div>
                        <div class="form-group col-md-12">
                            <label class="control-label">Ảnh 3x4 người dùng</label>
                            <div id="myfileupload">
                                <input type="file" id="uploadfile" name="ImageUpload" onchange="readURL(this);"/>
                            </div>
                            <div id="thumbbox">
                                <img height="300" width="300" alt="Thumb image" id="thumbimage" style="display: none"/>
                                <a class="removeimg" href="javascript:"></a>
                            </div>
                            <div id="boxchoice">
                                <a href="javascript:" class="Choicefile"><i class='bx bx-upload'></i></a>
                                <p style="clear:both"></p>
                            </div>

                        </div>
                    </form>
                </div>
                <button class="btn btn-save" type="button">Lưu lại</button>
                <a class="btn btn-cancel" href="${pageContext.request.contextPath}/view/admin/view/table-data-account.jsp">Hủy bỏ</a>
            </div>
        </div>
    </div>
</main>
<!-- Essential javascripts for application to work-->
<script src="${url}/js/jquery-3.2.1.min.js"></script>
<script src="${url}/js/popper.min.js"></script>
<script src="${url}/js/bootstrap.min.js"></script>
<script src="${url}/js/main.js"></script>
<!-- The javascript plugin to display page loading on top-->
<script src="${pageContext.request.contextPath}/view/admin/view/js/plugins/pace.min.js"></script>

<div id="modal1">
    <div class="modal__overlay">

    </div>
    <div id="modal__body1">
        <div id="turn__off" style="cursor: pointer; float:right; padding: 0 6px;">
            <i class="fas fa-times"></i>
        </div>
        <div class="card login-form">
            <div class="card-body">
                <h3 class="card-title text-center">Đổi mật khẩu</h3>

                <!--Password must contain one lowercase letter, one number, and be at least 7 characters long.-->

                <div class="card-text">
                    <form>
                        <div class="alert alert-danger alert-dismissible show" role="alert">
                            <strong>Xin chào!</strong> Vui lòng điền vào các trường bên dưới để đổi mật khẩu
                            <input name="id" value="0" hidden="true">
                            <a class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </a>
                        </div>
                        <div class="form-group">
                            <label>Mật khẩu cũ</label>
                            <input type="password" name="oldPassword" class="form-control form-control-sm">
                        </div>
                        <div class="form-group">
                            <label>Mật khẩu mới</label>
                            <input type="password" name="newPassword" class="form-control form-control-sm">
                        </div>
                        <div class="form-group">
                            <label>Nhập lại mật khẩu mới</label>
                            <input type="password" name="reNewPassword" class="form-control form-control-sm">
                        </div>
                        <button type="submit" class="btn btn-block submit-btn">Xác nhận</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(".nav li").click(function () {
        if ($(".nav li").removeClass("active")) {
            $(this).removeClass("active");
        }
        $(this).addClass("active");
    });

    function showChangePassword() {
        document.getElementById("modal1").style.display = "block";
    }

    $("#turn__off").click(
        function close() {
            document.getElementById("modal1").style.display = "none";
        });
</script>

</body>
</html>