<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/client/static" var="url"></c:url>
<%@ page buffer="64kb" %>
<c:set var="numProduct" value="${0}"/>
<c:forEach
        items="${sessionScope.cart}" var="map">
    <c:set var="numProduct"
           value="${numProduct + 1}"/>
</c:forEach>
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
    <title>DHH Ceramic | Giỏ hàng</title>

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
    <link rel="stylesheet" href="${url}/css/aucount.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/cart.css" type="text/css">
    <link rel="stylesheet" href="${url}/css/checkout.css" type="text/css">
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
                        <form action="#">
                            <input type="text" placeholder="Bạn đang cần gì?">
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

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg" data-setbg="${url}/img/banner2.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h2>Giỏ hàng</h2>
                    <div class="breadcrumb__option">
                        <a href="${pageContext.request.contextPath}/welcome">Trang chủ </a>
                        <span>Giỏ hàng</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Shoping Cart Section Begin -->
<!-- Shoping Cart Section Begin -->
<section id="cart_items">
    <div class="container">
        <%
            if (alert != null) {
        %>
        <p class="alert alert-danger" role="alert">
            <%= alert %>
        </p>
        <%
            }
        %>
        <div class="table-responsive cart22_info">
            <table class="table table-condensed">
                <thead>
                <tr class="cart_menu">
                    <td class="image">
                        <input type="checkbox" class="checkbox-filter" name="brands">
                        Tất cả (${numProduct} sản phẩm)
                    </td>
                    <td class="description">Tên sản phẩm</td>
                    <td class="size">Size</td>
                    <td class="price">Đơn giá</td>
                    <td class="quantity">Số lượng</td>
                    <td class="total">Thành tiền</td>
                    <td></td>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${sessionScope.cart}" var="map">
                    <c:choose>
                        <c:when test="${not empty map.value and not empty map.value.product}">
                            <tr>
                                <!-- Các thông tin sản phẩm -->
                                <td class="cart_product">
                                    <!-- Hình ảnh sản phẩm -->
                                    <a href=""><img src="${map.value.product.image}" alt=""></a>
                                </td>
                                <td class="cart_description">
                                    <!-- Tên sản phẩm -->
                                    <h4><a href="">${map.value.product.name}</a></h4>
                                </td>
                                <input type="text" id="size_${map.key}" value="${map.value.size}" hidden>
                                <td class="cart_size">
                                    <!-- Size sản phẩm -->
                                    <p>${map.value.size}</p>
                                </td>
                                <td class="cart_price">
                                    <!-- Đơn giá -->
                                    <p id="price_${map.key}">${map.value.product.price}đ</p>
                                </td>
                                <td>
                                    <!-- Số lượng -->
                                    <!-- Bổ sung kiểm tra tính hợp lệ của số lượng trước khi sử dụng -->
                                    <c:if test="${map.value.quantity > 0}">
                                        <div class="d-flex mb-4" style="max-width: 300px">
                                            <!-- Nút giảm số lượng -->
                                            <button class="btn btn-dark px-3 me-2"
                                                    onclick="updateItemCart(${map.key}, -1)"
                                                    style="height: 40px">
                                                <i class="fas fa-minus"></i>
                                            </button>
                                            <!-- Input hiển thị số lượng -->
                                            <div class="form-outline">
                                                <input id="quantity_${map.key}" min="1" name="quantity"
                                                       value="${map.value.quantity}" type="number"
                                                       class="form-control minicart-quantity ${map.key}" readonly>
                                            </div>
                                            <!-- Nút tăng số lượng -->
                                            <button class="btn btn-dark px-3 ms-2"
                                                    onclick="updateItemCart(${map.key}, 1)"
                                                    style="height: 40px">
                                                <i class="fas fa-plus"></i>
                                            </button>
                                        </div>
                                    </c:if>
                                </td>
                                <td class="cart_total">
                                    <!-- Tính tổng tiền -->
                                    <p id="total_price_${map.key}"
                                       class="cart_total_price">${map.value.product.price * map.value.quantity}đ</p>
                                </td>
                                <td class="cart_delete">
                                    <!-- Xóa sản phẩm khỏi giỏ hàng -->
                                    <a class="cart_quantity_delete"
                                       href="${pageContext.request.contextPath}/cart/remove?pId=${map.value.product.id}"><i
                                            class="fa fa-times"></i></a>
                                </td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <!-- Xử lý graceful khi không tìm thấy sản phẩm -->
                            <tr>
                                <td colspan="6">Sản phẩm không tồn tại hoặc đã bị xóa</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</section>
