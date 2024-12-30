<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/admin/static" var="url"></c:url>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Chỉnh sửa giảm giá | Quản trị Admin</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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

    <script>

        function readURL(input, thumbimage) {
            if (input.files && input.files[0]) { //Sử dụng  cho Firefox - chrome
                var reader = new FileReader();
                reader.onload = function (e) {
                    $("#thumbimage").attr('src', e.target.result);
                }
                reader.readAsDataURL(input.files[0]);
            } else { // Sử dụng cho IE
                $("#thumbimage").attr('src', input.value);

            }
            $("#thumbimage").show();
            $('.filename').text($("#uploadfile").val());
            $('.Choicefile').css('background', '#14142B');
            $('.Choicefile').css('cursor', 'default');
            $(".removeimg").show();
            $(".Choicefile").unbind('click');

        }

        $(document).ready(function () {
            $(".Choicefile").bind('click', function () {
                $("#uploadfile").click();

            });
            $(".removeimg").click(function () {
                $("#thumbimage").attr('src', '').hide();
                $("#myfileupload").html('<input type="file" id="uploadfile"  onchange="readURL(this);" />');
                $(".removeimg").hide();
                $(".Choicefile").bind('click', function () {
                    $("#uploadfile").click();
                });
                $('.Choicefile').css('background', '#14142B');
                $('.Choicefile').css('cursor', 'pointer');
                $(".filename").text("");
            });
        })
    </script>
</head>

</head>

<body class="app sidebar-mini rtl">
<style>
    .Choicefile {
        display: block;
        background: #14142B;
        border: 1px solid #fff;
        color: #fff;
        width: 150px;
        text-align: center;
        text-decoration: none;
        cursor: pointer;
        padding: 5px 0px;
        border-radius: 5px;
        font-weight: 500;
        align-items: center;
        justify-content: center;
    }

    .Choicefile:hover {
        text-decoration: none;
        color: white;
    }

    #uploadfile,
    .removeimg {
        display: none;
    }

    #thumbbox {
        position: relative;
        width: 100%;
        margin-bottom: 20px;
    }

    .removeimg {
        height: 25px;
        position: absolute;
        background-repeat: no-repeat;
        top: 5px;
        left: 5px;
        background-size: 25px;
        width: 25px;
        /* border: 3px solid red; */
        border-radius: 50%;

    }

    .removeimg::before {
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
        content: '';
        border: 1px solid red;
        background: red;
        text-align: center;
        display: block;
        margin-top: 11px;
        transform: rotate(45deg);
    }

    .removeimg::after {
        /* color: #FFF; */
        /* background-color: #DC403B; */
        content: '';
        background: red;
        border: 1px solid red;
        text-align: center;
        display: block;
        transform: rotate(-45deg);
        margin-top: -2px;
    }
</style>
<!-- Navbar-->
<jsp:include page="/view/admin/view/mainbar.jsp"></jsp:include>
<main class="app-content">
    <div class="app-title">
        <ul class="app-breadcrumb breadcrumb">
            <li class="breadcrumb-item">Danh sách giảm giá</li>
            <li class="breadcrumb-item"><a href="#">Chỉnh sửa giảm giá</a></li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <h3 class="tile-title">Chỉnh sửa khuyến mãi</h3>
                <div class="tile-body">
                    <form class="row" role="form"
                          action="${pageContext.request.contextPath}/Admin/discount/edit?id=${discount.id}"
                          method="post">
                        <%--                        <input type="hidden" name="id" value="${blog.id}">--%>
                        <input type="hidden" name="user"
                               value="${sessionScope.account.username}">
                        <div class="form-group  col-md-4">
                            <label class="control-label">Tên khuyến mãi</label>
                            <input class="form-control" type="text" name="name" value="${discount.name}" required>
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Loại khuyến mãi</label>
                            <select class="form-control" name="type" id="type">
                                <option>-- Chọn loại khuyến mãi --</option>
                                <option value="PRODUCT" ${discount.discountType == 'PRODUCT' ? 'selected' : ''} >
                                    PRODUCT
                                </option>
                                <option value="CATEGORY" ${discount.discountType == 'CATEGORY' ? 'selected' : ''}>
                                    CATEGORY
                                </option>
                                <option value="ALL" ${discount.discountType == 'ALL' ? 'selected' : ''}>ALL</option>
                            </select>
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Mô tả</label>
                            <input class="form-control" type="text" name="description" value="${discount.description}"
                                   required>
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Phần trăm(0-1) hoặc số tiền khuyến mãi (>1)</label>
                            <input class="form-control" type="text" name="discountPercent"
                                   value="${discount.discountPercent}" required>
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Sản phẩm</label>
                            <input class="form-control" type="text" name="disId"
                                   value="${discount.disId}" required>
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Ngày bắt đầu</label>
                            <input class="form-control" type="date" name="startDate" value="${discount.startDate}"
                                   required>
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Ngày kết thúc</label>
                            <input class="form-control" type="date" name="endDate" value="${discount.endDate}" required>
                        </div>
                        <div class="form-group  col-md-4">
                        </div>
                        <div class="form-group  col-md-4">
                        </div>
                        <button class="btn btn-save" type="submit">Lưu lại</button>
                        <a class="btn btn-cancel" href="${pageContext.request.contextPath}/Admin/discount/list">Hủy
                            bỏ</a>
                    </form>
                </div>

            </div>
        </div>
    </div>
</main>
<!-- Essential javascripts for application to work-->
<script src="${pageContext.request.contextPath}/view/client/view/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/view/client/view/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/view/client/view/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/view/client/view/js/main.js"></script>
<!-- The javascript plugin to display page loading on top-->
<script src="${pageContext.request.contextPath}/view/client/view/js/plugins/pace.min.js"></script>
</body>

</html>
