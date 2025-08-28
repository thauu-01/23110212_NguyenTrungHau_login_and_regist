package chucnangdangnhap;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        User user = this.get(username);
        if (user != null && password.equals(user.getPassWord())) {
            return user;
        }
        return null;
    }

    @Override
    public User get(String username) {
        return userDao.get(username);
    }

    @Override
    public void register(String username, String password, String email) {
        User user = new User();
        user.setUserName(username);
        user.setPassWord(password);
        user.setEmail(email);
    
        userDao.insert(user);
    }
}