<section id="do_action">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <div class="payment__type">
                    <div class="payment__type-left">Phương thức thanh toán</div>
                    <div class="payment__type-right">
                        <p>Thanh toán khi nhận hàng</p>
                        <div class="payment__type-right-change">
<%--                            <div type="button" class="launch" data-toggle="modal" data-target="#staticBackdrop">THAY ĐỔI--%>
<%--                            </div>--%>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="discount_area">
                <div class="discount_header">
                    <b style="margin-bottom:5px; margin-left: 10px">Khuyến mãi</b>
<%--                    <p class="number_of_discount">Có thể chọn mã giảm giá hoặc mã freeship</p>--%>
                </div>
                <form id="discountForm" method="post" action="${pageContext.request.contextPath}/apply-discount">
                    <input style="margin-left:15px" type="text" id="discount" name="discount" class="name"
                           placeholder="Nhập mã khuyến mãi">
                    <button type="submit">Nhập</button>
                </form>
                <a><i class="fas fa-tag"></i> Chọn mã khuyến mãi</a>
            </div>
            <form class="container" style="display: flex" action="${pageContext.request.contextPath}/member/order"
                  method="post">
                <div class="col-lg-7">
                    <div class="chose_area">
                        <div class="heading" style="margin-left: 10px">
                            <b style="margin-bottom:5px">Giao tới </b>
                        </div>
                        <div class="user_infor">
                            <label style="margin-right: 10px">Họ tên</label>
                            <input type="text" name="name" class="name" value="${sessionScope.account.fullname}">
                            <div class="filter-price-range-filter__range-line"></div>
                            <label style="margin-right: 10px">Số điện thoại</label>
                            <input type="text" name="phone" class="phone" value="${sessionScope.account.phoneNumber}">
                        </div>
                        <div class="user_address">
                            <label style="margin-right: 10px; margin-top:20px">Địa chỉ</label>
                            <input type="text" name="address" class="address" id="address"
                                   value="${sessionScope.account.address}" style="margin-top: 16px;">
                        </div>
                        <input type="button" id="changePasswordBtn" class="change__password-btn"
                               style="margin-top: 12px; margin-left:12px;color: #c43434" onclick="showChangePassword()"
                               value="Thay đổi ">
                        <div class="checkout__input">
                            <b style="margin-bottom:5px; margin-left: 10px">Lưu ý</b>
                            <input type="text" name="note" placeholder="hàng dễ vỡ,..." style="margin-left: 10px">
                        </div>
                    </div>
                </div>
                <div class="col-lg-5">
                    <div class="total_area">
                        <c:set var="total" value="${0}"/>
                        <c:set var="numProduct" value="${0}"/>
                        <c:forEach
                                items="${sessionScope.cart}" var="map">
                            <c:set var="total"
                                   value="${total + map.value.quantity * map.value.product.price}"/>
                            <c:set var="numProduct"
                                   value="${numProduct + 1}"/>
                        </c:forEach>
                        <c:set var="discountTotal" value="${discountTotal}"/>
                        <c:set var="feeShip" value="${50000}"/>
                        <c:set var="discountApplied" value="${discountApplied}"/>
                        <div class="checkout_calculate">
                            <div class="temp_price">
                                <p>Tạm tính</p>
                                <p id="total_price">${total}đ</p>
                            </div>
                            <div class="discount_checkout">
                                <p>Giảm giá</p>
                                <c:if test="${discountApplied}">
                                <p>${discountTotal } đ</p>
                                </c:if>
                                <c:if test="${not discountApplied}">
                                    <p>0đ</p>
                                </c:if>
                            </div>
                            <div class="discount_checkout">
                                <p>Phí ship</p>
                                <p>${feeShip} đ</p>
                            </div>
                            <div class="filter-price-range-filter__range-line-checkout"></div>
                            <div class="sum_price">
                                <p style="font-size: 24px;">Tổng cộng:</p>
                                <p id="total_dc" class="no_product" style="font-size: 24px;">${total - discountTotal + feeShip}đ</p>
                                <input type="hidden" name="total" value="${total - discountTotal + feeShip}">
                            </div>
                            <p class="vat">(Đã bao gồm thuế VAT nếu có)</p>
                        </div>
                        <div class="checkout_button">
                            <input type="submit" class="checkout" value="Mua hàng (${numProduct})">
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</section><!--/#do_action-->
<!-- Shoping Cart Section End -->
<!--/Modal-->
<div id="modal1">
    <div class="modal__overlay">

    </div>
    <div id="modal__body1">
        <div id="turn__off" style="cursor: pointer; float:right; padding: 0 6px;">
            <i class="fas fa-times"></i>
        </div>
        <div class="card login-form">
            <div class="card-body">
                <h3 class="card-title text-center">Thay đổi thông tin</h3>

                <!--Password must contain one lowercase letter, one number, and be at least 7 characters long.-->

                <div class="card-text">
                    <form action="${pageContext.request.contextPath}/order/change-address" method="get">
                        <div class="alert alert-danger alert-dismissible show" role="alert">
                            <strong>Xin chào!</strong> Vui lòng điền vào các trường bên dưới để đổi thông tin
                            <input name="id" value="${sessionScope.account.id }" hidden="true">
                            <a class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </a>
                        </div>
                        <div class="form-group">
                            <label>Họ tên</label>
                            <input type="text" name="newName" class="form-control form-control-sm"
                                   value="${sessionScope.account.fullname}">
                        </div>
                        <div class="form-group">
                            <label>Số điện thoại</label>
                            <input type="text" name="newPhone" class="form-control form-control-sm"
                                   value="${sessionScope.account.phoneNumber}">
                        </div>
                        <div class="form-group">
                            <label>Địa chỉ</label>
                            <input type="address" name="newAddress" class="form-control form-control-sm"
                                   value="${sessionScope.account.address}">
                        </div>
                        <button type="submit" class="btn btn-block submit-btn">Xác nhận</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
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
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<script>
    $("#turn__off").click(
        function close() {
            document.getElementById("modal1").style.display = "none";
        });

    function showChangePassword() {
        document.getElementById("modal1").style.display = "block";
    }
