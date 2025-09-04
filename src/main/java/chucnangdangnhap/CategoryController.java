package chucnangdangnhap;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/category/list", "/category/add", "/category/edit", "/category/delete"})
public class CategoryController extends HttpServlet {
    private CategoryService service = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("account");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        int userId = user.getId();

        String action = req.getServletPath();
        switch (action) {
            case "/category/list":
                List<Category> categories = service.getAllByUser(userId);
                req.setAttribute("categories", categories);
                RequestDispatcher listDispatcher = req.getRequestDispatcher("/WEB-INF/views/category/list.jsp");
                listDispatcher.forward(req, resp);
                break;
            case "/category/add":
                RequestDispatcher addDispatcher = req.getRequestDispatcher("/WEB-INF/views/category/add.jsp");
                addDispatcher.forward(req, resp);
                break;
            case "/category/edit":
                String cateIdStr = req.getParameter("cateId");
                if (cateIdStr != null) {
                    try {
                        int cateId = Integer.parseInt(cateIdStr);
                        Category category = service.get(cateId);
                        if (category != null && category.getUserId() == userId) {
                            req.setAttribute("category", category);
                            RequestDispatcher editDispatcher = req.getRequestDispatcher("/WEB-INF/views/category/edit.jsp");
                            editDispatcher.forward(req, resp);
                        } else {
                            resp.sendRedirect(req.getContextPath() + "/category/list");
                        }
                    } catch (NumberFormatException e) {
                        resp.sendRedirect(req.getContextPath() + "/category/list");
                    }
                }
                break;
            case "/category/delete":
                cateIdStr = req.getParameter("cateId");
                if (cateIdStr != null) {
                    try {
                        int cateId = Integer.parseInt(cateIdStr);
                        Category category = service.get(cateId);
                        if (category != null && category.getUserId() == userId) {
                            service.delete(cateId);
                        }
                    } catch (NumberFormatException e) {
            
                    }
                }
                resp.sendRedirect(req.getContextPath() + "/category/list");
                break;
            default:
                resp.sendRedirect(req.getContextPath() + "/category/list");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("account");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        int userId = user.getId();

        req.setCharacterEncoding("UTF-8");
        String action = req.getServletPath();

        if (action.equals("/category/add")) {
            String cateName = req.getParameter("cateName");
            if (cateName != null && !cateName.trim().isEmpty()) {
                Category category = new Category(cateName.trim(), userId);
                service.insert(category);
            } else {
                req.setAttribute("alert", "Tên danh mục không được để trống!");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/category/add.jsp");
                dispatcher.forward(req, resp);
                return;
            }
        } else if (action.equals("/category/edit")) {
            String cateIdStr = req.getParameter("cateId");
            String cateName = req.getParameter("cateName");
            if (cateIdStr != null && cateName != null && !cateName.trim().isEmpty()) {
                try {
                    int cateId = Integer.parseInt(cateIdStr);
                    Category category = service.get(cateId);
                    if (category != null && category.getUserId() == userId) {
                        category.setCateName(cateName.trim());
                        service.update(category);
                    }
                } catch (NumberFormatException e) {
         
                }
            } else {
                req.setAttribute("alert", "Tên danh mục không được để trống!");
                RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/category/edit.jsp");
                dispatcher.forward(req, resp);
                return;
            }
        }
        resp.sendRedirect(req.getContextPath() + "/category/list");
    }
}