package chucnangdangnhap;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String alertMsg = "";

        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            alertMsg = "Tài khoản, mật khẩu hoặc email không được để rỗng!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
            return;
        }

        UserService service = new UserServiceImpl();
        User user = service.get(username);

        if (user != null) {
            alertMsg = "Tài khoản hoặc email đã tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
            return;
        }

        service.register(username, password, email);
        sendMail(email, "Đăng ký thành công!", "Chào " + username + ", bạn đã đăng ký thành công. Mật khẩu của bạn là: " + password);
        req.setAttribute("alert", "Đăng ký thành công!");
        resp.sendRedirect(req.getContextPath() + "/login");
    }

    private void sendMail(String to, String subject, String body) {
        final String username = "your_email@gmail.com"; // Thay bằng email của bạn
        final String password = "your_app_password"; // Thay bằng app password nếu dùng Gmail

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}