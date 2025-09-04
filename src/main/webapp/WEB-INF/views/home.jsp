<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang chủ</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>Trang chủ của người dùng</h2>
        <a href="${pageContext.request.contextPath}/category/list" class="btn btn-primary">
            <i class="fas fa-list"></i> Quản lý Category
        </a>
    </div>
</body>
</html>