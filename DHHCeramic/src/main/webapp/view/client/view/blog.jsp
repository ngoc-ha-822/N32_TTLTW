<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/client/static" var="url"></c:url>
<%@ page buffer="64kb" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>DHH Ceramic - Tin Tức</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">
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
</head>

<body>
<!-- Header Section Begin -->
<jsp:include page="/view/client/view/header.jsp"></jsp:include>
<!-- Header Section End -->


<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg section_martop" data-setbg="${url}/img/banner2.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h2 style="color: white!important;">Tin tức</h2>
                    <div class="breadcrumb__option">
                        <a href="${pageContext.request.contextPath}/welcome" style="color: white">Trang chủ</a>
                        <span>Tin tức</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Blog Section Begin -->
<section class="blog spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-5">
                <div class="blog__sidebar">
                    <div class="blog__sidebar__search">
                        <form action="#">
                            <input type="text" placeholder="Tìm kiếm...">
                            <button type="submit"><span class="icon_search"></span></button>
                        </form>
                    </div>

                    <div class="blog__sidebar__item">
                        <h4>Tin tức mới</h4>
                        <div class="blog__sidebar__recent">
                            <a href="#" class="blog__sidebar__recent__item show-more-blog">
                                <div class="blog__sidebar__recent__item__pic">
                                    <img src="${url}/img/blog/sidebar/sr-1.jpg" alt="">
                                </div>
                                <div class="blog__sidebar__recent__item__text">
                                    <h6>LỰA CHỌN AN TOÀN CHO NGÔI NHÀ CỦA ÔNG BÀ<br/></h6>
                                    <span>24 tháng 10, 2023</span>
                                </div>
                            </a>
                            <a href="#" class="blog__sidebar__recent__item show-more-blog">
                                <div class="blog__sidebar__recent__item__pic">
                                    <img src="${url}/img/blog/sidebar/sr-2.jpg" alt="">
                                </div>
                                <div class="blog__sidebar__recent__item__text">
                                    <h6>HÃY ĐỂ NHÀ LÀ NƠI CHỮA LÀNH TÂM HỒN</h6>
                                    <span>14 tháng 10, 2023</span>
                                </div>
                            </a>
                            <a href="#" class="blog__sidebar__recent__item show-more-blog">
                                <div class="blog__sidebar__recent__item__pic">
                                    <img src="${url}/img/blog/sidebar/sr-3.jpg" alt="">
                                </div>
                                <div class="blog__sidebar__recent__item__text">
                                    <h6>PHÒNG TẮM MỞ PHÓNG KHOÁNG ĐỂ THƯ GIÃN TỐI ĐA</h6>
                                    <span>11 tháng 10, 2023</span>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-9 col-md-7">
                <div class="row">
                    <c:forEach items="${blog}" var="b">
                        <c:url value="${b.image}" var="imgUrl"></c:url>
                        <div class="col-lg-6 col-md-6 col-sm-6 from-blog-show">
                            <div class="blog__item">
                                <a class="blog__item__pic"
                                   href="${pageContext.request.contextPath}/view/client/view/blog-details.jsp">
                                    <img src="${imgUrl}" alt="">
                                </a>
                                <div class="blog__item__text"
                                     onclick="window.location.href='${pageContext.request.contextPath}/view/client/view/blog-details.jsp'">
                                    <ul>
                                        <li><i class="fa fa-calendar-o"></i>${b.date}</li>
                                        <li><i class="fa fa-comment-o"></i> 5</li>
                                    </ul>
                                    <h5>
                                        <a href="${pageContext.request.contextPath}/view/client/view/blog-details.jsp">${b.title}</a>
                                    </h5>
                                    <p>${b.des}</p>
                                    <a href="${pageContext.request.contextPath}/view/client/view/blog-details.jsp"
                                       class="blog__btn">Xem thêm</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <ul class="pagination">
                    <c:if test="${currentPage != 1}">
                        <li class="page-item"><a class="page-link"
                                                 href="?page=${currentPage-1}">&laquo;</a>
                        </li>
                    </c:if>

                    <c:forEach begin="1" end="${numOfPages}" var="i">
                        <c:choose>
                            <c:when test="${currentPage eq i}">
                                <li class="page-item active"><a class="page-link">
                                        ${i}</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item"><a class="page-link"
                                                         href="?page=${i}">${i}</a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                    <c:if test="${currentPage lt numOfPages}">
                        <li class="page-item"><a class="page-link"
                                                 href="?page=${currentPage+1}">&raquo;</a>
                        </li>
                    </c:if>
                </ul>

            </div>
        </div>
    </div>
</section>
<!-- Blog Section End -->

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


</body>

</html>