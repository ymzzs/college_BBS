package muzhou.com.dao.daoImpl;

import muzhou.com.bean.PageBean;
import muzhou.com.bean.QuestionBean;
import muzhou.com.dao.QuestionDao;

import java.util.List;
import java.util.Map;

public class QuestionDaoImpl extends DAO<QuestionBean> implements QuestionDao {
    public void addQuestion(QuestionBean question) {
        System.out.println("插入数据成功");
        String sql = "INSERT INTO question(userid,username,category,keyword,title,content,integral,likeCount, visitCount, bestAid, visible,solved) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        update(sql, question.getUserId(), question.getUsername(), question.getCategory(), question.getKeyword(), question.getTitle(), question.getContent(), question.getIntegral(), question.getLikeCount(), question.getVisitCount(), question.getBestAid(), question.getVisible(), question.getSolved());
    }

    public List<QuestionBean> getAllQuestion() {

        return getForList("select * from question");
    }

    public QuestionBean getQuestionBySearch(String keyword, String title, String content) {

        String sql = "select * from question where keyword = " + keyword + " and title = " + title + " and content = " + content;
        return get(sql);
    }

    public PageBean<QuestionBean> getQuestionByPage(int page) {
        //创建pageBean
        PageBean<QuestionBean> pageBean = new PageBean<>();

        //设置totalCount
        String sql = "select count(*) from question";
        Long totalCount = getForValue(sql);
        pageBean.setTotalCount(totalCount);

        //设置总页数
        int totalPage = (int) (totalCount % pageBean.getPageCount() == 0 ? totalCount / pageBean.getPageCount() : totalCount / pageBean.getPageCount() + 1);
        pageBean.setTotalPage(totalPage);

        //设置当前页
        pageBean.setCurrentPage(page);

        //设置pageBean里的list数据【按积分从高到低排序】
        String sql1 = "select title,time,userid,integral,category,answerCount,visitCount,qid,username,keyword from question order by integral DESC limit ?,?";
        int start = (page - 1) * pageBean.getPageCount();
        List<QuestionBean> questionBeans = getForList(sql1, start, pageBean.getPageCount());
        pageBean.setList(questionBeans);
        return pageBean;
    }

    public PageBean<QuestionBean> getQuestionByPageAndSolved(int page, int solved) {
        //创建pageBean
        PageBean<QuestionBean> pageBean = new PageBean<>();

        //设置totalCount
        String sql = "select count(*) from question where solved = " + solved;
        Long totalCount = getForValue(sql);
        pageBean.setTotalCount(totalCount);

        //设置总页数
        int totalPage = (int) (totalCount % pageBean.getPageCount() == 0 ? totalCount / pageBean.getPageCount() : totalCount / pageBean.getPageCount() + 1);
        pageBean.setTotalPage(totalPage);

        //设置当前页
        pageBean.setCurrentPage(page);

        //设置pageBean里的list数据【按积分从高到低排序】
        String sql1 = "select title,userid,integral,category,answerCount,visitCount,qid,username,keyword,time from question where solved = " + solved + " order by integral DESC limit ?,?";
        int start = (page - 1) * pageBean.getPageCount();
        List<QuestionBean> questionBeans = getForList(sql1, start, pageBean.getPageCount());
        pageBean.setList(questionBeans);
        return pageBean;
    }

    public PageBean<QuestionBean> getQuestionByPageAndSolvedAndMajor(int page, int solved, String major) {
        //创建pageBean
        PageBean<QuestionBean> pageBean = new PageBean<>();
        System.out.println("我被调用了");
        //设置totalCount
        String sql = "select count(*) from question where solved = " + solved + " and category = " + "'" + major + "'";
        Long totalCount = getForValue(sql);
        pageBean.setTotalCount(totalCount);
        //设置总页数
        int totalPage = (int) (totalCount % pageBean.getPageCount() == 0 ? totalCount / pageBean.getPageCount() : totalCount / pageBean.getPageCount() + 1);
        pageBean.setTotalPage(totalPage);

        //设置当前页
        pageBean.setCurrentPage(page);

        //设置pageBean里的list数据【按积分从高到低排序】
        String sql1 = "select title,userid,integral,category,qid,answerCount,visitCount,username,keyword,time from question where solved = " + solved + " and category = " + "'" + major + "'" + " order by integral DESC limit ?,?";
        int start = (page - 1) * pageBean.getPageCount();
        List<QuestionBean> questionBeans = getForList(sql1, start, pageBean.getPageCount());
        pageBean.setList(questionBeans);
        return pageBean;
    }

