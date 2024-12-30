<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/2/2023
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/client/static" var="url"></c:url>
<!DOCTYPE html>
<html lang="zxx">

<head>

    <!--====== Required meta tags ======-->
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!--====== Title ======-->
    <title>DHH Ceramic</title>

    <!--====== Font awesome =======-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

    <!--====== Favicon Icon ======-->

    <!--====== Bootstrap css ======-->
    <link rel="stylesheet" href="${url}/css/landingcss/bootstrap4.min.css">

    <!--====== Animate css ======-->
    <link rel="stylesheet" href="${url}/css/landingcss/animateLanding.css">

    <!--====== Magnific Popup css ======-->
    <link rel="stylesheet" href="${url}/css/landingcss/magnific-popup.css">

    <!--====== Slick css ======-->
    <link rel="stylesheet" href="${url}/css/landingcss/slick.css">

    <!--====== Line Icons css ======-->
    <link rel="stylesheet" href="${url}/css/landingcss/LineIcons.css">

    <!--====== Style css ======-->
    <link rel="stylesheet" href="${url}/css/landingcss/landing.css">

    <!--====== Responsive css ======-->
    <link rel="stylesheet" href="${url}/css/landingcss/responsive.css">
    <link href="${url}/css/landingcss/all.min.css" rel="stylesheet">
    <!--    <link rel="shortcut icon" type="image/png" href="img/logo_2.png"/>-->
</head>

<body>
<!--====== HEADER PART START ======-->

<header class="header-area">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <nav class="navbar navbar-expand-lg">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/welcome">
                        <div class="header__logo">
                            <a href="${pageContext.request.contextPath}/view/client/view/index.html"><img src="${url}/img/logo_2.png" alt=""></a>
                        </div>
                    </a> <!-- Logo -->
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="bar-icon"></span>
                        <span class="bar-icon"></span>
                        <span class="bar-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul id="nav" class="navbar-nav ml-auto">
                            <li class="nav-item">
                                <i class="fas fa-phone-alt"></i>
                                +84342111202
                            </li>
                            <li class="nav-item">
                                <i class="far fa-envelope"></i>
                                dhh_ceramic@gmail.com
                            </li>
                        </ul> <!-- navbar nav -->
                    </div>
                </nav> <!-- navbar -->
            </div>
        </div> <!-- row -->
    </div> <!-- container -->
</header>

<!--====== HEADER PART ENDS ======-->

<!--====== SLIDER PART START ======-->

