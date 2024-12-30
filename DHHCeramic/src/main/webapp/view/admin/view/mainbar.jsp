<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/2/2023
  Time: 5:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/admin/static" var="url"></c:url>

<!-- Main CSS-->
<link rel="stylesheet" type="text/css" href="${url}/css/main.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
<!-- or -->
<link rel="stylesheet" href=https://unpkg.com/boxicons@latest/css/boxicons.min.css">
<!-- Font-icon css-->
<link rel="stylesheet" type="text/css"
      href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">

<!-- Navbar-->
<header class="app-header">
    <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                    aria-label="Hide Sidebar"></a>
    <!-- Navbar Right Menu-->
    <ul class="app-nav">


        <!-- User Menu-->
        <li><a class="app-nav__item" href="${pageContext.request.contextPath}/AdminLogout"><i
                class='bx bx-log-out bx-rotate-180'></i> </a>

        </li>
    </ul>
</header>
<!-- Sidebar menu-->
<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
<aside class="app-sidebar">
    <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="${url}/images/hay.jpg" width="50px"
                                        alt="User Image">
        <div>
            <p class="app-sidebar__user-name"><b>Admin</b></p>
            <p class="app-sidebar__user-designation">Chào mừng bạn trở lại</p>
        </div>
    </div>
    s
    <hr>
    <ul class="app-menu">
        <li><a class="app-menu__item menu-link " href="${pageContext.request.contextPath}/Admin/Welcome"><i
                class='app-menu__icon bx bx-tachometer'></i><span
                class="app-menu__label">Bảng điều khiển</span></a></li>
        <li><a class="app-menu__item menu-link" href="${pageContext.request.contextPath}/Admin/user/list"><i
                class='app-menu__icon bx bx-id-card'></i> <span
                class="app-menu__label">Quản lý nguời dùng</span></a></li>
        <!--      <li><a class="app-menu__item" href="table-data-customer.jsp"><i class='app-menu__icon bx bx-user-voice'></i><span-->
        <!--              class="app-menu__label">Quản lý khách hàng</span></a></li>-->
        <li><a class="app-menu__item menu-link" href="${pageContext.request.contextPath}/Admin/cate/list"><i
                class='app-menu__icon bx bx bxs-category'></i><span class="app-menu__label">Quản lý danh mục</span></a>
        </li>
        <li><a class="app-menu__item menu-link" href="${pageContext.request.contextPath}/Admin/product/list"><i
                class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Quản lý sản phẩm</span></a>
        </li>
        <li><a class="app-menu__item menu-link" href="${pageContext.request.contextPath}/Admin/order/list"><i
                class='app-menu__icon bx bx-task'></i><span
                class="app-menu__label">Quản lý đơn hàng</span></a></li>
        <li><a class="app-menu__item menu-link" href="${pageContext.request.contextPath}/Admin/log/list"><i
                class='app-menu__icon bx bx-list-check'></i><span
                class="app-menu__label">Quản lý log
          </span></a></li>

        <li><a class="app-menu__item" href="${pageContext.request.contextPath}/Admin/discount/list"><i
                class='app-menu__icon bx bx bxs-discount'></i><span
                class="app-menu__label">Quản lý giảm giá
            </span></a></li>
        <li><a class="app-menu__item menu-link" href="${pageContext.request.contextPath}/admin/warehouse"><i
                class='app-menu__icon bx bx-package'></i><span
                class="app-menu__label">Quản lý tồn kho
          </span></a></li>
        <li><a class="app-menu__item menu-link" href="${pageContext.request.contextPath}/admin/productImports"><i
                class='app-menu__icon bx bx-package'></i><span
                class="app-menu__label">Quản lý nhập hàng
          </span></a></li>

        <li><a class="app-menu__item menu-link" href="${pageContext.request.contextPath}/Admin/blog/list"><i
                class='app-menu__icon bx bx bxl-blogger'></i><span
                class="app-menu__label">Quản lý tin tức
          </span></a></li>
        <li><a class="app-menu__item menu-link" href="${pageContext.request.contextPath}/Admin/contact/list"><i
                class="app-menu__icon bx bxs-contact"></i><span
                class="app-menu__label">Quản lý liên hệ
          </span></a></li>
        <li><a class="app-menu__item menu-link" href="${pageContext.request.contextPath}/Admin/comment/list"><i
                class="app-menu__icon bx bxs-chat"></i><span
                class="app-menu__label">Quản lý bình luận
          </span></a></li>
        <%--        <li><a class="app-menu__item" href="${pageContext.request.contextPath}/view/admin/view/table-data-help.jsp"><i class="app-menu__icon bx bxs-help-circle"></i><span--%>
        <%--                class="app-menu__label">Quản lý trợ giúp--%>
        <%--          </span></a></li>--%>
        <!--      <li><a class="app-menu__item" href="table-data-money.jsp"><i class='app-menu__icon bx bx-dollar'></i><span-->
        <!--            class="app-menu__label">Bảng kê lương</span></a></li>-->
        <!--      <li><a class="app-menu__item" href="quan-ly-bao-cao.jsp"><i-->
        <!--            class='app-menu__icon bx bx-pie-chart-alt-2'></i><span class="app-menu__label">Báo cáo doanh thu</span></a>-->
        <!--      </li>-->
        <!--      <li><a class="app-menu__item" href="page-calendar.jsp"><i class='app-menu__icon bx bx-calendar-check'></i><span-->
        <!--            class="app-menu__label">Lịch công tác </span></a></li>-->
        <%--        <li><a class="app-menu__item" href="${pageContext.request.contextPath }/Admin/myAccount?id=${sessionScope.account.id}"><i class='app-menu__icon bx bx-cog'></i><span class="app-menu__label">Cài--%>
        <%--            đặt tài khoản</span></a></li>--%>
    </ul>
