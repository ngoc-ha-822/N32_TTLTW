<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/client/static" var="url"></c:url>
<%@ page buffer="64kb" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>DHH Ceramic | Sản phẩm</title>

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

<!-- Hero Section Begin -->
<section class="hero hero-normal">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="hero__categories">
                    <div class="hero__categories__all">
                        <i class="fa fa-bars"></i>
                        <span>Tất cả sản phẩm</span>
                    </div>
                    <ul>
                        <li><a href="#">Gạch giá rẻ</a></li>
                        <li><a href="#">Gạch lát nền</a></li>
                        <li><a href="#">Gạch ốp tường</a></li>
                        <li><a href="#">Gạch lát sân vườn</a></li>
                        <li><a href="#">Gạch giả gỗ</a></li>
                        <li><a href="#">Gạch ốp lát cao cấp</a></li>
                        <li><a href="#">Gạch tranh thảm</a></li>
                        <li><a href="#">Gạch trang trí</a></li>
                        <li><a href="#">Gạch vỉa hè</a></li>
                        <li><a href="#">Gạch kính lấy sáng</a></li>
                        <li><a href="#">Gạch lát cầu thang</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-9">

                <div class="hero__search">
                    <div class="hero__search__form">
                        <form action="${pageContext.request.contextPath }/product/search" method="get">
                            <input oninput="searchByName(this)" type="text" name="name" placeholder="Bạn đang cần gì?">
                            <button type="submit" class="site-btn">Tìm kiếm</button>
                        </form>
                    </div>
                    <div class="hero__search__phone">
                        <div class="hero__search__phone__icon">
                            <i class="fa fa-phone"></i>
                        </div>
                        <div class="hero__search__phone__text">
                            <h5>+65 11.188.888</h5>
                            <span>Hỗ trợ 24/7</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Hero Section End -->

<!-- Product Section Begin -->
<section class="product spad">
    <div class="container">
        <div class="row">
            <jsp:include page="/view/client/view/left-bar.jsp"></jsp:include>
            <div class="col-lg-9 col-md-7">
                <div class="product__discount">
                    <div class="filter__item">
<%--                        <div class="row">--%>
<%--                            <div class="col-lg-4 col-md-5">--%>
<%--                                <div class="filter__sort">--%>
<%--                                    <span>Sắp xếp</span>--%>
<%--                                    <select>--%>
<%--                                        <option value="0">Mặc định</option>--%>
<%--                                        <option value="0">Mặc định</option>--%>
<%--                                    </select>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="col-lg-4 col-md-4">--%>
<%--                                <div class="filter__found">--%>
<%--                                    <h6><span>159</span> Sản phẩm có sẵn</h6>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="col-lg-4 col-md-3">--%>
<%--                                <div class="filter__option">--%>
<%--                                    <span class="icon_grid-2x2"></span>--%>
<%--                                    <span class="icon_ul"></span>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
                    </div>
                    <div id="contentProduct" style="margin: 32px 0;"></div>
                    <div id="list_pro" class="row">
                        <c:forEach items="${productSearchByName}" var="p">
                            <div class="col-lg-4 col-md-6 col-sm-6 show-product"
                                 onclick="window.location.href='${pageContext.request.contextPath}/product/detail?id=${p.id}'">
                                <div class="product__item">
                                    <div class="product__item__pic set-bg" data-setbg="${p.image}">
                                        <ul class="product__item__pic__hover">
                                            <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                            <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                            <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="product__item__text">
                                        <span>${p.category.name}</span>
                                        <h6><a href="#">${p.name}</a></h6>
                                        <h5>${p.price} VND</h5>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                        <ul class="pagination">
                            <c:if test="${currentPage != 1}">
                                <li class="page-item"><a class="page-link" href="?page=${currentPage-1}">&laquo;</a>
                                </li>
                            </c:if>

                            <c:set var="startPage" value="${currentPage - 5}"/>
                            <c:if test="${startPage lt 1}">
                                <c:set var="startPage" value="1"/>
                            </c:if>

                            <c:set var="endPage" value="${startPage + 9}"/>
                            <c:if test="${endPage gt numOfPages}">
                                <c:set var="endPage" value="${numOfPages}"/>
                            </c:if>

                            <c:forEach begin="${startPage}" end="${endPage}" var="i">
                                <c:choose>
                                    <c:when test="${currentPage eq i}">
                                        <li class="page-item active"><a class="page-link">${i}</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="page-item"><a class="page-link" href="?page=${i}">${i}</a></li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>

                            <c:if test="${currentPage lt numOfPages}">
                                <li class="page-item"><a class="page-link" href="?page=${currentPage+1}">&raquo;</a>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                    <div class="section-title product__discount__title">
                        <h2>Sản phẩm khuyến mãi</h2>
                    </div>
                    <div class="row">
                        <div class="product__discount__slider owl-carousel">
                            <c:forEach items="${productSale}" var="ps">
                                <div class="col-lg-4 show-product"
                                     onclick="window.location.href='${pageContext.request.contextPath}/product/detail?id=${ps.id}'">
                                    <div class="product__discount__item">
                                        <div class="product__discount__item__pic set-bg"
                                             data-setbg="${ps.image}">
                                                <%--                                        <div class="product__discount__percent">-20%</div>--%>
                                            <ul class="product__item__pic__hover">
                                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                            </ul>
                                        </div>
                                        <div class="product__discount__item__text">
                                            <span>${ps.category.name}</span>
                                            <h5><a href="#">${ps.name}</a></h5>
                                            <div class="product__item__price">${ps.saleId}
                                                VND<span>${ps.price} VND</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Product Section End -->

