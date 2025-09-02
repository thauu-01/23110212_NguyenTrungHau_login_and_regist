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
            padding: 0;
        }
        .right-topbar li {
            display: inline-block;
            margin-left: 10px;
        }
        .right-topbar a {
            color: #007bff; 
            text-decoration: none;
        }
        .right-topbar a:hover {
            color: #0056b3; 
            text-decoration: underline;
        }
        .search-button {
            font-size: 1.2em;
            color: #333;
            cursor: pointer;
        }
        .search-button:hover {
            color: #007bff;
        }
    </style>
</head>
<body>
    <div class="col-sm-6">
        <ul class="list-inline right-topbar pull-right">
            <c:choose>
                <c:when test="${sessionScope.account == null}">
                    <li><a href="${pageContext.request.contextPath}/login">Đăng nhập</a> | 
                        <a href="${pageContext.request.contextPath}/register">Đăng ký</a> | 
                        <a href="${pageContext.request.contextPath}/forgetPassword">Quên mật khẩu?</a></li>
                    <li><i class="fas fa-search search-button"></i></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageContext.request.contextPath}/member/myaccount">${sessionScope.account.fullName}</a> | 
                        <a href="${pageContext.request.contextPath}/logout">Đăng Xuất</a></li>
                    <li><i class="fas fa-search search-button"></i></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</body>
</html>