</aside>

<script src="${url}/js/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="${url}/js/popper.min.js"></script>
<script src="https://unpkg.com/boxicons@latest/dist/boxicons.js"></script>
<!--===============================================================================================-->
<script src="${url}/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="${url}/js/main.js"></script>
<!--===============================================================================================-->
<script src="${url}/js/plugins/pace.min.js"></script>
<!--===============================================================================================-->
<script type="/text/javascript" src="${url}/js/plugins/chart.js"></script>
<!--===============================================================================================-->
<script>
    $(document).ready(function () {
        $(".menu-link").click(function () {
            console.log("Clicked!"); // Kiểm tra xem đoạn mã này có được hiển thị trong Console không

            $(".menu-link").removeClass("active");
            $(this).addClass("active");
        });
    });
</script>


<script type="text/javascript">
    var data = {
        labels: ["Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6"],
        datasets: [{
            label: "Dữ liệu đầu tiên",
            fillColor: "rgba(255, 213, 59, 0.767), 212, 59)",
            strokeColor: "rgb(255, 212, 59)",
            pointColor: "rgb(255, 212, 59)",
            pointStrokeColor: "rgb(255, 212, 59)",
            pointHighlightFill: "rgb(255, 212, 59)",
            pointHighlightStroke: "rgb(255, 212, 59)",
            data: [20, 59, 90, 51, 56, 100]
        },
            {
                label: "Dữ liệu kế tiếp",
                fillColor: "rgba(9, 109, 239, 0.651)  ",
                pointColor: "rgb(9, 109, 239)",
                strokeColor: "rgb(9, 109, 239)",
                pointStrokeColor: "rgb(9, 109, 239)",
                pointHighlightFill: "rgb(9, 109, 239)",
                pointHighlightStroke: "rgb(9, 109, 239)",
                data: [48, 48, 49, 39, 86, 10]
            }
        ]
    };
    var ctxl = $("#lineChartDemo").get(0).getContext("2d");
    var lineChart = new Chart(ctxl).Line(data);

    var ctxb = $("#barChartDemo").get(0).getContext("2d");
    var barChart = new Chart(ctxb).Bar(data);
</script>
<script type="text/javascript">
    //Thời Gian
    function time() {
        var today = new Date();
        var weekday = new Array(7);
        weekday[0] = "Chủ Nhật";
        weekday[1] = "Thứ Hai";
        weekday[2] = "Thứ Ba";
        weekday[3] = "Thứ Tư";
        weekday[4] = "Thứ Năm";
        weekday[5] = "Thứ Sáu";
        weekday[6] = "Thứ Bảy";
        var day = weekday[today.getDay()];
        var dd = today.getDate();
        var mm = today.getMonth() + 1;
        var yyyy = today.getFullYear();
        var h = today.getHours();
        var m = today.getMinutes();
        var s = today.getSeconds();
        m = checkTime(m);
        s = checkTime(s);
        nowTime = h + " giờ " + m + " phút " + s + " giây";
        if (dd < 10) {
            dd = '0' + dd
        }
        if (mm < 10) {
            mm = '0' + mm
        }
        today = day + ', ' + dd + '/' + mm + '/' + yyyy;
        tmp = '<span class="date"> ' + today + ' - ' + nowTime +
            '</span>';
        document.getElementById("clock").innerHTML = tmp;
        clocktime = setTimeout("time()", "1000", "Javascript");

        function checkTime(i) {
            if (i < 10) {
                i = "0" + i;
            }
            return i;
        }
    }
</script>