<!-- Footer Section Begin -->
<jsp:include page="/view/client/view/footer.jsp"></jsp:include>
<!-- Footer Section End -->
<script>
    function searchByCategory(param) {
        $.ajax({
            url: '/DHHCeramic/product/category',
            type: 'GET',
            data: {
                cate_id: param
            },
            success: function (data) {
                document.getElementById('list_pro').style.display = 'none';
                var row = document.getElementById('contentProduct');
                row.innerHTML = data;

            }
        });
    }

    function searchByBrand(param) {
        $.ajax({
            url: '/DHHCeramic/productSearchByBrand',
            type: 'GET',
            data: {
                brands: param
            },
            success: function (data) {
                document.getElementById('list_pro').style.display = 'none';
                var row = document.getElementById('contentProduct');
                row.innerHTML = data;


            }
        });
    }

    function searchByRating(param) {
        $.ajax({
            url: '/DHHCeramic/searchByRating',
            type: 'GET',
            data: {
                rating: param
            },
            success: function (data) {
                document.getElementById('list_pro').style.display = 'none';
                var row = document.getElementById('contentProduct');
                row.innerHTML = data;


            }
        });
    }

    function searchByPrice(param1, param2, param3) {
        $.ajax({
            url: '/DHHCeramic/productSearchByPrice',
            type: 'GET',
            data: {
                brands: param1,
                priceFrom: param2,
                priceTo: param3
            },
            success: function (data) {
                document.getElementById('list_pro').style.display = 'none';
                var row = document.getElementById('contentProduct');
                row.innerHTML = data;


            }
        });
    }

    function cartRemove(param) {
        var txtSearch = param.value;
        $.ajax({
            url: '/DHHCeramic/cart/remove',
            type: 'GET',
            data: {
                pId: txtSearch
            },
            success: function (data) {
                var row = document.getElementById('removeCart');
                row.innerHTML = data;
            }
        });
    }

    function searchByName(param) {
        var txtSearch = param.value;
        $.ajax({
            url: '/DHHCeramic/product/searchByName',
            type: 'GET',
            data: {
                name: txtSearch
            },
            success: function (data) {
                console.log("Received data:", data); // Thêm dòng này để kiểm tra giá trị của data
                document.getElementById('list_pro').style.display = 'none';
                var row = document.getElementById('contentProduct');
                row.innerHTML = data;


            }
        });
    }
</script>
<script>
    $(".nav li").click(function () {
        if ($(".nav li").removeClass("active")) {
            $(this).removeClass("active");
        }
        $(this).addClass("active");
    });

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