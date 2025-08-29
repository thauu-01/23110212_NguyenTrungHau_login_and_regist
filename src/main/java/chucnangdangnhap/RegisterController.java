package chucnangdangnhap;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            resp.sendRedirect(req.getContextPath() + "/home"); 
            return;
        }
        req.getRequestDispatcher("WEB-INF/views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String fullName = req.getParameter("fullName");
        String phone = req.getParameter("phone");

        UserService service = new UserServiceImpl();
        String alertMsg = "";

        if (service.checkExistUsername(username)) {
            alertMsg = "Tài khoản đã tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("WEB-INF/views/register.jsp").forward(req, resp);
            return;
        }

        if (username.isEmpty() || password.isEmpty() || email.isEmpty() || fullName.isEmpty()) {
            alertMsg = "Không được để trống các trường bắt buộc!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("WEB-INF/views/register.jsp").forward(req, resp);
            return;
        }

        User user = new User();
        user.setUserName(username);
        user.setPassWord(password);
        user.setEmail(email);
        user.setFullName(fullName);
        user.setPhone(phone);
        user.setAvatar(null); 
        user.setRoleid(3); 

        service.register(user);
        resp.sendRedirect(req.getContextPath() + "/login"); 
    }
}