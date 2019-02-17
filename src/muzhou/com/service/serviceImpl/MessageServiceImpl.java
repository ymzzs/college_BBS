package muzhou.com.service.serviceImpl;

import muzhou.com.bean.MessageBean;
import muzhou.com.service.MessageService;

import java.util.List;
import java.util.Map;

public class MessageServiceImpl extends BaseService implements MessageService {

    public List<Map<String, Object>> getMessageList(int userid){return messageDao.getMessageList(userid);}
    public void delMessageByMid(int mid){messageDao.delMessageByMid(mid);}
    public void delMessageBySidAndRidAndType(int send_userid,int rece_userid,String type){messageDao.delMessageBySidAndRidAndType(send_userid,rece_userid,type);}
    public long getMessageCount(int userid){return messageDao.getMessageCount(userid);}

}
