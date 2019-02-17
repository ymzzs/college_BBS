package muzhou.com.dao;

import muzhou.com.bean.UserBean;

import java.util.Map;

public interface UserDao {

    public void addUser(UserBean user);
    public UserBean getUser(String userName);
    public UserBean getUserById(int userId);
    public void updateUser(UserBean user);
    public void updatePassword(int userid, String newPassword);
    public void updateHead(int userId ,String head);
    public void updateSignInStatus(int usrId);
    public Map<String,Object> getUserInf(int userid);
}
