
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Category</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <style>
        .container { max-width: 400px; margin: 50px auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; background-color: #f9f9f9; }
        .form-group label { font-weight: bold; }
        .btn-primary, .btn-secondary { width: 48%; margin: 5px 1%; }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="text-center mb-4">Thêm Category Mới</h2>
        <c:if test="${alert != null}">
            <div class="alert alert-danger text-center">${alert}</div>
        </c:if>
        <form action="${pageContext.request.contextPath}/category/add" method="post">
            <div class="form-group">
                <label for="cateName"><i class="fas fa-list"></i> Tên Category</label>
                <input type="text" class="form-control" id="cateName" name="cateName" placeholder="Nhập tên danh mục" required>
            </div>
            <button type="submit" class="btn btn-primary">Thêm</button>
            <a href="${pageContext.request.contextPath}/category/list" class="btn btn-secondary">Hủy</a>
        </form>
    </div>
</body>
</html>
