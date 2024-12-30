<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/admin/static" var="url"></c:url>
<%@ page buffer="64kb" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Chỉnh sửa thông tin người dùng | Quản trị Admin</title>
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
            <li class="breadcrumb-item"><a
                    href="${pageContext.request.contextPath}/Admin/user/list">Danh sách người dùng</a></li>
            <li class="breadcrumb-item"><a>Chỉnh sửa người dùng</a></li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">

            <div class="tile">

                <h3 class="tile-title">Chỉnh sửa người dùng</h3>
                <div class="tile-body">
                    <div class="row element-button">
                        <div class="col-sm-2">
                            <a class="btn btn-add btn-sm" data-toggle="modal" data-target="#exampleModalCenter"><b><i
                                    class="fas fa-folder-plus"></i> Tạo quyền mới</b></a>
                        </div>

                    </div>
                    <form class="row" role="form" action="edit?id=${user.id}" method="post">
                        <input type="hidden" name="user"
                               value="${sessionScope.account.username}">
                        <div class="form-group col-md-4">
                            <label class="control-label">Tên người dùng</label>
                            <input class="form-control" type="text" name="username" value="${user.username}" required>
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Mật khẩu</label>
                            <input class="form-control" type="text" name="password" value="${user.password}" required>
                        </div>
                        <div class="form-group col-md-4">
                            <label class="control-label">Email</label>
                            <input class="form-control" type="text" name="email" value="${user.email}" required>
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Facebook</label>
                            <input class="form-control" type="text" value="${user.facebook}" name="facebook">
                        </div>
                        <div class="form-group col-md-4">
                            <label class="control-label">Họ và tên</label>
                            <input class="form-control" type="text" name="fullname" value="${user.fullname}" required>
                        </div>
                        <div class="form-group col-md-4">
                            <label class="control-label">Địa chỉ</label>
                            <input class="form-control" type="text" name="address" value="${user.address}" required>
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Số điện thoại</label>
                            <input class="form-control" type="number" name="phoneNumber" value="${user.phoneNumber}" required>
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Quyền</label>
                            <%--                            <input class="form-control" type="text" name="roleId" value="${user.roleId}" required>--%>
                            <select class="form-control" name="roleId" value="${user.roleId}" required>
                                <option value="1"  ${user.roleId == '1' ? 'selected' : ''}>Admin</option>
                                <option value="2" ${user.roleId == '2' ? 'selected' : ''}>User</option>
                            </select>
                        </div>
                        <div class="form-group  col-md-4">
                            <label class="control-label">Trạng Thái</label>
                            <%--                            <input class="form-control" type="text" name="status" value="${user.status}" required>--%>
                            <select class="form-control" name="status" value="${user.status}" required>
                                <option value="0" ${user.status == '0' ? 'selected' : ''}>Bị khóa</option>
                                <option value="1" ${user.status == '1' ? 'selected' : ''}>Hoạt động</option>
                            </select>
                        </div>
                        <div class="form-group col-md-12">
                            <input type="button" value="Tải ảnh lên"
                                   onclick="BrowseServer();" class="btn btn-controls"/>
                            <input type="text" name="avatar" id="avatar" value="${user.avatar}">
                        </div>

                        <button class="btn btn-save" type="submit">Lưu lại</button>
                        <a class="btn btn-cancel" href="${pageContext.request.contextPath}/Admin/user/list">Hủy bỏ</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>

<!--
MODAL
-->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
     data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">

            <div class="modal-body">
                <div class="row">
                    <div class="form-group  col-md-12">
              <span class="thong-tin-thanh-toan">
                <h5>Tạo quyền mới</h5>
              </span>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label">Nhập quyền mới</label>
                        <input class="form-control" type="text" value="">
                    </div>
                </div>
                <BR>
                <button class="btn btn-save" type="button">Lưu lại</button>
                <a class="btn btn-cancel" data-dismiss="modal" href="#">Hủy bỏ</a>
                <BR>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>

<!--
MODAL
-->

<!-- Essential javascripts for application to work-->
<script src="${url}/js/jquery-3.2.1.min.js"></script>
<script src="${url}/js/popper.min.js"></script>
<script src="${url}/js/bootstrap.min.js"></script>
<script src="${url}/js/main.js"></script>
<script src="${url}/js/plugins/pace.min.js"></script>

</body>

</html>