</script>

<script>
    function updateItemCart(idItem, type = 0) {
        let inputQuantityEle = document.getElementById('quantity_' + idItem);
        let totalPriceEle = document.getElementById('total_price_' + idItem);
        let sumTotalEle = document.getElementById('total_price');
        let sumTotal = document.getElementById('total_dc');
        let size = document.getElementById('size_' + idItem).value;
        let quantity = inputQuantityEle.value;
        const feeShip = 50000;
        $.ajax({
            dataType: 'json',
            type: 'POST',
            data: {
                "action": "update-cart",
                "id_item": idItem,
                "quantity": quantity * 1 + type,
                "size": size
            },
            url: "<%=request.getContextPath()%>/cart/update",
            success: function (data) {
                if (data.success) {
                    inputQuantityEle.value = quantity * 1 + type;

                    // Tính toán giá tiền mới
                    let newTotalPrice = data.new_price;

                    // Cập nhật giá tiền mới vào thẻ HTML
                    totalPriceEle.textContent = newTotalPrice + 'đ';

                    let newSumTotal = data.newSumPrice;
                    sumTotalEle.textContent = newSumTotal + 'đ';

                    sumTotal.textContent = (newSumTotal + feeShip) + 'đ';
                } else {
                    swal("Có lỗi xảy ra khi cập nhật giỏ hàng!", {
                        buttons: false,
                        timer: 1000,
                        icon: "error",
                    });
                }
            }
        });
    }

</script>

</body>

</html>
