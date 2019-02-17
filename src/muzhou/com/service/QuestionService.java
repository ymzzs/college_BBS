package muzhou.com.service;

import muzhou.com.bean.PageBean;
import muzhou.com.bean.QuestionBean;

import java.util.List;
import java.util.Map;


public interface QuestionService {
    public void addQuestion(QuestionBean question);
    public List<QuestionBean> getAllQuestion();
    public QuestionBean getQuestionBySearch(String keyword,String title,String content);
    public QuestionBean getQuestionById(int qid);
    public void deleteQuestionById(int Qid);
    public PageBean<QuestionBean> getQuestionByPage(int page);
    public PageBean<QuestionBean> getQuestionByPageAndSolved(int page,int solved);
    public PageBean<QuestionBean> getQuestionByPageAndSolvedAndMajor(int page,int solved,String major);
    public PageBean<QuestionBean> getPublishedByPageAndUid(int page, int userid);
    public void setBestAnswer(int qid,int aid);
    public void updateIntegral(int quserid,int auserid,int qid);
    public void sendBestMessage(int send_userid,int rece_userid,int qid);
    public void addVisitCount(int qid);
    public List<Map<String,Object>> getLeastQuestions();
    public List<Map<String,Object>> getHotQuestions();
    public int getUserIdByQid(int qid);
    public List<Map<String, Object>> getUnLoginQuestions();
    public List<Map<String, Object>> getLoginQuestions(int userid);
    public int getLastQid();
}
