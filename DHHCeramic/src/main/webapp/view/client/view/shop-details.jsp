<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/client/static" var="url"></c:url>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>DHH Ceramic | Chi tiết sản phẩm</title>

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

<section class="hero hero-normal">
    <div class="container">

    </div>
</section>
<!-- Hero Section End -->

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg" data-setbg="${url}/img/banner2.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h2>Chi tiết sản phẩm</h2>
                    <div class="breadcrumb__option">
                        <a href="${pageContext.request.contextPath}/welcome">Trang chủ</a>
                        <a href="${pageContext.request.contextPath}/product/list">Sản phẩm</a>
                        <span>Chi tiết sản phẩm</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Product Details Section Begin -->
<section class="product-details spad">
    <div class="container">
        <div class="row">
            <%--hiển thị ảnh--%>
            <div class="col-lg-6 col-md-6">
                <div class="product__details__pic">
                    <div class="product__details__pic__item">
                        <c:url value="${product.image}" var="imgUrl"></c:url>
                        <img class="product__details__pic__item--large"
                             src="<c:url value='${product.image}'/>" alt="Large Image">
                    </div>

                    <div class="product__details__pic__slider owl-carousel">
                        <c:forEach items="${moreImg}" var="img">
                            <c:url value="${img}" var="imgMore"></c:url>
                            <img data-imgbigurl="<c:url value='${img}'/>"
                                 src="<c:url value='${img}'/>" alt="Thumbnail Image">
                        </c:forEach>
                    </div>
                </div>
            </div>


            <div class="col-lg-6 col-md-6">
                <input type="text" value="${product.id }" name="pId" hidden="" id="id">
                <input type="text" value="${product.size }" name="size" hidden="" id="size">
                <div class="product__details__text">
                    <h3>${product.name}</h3>
                    <div class="product__details__rating">
                        <c:if test="${productRatings[product.id] == 0}">
                            <span style="font-size: 15px; color: darkgray">Chưa có đánh giá</span>
                        </c:if>
                        <c:if test="${productRatings[product.id] > 0}">
                            <c:forEach begin="1" end="5" var="star">
                                <c:choose>
                                    <c:when test="${star <= productRatings[product.id]}">
                                        <i class="fas fa-star"></i>
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${star >= productRatings[product.id] and star - productRatings[product.id] < 1}">
                                                <i class="fas fa-star-half-alt"></i>
                                            </c:when>
                                            <c:otherwise>
                                                <i class="fa-regular fa-star"></i>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                            <span>(${numberOfComments} Đánh giá)</span>
                        </c:if>


                    </div>
                    <div class="product__details__price">
                        <fmt:formatNumber value="${product.price}" type="number" pattern="#,##0"/> VND
                    </div>
                    <p></p>
                    <div class="product__details__quantity">
                        <div class="quantity">
                            <div class="pro-qty">
                                <input id="quantity" min="1" name="quantity" type="number" value="1" style="text-align:center;"/>
                            </div>
                        </div>
                    </div>
                    <button onclick="addCart()" class="primary-btn">Thêm
                        vào giỏ hàng</button>
                    <a class="heart-icon">
                        <i class="fa-solid fa-heart"></i>
                    </a>
                    <ul>
                        <li><b>Sản xuất :</b> <span>${product.manufacture}</span></li>
                        <li><b>Kích thước :</b> <span>${product.size} cm (Thùng 4 viên = 1,44 m²)</span></li>
                        <li><b>Đơn giá :</b> <span>Trên m²  (Hàng loại 1, bao bể, vỡ)</span></li>
                        <li><b>Miễn phí vận chuyển :</b> <span>Nội thành HCM với đơn trên 1.000.000</span></li>
                        <li><b>Chia sẻ qua :</b>
                            <div class="share">


                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-google"></i></a>
                                <!--                                <a href="#"><i class="fa fa-pinterest"></i></a>-->
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <%--    hết ảnh--%>
            <%--    bình luận --%>
            <div class="col-lg-12">
                <div class="product__details__tab">
                    <ul class="nav nav-tabs" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link  active" data-toggle="tab" href="#tabs-1" role="tab"
                               aria-selected="true">Đánh giá <span>(${numberOfComments})</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab"
                               aria-selected="false">Mô tả</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab"
                               aria-selected="false">Chi tiết sản phẩm</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane" id="tabs-2" role="tabpanel">
                            <div class="product__details__tab__desc">
                                <!--                                <h6>M</h6>-->
                                <div id="product__comment-icon1" style="color:#efac92;cursor: pointer;padding-bottom: 15px;font-size: 15px;
    font-weight: 700;">MÔ TẢ
                                </div>
                                <p>${product.des}</p>
                            </div>
                        </div>
                        <div class="tab-pane" id="tabs-3" role="tabpanel">
                            <div class="product__details__tab__desc">
                                <div id="product__comment-icon3" style="color:#efac92;cursor: pointer;padding-bottom: 15px;font-size: 15px;
    font-weight: 700;">CHI TIẾT SẢN PHẨM
                                </div>
                                <p>Sản phẩm là gạch lát nền Prime do Việt Nam sản xuất</p>
                            </div>
                        </div>
                        <div class="tab-pane  active" id="tabs-1" role="tabpanel">
                            <form id="product__comment">
                                <div id="product__comment-icon2" style="color:#efac92;cursor: pointer;padding-bottom: 15px;font-size: 15px;
    font-weight: 700;">ĐÁNH GIÁ SẢN PHẨM
                                </div>

                                <div id="product__comment-text">
                                    <c:forEach items="${listComment}" var="comment">
                                        <div class="product__comment-text1">
                                            <div class="product__comment-text1-cmt">
                                                    <%--                                                <c:url value="${comment.avatar}"--%>
                                                    <%--                                                       var="imgUrl"></c:url>--%>
                                                    <%--                                                <img src="${imgUrl}" alt=""--%>
                                                    <%--                                                     style="width: 20px;height: 20px;">--%>
                                                <p>${comment.username.username}</p>
                                            </div>
                                            <div class="home-product-item__rating"
                                                 style="float: left; margin-left: -12px;padding-right: 12px;">
                                                <c:forEach begin="1" end="${comment.rating}">
                                                    <i class="home-product-item__star--gold fas fa-star"></i>
                                                </c:forEach>

                                            </div>
                                            <p>${comment.content}</p>
                                            <p style="font-size: 8px;">${comment.time}</p>
                                        </div>
                                    </c:forEach>
                                </div>
                            </form>
                            <form action="${pageContext.request.contextPath}/comment?id=${product.id}"
                                  method="post">
                                <div class="rating">
                                    <input type="radio" id="star5" name="rating" value="5" />
                                    <label class="star" for="star5" title="Awesome" aria-hidden="true"><i class="fas fa-star"></i></label>
                                    <input type="radio" id="star4" name="rating" value="4" />
                                    <label class="star" for="star4" title="Great" aria-hidden="true"><i class="fas fa-star"></i></label>
                                    <input type="radio" id="star3" name="rating" value="3" />
                                    <label class="star" for="star3" title="Very good" aria-hidden="true"><i class="fas fa-star"></i></label>
                                    <input type="radio" id="star2" name="rating" value="2" />
                                    <label class="star" for="star2" title="Good" aria-hidden="true"><i class="fas fa-star"></i></label>
                                    <input type="radio" id="star1" name="rating" value="1" />
                                    <label class="star" for="star1" title="Bad" aria-hidden="true"><i class="fas fa-star"></i></label>
                                </div>
                                <div class="comment"
                                     style="display: flex; width: auto; height: 350px; margin-top:20px">
                                    <div style="margin-left:24px;">
                                        <form>
                                            <div style="display: flex; float: left">
                                                <img src="${url}/img/user/default.png" alt=""
                                                     style="width: 45px;height: 45px; margin-top: 23px">
                                            </div>
                                            <div class="row">
                                                <div class="product__comment-input col-md-12 form-group mb-5">
                                                            <textarea class="form-control ckeditor" name="message1"
                                                                      id="message" cols="60" rows="2"
                                                                      placeholder="Bình luận..." required> </textarea>
                                                    <input type="hidden" name="user"
                                                           value="${sessionScope.account.username}">
                                                    <input type="submit" id="commentButton"
                                                           class="btn product__comment-btn" value="Bình luận">
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="fb-comments" style="margin-left: 24px;" data-width=""
                                         data-numposts="2"></div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%--        hết bình luận--%>
    </div>
    </div>
    </div>
