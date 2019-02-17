package muzhou.com.dao.daoImpl;


import muzhou.com.bean.MessageBean;
import muzhou.com.dao.MessageDao;

import java.util.List;
import java.util.Map;

public class MessageDaoImpl extends DAO<MessageBean> implements MessageDao {
    public List<Map<String, Object>> getMessageList(int userid) {
        String sql = "select m.mid,m.time,m.send_userid,m.qid,q.title,m.type,u.username from message m,user u,question q where u.userid=m.send_userid and m.rece_userid = "+userid+" group by m.mid order by m.time desc";

        return getForMapList(sql);

    }

    public void delMessageByMid(int mid) {
        String sql = "delete from message where mid = ?";
        update(sql, mid);
    }

    public void delMessageBySidAndRidAndType(int send_userid,int rece_userid,String type) {
        String sql = "delete from message where send_userid = ? and rece_userid = ? and type = ?";
        update(sql, send_userid,rece_userid,type);
    }

    public long getMessageCount(int userid)
    {
        String sql = "select count(*) from message where rece_userid = ?";
        return getForValue(sql,userid);
    }
}
