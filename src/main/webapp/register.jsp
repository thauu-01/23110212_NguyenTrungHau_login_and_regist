<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng Ký</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <h2>Tạo tài khoản mới</h2>
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
                    <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                    <input type="email" placeholder="Email" name="email" class="form-control" required>
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
        <button type="submit" class="btn btn-primary">Đăng Ký</button>
    </form>
</body>
</html>