
package chucnangdangnhap;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        User user = this.get(username);
        System.out.println("User trả về: " + (user != null ? user.getUserName() + ", password: " + user.getPassWord() : "null"));
        if (user != null && password.equals(user.getPassWord())) {
            System.out.println("Đăng nhập thành công cho username: " + username);
            return user;
        }
        System.out.println("Đăng nhập thất bại cho username: " + username);
        return null;
    }

    @Override
    public User get(String username) {
        return userDao.get(username);
    }

    @Override
    public void register(User user) {
        userDao.insert(user);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public boolean resetPassword(String email, String newPassword) {
        return userDao.resetPassword(email, newPassword);
    }
}
