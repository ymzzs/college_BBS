package muzhou.com.dao;

import muzhou.com.bean.AnswerBean;
import muzhou.com.bean.PageBean;

import java.util.List;
import java.util.Map;

public interface AnswerDao {
    public void addAnswer(AnswerBean answer);
    public AnswerBean getAnswer(String keywords);//用于查询
    public List<AnswerBean> getAnswerByUid(int uid); //用于查询用户所属的
    public void deleteAnswer(int Aid);
    public List<Map<String,Object>> getAnswerInfByQid(int qid);
    public AnswerBean getAnswerByAid(int aid);
    public void updateLikeCount(int aid,int newtotal);
    public void updateDislikeCount(int aid,int newtotal);
    public void addLikedUserId(int userid,int aid);
    public void addDisLikedUserId(int userid,int aid);
    public void deleteLikedUserId(int userid,int aid);
    public void deleteDisLikedUserId(int userid,int aid);
    public PageBean<Map<String,Object>> getMyAnswerByPageAndUid(int page, int userid);
    public void sendAnswerMessage(int send_userid,int rece_userid,int qid);
    public int getUserIdByAid(int aid);
}
