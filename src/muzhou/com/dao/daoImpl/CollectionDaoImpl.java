package muzhou.com.dao.daoImpl;

import muzhou.com.bean.CollectionBean;
import muzhou.com.bean.CommentBean;
import muzhou.com.bean.PageBean;
import muzhou.com.bean.QuestionBean;
import muzhou.com.dao.CollectionDao;

import java.util.List;
import java.util.Map;

public class CollectionDaoImpl extends DAO<CollectionBean> implements CollectionDao {

    public void addCollection(CollectionBean collectionBean)
    {
        String sql = "insert into collection(userid,qid) values(?,?)";
        update(sql,collectionBean.getUserid(),collectionBean.getQid());
    }
    public void deleteCollection(int qid,int userid)
    {
        String sql = "delete from collection where qid = ? and userid = ?";
        update(sql,qid,userid);
    }
    public List<CollectionBean> getCollectionByQid(int qid)
    {
        String sql = "select * from collection where qid = ?";
        return  getForList(sql,qid);
    }
    public PageBean<Map<String,Object>> getCollectionByPageAndUserId(int page,int userid)
    {
        //创建pageBean
        PageBean<Map<String,Object>> pageBean = new PageBean<>();

        //设置totalCount
        String sql = "select count(*) from collection where userid = ?";
        Long totalCount = getForValue(sql,userid);
        pageBean.setTotalCount(totalCount);

        //设置总页数
        int totalPage = (int)(totalCount % pageBean.getPageCount() == 0 ? totalCount / pageBean.getPageCount() : totalCount / pageBean.getPageCount() + 1);
        pageBean.setTotalPage(totalPage);

        //设置当前页
        pageBean.setCurrentPage(page);

        //设置pageBean里的list数据【按积分从高到低排序】
        String sql1 = "SELECT c.colid,q.userid,c.qid,c.time,q.title,q.username,q.qid,q.title,q.integral FROM collection c,question q WHERE c.qid=q.qid and c.userid = ? order by time DESC limit ?,?";
        int start = (page - 1) * pageBean.getPageCount();
        List<Map<String,Object>>collections = getForMapList(sql1,userid,start,pageBean.getPageCount());
        pageBean.setList(collections);
        return pageBean;
    }

    public void sendCollectionMessage(int send_userid,int rece_userid,int qid)
    {
        String sql = "insert into message(send_userid,rece_userid,type,qid) values(?,?,'collection',?)";
        update(sql,send_userid,rece_userid,qid);
    }
}
