<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/admin/static" var="url"></c:url>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Chỉnh sửa đơn hàng | Quản trị Admin</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="${url}/css/main.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <!-- or -->
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
    <link rel="stylesheet" type="text/css"
          href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="http://code.jquery.com/jquery.min.js" type="text/javascript"></script>

</head>
<body onload="time()" class="app sidebar-mini rtl">
<jsp:include page="/view/admin/view/mainbar.jsp"></jsp:include>
<main class="app-content">
    <div class="app-title">
        <ul class="app-breadcrumb breadcrumb">
            <li class="breadcrumb-item">Danh sách đơn hàng</li>
            <li class="breadcrumb-item"><a href="#">Thêm đơn hàng</a></li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <h3 class="tile-title">Thay đổi trạng thái đơn hàng</h3>
                <% String error = (String) session.getAttribute("error");
                    if (error != null && !error.isEmpty()) {
                %>
                <div class="alert alert-danger" role="alert">
                    <%= error %>
                </div>
                <%
                        session.removeAttribute("error"); // Xóa thông điệp lỗi sau khi đã hiển thị
                    }
                %>
                <div class="tile-body">
                    <form class="row" action="${pageContext.request.contextPath}/Admin/order/edit"
                          method="post">
                        <div class="form-group  col-md-4">
                            <label class="control-label">ID đơn hàng</label>
                            <input class="form-control" type="text" name="id" value="${id}">
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Tên khách hàng</label>
                            <input class="form-control" type="text" name="fullname" value="${cartItem.buyer.fullname}" >
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Tổng tiền</label>
                            <input class="form-control" type="number" name="total"  value="${cartItem.total}">
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Ghi chú</label>
                            <input class="form-control" type="text" name="note"  value="${cartItem.note}">
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Địa chỉ</label>
                            <input class="form-control" type="text" name="address"  value="${cartItem.address}">
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Số điện thoại</label>
                            <input class="form-control" type="number" name="phone"  value="${cartItem.phoneNumber}">
                        </div>
                        <div class="form-group col-md-4">
                            <label for="status" class="control-label">Tình trạng</label>
                            <select id="status" name="status" class="form-control">
                                <option value="Đang xử lý" ${cartItem.status == 'Đang xử lý' ? 'selected' : ''}>Đang xử lý</option>
                                <option value="Đã xác nhận" ${cartItem.status == 'Đã xác nhận' ? 'selected' : ''}>Đã xác nhận</option>
                                <option value="Chuẩn bị hàng" ${cartItem.status == 'Chuẩn bị hàng' ? 'selected' : ''}>Người bán đang chuẩn bị hàng</option>
                                <option value="Đã hủy" ${cartItem.status == 'Đã hủy' ? 'selected' : ''}>Đã hủy</option>
                                <option value="Đã bàn giao cho đơn vị vận chuyển GHTK" ${cartItem.status == 'Đã bàn giao cho đơn vị vận chuyển GHTK' ? 'selected' : ''}>Đã bàn giao cho đơn vị vận chuyển GHTK</option>
                                <option value="Đang giao hàng" ${cartItem.status == 'Đang giao hàng' ? 'selected' : ''}>Đang giao hàng</option>
                                <option value="Đã giao hàng" ${cartItem.status == 'Đã giao hàng' ? 'selected' : ''}>Đã giao hàng</option>
                                <option value="Đã hoàn trả" ${cartItem.status == 'Đã hoàn trả' ? 'selected' : ''}>Đã hoàn trả</option>
                            </select>
                        </div>
                        <div class="form-group  col-md-4">
                        </div>
                        <div class="form-group  col-md-4">
                        </div>
                        <button class="btn btn-save" type="submit">Lưu lại</button>
                        <a class="btn btn-cancel" href="${pageContext.request.contextPath}/Admin/order/list">Hủy bỏ</a>
                    </form>
                </div>

            </div>
        </div>
    </div>
</main>

<!-- Essential javascripts for application to work-->
<script src="${url}/js/jquery-3.2.1.min.js"></script>
<script src="${url}/js/popper.min.js"></script>
<script src="${url}/js/bootstrap.min.js"></script>
<script src="${url}/js/main.js"></script>
<!-- The javascript plugin to display page loading on top-->
<script src="${url}/js/plugins/pace.min.js"></script>
</body>
</html>