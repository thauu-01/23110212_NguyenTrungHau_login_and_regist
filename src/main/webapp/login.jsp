<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng Nhập</title>
    <!-- Thêm CSS nếu cần, ví dụ Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <h2>Đăng Nhập</h2>
        <c:if test="${alert != null}">
            <h3 class="alert alert-danger">${alert}</h3>
        </c:if>
        <section>
            <label class="input login-input">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <input type="text" placeholder="Tài khoản" name="username" class="form-control" required>
                </div>
            </label>
        </section>
        <section>
            <label class="input login-input">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    <input type="password" placeholder="Mật khẩu" name="password" class="form-control" required>
                </div>
            </label>
        </section>
        <section>
            <label class="checkbox">
                <input type="checkbox" name="remember"> Nhớ mật khẩu
            </label>
        </section>
        <button type="submit" class="btn btn-primary">Đăng Nhập</button>
    </form>
</body>
</html>