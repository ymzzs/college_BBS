package muzhou.com.dao;

import muzhou.com.bean.CollectionBean;
import muzhou.com.bean.PageBean;

import java.util.List;
import java.util.Map;

public interface CollectionDao {
    public void addCollection(CollectionBean collectionBean);
    public void deleteCollection(int qid,int userid);
    public List<CollectionBean> getCollectionByQid(int qid);
    public PageBean<Map<String,Object>> getCollectionByPageAndUserId(int page, int userid);
    public void sendCollectionMessage(int send_userid,int rece_userid,int qid);
}