<section id="home" class="slider-area pt-100">
    <div class="container-fluid position-relative" style="height: 550px">
        <div class="slider-active">
            <div class="single-slider">
                <div class="slider-bg">
                    <div class="row no-gutters align-items-center ">
                        <div class="col-lg-6 col-md-5">
                            <div class="slider-product-image d-none d-md-block">
                                <img src="${url}/img/hero/banner2.png" height="450px" alt="Slider">
                                <div class="slider-discount-tag">
                                    <p>-50% <br> OFF</p>
                                </div>
                            </div> <!-- slider product image -->
                        </div>
                        <div class="col-lg-6 col-md-7">
                            <div class="slider-product-content">
                                <h1 class="slider-title mb-10" data-animation="fadeInUp" data-delay="0.3s">Sale sập sàn
                                    50%</h1>
                                <p class="mb-25" data-animation="fadeInUp" data-delay="0.9s">Khuyến mãi đầu năm -
                                    Sale off lên đến 50%. Khi mua hàng bạn còn có cơ hội nhận những phần quà hấp dẫn.
                                    Hãy đến với chúng tôi ngay thôi</p>
                                <a class="main-btn" href="${pageContext.request.contextPath}/welcome"
                                   data-animation="fadeInUp" data-delay="1.5s">Shop
                                    now <i class="fa-solid fa-chevron-right"></i></a>
                            </div> <!-- slider product content -->
                        </div>
                    </div> <!-- row -->
                </div> <!-- container -->
            </div> <!-- single slider -->

            <div class="single-slider">
                <div class="slider-bg">
                    <div class="row no-gutters align-items-center">
                        <div class="col-lg-6 col-md-5">
                            <div class="slider-product-image d-none d-md-block">
                                <img src="${url}/img/hero/banner5.jpg" height="450px" alt="Slider">
                                <div class="slider-discount-tag">
                                    <p>-10% <br> OFF</p>
                                </div>
                            </div> <!-- slider product image -->
                        </div>
                        <div class="col-lg-6 col-md-7">
                            <div class="slider-product-content">
                                <h1 class="slider-title mb-10" data-animation="fadeInUp" data-delay="0.3s">Ưu đãi hấp
                                    dẫn</h1>
                                <p class="mb-25" data-animation="fadeInUp" data-delay="0.9s">Mua từ 5tr trở lên
                                    bạn sẽ nhận được ưu đãi giảm 10% tổng hóa đơn. Còn chần chờ gì nữa, hãy đến cửa hàng
                                    cùng chúng tôi trang trí ngôi nhà bạn</p>
                                <a class="main-btn" href="${pageContext.request.contextPath}/welcome"
                                   data-animation="fadeInUp" data-delay="1.5s">Shop
                                    now <i class="fa-solid fa-chevron-right"></i></a>
                            </div> <!-- slider product content -->
                        </div>
                    </div> <!-- row -->
                </div> <!-- container -->
            </div> <!-- single slider -->

            <div class="single-slider">
                <div class="slider-bg">
                    <div class="row no-gutters align-items-center">
                        <div class="col-lg-6 col-md-5">
                            <div class="slider-product-image d-none d-md-block">
                                <img src="${url}/img/hero/banner3.png" height="450px" alt="Slider">
                            </div> <!-- slider product image -->
                        </div>
                        <div class="col-lg-6 col-md-7">
                            <div class="slider-product-content">
                                <h1 class="slider-title mb-10" data-animation="fadeInUp" data-delay="0.3s">Cùng khám phá
                                    nào!!!</h1>
                                <a class="main-btn" href="${pageContext.request.contextPath}/welcome"
                                   data-animation="fadeInUp" data-delay="1.5s">Let's
                                    go<i class="fa-solid fa-chevron-right"></i></a>
                            </div> <!-- slider product content -->
                        </div>
                    </div> <!-- row -->
                </div> <!-- container -->
            </div> <!-- single slider -->
        </div> <!-- slider active -->
        <div class="slider-social">
            <div class="row justify-content-end">
                <div class="col-lg-7 col-md-6">
                    <ul class="social text-right">
                        <li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
                        <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fab fa-google"></i></a></li>
                        <li><a href="#"><i class="fab fa-instagram"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div> <!-- container fluid -->
</section>

<!--====== SLIDER PART ENDS ======-->
<section id="information" class="text-center">
    <div class="row">
        <div class="col-sm-12">
            <h2 style="margin:15px">Đến với chúng tôi</h2>
        </div>
    </div>
    <div class="row row-3">
        <div class="col-sm-4 box-infor">
            <i class="fas fa-truck"></i>
            <p>Giao hàng trên toàn quốc. Miễn phí ship khi mua đơn hàng từ 500k trở lên.</p>
        </div>
        <div class="col-sm-4 box-infor">
            <i class="fas fa-exchange-alt"></i>
            <p>Đổi trả hàng miễn phí nếu xảy ra vấn đề vận chuyển</p>
        </div>
        <div class="col-sm-4 box-infor">
            <i class="fas fa-id-card"></i>
            <p>Nhận nhiều ưu đãi hấp dẫn khi đăng kí thành viên</p>
        </div>
    </div>
</section>

<!--====== BACK TO TOP PART START ======-->

<a href="#" class="back-to-top"><i class="lni-chevron-up"></i></a>

<!--====== BACK TO TOP PART ENDS ======-->


<!--====== jquery js ======-->
<script src="${url}/js/landingjs/modernizr-3.6.0.min.js"></script>
<script src="${url}/js/jquery-3.3.1.min.js"></script>

<!--====== Bootstrap js ======-->
<script src="${url}/js/landingjs/bootstrap4.min.js"></script>


<!--====== Slick js ======-->
<script src="${url}/js/landingjs/slick.min.js"></script>

<!--====== Magnific Popup js ======-->
<script src="${url}/js/landingjs/jquery.magnific-popup.min.js"></script>


<!--====== nav js ======-->
<script src="${url}/js/landingjs/jquery.nav.js"></script>

<!--====== Nice Number js ======-->
<script src="${url}/js/landingjs/jquery.nice-number.min.js"></script>

<!--====== Main js ======-->
<script src="${url}/js/landingjs/landing.js"></script>

</body>

</html>

