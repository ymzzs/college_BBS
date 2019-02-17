package muzhou.com.dao.daoImpl;

import muzhou.com.bean.CommentBean;
import muzhou.com.dao.CommentDao;

import java.util.List;
import java.util.Map;

public class CommentDaoImpl extends DAO<CommentBean> implements CommentDao {
    public void addComment(CommentBean comment){
        String sql = "INSERT INTO comment(userid,qid,aid,recid,content,likeCount,dislikeCount,visible) values(?,?,?,?,?,?,?,?)";
        System.out.println("addComment()");
        update(sql,comment.getUserId(),comment.getQid(),comment.getAid(),comment.getRecId(),comment.getContent(),comment.getLikeCount(),comment.getDislikeCount(),comment.getVisible());
    }
    public CommentBean getComment(String keywords){
        /**
         *
         *
         * 此处尚未添加查询代码！！！
         *
         *
         */
        return null;
    }//用于查询

    public CommentBean getCommentById(int uid){
        String sql = "SELECT * FROM comment WHERE userid = ?";
        return get(sql,uid);
    }; //用于查询用户所属的

    public List<Map<String,Object>> getCommentInfByAid(int aid)
    {
        String sql = "SELECT c.cid,c.aid,c.content,c.time,c.likeCount,c.dislikeCount,c.visible,u.username,u.userid,u.level,u.school,u.major FROM comment c,answer a,user u WHERE c.userid=u.userid and c.aid=a.aid and c.aid = ?";
        return getForMapList(sql,aid);
    }

    public List<Map<String,Object>> getCommentInfByQid(int qid)
    {
        String sql = "SELECT c.cid,c.aid,c.content,c.time,c.likeCount,c.dislikeCount,c.visible,u.username,u.userid,u.level FROM comment c,user u WHERE c.userid=u.userid and c.qid = ?";
        return getForMapList(sql,qid);
    }

    public void deleteComment(int Cid){
        String sql = "DELETE  FROM comment WHERE cid = ?";    //从answer表删除
        update(sql,Cid);
    }
}
