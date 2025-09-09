
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chủ Admin</title>
    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #f8f9fa; }
        .header { background-color: #007bff; color: white; padding: 15px; border-radius: 5px 5px 0 0; }
        .card { transition: transform 0.3s, box-shadow 0.3s; }
        .card:hover { transform: translateY(-5px); box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2); }
        .card-body { background-color: #e3f2fd; }
        .btn-primary { background-color: #007bff; border-color: #007bff; }
        .btn-primary:hover { background-color: #0056b3; }
        .dashboard-container { margin: 30px auto; max-width: 1100px; }
    </style>
</head>
<body>
    <div class="dashboard-container">
        <div class="row">
            <div class="col-12">
                <h2 class="header text-center">Trang chủ Admin</h2>
                
                <!-- Thông tin chào mừng -->
                <div class="alert alert-info text-center mb-4" role="alert">
                    <c:choose>
                        <c:when test="${sessionScope.account != null}">
                            Chào mừng, ${sessionScope.account.fullName}! Bạn đang ở trang quản lý admin.
                        </c:when>
                        <c:otherwise>
                            Chào mừng đến với trang quản lý admin! Vui lòng đăng nhập để tiếp tục.
                        </c:otherwise>
                    </c:choose>
                </div>

                <!-- Các thẻ chức năng -->
                <div class="row">
                    <div class="col-md-4 mb-3">
                        <div class="card h-100">
                            <div class="card-body text-center">
                                <h5 class="card-title">Quản lý Danh mục</h5>
                                <p class="card-text">Xem, thêm, sửa, xóa danh mục sản phẩm.</p>
                                <a href="${pageContext.request.contextPath}/category/list" class="btn btn-primary">Vào quản lý</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <div class="card h-100">
                            <div class="card-body text-center">
                                <h5 class="card-title">Quản lý Người dùng</h5>
                                <p class="card-text">Quản lý thông tin và quyền người dùng.</p>
                                <a href="${pageContext.request.contextPath}/user/list" class="btn btn-primary" 
                                   onclick="alert('Chức năng đang phát triển!')">Vào quản lý</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <div class="card h-100">
                            <div class="card-body text-center">
                                <h5 class="card-title">Thống kê Báo cáo</h5>
                                <p class="card-text">Xem báo cáo và thống kê hoạt động.</p>
                                <a href="#" class="btn btn-primary" onclick="alert('Chức năng đang phát triển!')">Xem báo cáo</a>
                            </div>
                        </div>
                    </div>
                </div>

    
                <div class="text-center mt-4">
                    <a href="${pageContext.request.contextPath}/logout" class="btn btn-secondary">
                        <i class="fas fa-sign-out-alt"></i> Đăng xuất
                    </a>
                </div>
            </div>
        </div>
    </div>

    <!-- Font Awesome CDN cho icon -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
