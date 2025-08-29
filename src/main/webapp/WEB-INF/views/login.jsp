<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng Nhập</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome for icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <style>
        /* CSS tùy chỉnh để giống hình ảnh */
        .login-container {
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .form-group label {
            font-weight: bold;
        }
        .btn-primary {
            width: 100%;
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }
        .form-control {
            background-color: #e9ecef;
            border: none;
        }
        .form-check-label {
            margin-left: 5px;
        }
        .login-container h2 {
            font-size: 1.5rem; /* Kích thước nhỏ hơn một chút */
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2 class="text-center mb-4">Đăng Nhập Vào Hệ Thống</h2>
        <form action="login" method="post">
            <c:if test="${alert !=null}">
                <div class="alert alert-danger text-center">${alert}</div>
            </c:if>
            <div class="form-group">
                <label for="username"><i class="fas fa-user"></i> Tài khoản</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="Tài khoản">
            </div>
            <div class="form-group">
                <label for="password"><i class="fas fa-lock"></i> Mật khẩu</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Mật khẩu">
            </div>
            <div class="form-check mb-3">
                <input type="checkbox" class="form-check-input" name="remember" id="remember">
                <label class="form-check-label" for="remember">Nhớ mật khẩu</label>
            </div>
            <button type="submit" class="btn btn-primary">Đăng nhập</button>
            <div class="text-center mt-2">
                <small>Chưa có tài khoản? <a href="${pageContext.request.contextPath}/register">Đăng ký</a></small>
            </div>
        </form>
    </div>
</body>
</html>