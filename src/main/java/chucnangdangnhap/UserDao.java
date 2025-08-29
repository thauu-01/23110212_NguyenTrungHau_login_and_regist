package chucnangdangnhap;

public interface UserDao {
    // Hàm từ ví dụ 1
    User get(String username);

    // Thêm hàm mới
    void insert(User user);
    boolean checkExistUsername(String username);
}