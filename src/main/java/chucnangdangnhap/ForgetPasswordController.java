package chucnangdangnhap;

import java.io.IOException;
import java.util.UUID; 

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/forgetPassword")
public class ForgetPasswordController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/forgetPassword.jsp").forward(req, resp); 
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String email = req.getParameter("email");
        if (email == null || email.trim().isEmpty()) {
            req.setAttribute("alert", "Email không được để trống!");
            req.getRequestDispatcher("WEB-INF/views/forgetPassword.jsp").forward(req, resp);
            return;
        }

        UserService service = new UserServiceImpl();
        User user = service.findByEmail(email);
        if (user == null) {
            req.setAttribute("alert", "Email không tồn tại trong hệ thống!");
            req.getRequestDispatcher("WEB-INF/views/forgetPassword.jsp").forward(req, resp);
            return;
        }


        String newPassword = UUID.randomUUID().toString().substring(0, 8); 

        if (service.resetPassword(email, newPassword)) {
            req.setAttribute("alert", "Reset thành công! Mật khẩu mới: " + newPassword + ". Vui lòng đăng nhập và đổi lại.");
    
        } else {
            req.setAttribute("alert", "Reset thất bại! Vui lòng thử lại.");
        }
        req.getRequestDispatcher("WEB-INF/views/forgetPassword.jsp").forward(req, resp);
    }
}