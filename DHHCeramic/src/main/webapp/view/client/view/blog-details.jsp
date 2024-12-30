<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/client/static" var="url"></c:url>
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
<!-- Blog Details Hero Begin -->
<section class="blog-details-hero set-bg" data-setbg="${url}/img/banner2.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="blog__details__hero__text">
                    <h2>LỰA CHỌN AN TOÀN CHO NGÔI NHÀ CỦA BẠN</h2>
                    <ul>
                        <li>By DHH</li>
                        <li>24 tháng 10, 2023</li>
                        <li>8 Bình luận</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Blog Details Hero End -->

<!-- Blog Details Section Begin -->
<section class="blog-details spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-5 order-md-1 order-2">
                <div class="blog__sidebar">
                    <div class="blog__sidebar__search">
                        <form action="#">
                            <input type="text" placeholder="Search...">
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
            <div class="col-lg-9 col-md-7 order-md-1 order-1">
                <div class="blog__details__text">
                    <h3>GẠCH LÁT NỀN PHÒNG NGỦ CHO NGƯỜI LỚN TUỔI</h3>
                    <img src="img/blog/details/details-pic2.jpg" alt="">
                    <h4>1. Không gian phòng ngủ của người cao tuổi có đặc điểm gì?</h4>
                    <p>GẠCH MEN DHH hiểu được rằng không gian phòng ngủ là tổ ấm để ông bà nghỉ ngơi và thư giãn. Vì
                        vậy, hãy chú trọng vào việc tạo nên một không gian vừa thẩm mỹ, vừa thoải mái để giúp ông bà cảm
                        thấy thư thái và ngủ ngon hơn.</p>
                    <p>Đầu tiên, an toàn là yếu tố quan trọng nhất cần xem xét. Hạn chế lựa chọn Gạch lát nền phòng ngủ
                        có bề mặt men bóng, trơn trượt rất nguy hiểm. Thay vào đó, hãy chọn những mẫu gạch men mờ có độ
                        ma sát cao. Việc di chuyển của ông bà sẽ an toàn và thuận tiện hơn.
                        <br>
                        Thứ hai, phòng ngủ cần có đủ ánh sáng tự nhiên và không gian thoáng đãng. Ánh sáng tự nhiên giúp
                        cải thiện tâm trạng và sức khỏe, không gian thoáng đãng tạo cảm giác thoải mái.
                        <br>
                        Cuối cùng, về nội thất, căn phòng nên được thiết kế tránh các vật trang trí hoặc đồ nội thất cản
                        trở tầm nhìn gây nguy hiểm. Nên lựa chọn màu sắc hài hòa để không gian gần gũi và ấm cúng hơn.
                    </p>
                    <h4>2. Nên chọn gạch gì để lát phòng ngủ cho người cao tuổi?</h4>
                    <br>
                    <h4> Gạch Sugar</h4>
                    <img src="${url}/img/blog/details/details-pic3.jpg" alt="">
                    <p>Áp dụng công nghệ phủ men hiện đại của châu Âu. Bộ sản phẩm Sugar Diamond 60×60 là một sự đột phá
                        trong sản xuất gạch men của Ý MỸ. Đúng với tên gọi Sugar Diamond, BST có lớp men trên bề mặt
                        được tạo hiệu ứng hạt đường nhỏ li ti. Cùng với sự chắc chắn của chất liệu Porcelain, chống trầy
                        xước, thấm nước. Đây là những ưu điểm đắt giá cho sản phẩm với khả năng chống trơn trượt tối đa,
                        bảo vệ sự an toàn cho người sử dụng.
                        <br>
                        Bên cạnh đó, hiệu ứng hạt Luster phản chiếu ánh sáng sẽ làm nổi bật sắc màu lấp lánh. Giúp không
                        gian độc đáo và ấn tượng hơn. Chọn sản phẩm Sugar Diamond để làm Gạch lát nền phòng ngủ cho ông
                        bà là một ý tưởng đáng để bạn cân nhắc.</p>
                </div>
                <div class="blog__details__content">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="blog__details__author">
                                <div class="blog__details__author__pic">
                                    <img src="${url}/img/blog/details/details-author.jpg" alt="">
                                </div>
                                <div class="blog__details__author__text">
                                    <h6>Michael Scofield</h6>
                                    <span>Quản trị viên</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="blog__details__widget">
                                <div class="blog__details__social">
                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-google-plus"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Blog Details Section End -->

