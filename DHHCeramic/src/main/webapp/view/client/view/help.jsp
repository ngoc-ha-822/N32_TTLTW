<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/client/static" var="url"></c:url>
<!DOCTYPE html>
<html lang="en">
<head>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>DHH Ceramic | Trợ giúp</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
              rel="stylesheet">
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
        <link rel="stylesheet" href="${url}/css/help.css" type="text/css">

    </head>
<body>
<!-- Header Section Begin -->
<jsp:include page="/view/client/view/header.jsp"></jsp:include>
<!-- Header Section End -->
<section id="welcome-ask" class="text-center">
    <div class="container">
        <h2>Chào mừng bạn đến trang trợ giúp của chúng tôi</h2>
        <h3>Chúng tôi có thể giúp gì cho bạn?</h3>
        <div class="input-group">
            <div class="input-group-prepend">
                <input id="question" type="text" placeholder="Đặt câu hỏi hoặc tìm từ khóa">
                <i class="fas fa-search"></i>
            </div>
        </div>

    </div>
</section>

<!--Help-->
<section id="main-content">
    <div class="container">
        <div class="row">
            <div class="answer col-lg-12">
                <div class="text-2">
                    <h3>Câu hỏi thường gặp</h3>
                </div>
                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapse1">[Người dùng mới] Cách đăng kí tài khoản
                                    người dùng trên trang web
                                    của cửa hàng?</a>
                            </h4>
                        </div>
                        <div id="collapse1" class="panel-collapse collapse">
                            <div class="panel-body">
                                <p>Chúng tôi rất vui mừng khi bạn đăng kí tài khoản người dùng trên trang
                                    web của shop, việc đăng kí của bạn giúp shop tính toán được mức độ ưa thích các sản
                                    phẩm của
                                    khách hàng.</p>
                                <p><strong>Các bước đăng kí</strong></p>
                                <ol class="list-step">
                                    <li class="step">Tại trang chủ của website, click vào mục Đăng ký trên thanh
                                        menu.
                                    </li>
                                    <li class="step">Điền các thông tin như email đăng kí, password. Click chọn Đăng
                                        kí.
                                    </li>
                                    <li class="step">Sau khi đăng kí thành công, trang web sẽ tự động đưa bạn đến mục
                                        cập nhật thông tin tài khoản.
                                    </li>
                                    <li class="step">Bạn vui lòng điền đủ thông tin tài khoản để giúp việc đặt hàng dễ
                                        dàng hơn.
                                    </li>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapse2">[Người dùng mới] Quên mật khẩu tài khoản.
                                    Làm thế nào để thay đổi?</a>
                            </h4>
                        </div>
                        <div id="collapse2" class="panel-collapse collapse">
                            <div class="panel-body">
                                <p><strong>Các bước thay đổi mật khẩu</strong></p>
                                <ol class="list-step">
                                    <li class="step">Tại trang chủ của website, click vào mục Đăng nhập trên thanh
                                        menu.
                                    </li>
                                    <li class="step">Tại trang đăng nhập, click vào mục Quên mật khẩu.</li>
                                    <li class="step">Điền email đăng kí. Đợi mail xác nhận.</li>
                                    <li class="step">Nhập mã xác nhận vào ô Mã xác nhận.</li>
                                    <li class="step">Điền mật khẩu mới và click chọn Cập nhật.</li>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapse3">[Vận chuyển] Thời gian giao hàng mất bao
                                    lâu?</a>
                            </h4>
                        </div>
                        <div id="collapse3" class="panel-collapse collapse">
                            <div class="panel-body">
                                <p>Thời gian giao hàng khoảng 2-5 ngày tùy vào vị trí đặt hàng của bạn.</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapse5">[Thanh toán] Shop có những phương thức thanh
                                    toán nào?</a>
                            </h4>
                        </div>
                        <div id="collapse5" class="panel-collapse collapse">
                            <div class="panel-body">
                                <p><strong>Các hình thức thanh toán chủ yếu</strong></p>
                                <ol class="list-step">
                                    <p class="step">Thanh toán khi nhận hàng. Áp dụng với trường hợp đặt hàng online và
                                        giao hàng tận nơi.
                                    </p>
<!--                                    <li class="step">Thanh toán bằng thẻ ATM.</li>-->
<!--                                    <li class="step">Thanh toán bằng hình thức chuyển khoản thông qua app banking.</li>-->
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapse6">[Vận chuyển]Đơn hàng của tôi có thể free
                                    ship không?</a>
                            </h4>
                        </div>
                        <div id="collapse6" class="panel-collapse collapse">
                            <div class="panel-body">
                                <p>Shop đang áp dụng chương trình khuyến mãi freeship khi mua hóa đơn từ 500.000 VND trở lên.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<hr>
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
<!--/*&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;-->
<!--Hero_BG-->
<!--&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;&#45;*/-->
<script>
    let slideIndex = 1;
    showSlides(slideIndex);

    // Next/previous controls
    function plusSlides(n) {
        showSlides(slideIndex += n);
    }

    // Thumbnail image controls
    function currentSlide(n) {
        showSlides(slideIndex = n);
    }

    function showSlides(n) {
        let i;
        let slides = document.getElementsByClassName("slider");
        let dots = document.getElementsByClassName("dot");
        if (n > slides.length) {
            slideIndex = 1;
        }
        if (n < 1) {
            slideIndex = slides.length;
        }
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }
        slides[slideIndex - 1].style.display = "block";
        dots[slideIndex - 1].className += " active";
    }

    // Tự động chuyển hình sau mỗi 5 giây
    setInterval(function () {
        plusSlides(1);
    }, 5000);
</script>
</body>
</html>