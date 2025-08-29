<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng Ký</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome for icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <style>
        /* CSS tùy chỉnh tương tự login.jsp */
        .register-container {
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
        .register-container h2 {
            font-size: 1.5rem; /* Kích thước nhỏ hơn một chút, tương tự login */
            text-center: center;
        }
    </style>
</head>
<body>
    <div class="register-container">
        <h2 class="text-center mb-4">Tạo Tài Khoản Mới</h2>
        <form action="register" method="post">
            <c:if test="${alert !=null}">
                <div class="alert alert-danger text-center">${alert}</div>
            </c:if>
            <div class="form-group">
                <label for="username"><i class="fas fa-user"></i> Tài khoản</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="Tài khoản" required>
            </div>
            <div class="form-group">
                <label for="password"><i class="fas fa-lock"></i> Mật khẩu</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Mật khẩu" required>
            </div>
            <div class="form-group">
                <label for="email"><i class="fas fa-envelope"></i> Email</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Email" required>
            </div>
            <div class="form-group">
                <label for="fullName"><i class="fas fa-user-circle"></i> Họ tên đầy đủ</label>
                <input type="text" class="form-control" id="fullName" name="fullName" placeholder="Họ tên đầy đủ" required>
            </div>
            <div class="form-group">
                <label for="phone"><i class="fas fa-phone"></i> Số điện thoại</label>
                <input type="text" class="form-control" id="phone" name="phone" placeholder="Số điện thoại">
            </div>
            <button type="submit" class="btn btn-primary">Đăng ký</button>
            <div class="text-center mt-2">
                <small>Đã có tài khoản? <a href="${pageContext.request.contextPath}/login">Đăng nhập</a></small>
            </div>
        </form>
    </div>
</body>
</html>