<!-- Related Blog Section Begin -->
<section class="related-blog spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title related-blog-title">
                    <h2>Những tin tức bạn có thể thích</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-6 from-blog-show">
                <div class="blog__item">
                    <a class="blog__item__pic" href="${pageContext.request.contextPath}/view/client/view/blog-details.jsp" >
                        <img src="${url}/img/blog/blog-1.jpg" alt="">
                    </a>
                    <div class="blog__item__text">
                        <ul>
                            <li><i class="fa fa-calendar-o"></i> 29 tháng 9, 2023</li>
                            <li><i class="fa fa-comment-o"></i> 5</li>
                        </ul>
                        <h5><a href="${pageContext.request.contextPath}/view/client/view/blog-details.jsp">PHÒNG TẮM CHILL CHO ĐỜI THÊM YÊU</a></h5>
                        <p>PHÒNG TẮM CHILL CHO ĐỜI THÊM YÊU Phòng tắm không chỉ là nơi sinh hoạt riêng tư mà còn
                            là nơi giúp thư giãn. Do vậy, đầu tư thiết kế không gian này sẽ nâng cao chất lượng
                            cuộc...</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-6 from-blog-show">
                <div class="blog__item">
                    <a class="blog__item__pic" href="${pageContext.request.contextPath}/view/client/view/blog-details.jsp">
                        <img src="${url}/img/blog/blog-2.jpg" alt="" href="${pageContext.request.contextPath}/view/client/view/blog-details.jsp">
                    </a>
                    <div class="blog__item__text">
                        <ul>
                            <li><i class="fa fa-calendar-o"></i> 21 tháng 10, 2023</li>
                            <li><i class="fa fa-comment-o"></i> 5</li>
                        </ul>
                        <h5><a href="${pageContext.request.contextPath}/view/client/view/blog-details.jsp">LỰA CHỌN AN TOÀN CHO NGÔI NHÀ CỦA ÔNG BÀ</a></h5>
                        <p>GẠCH LÁT NỀN PHÒNG NGỦ CHO NGƯỜI LỚN TUỔI Không gian phòng ngủ của ông bà cần phải
                            được cân nhắc và tính toán sao cho hợp lý, phù hợp với sức khỏe và thuận tiện
                            với...</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-6 from-blog-show">
                <div class="blog__item">
                    <a class="blog__item__pic" href="${pageContext.request.contextPath}/view/client/view/blog-details.jsp">
                        <img src="${url}/img/blog/blog-3.jpg" alt="" href="${pageContext.request.contextPath}/view/client/view/blog-details.jsp">
                    </a>
                    <div class="blog__item__text">
                        <ul>
                            <li><i class="fa fa-calendar-o"></i> 14 tháng 10, 2023</li>
                            <li><i class="fa fa-comment-o"></i> 5</li>
                        </ul>
                        <h5><a href="${pageContext.request.contextPath}/view/client/view/blog-details.jsp">HÃY ĐỂ NHÀ LÀ NƠI CHỮA LÀNH TÂM HỒN</a></h5>
                        <p>NHÀ LÀ NƠI CHỮA LÀNH TÂM HỒN Khám phá xu hướng và lợi ích của Gạch lát nền vân gỗ
                            trong thiết kế không gian. Bài viết này sẽ tập trung vào khả năng tạo cảm giác ấm áp
                            và bình yên...</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Related Blog Section End -->

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