package chucnangdangnhap;

public interface UserService {
    // Các hàm từ ví dụ 1
    User login(String username, String password);
    User get(String username);

    // Thêm hàm mới cho đăng ký
    void register(User user);
    boolean checkExistUsername(String username);
}