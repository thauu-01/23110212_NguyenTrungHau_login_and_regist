
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách Category</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <style>
        .container { max-width: 800px; margin: 50px auto; }
        .table { background-color: #f9f9f9; }
        .btn-primary, .btn-warning, .btn-danger { margin-right: 5px; }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="text-center mb-4">Danh sách Category</h2>
        <c:if test="${alert != null}">
            <div class="alert alert-danger text-center">${alert}</div>
        </c:if>
        <a href="${pageContext.request.contextPath}/category/add" class="btn btn-primary mb-3">
            <i class="fas fa-plus"></i> Thêm Category
        </a>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Tên Category</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="category" items="${categories}">
                    <tr>
                        <td>${category.cateId}</td>
                        <td>${category.cateName}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/category/edit?cateId=${category.cateId}" class="btn btn-warning btn-sm">
                                <i class="fas fa-edit"></i> Sửa
                            </a>
                            <a href="${pageContext.request.contextPath}/category/delete?cateId=${category.cateId}" class="btn btn-danger btn-sm" 
                               onclick="return confirm('Bạn chắc chắn muốn xóa danh mục này?')">
                                <i class="fas fa-trash"></i> Xóa
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="${pageContext.request.contextPath}/home" class="btn btn-secondary">
            <i class="fas fa-home"></i> Quay lại Trang chủ
        </a>
    </div>
</body>
</html>
