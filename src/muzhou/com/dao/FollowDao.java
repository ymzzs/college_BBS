package muzhou.com.dao;

import muzhou.com.bean.FollowBean;
import muzhou.com.bean.PageBean;

import java.util.List;
import java.util.Map;

public interface FollowDao {

    public void addFollow(FollowBean followBean);
    public void deleteFollow(int userid,int followed_userid);
    public PageBean<Map<String,Object>> getFollowByPageAndUserId(int page, int userid);
    public List<FollowBean> getFollowByUserid(int followed_userid );
    public PageBean<Map<String,Object>> getFansByPageAndUserId(int page, int userid);
    public List<FollowBean> getFollowByLoginUserid(int userid );
    public void sendFollowMessage(int userid,int followed_userid);
}
