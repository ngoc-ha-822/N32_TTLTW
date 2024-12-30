<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/client/static" var="url"></c:url>
<%
    String alertMsg = (String) request.getAttribute("alert");
%>
<!DOCTYPE html>
<html lang="zxx">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>DHH Ceramic | Đăng ký</title>

    <!-- Google Font -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="${url}/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/style.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/signup.css" type="text/css">
</head>

<body>

<!-- Page Preloder -->
<!-- Header Section Begin -->
<jsp:include page="/view/client/view/header.jsp"></jsp:include>
<!-- Header Section End -->

<!--Login Section Begin -->

<section class="page-login">
    <div id="form-signIn">
        <div id="form-bg">
            <img id="image-bg" src="${url}/img/banner-login.jpg" width="100%" height="750px">
        </div>
        <div class="container" style="height: 680px">
            <div class="title">
                <h3>Đăng ký</h3>
            </div>
            <form class="form_input_group" autocomplete="off" onsubmit="return(checkForm())"
                  action="${pageContext.request.contextPath}/register" method="post">
                <%
                    if (alertMsg != null) {
                %>
                <p class="alert alert-danger" role="alert">
                    <%= alertMsg %>
                </p>
                <%
                    }
                %>
                <div class="input-group-control ">
                    <input type="text" id="email" name="email" required placeholder="Email">
                    <small></small>
                </div>
                <div class="input-group-control ">
                    <input type="text" id="username" name="username" required placeholder="Tên đăng nhập">
                    <small></small>
                </div>
                <div class="input-group-control ">
                    <input type="password" id="password" name="password" required placeholder="Mật khẩu">
                    <small></small>
                </div>
                <div class="input-group-control">
                    <input type="password" id="re-password" name="re-password" required placeholder="Nhập lại mật khẩu">
                    <small></small>
                </div>
                <div id="forgot">
                    <!--                    <div class="fg-left">-->
                    <!--                        <a href="forgotpass.jsp">Quên mật khẩu</a>-->
                    <!--                    </div>-->
                    <div id="help-right">
                        <a href="${pageContext.request.contextPath}/view/client/view/help.jsp">Cần trợ giúp?</a>
                    </div>
                </div>
                <input type="submit" class="btn btn-signIn" value="Đăng ký">
                <div id="txt-loginWith">
                    <p>Hoặc đăng ký với</p>
                </div>
                <div id="icon-socs">
                    <button class="left"><a class="fab fa-facebook-f"></a>Facebook</button>
                    <button class="right"><a class="fab fa-google"></a>Google</button>
                </div>
                <div id="sign_up">
                    <p>Bạn đã có tài khoản? <a href="${pageContext.request.contextPath}/view/client/view/login.jsp">Đăng
                        nhập tại đây</a></p>
                </div>
            </form>

        </div>
    </div>
</section>
<!-- Login Section End -->

<!-- Footer Section Begin -->
<!-- Footer Section Begin -->
<jsp:include page="/view/client/view/footer.jsp"></jsp:include>
<!-- Footer Section End -->

<!-- Js Plugins -->
<script src="${url}/js/jquery-3.3.1.min.js"></script>
<script src="${url}/js/bootstrap.min.js"></script>
<script src="${url}/js/jquery.nice-select.min.js"></script>
<script src="${url}/js/jquery-ui.min.js"></script>
<script src="${url}/js/jquery.slicknav.js"></script>
<script src="${url}/js/mixitup.min.js"></script>
<script src="${url}/js/owl.carousel.min.js"></script>
<script src="${url}/js/main.js"></script>
<script src="${url}/js/register.js"></script>


</body>

</html>