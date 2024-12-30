<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/8/2023
  Time: 12:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/admin/static" var="url"></c:url>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Khôi phục mật khẩu | Quản trị admin</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${url}/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${url}/vendor/animate/animate.css">
    <link rel="stylesheet" type="text/css" href="${url}/vendor/css-hamburgers/hamburgers.min.css">
    <link rel="stylesheet" type="text/css" href="${url}/vendor/select2/select2.min.css">
    <link rel="stylesheet" type="text/css" href="${url}/css/login/util.css">
    <link rel="stylesheet" type="text/css" href="${url}/css/login/main.css">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
</head>

<body>
<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-pic js-tilt" data-tilt>
                <img src="${url}/images/fg-img.png" alt="IMG">
            </div>
            <form class="login100-form validate-form" action="${pageContext.request.contextPath}/Admin/recoverPassword" method="post">
                    <span class="login100-form-title">
                        <b>KHÔI PHỤC MẬT KHẨU</b>
                    </span>
                <form action="">
                    <div class="wrap-input100 validate-input"
                         data-validate="Bạn cần nhập đúng thông tin như: ex@abc.xyz">
                        <input class="input100" type="text" placeholder="Nhập email" name="email"
                               id="emailInput" value="" />
                        <span class="focus-input100"></span>
                        <span class="symbol-input100">
                                <i class='bx bx-mail-send' ></i>
                            </span>
                    </div>
                    <div class="container-login100-form-btn">
                        <input type="submit" onclick="return RegexEmail('emailInput')" value="Lấy mật khẩu" />
                    </div>

                    <div class="text-center p-t-12">
                        <a class="txt2" href="${pageContext.request.contextPath}/AdminLogin">
                            Trở về đăng nhập
                        </a>
                    </div>
                </form>
                <div class="text-center p-t-70 txt2">
                    Phần mềm quản lý bán hàng <i class="far fa-copyright" aria-hidden="true"></i>
                    <script type="text/javascript">document.write(new Date().getFullYear());</script>
                </div>
            </form>
        </div>
    </div>
</div>
<!--===============================================================================================-->
<script src="${url}/js/vendor/main.js"></script>
<!--===============================================================================================-->
<script src="${url}/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="${url}/vendor/bootstrap/js/popper.js"></script>
<!--===============================================================================================-->
<script src="${url}/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="${url}/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
</body>
</html>
