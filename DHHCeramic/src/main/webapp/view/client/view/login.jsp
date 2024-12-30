<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/client/static" var="url"></c:url>
<%
    String alert = (String) request.getAttribute("alert");
%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>DHH Ceramic | Đăng nhập</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <!-- Css Styles -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="${url}/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/style.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/login.css" type="text/css">
</head>

<body>
<!-- Header Section Begin -->
<jsp:include page="/view/client/view/header.jsp"></jsp:include>
<!-- Header Section End -->

<!--Login Section Begin -->

<section class="page-login">
    <div id="form-signIn">
        <div id="form-bg">
            <img id="image-bg" src="${url}/img/banner-login.jpg" width="100%" height="780px">
        </div>
        <div class="container">
            <div class="title">
                <h3>Đăng nhập</h3>
            </div>
            <form class="form_input_group" onsubmit="checkForm()" action="${pageContext.request.contextPath}/login"
                  method="post">
                <%
                    if (alert != null) {
                %>
                <p class="alert alert-danger" role="alert">
                    <%= alert%>
                </p>
                <%
                    }
                %>
                <div class="input-group-control">
                    <input type="text" id="user1" name="username" required placeholder="Tên đăng nhập hoặc Email">
                    <small></small>
                </div>
                <div class="input-group-control">
                    <input type="password" id="password1" name="password" required placeholder="Mật khẩu">
                    <small></small>
                </div>
                <div class="g-recaptcha" style="margin-top: 16px; margin-left: 25px"
                     data-sitekey="6LfgknkhAAAAABXAQugTItLaoMe6aDZIIM-gtNQ0"></div>
                <div id="forgot">
                    <div class="fg-left">
                        <a href="${pageContext.request.contextPath}/view/client/view/forgotpass.jsp">Quên mật khẩu</a>
                    </div>
                    <div id="help-right">
                        <a href="${pageContext.request.contextPath}/view/client/view/help.jsp">Cần trợ giúp?</a>
                    </div>
                </div>
                <button class="btn btn-signIn">Đăng nhập</button>
                <div id="txt-loginWith">
                    <p>Hoặc đăng nhập với</p>
                </div>
                <div class="auth-form__socials">
                    <a href="https://www.facebook.com/dialog/oauth?client_id=615535650697352&redirect_uri=http://localhost:8080/DHHCeramic/login-facebook"
                       class="auth-form__socials--facebook btn btn--size-s btn--with-icon">
                        <i class="auth-form__socials-icon fab fa-facebook-square"></i>
                        <span class="auth-form__socials-title">
                              Facebook
                         </span>
                    </a>
                    <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/DHHCeramic/login-google&response_type=code
                    &client_id=474718330255-ip6b590c85jul6if27u8hvcu7fkrttoc.apps.googleusercontent.com&approval_prompt=force"
                       class="auth-form__socials--google btn btn--size-s btn--with-icon">
                        <img src="${url}/img/home/google.png" alt="">
                        <span class="auth-form__socials-title">
                              Google
                         </span>
                    </a>
                </div>
                <div id="sign_up">
                    <p>Bạn chưa có tài khoản? <a
                            href="${pageContext.request.contextPath}/view/client/view/register.jsp">Đăng ký tại đây</a>
                    </p>
                </div>
            </form>


        </div>
    </div>
</section>
<!-- Login Section End -->

<!-- Footer Section Begin -->
<jsp:include page="/view/client/view/footer.jsp"></jsp:include>
<!-- Footer Section End -->
<script src="https://www.google.com/recaptcha/api.js"></script>
<script>
    const form = document.getElementsByClassName('form_input_group');
    const email = document.getElementById('email');
    const username = document.getElementById('username');
    const password = document.getElementById('password');
    const re_password = document.getElementById('re-password');
    const email1 = document.getElementById('user1');
    const password1 = document.getElementById('password1');


    //Show input error message

    function showError(input, message) {
        const formControl = input.parentElement;
        formControl.className = 'input-group-control error';
        const small = formControl.querySelector('small');
        small.style.display = 'block';
        small.innerText = message;

    }

    function showSuccess(input) {
        const formControl = input.parentElement;
        formControl.className = 'input-group-control success';

    }

    //Email

    function isValidEmail(email) {
        const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<script>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(String(email).toLowerCase());
    }

    function isValidVietnamesePhone(phone) {
        return /(03|05|07|08|09|01[2|6|8|9])+([0-9]{8})\b/.test(phone);
    }

    var count = 0, count1 = 0;

    function checkForm() {
        if (email.value === '') {
            showError(email, 'Vui lòng nhập email');
        } else if (!isValidEmail(email.value)) {
            showError(email, 'Email không tồn tại');
        } else {
            showSuccess(email);
            count++;
        }
        if (phone.value === '') {
            showError(phone, 'Vui lòng nhập số điện thoại');
        } else if (!isValidVietnamesePhone(phone.value)) {
            showError(phone, 'Email không tồn tại');
        } else {
            showSuccess(phone);
            count++;
        }
        if (password.value === '') {
            showError(password, 'Vui lòng nhập mật khẩu');
        } else {
            showSuccess(password);
            count++;
        }
        if (re_password.value !== password.value || re_password === '') {
            showError(re_password, 'Xác nhận mật khẩu sai');
        } else {
            count++;
        }

        if (email1.value === '') {
            showError(email1, 'Vui lòng nhập email');
        } else if (!isValidEmail(email1.value)) {
            showError(email1, 'Email không tồn tại');
        } else {
            showSuccess(email1);
            count1++;
        }
        if (password1.value === '') {
            showError(password1, 'Vui lòng nhập mật khẩu');
        } else {
            showSuccess(password1);
            count1++;
        }


    }


</script>
<!-- Js Plugins -->
<script src="${url}/js/jquery-3.3.1.min.js"></script>
<script src="${url}/js/bootstrap.min.js"></script>
<script src="${url}/js/jquery.nice-select.min.js"></script>
<script src="${url}/js/jquery-ui.min.js"></script>
<script src="${url}/js/jquery.slicknav.js"></script>
<script src="${url}/js/mixitup.min.js"></script>
<script src="${url}/js/owl.carousel.min.js"></script>
<script src="${url}/js/main.js"></script>
</body>
</html>