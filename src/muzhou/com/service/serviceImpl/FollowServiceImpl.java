package muzhou.com.service.serviceImpl;

import muzhou.com.bean.FollowBean;
import muzhou.com.bean.PageBean;
import muzhou.com.service.FollowService;

import java.util.List;
import java.util.Map;

public class FollowServiceImpl extends BaseService implements FollowService {

    public void addFollow(FollowBean followBean){followDao.addFollow(followBean);}
    public void deleteFollow(int userid,int followed_userid){followDao.deleteFollow(userid,followed_userid);}
    public PageBean<Map<String,Object>> getFollowByPageAndUserId(int page, int userid){return followDao.getFollowByPageAndUserId(page,userid);}
    public List<FollowBean> getFollowByUserid(int followed_userid ){return followDao.getFollowByUserid(followed_userid);}
    public PageBean<Map<String,Object>> getFansByPageAndUserId(int page, int userid){return followDao.getFansByPageAndUserId(page,userid);}
    public List<FollowBean> getFollowByLoginUserid(int userid ){return followDao.getFollowByLoginUserid(userid);}
    public void sendFollowMessage(int userid,int followed_userid){followDao.sendFollowMessage(userid,followed_userid);}
}
