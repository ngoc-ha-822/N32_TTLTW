<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/admin/static" var="url"></c:url>
<%@ page buffer="64kb" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Danh sách danh mục | Quản trị Admin</title>
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
    <script src="https://cdn.jsdelivr.net/npm/xlsx@0.18.4/dist/xlsx.full.min.js"></script>
</head>

<body onload="time()" class="app sidebar-mini rtl">
<!-- Navbar-->
<!-- Sidebar menu-->
<jsp:include page="/view/admin/view/mainbar.jsp"></jsp:include>
<main class="app-content">
    <div class="app-title">
        <ul class="app-breadcrumb breadcrumb side">
            <li class="breadcrumb-item active"><a href="#"><b>Danh sách sản phẩm</b></a></li>
        </ul>
        <div id="clock"></div>
    </div>
    <div id="error-message" class="alert-danger d-none"></div>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">
                    <div class="row element-button">
                        <div class="col-sm-2">

                            <a class="btn btn-add btn-sm"
                               href="${pageContext.request.contextPath}/view/admin/view/form-add-cate.jsp" title="Thêm"><i
                                    class="fas fa-plus"></i>
                                Tạo mới loại sản phẩm</a>
                        </div>
                        <form id="uploadForm" action="uploadProduct" method="post" enctype="multipart/form-data">
                            <div class="col-sm-2">
                                <label for="file-upload" class="btn btn-delete btn-sm nhap-tu-file">
                                    <i class="fas fa-file-upload"></i> Tải từ file
                                </label>
                                <input id="file-upload" type="file" name="file" style="display: none;" onchange="document.getElementById('uploadForm').submit()">
                            </div>
                        </form>

                        <div class="col-sm-2">
                            <a class="btn btn-delete btn-sm print-file" type="button" title="In"
                               onclick="myApp.printTable()"><i
                                    class="fas fa-print"></i> In dữ liệu</a>
                        </div>
                        <div class="col-sm-2">
                            <a class="btn btn-delete btn-sm print-file js-textareacopybtn" type="button"
                               title="Sao chép"><i
                                    class="fas fa-copy"></i> Sao chép</a>
                        </div>

                        <div class="col-sm-2">
                            <a class="btn btn-excel btn-sm" href="" title="In" onclick="myApp.exportToExcel()"><i class="fas fa-file-excel"></i> Xuất
                                Excel</a>
                        </div>
                        <div class="col-sm-2">
                            <a class="btn btn-delete btn-sm pdf-file" type="button" title="In"
                               onclick="myFunction(this)"><i
                                    class="fas fa-file-pdf"></i> Xuất PDF</a>
                        </div>
                        <div class="col-sm-2">
                            <a  id="deleteSelected" class="btn btn-delete btn-sm" type="button" title="Xóa"><i
                                    class="fas fa-trash-alt"></i> Xóa đã chọn </a>
                        </div>
                    </div>
                    <table class="table table-hover table-bordered" id="sampleTable">
                        <thead>
                        <tr>
                            <td width="10"><input type="checkbox" name="check1"></td>
                            <input type="hidden" name="user"
                                   value="${sessionScope.account.username}">
                            <th>Mã loại sản phẩm</th>
                            <th>Tên loại sản phẩm</th>
                            <th>Trạng thái</th>
                            <th width="100">Chức năng</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${cateList}" var="cate">
                            <tr>
                                <td width="10"><input type="checkbox" name="check1"  value="${cate.id}"></td>
                                <td>${cate.id}</td>
                                <td>${cate.name}</td>
                                <td>${cate.status}</td>
                                <td class="table-td-center">
                                    <button class="btn btn-primary btn-sm trash delete-cate" data-id="${cate.id}" type="button" title="Xóa"
                                            onclick="confirmDelete(${cate.id})"><i class="fas fa-trash-alt"></i>
                                    </button>
                                    <a href="${pageContext.request.contextPath}/Admin/cate/edit?id=${cate.id}">
                                        <button class="btn btn-primary btn-sm edit" type="button" title="Sửa"
                                                id="show-emp"
                                                data-toggle="modal" data-target="#ModalUP"><i class="fas fa-edit"></i>
                                        </button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>


<!-- Essential javascripts for application to work-->
<script src="${url}/js/jquery-3.2.1.min.js"></script>
<script src="${url}/js/popper.min.js"></script>
<script src="${url}/js/bootstrap.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/view/client/view/src/jquery.table2excel.js"></script>
<script src="${url}/js/main.js"></script>
<!-- The javascript plugin to display page loading on top-->
<script src="${url}/js/plugins/pace.min.js"></script>
<!-- Page specific javascripts-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
<!-- Data table plugin-->
<script type="text/javascript" src="${url}/js/plugins/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${url}/js/plugins/dataTables.bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/FileSaver.js/2.0.0/FileSaver.min.js"></script>

