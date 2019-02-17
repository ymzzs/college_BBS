package muzhou.com.dao.daoImpl;

import muzhou.com.bean.FollowBean;
import muzhou.com.bean.PageBean;
import muzhou.com.dao.FollowDao;

import java.util.List;
import java.util.Map;

public class FollowDaoImpl extends DAO<FollowBean> implements FollowDao {

    public void addFollow(FollowBean followBean)
    {
        String sql = "insert into follow(userid,followed_userid) values(?,?)";
        update(sql,followBean.getUserid(),followBean.getFollowed_userid());
    }
    public void deleteFollow(int userid,int followed_userid)
    {
        String sql = "delete from follow where userid = ? and followed_userid = ?";
        update(sql,userid,followed_userid);
    }

    public List<FollowBean> getFollowByUserid(int followed_userid ) {

        String sql = "select * from follow where followed_userid = ?";
        return getForList(sql, followed_userid);
    }
    public List<FollowBean> getFollowByLoginUserid(int userid ) {

        String sql = "select * from follow where userid = ?";
        return getForList(sql, userid);
    }

    public PageBean<Map<String,Object>> getFollowByPageAndUserId(int page, int userid)
    {
        //创建pageBean
        PageBean<Map<String,Object>> pageBean = new PageBean<>();

        //设置totalCount
        String sql = "select count(*) from follow where userid = ?";
        Long totalCount = getForValue(sql,userid);
        pageBean.setTotalCount(totalCount);

        //设置总页数
        int totalPage = (int)(totalCount % pageBean.getPageCount() == 0 ? totalCount / pageBean.getPageCount() : totalCount / pageBean.getPageCount() + 1);
        pageBean.setTotalPage(totalPage);

        //设置当前页
        pageBean.setCurrentPage(page);

        //设置pageBean里的list数据【按积分从高到低排序】
        String sql1 = "SELECT f.followed_userid,u.username,u.signature,u.head FROM follow f,user u WHERE f.followed_userid = u.userid and f.userid = ? order by time DESC limit ?,?";
        int start = (page - 1) * pageBean.getPageCount();
        List<Map<String,Object>> follows = getForMapList(sql1,userid,start,pageBean.getPageCount());
        pageBean.setList(follows);
        return pageBean;
    }

    public PageBean<Map<String,Object>> getFansByPageAndUserId(int page, int userid)
    {
        //创建pageBean
        PageBean<Map<String,Object>> pageBean = new PageBean<>();

        //设置totalCount
        String sql = "select count(*) from follow where followed_userid = ?";
        Long totalCount = getForValue(sql,userid);
        pageBean.setTotalCount(totalCount);

        //设置总页数
        int totalPage = (int)(totalCount % pageBean.getPageCount() == 0 ? totalCount / pageBean.getPageCount() : totalCount / pageBean.getPageCount() + 1);
        pageBean.setTotalPage(totalPage);

        //设置当前页
        pageBean.setCurrentPage(page);

        //设置pageBean里的list数据【按积分从高到低排序】
        String sql1 = "SELECT f.followed_userid, f.userid,u.username,u.signature,u.head FROM follow f,user u WHERE f.userid = u.userid and f.followed_userid = ? order by time DESC limit ?,?";
        int start = (page - 1) * pageBean.getPageCount();
        List<Map<String,Object>> fans = getForMapList(sql1,userid,start,pageBean.getPageCount());
        pageBean.setList(fans);
        return pageBean;
    }

    public void sendFollowMessage(int userid,int followed_userid)
    {
        String sql = "insert into message(send_userid,rece_userid,type) values(?,?,'follow')";
        update(sql,userid,followed_userid);
    }

}
