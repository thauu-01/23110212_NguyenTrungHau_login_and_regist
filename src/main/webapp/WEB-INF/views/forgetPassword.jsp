<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quên Mật Khẩu</title>
   
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <style>
  
        .forget-container {
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
        .forget-container h2 {
            font-size: 1.5rem; 
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="forget-container">
        <h2 class="text-center mb-4">Quên Mật Khẩu</h2>
        <form action="forgetPassword" method="post">
            <c:if test="${alert !=null}">
                <div class="alert alert-danger text-center">${alert}</div> 
            </c:if>
            <div class="form-group">
                <label for="email"><i class="fas fa-envelope"></i> Email</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Nhập email của bạn" required>
            </div>
            <button type="submit" class="btn btn-primary">Gửi Yêu Cầu Reset</button>
            <div class="text-center mt-2">
                <small><a href="${pageContext.request.contextPath}/login">Quay lại Đăng nhập</a></small>
            </div>
        </form>
    </div>
</body>
</html>