<script type="text/javascript">
    // $('#sampleTable').DataTable();
    $(function () {
        $("#sampleTable").DataTable({
            "columnDefs": [
                {
                    "targets": 3,
                    "render": function (data, type, row, meta) {
                        if (data == 0) {
                            return '<i class="fas fa-times text-danger"></i>'; // Biểu tượng X đỏ
                        } else if (data == 1) {
                            return '<i class="fas fa-check text-success"></i>'; // Biểu tượng tích xanh
                        }
                    }
                }
            ]
        });
    });

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
    var myApp = new function () {
        this.printTable = function () {
            var tab = document.getElementById('sampleTable');
            var win = window.open('', '', 'height=700,width=700');
            win.document.write(tab.outerHTML);
            win.document.close();
            win.print();
        }
        // Xuất dữ liệu ra file Excel
        this.exportToExcel = function () {
            var table = document.getElementById('sampleTable');
            var ws = XLSX.utils.table_to_sheet(table);
            for (var r = 0; r < ws['!ref'].split(':')[1].match(/\d+/)[0]; r++) {
                delete ws[XLSX.utils.encode_cell({ c: ws['!ref'].split(':')[1].match(/[A-Z]+/)[0].charCodeAt(0) - 65, r: r })];
            }
            var wb = XLSX.utils.book_new();
            XLSX.utils.book_append_sheet(wb, ws, 'Sheet1');
            var wbout = XLSX.write(wb, { bookType: 'xlsx', type: 'binary' });

            function s2ab(s) {
                var buf = new ArrayBuffer(s.length);
                var view = new Uint8Array(buf);
                for (var i = 0; i < s.length; i++) view[i] = s.charCodeAt(i) & 0xFF;
                return buf;
            }
            var title = document.title.split(' | ')[0];
            var fileName = title + '.xlsx';

            saveAs(new Blob([s2ab(wbout)], { type: 'application/octet-stream' }), fileName);
        };

    }
</script>
<script>

    $(document).ready(function () {
        // Sử dụng delegated event cho các nút xóa
        $(document).on('click', '.delete-cate', function (e) {
            e.preventDefault(); // Ngăn chặn hành vi mặc định của liên kết
            var username = '${sessionScope.account.username}'; // Lấy thông tin người dùng từ phiên
            var deleteUserButton = $(this); // Lưu trữ phần tử .delete-user ban đầu
            var logId = $(this).data('id'); // Lấy id người dùng từ thuộc tính data-id
            console.log(username);
            // Hiển thị hộp thoại xác nhận trước khi xóa
            if (confirm("Bạn có chắc chắn muốn xóa danh mục này không?")) {
                // Gửi yêu cầu AJAX để xóa danh mục
                $.ajax({
                    url: '${pageContext.request.contextPath}/Admin/cate/delete?id=' + logId + '&username=' + username,
                    type: 'DELETE', // Sử dụng phương thức DELETE
                    success: function (response) {
                        // Xóa dòng chứa nút xóa được nhấn
                        deleteUserButton.closest('tr').remove();
                        // Hiển thị thông báo hoặc thực hiện các hành động khác
                        alert("Xóa danh mục thành công");
                        displayErrorMessage("");
                    },
                    error: function (xhr, status, error) {
                        console.error("Error deleting category:", error);
                        var response = JSON.parse(xhr.responseText);
                        displayErrorMessage(response.error); // Hiển thị thông báo lỗi
                    }
                });
            }
        });
    });

    function displayErrorMessage(message) {
        var errorMessage = document.getElementById('error-message');
        errorMessage.textContent = message;
        errorMessage.classList.remove('d-none'); // Hiển thị thông báo lỗi
    }



    // Khai báo biến toàn cục để lưu trạng thái của các dòng đã chọn
    var selectedLogs = [];
    $(document).ready(function() {
        // Hàm để cập nhật trạng thái của các dòng đã chọn khi trang được tải lại hoặc khi checkbox thay đổi
        function updateSelectedLogs() {
            selectedLogs = [];
            $('input[name="check1"]:checked').each(function() {
                selectedLogs.push($(this).val());
            });
        }

        // Xử lý sự kiện khi checkbox được chọn hoặc bỏ chọn
        $(document).on('change', 'input[name="check1"]', function() {
            updateSelectedLogs();
        });

        // Xử lý sự kiện khi nút xóa được nhấn
        $('#deleteSelected').click(function (e) {
            e.preventDefault();

            if (selectedLogs.length === 0) {
                alert("Vui lòng chọn ít nhất một cate để xóa.");
                return;
            }

            if (confirm("Bạn có chắc chắn muốn xóa những cate đã chọn không?")) {
                // Gửi yêu cầu AJAX với dữ liệu là mảng các ID đã chọn
                $.ajax({
                    url: '${pageContext.request.contextPath}/Admin/cate/deleteSelected',
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify(selectedLogs),
                    success: function (response) {
                        alert("Xóa cate đã chọn thành công");
                        // Xóa các dòng từ bảng mà không cần tải lại trang
                        selectedLogs.forEach(function(logId) {
                            $('input[name="check1"][value="' + logId + '"]').closest('tr').remove();
                        });
                        // Sau khi xóa thành công, cập nhật lại trạng thái của các dòng đã chọn
                        updateSelectedLogs();
                    },
                    error: function (xhr, status, error) {
                        console.error("Error deleting logs:", error);
                        alert("Đã xảy ra lỗi khi xóa log.");
                    }
                });
            }
        });

        // Cập nhật trạng thái của các dòng đã chọn khi trang được tải lại
        updateSelectedLogs();
    });



</script>
</body>

</html>