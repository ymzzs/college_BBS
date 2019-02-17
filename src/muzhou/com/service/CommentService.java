package muzhou.com.service;

import muzhou.com.bean.CommentBean;

import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.Map;

public interface CommentService {
    public void addComment(CommentBean comment);
    public CommentBean getCommentByKeywords(String keywords);
    public CommentBean getCommentById(int uid);
    public void deleteCommentById(int Cid);
    public List<Map<String,Object>> getCommentInfByAid(int aid);
    public List<Map<String,Object>> getCommentInfByQid(int qid);
}
