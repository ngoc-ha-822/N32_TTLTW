<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/7/2024
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/view/admin/static" var="url"></c:url>
<%@ page buffer="64kb" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Quản lý tồn kho | Quản trị Admin</title>
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
<jsp:include page="/view/admin/view/mainbar.jsp"></jsp:include>
<main class="app-content">
    <div class="app-title">
        <ul class="app-breadcrumb breadcrumb side">
            <li class="breadcrumb-item active"><a href="#"><b>Danh sách sản phẩm</b></a></li>
        </ul>
        <div id="clock"></div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <div class="tile-body">
                    <div class="row element-button">
                        <div class="row">
                            <div class="col-sm-3">
                                <a class="btn btn-delete btn-sm print-file" type="button" title="In" onclick="myApp.printTable()">
                                    <i class="fas fa-print"></i> In dữ liệu
                                </a>
                            </div>
                            <div class="col-sm-3">
                                <a class="btn btn-delete btn-sm print-file js-textareacopybtn" type="button" title="Sao chép">
                                    <i class="fas fa-copy"></i> Sao chép
                                </a>
                            </div>
                            <div class="col-sm-3">
                                <a class="btn btn-excel btn-sm" href="" title="In" onclick="myApp.exportToExcel()">
                                    <i class="fas fa-file-excel"></i> Xuất Excel
                                </a>
                            </div>
                            <div class="col-sm-3">
                                <a class="btn btn-delete btn-sm pdf-file" type="button" title="In" onclick="myFunction(this)">
                                    <i class="fas fa-file-pdf"></i> Xuất PDF
                                </a>
                            </div>
                        </div>

                        <table class="table table-hover table-bordered js-copytextarea" cellpadding="0" cellspacing="0"
                               border="0"
                               id="sampleTable">
                            <thead>
                            <tr>
                                <th width="10"><input type="checkbox" id="all"></th>
                                <th>ID</th>
                                <th>Tên sản phẩm</th>
                                <th>Hình ảnh</th>
                                <th>Số sản phẩm tồn kho</th>
                                <th width="100">Trạng thái</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="warehouse" items="${warehouse}">
                                <tr>
                                    <td width="10"><input type="checkbox" name="check1" value="1"></td>
                                    <td>${warehouse.id}</td>
                                    <td>${warehouse.name}</td>
                                    <c:url value="${warehouse.image }" var="imgUrl"></c:url>
                                    <td><img src="${imgUrl}" alt="" width="100px;"></td>
                                    <td>${warehouse.remainingStock}</td>
                                    <c:choose>
                                        <c:when test="${warehouse.stockStatus == 'Hết hàng'}">
                                            <td><span style="display: inline-block; padding: 0.3em 0.6em; background-color: #ffcccc; color: #cc0000; font-weight: bold; border-radius: 8px;font-size: 0.9em;">Hết hàng</span></td>
                                        </c:when>
                                        <c:when test="${warehouse.stockStatus == 'Sắp hết hàng'}">
                                            <td><span class="badge bg-danger">Sắp hết hàng</span></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><span class="badge bg-success">Còn hàng</span></td>
                                        </c:otherwise>
                                    </c:choose>



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
<!-- Essential javascripts for application to work-->
<script src="${url}/js/jquery-3.2.1.min.js"></script>
<script src="${url}/js/popper.min.js"></script>
<script src="${url}/js/bootstrap.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="${url}/src/jquery.table2excel.js"></script>
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
    $('#sampleTable').DataTable();

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
    <%--function confirmDelete(blogId) {--%>
    <%--    swal({--%>
    <%--        title: "Cảnh báo",--%>
    <%--        text: "Bạn có chắc chắn muốn xóa sản phẩm này?",--%>
    <%--        buttons: ["Hủy bỏ", "Đồng ý"],--%>
    <%--    }).then((willDelete) => {--%>
    <%--        if (willDelete) {--%>
    <%--            window.location.href = "${pageContext.request.contextPath}/Admin/product/delete?id=" + blogId;--%>
    <%--        }--%>
    <%--    });--%>
    <%--}--%>
    $(document).ready(function () {
        // Sử dụng delegated event cho các nút xóa
        $(document).on('click', '.delete-product', function (e) {
            e.preventDefault(); // Ngăn chặn hành vi mặc định của liên kết
            var username = '${sessionScope.account.username}'; // Lấy thông tin người dùng từ phiên
            var deleteUserButton = $(this); // Lưu trữ phần tử .delete-user ban đầu
            var logId = $(this).data('id'); // Lấy id người dùng từ thuộc tính data-id
            console.log(username);
            // Hiển thị hộp thoại xác nhận trước khi xóa
            if (confirm("Bạn có chắc chắn muốn xóa sản phẩm này không?")) {
                // Gửi yêu cầu AJAX để xóa người dùng
                $.ajax({
                    url: '${pageContext.request.contextPath}/Admin/product/delete?id=' + logId + '&username=' + username,
                    type: 'DELETE', // Sử dụng phương thức DELETE
                    success: function (response) {
                        // Xóa dòng chứa nút xóa được nhấn
                        deleteUserButton.closest('tr').remove();
                        // Hiển thị thông báo hoặc thực hiện các hành động khác
                        alert("Xóa sản phẩm thành công");
                    },
                    error: function (xhr, status, error) {
                        console.error("Error deleting user:", error);
                        // Xử lý lỗi nếu cần
                    }
                });
            }
        });
    });

    oTable = $('#sampleTable').dataTable();
    $('#all').click(function (e) {
        $('#sampleTable tbody :checkbox').prop('checked', $(this).is(':checked'));
        e.stopImmediatePropagation();
    });
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
                alert("Vui lòng chọn ít nhất một sản phẩm để xóa.");
                return;
            }

            if (confirm("Bạn có chắc chắn muốn xóa những sản phẩm đã chọn không?")) {
                // Gửi yêu cầu AJAX với dữ liệu là mảng các ID đã chọn
                $.ajax({
                    url: '${pageContext.request.contextPath}/Admin/product/deleteSelected',
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify(selectedLogs),
                    success: function (response) {
                        alert("Xóa sản phẩm đã chọn thành công");
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