package muzhou.com.service;

import muzhou.com.bean.UserBean;
import muzhou.com.dao.UserDao;

import java.util.Map;

public interface UserService {

    public void addUser(UserBean user);
    public UserBean getUser(String userName);
    public UserBean getUserById(int userId);
    public void updateUser(UserBean user);
    public void updatePassword(int userid, String newPassword);
    public void updateHead(int userId ,String head);
    public  void updateSignInStatus(int userid);
    public Map<String,Object> getUserInf(int userid);
}