    public QuestionBean getQuestionById(int qid) {
        String sql = "SELECT * FROM question WHERE qid = ?";
        return get(sql, qid);
    }

    ;//用于查询用户所属的

    public void deleteQuestion(int Qid) {
        String sql = "DELETE  FROM question WHERE qid = ?";    //从question表删除
        update(sql, Qid);
    }

    public PageBean<QuestionBean> getPublishedByPageAndUid(int page, int userid) {
        //创建pageBean
        PageBean<QuestionBean> pageBean = new PageBean<>();

        //设置totalCount
        String sql = "select count(*) from question where userid = ?";
        Long totalCount = getForValue(sql, userid);
        pageBean.setTotalCount(totalCount);

        //设置总页数
        int totalPage = (int) (totalCount % pageBean.getPageCount() == 0 ? totalCount / pageBean.getPageCount() : totalCount / pageBean.getPageCount() + 1);
        pageBean.setTotalPage(totalPage);

        //设置当前页
        pageBean.setCurrentPage(page);

        //设置pageBean里的list数据【按积分从高到低排序】
        String sql1 = "select title,integral,answerCount,category,visitCount,qid,solved,keyword,time from question where userid = ? order by integral DESC limit ?,?";
        int start = (page - 1) * pageBean.getPageCount();
        List<QuestionBean> questionBeans = getForList(sql1, userid, start, pageBean.getPageCount());
        pageBean.setList(questionBeans);
        return pageBean;
    }

    public void setBestAnswer(int qid, int aid) {
        String sql = "update question set bestAid = ? , solved = 1 where qid = ?";
        update(sql, aid, qid);
    }
    public void updateIntegral(int quserid,int auserid,int qid)
    {
        String qintegral = "select integral from question where qid = ?";
        int qintegral1 = (int)getForValue(qintegral,qid);

        String sql = "update user set integral = (integral - "+qintegral1+") where userid = ?";
        update(sql,quserid);

        String sql1 = "update user set integral = (integral + "+qintegral1+") where userid = ?";
        update(sql1,auserid);
    }

    public void sendBestMessage(int send_userid,int rece_userid,int qid)
    {
        String sql = "insert into message(send_userid,rece_userid,type,qid) values(?,?,'best',?)";
        update(sql,send_userid,rece_userid,qid);
    }

    public void addVisitCount(int qid) {
        String sql = "update question set visitCount = visitCount + 1 where qid = ?";
        update(sql, qid);
    }

    public List<Map<String, Object>> getLeastQuestions() {
        String sql = "select qid,username,userid,visitCount,answerCount,title,integral,time from question order by time desc limit 10";
        return getForMapList(sql);
    }

    public List<Map<String, Object>> getHotQuestions() {
        String sql = "select qid,username,userid,visitCount,answerCount,title,integral,time from question order by answerCount desc limit 10";
        return getForMapList(sql);
    }

    public List<Map<String, Object>> getUnLoginQuestions() {
        String sql = "select qid,username,userid,visitCount,answerCount,keyword,category,title,integral,time from question where bestAid!=0 order by answerCount desc limit 10";
        return getForMapList(sql);
    }
    public List<Map<String, Object>> getLoginQuestions(int userid) {

        String sql1 = "select major from user where userid = ?";
        String category = getForValue(sql1,userid);
        String sql = "select qid,username,userid,visitCount,answerCount,keyword,category,title,integral,time from question where category = ?  order by answerCount desc limit 10 ";
        List<Map<String,Object>> list =  getForMapList(sql,category);
        if ( list==null||list.size() == 0)
        {
            String sql2 = "select qid,username,userid,visitCount,answerCount,keyword,category,title,integral,time from question where bestAid!=0 order by visitCount desc limit 10";
            list = getForMapList(sql2);
        }
        return list;
    }

    public int getUserIdByQid(int qid)
    {
        String sql = "select userid from question where qid = ?";
        return getForValue(sql,qid);
    }

    public int getLastQid()
    {
        String sql = "select max(qid) from question";
        return getForValue(sql);
    }

}
