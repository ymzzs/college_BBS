package muzhou.com.dao;

import muzhou.com.bean.CommentBean;

import java.util.List;
import java.util.Map;

public interface CommentDao {
    public void addComment(CommentBean comment);
    public CommentBean getComment(String keywords);//用于查询
    public CommentBean getCommentById(int uid); //用于查询用户所属的
    public void deleteComment(int Cid);
    public List<Map<String,Object>> getCommentInfByAid(int aid);
    public List<Map<String,Object>> getCommentInfByQid(int qid);
}
