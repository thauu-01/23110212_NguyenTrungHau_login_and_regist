
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Top Bar</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <style>
        .right-topbar {
            margin: 0;
            padding: 10px 0;
            display: flex;
            align-items: center;
            justify-content: flex-end;
        }
        .right-topbar li {
            margin-left: 15px;
            list-style: none;
        }
        .right-topbar a {
            color: #007bff;
            text-decoration: none;
            font-size: 0.9rem;
            font-weight: 500;
        }
        .right-topbar a:hover {
            color: #0056b3;
            text-decoration: underline;
        }
        .search-button {
            font-size: 1.2rem;
            color: #333;
            cursor: pointer;
            margin-left: 15px;
        }
        .search-button:hover {
            color: #007bff;
        }
        .topbar-container {
            background-color: #f8f9fa;
            padding: 10px 20px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>
    <div class="topbar-container">
        <div class="container">
            <ul class="right-topbar">
                <c:choose>
                    <c:when test="${sessionScope.account == null}">
                        <li>
                            <a href="${pageContext.request.contextPath}/login">Đăng nhập</a> | 
                            <a href="${pageContext.request.contextPath}/register">Đăng ký</a> | 
                            <a href="${pageContext.request.contextPath}/forgetPassword">Quên mật khẩu?</a>
                        </li>
                        <li><i class="fas fa-search search-button"></i></li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="${pageContext.request.contextPath}/member/myaccount">${sessionScope.account.fullName}</a> | 
                            <a href="${pageContext.request.contextPath}/category/list">Quản lý Category</a> | 
                            <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
                        </li>
                        <li><i class="fas fa-search search-button"></i></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</body>
</html>
