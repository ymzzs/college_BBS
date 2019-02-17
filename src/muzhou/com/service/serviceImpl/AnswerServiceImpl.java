package muzhou.com.service.serviceImpl;


import muzhou.com.bean.AnswerBean;
import muzhou.com.bean.PageBean;
import muzhou.com.service.AnswerService;

import java.util.List;
import java.util.Map;

public class AnswerServiceImpl extends BaseService implements AnswerService {
    public void addAnswer(AnswerBean answer) {
        answerDao.addAnswer(answer);
    }

    public AnswerBean getAnswerByKeywords(String keywords) {
        return answerDao.getAnswer(keywords);
    }

    public List<AnswerBean> getAnswerByUid(int uid) {
        return answerDao.getAnswerByUid(uid);
    }

    public void deleteAnswerById(int Aid) {
        answerDao.deleteAnswer(Aid);
    }

    public List<Map<String, Object>> getAnswerInfByQid(int qid) {
        return answerDao.getAnswerInfByQid(qid);
    }

    public AnswerBean getAnswerByAid(int aid) {
        return answerDao.getAnswerByAid(aid);
    }

    public void updateLikeCount(int aid, int newtotal) {
        answerDao.updateLikeCount(aid, newtotal);
    }
    public void updateDislikeCount(int aid,int newtotal)
    {
        answerDao.updateDislikeCount(aid,newtotal);
    }

    public void addLikedUserId(int userid,int aid) {
        answerDao.addLikedUserId(userid,aid);
    }

    public void addDisLikedUserId(int userid,int aid) {
        answerDao.addDisLikedUserId(userid,aid);
    }
    public void deleteLikedUserId(int userid,int aid){answerDao.deleteLikedUserId(userid,aid);}
    public void deleteDisLikedUserId(int userid,int aid){answerDao.deleteDisLikedUserId(userid,aid);}
    public PageBean<Map<String,Object>> getMyAnswerByPageAndUid(int page, int userid){return answerDao.getMyAnswerByPageAndUid(page,userid);}
    public void sendAnswerMessage(int send_userid,int rece_userid,int qid){answerDao.sendAnswerMessage(send_userid,rece_userid,qid);}
    public int getUserIdByAid(int aid){return answerDao.getUserIdByAid(aid);}
}
