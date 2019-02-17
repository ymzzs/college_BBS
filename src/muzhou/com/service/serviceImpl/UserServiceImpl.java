package muzhou.com.service.serviceImpl;

import muzhou.com.bean.UserBean;
import muzhou.com.service.UserService;

import java.util.Map;

public class UserServiceImpl extends BaseService implements UserService {

    public void addUser(UserBean user)
    {
        userDao.addUser(user);
    }
    public UserBean getUser(String userName)
    {
        return userDao.getUser(userName);
    }
    public UserBean getUserById(int userId)
    {
        return userDao.getUserById(userId);
    }
    public void updateUser(UserBean user){ userDao.updateUser(user);}
    public void updatePassword(int userid, String newPassword){userDao.updatePassword(userid,newPassword);}
    public void updateHead(int userId ,String head){userDao.updateHead(userId,head);}
    public  void  updateSignInStatus(int userid){ userDao.updateSignInStatus(userid);}
    public Map<String,Object> getUserInf(int userid){return userDao.getUserInf(userid);}
}
