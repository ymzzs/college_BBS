package muzhou.com.service.serviceImpl;

import muzhou.com.bean.CommentBean;
import muzhou.com.service.CommentService;

import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.Map;

public class CommentServiceImpl extends BaseService implements CommentService {
    public void addComment(CommentBean comment){
        commentDao.addComment(comment);
    }
    public CommentBean getCommentByKeywords(String keywords){
        return commentDao.getComment(keywords);
    }
    public CommentBean getCommentById(int uid){
        return commentDao.getCommentById(uid);
    }
    public void deleteCommentById(int Cid){
        commentDao.deleteComment(Cid);
    }
    public List<Map<String,Object>> getCommentInfByAid(int aid){return commentDao.getCommentInfByAid(aid);}
    public List<Map<String,Object>> getCommentInfByQid(int qid){ return commentDao.getCommentInfByQid(qid);}
}
