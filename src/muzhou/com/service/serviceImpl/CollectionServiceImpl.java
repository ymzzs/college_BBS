package muzhou.com.service.serviceImpl;

import muzhou.com.bean.CollectionBean;
import muzhou.com.bean.PageBean;
import muzhou.com.service.CollectionService;

import java.util.List;
import java.util.Map;

public class CollectionServiceImpl extends BaseService implements CollectionService {

    public PageBean<Map<String,Object>> getCollectionByPageAndUserId(int page, int userid)
    {return collectionDao.getCollectionByPageAndUserId(page,userid);}
    public void addCollection(CollectionBean collectionBean)
    {
        collectionDao.addCollection(collectionBean);
    }
    public List<CollectionBean> getCollectionByQid(int qid){return collectionDao.getCollectionByQid(qid);}
    public void deleteCollection(int qid,int userid)
    {
        collectionDao.deleteCollection(qid,userid);
    }
    public void sendCollectionMessage(int send_userid,int rece_userid,int qid){collectionDao.sendCollectionMessage(send_userid,rece_userid,qid);}
}
