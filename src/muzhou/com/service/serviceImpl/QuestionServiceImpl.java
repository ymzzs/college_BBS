package muzhou.com.service.serviceImpl;

import muzhou.com.bean.PageBean;
import muzhou.com.bean.QuestionBean;
import muzhou.com.service.QuestionService;

import java.util.List;
import java.util.Map;


public class QuestionServiceImpl extends BaseService implements QuestionService {
    public void addQuestion(QuestionBean question)
    {
        questionDao.addQuestion(question);
    }
    public List<QuestionBean> getAllQuestion(){return questionDao.getAllQuestion();}
    public QuestionBean getQuestionBySearch(String keyword,String title,String content){return questionDao.getQuestionBySearch(keyword,title,content);}
    public QuestionBean getQuestionById(int qid){
        return questionDao.getQuestionById(qid);
    }
    public void deleteQuestionById(int Qid)
    {
        questionDao.deleteQuestion(Qid);
    }
    public PageBean<QuestionBean> getQuestionByPage(int page){return  questionDao.getQuestionByPage(page);}
    public PageBean<QuestionBean> getQuestionByPageAndSolved(int page,int solved){return questionDao.getQuestionByPageAndSolved(page,solved);}
    public PageBean<QuestionBean> getQuestionByPageAndSolvedAndMajor(int page,int solved,String major){return questionDao.getQuestionByPageAndSolvedAndMajor(page,solved,major);}
    public PageBean<QuestionBean> getPublishedByPageAndUid(int page, int userid){return questionDao.getPublishedByPageAndUid(page,userid);}
    public void setBestAnswer(int qid,int aid){questionDao.setBestAnswer(qid,aid);}
    public void updateIntegral(int quserid,int auserid,int qid){questionDao.updateIntegral(quserid,auserid,qid);}
    public void sendBestMessage(int send_userid,int rece_userid,int qid){questionDao.sendBestMessage(send_userid,rece_userid,qid);}
    public void addVisitCount(int qid){questionDao.addVisitCount(qid);}
    public List<Map<String,Object>> getLeastQuestions(){return questionDao.getLeastQuestions();}
    public List<Map<String,Object>> getHotQuestions(){return questionDao.getHotQuestions();}
    public int getUserIdByQid(int qid){return questionDao.getUserIdByQid(qid);}
    public List<Map<String, Object>> getUnLoginQuestions(){return questionDao.getUnLoginQuestions();}
    public List<Map<String, Object>> getLoginQuestions(int userid){return questionDao.getLoginQuestions(userid);}
    public int getLastQid(){return questionDao.getLastQid();}
}
