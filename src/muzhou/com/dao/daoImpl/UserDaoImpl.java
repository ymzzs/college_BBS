package muzhou.com.dao.daoImpl;

import muzhou.com.bean.UserBean;
import muzhou.com.dao.UserDao;

import java.util.Map;

public class UserDaoImpl extends DAO<UserBean> implements UserDao {
    public void addUser(UserBean user)
    {


            String sql = "INSERT INTO user(password,username,email,level,integral,contribute,school,major,telephone) values(?,?,?,?,?,?,?,?,?)";
            update(sql,user.getPassWord(),user.getUserName(),user.getEmail(),user.getLevel(),user.getIntegral(),user.getContribute(),user.getSchool(),user.getMajor(),user.getTelephone());

    }
    public UserBean getUser(String userName)
    {

        String sql = "SELECT * FROM user WHERE username = ?";

        return get(sql,userName);
    }
    public UserBean getUserById(int userId)
    {
        String sql = "SELECT * FROM user WHERE userid = ?";
        return get(sql,userId);
    }

    public void updateUser(UserBean user)
    {
        String sql="UPDATE user SET username= ?,email= ?,school= ?,major= ?,telephone=?,birthday=?,sex=?,signature=? WHERE userid= ?";
        System.out.println("updateUser(UserBean user)");
        update(sql,user.getUserName(),user.getEmail(),user.getSchool(),user.getMajor(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getSignature(),user.getUserId());
    }

    public void updatePassword(int userid, String newPassword)
    {
        String sql="UPDATE user SET password = ? WHERE userid= ?";
        System.out.println("updateUser(UserBean user)");
        update(sql,newPassword,userid);
    }

    public void updateHead(int userid,String head){
        String sql= "UPDATE user SET head =? WHERE userid = ?";
        update(sql,head,userid);
    }
    public void updateSignInStatus(int userid){
        String sql= "UPDATE user SET signin =1,last_signin_time = CURRENT_TIMESTAMP(),integral=integral+5,bonus = bonus+5 WHERE userid = ?";
        update(sql,userid);
    }

    public Map<String,Object> getUserInf(int userid)
    {
        String sql = "select u.username,u.level,count(DISTINCT q.qid) as userqCount,count(DISTINCT a.qid) as useraCount from user u,question q,answer a where u.userid = q.userid and u.userid = a.userid and u.userid = ?";

        Map<String,Object> map =  getForMap(sql,userid);

        String sql1 = "select count(*) from question where userid = ? and solved = 1";
        long solvedCount = getForValue(sql1,userid);
        map.put("solvedCount",solvedCount);

        String sql2 = "select count(q.bestAid) from answer a,question q where q.bestAid = a.aid and a.userid = ?";

        long bestCount = getForValue(sql2,userid);
        map.put("bestCount",bestCount);


        return map;
    }
}