</section>
<!-- Product Details Section End -->

<!-- Related Product Section Begin -->
<section class="related-product">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title related__product__title">
                    <h2>Sản phẩm liên quan</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <c:forEach items="${categories}" var="p" begin="0" end="3">
                <c:url value="${p.image}" var="imgUrl2"></c:url>
                <div class="col-lg-3 col-md-4 col-sm-6 show-product" onclick="window.location.href='${pageContext.request.contextPath}/product/detail?id=${p.id}'">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="${imgUrl2}">
                            <ul class="product__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="product__item__text">
                                <%--                        <span>${p.category.name}</span>--%>
                            <h6><a href="#">${p.name}</a></h6>
                            <h5>${p.price} VNĐ</h5>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<!-- Related Product Section End -->

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

<script>
    function addCart() {
        var id = document.getElementById("id").value;
        var quantity = document.getElementById('quantity').value;
        var size = document.getElementById("size").value;
        $.ajax({
            url: '${pageContext.request.contextPath }/cart/add',
            type: 'POST',
            data: {
                pId: id,
                quantity: quantity,
                size: size,
            },
            success: function (data) {

                var row = document.getElementById('contentCarted');
                row.innerHTML = data;
                alert('Thêm vào giỏ hàng thành công');

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

</script>
<script>
    function decrementQuantity() {
        var result = document.getElementById('quantity');
        var qty = result.value;
        if (!isNaN(qty) && qty > 1) {
            result.value--;
        }
    }

    function incrementQuantity() {
        var result = document.getElementById('quantity');
        var qty = result.value;
        if (!isNaN(qty)) {
            result.value++;
        }
    }
</script>
</body>

</html>