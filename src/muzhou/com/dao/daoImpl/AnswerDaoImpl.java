package muzhou.com.dao.daoImpl;

import muzhou.com.bean.AnswerBean;
import muzhou.com.bean.PageBean;
import muzhou.com.bean.QuestionBean;
import muzhou.com.dao.AnswerDao;

import java.util.List;
import java.util.Map;

public class AnswerDaoImpl extends DAO<AnswerBean> implements AnswerDao {
    public void addAnswer(AnswerBean answer){
        String sql = "INSERT INTO answer(userid,qid,content,likeCount,dislikeCount,visible,likedUserId,dislikedUserId) values(?,?,?,?,?,?,?,?)";
        update(sql,answer.getUserId(),answer.getQid(),answer.getContent(),answer.getLikeCount(),answer.getDislikeCount(),answer.getVisible(),answer.getLikedUserId(),answer.getDislikedUserId());
    }
    public AnswerBean getAnswer(String keywords){
        /**
         *
         *
         * 此处尚未添加查询代码！！！
         *
         *
         *
         */
        return null;
    }
    public List<Map<String,Object>> getAnswerInfByQid(int qid)
        {
        String sql = "SELECT a.aid,a.content,a.time,a.likeCount,a.dislikeCount,a.visible,a.likedUserId,a.dislikedUserId,u.head,u.username,u.userid,u.level,u.school,u.major,q.bestAid FROM answer a,question q,user u WHERE a.userid=u.userid and a.qid=q.qid and a.qid = ? order by (a.likeCount-a.dislikeCount) DESC";
        return getForMapList(sql,qid);
    }
    public List<AnswerBean> getAnswerByUid(int uid){
        String sql = "SELECT * FROM answer WHERE userid = ?";
        return getForList(sql,uid);
    }; //用于查询用户所属的
    public AnswerBean getAnswerByAid(int aid)
    {
        String sql = "SELECT * FROM answer WHERE aid = ?";
        return get(sql,aid);
    }
    public void deleteAnswer(int Aid){
        String sql = "DELETE  FROM answer WHERE aid = ?";    //从answer表删除
        update(sql,Aid);
    }
    public void updateLikeCount(int aid,int newtotal)
    {
        String sql = "UPDATE answer set likeCount=? where aid=?";
        update(sql,newtotal,aid);
    }
    public void updateDislikeCount(int aid,int newtotal)
    {
        String sql = "UPDATE answer set dislikeCount= ? where aid=?";
        update(sql,newtotal,aid);
    }
    public void addLikedUserId(int userid,int aid)
    {
        String sql = "update answer set likedUserId =CONCAT(likedUserId,',',"+userid+") where aid = ?";
        update(sql,aid);
    }
    public void addDisLikedUserId(int userid,int aid)
    {
        String sql = "update answer set dislikedUserId = CONCAT(dislikedUserId,',',"+userid+") where aid = ?";
        update(sql,aid);
    }
    public void deleteLikedUserId(int userid,int aid)
    {
        String sql = "update answer set likedUserId = REPLACE(likedUserId,',"+userid+"','') where aid = ?";
        update(sql,aid);
    }
    public void deleteDisLikedUserId(int userid,int aid)
    {
        String sql = "update answer set dislikedUserId = REPLACE(dislikedUserId,',"+userid+"','') where aid = ?";
        update(sql,aid);
    }

    public PageBean<Map<String,Object>> getMyAnswerByPageAndUid(int page, int userid)
    {
        //创建pageBean
        PageBean<Map<String,Object>> pageBean = new PageBean<>();

        //设置totalCount
        String sql = "select count(*) from answer where userid = ?";
        Long totalCount = getForValue(sql,userid);
        pageBean.setTotalCount(totalCount);

        //设置总页数
        int totalPage = (int)(totalCount % pageBean.getPageCount() == 0 ? totalCount / pageBean.getPageCount() : totalCount / pageBean.getPageCount() + 1);
        pageBean.setTotalPage(totalPage);

        //设置当前页
        pageBean.setCurrentPage(page);

        //设置pageBean里的list数据【按积分从高到低排序】
        String sql1 = "select a.aid,a.time,a.likeCount,q.qid,q.userid,q.title,q.category,q.username,q.integral from question q,answer a where a.qid = q.qid and a.userid = ? order by time DESC limit ?,?";
        int start = (page - 1) * pageBean.getPageCount();
        List<Map<String,Object>>myAnswer =  getForMapList(sql1,userid,start,pageBean.getPageCount());
        pageBean.setList(myAnswer);
        return pageBean;
    }

    public void sendAnswerMessage(int send_userid,int rece_userid,int qid)
    {
        String sql = "insert into message(send_userid,rece_userid,type,qid) values(?,?,'answer',?)";
        update(sql,send_userid,rece_userid,qid);
    }

    public int getUserIdByAid(int aid)
    {
        String sql = "select userid from answer where aid = ?";
        return getForValue(sql,aid);
    }


}
