package muzhou.com.service;

import java.util.List;
import java.util.Map;

public interface MessageService {
    public List<Map<String, Object>> getMessageList(int userid);
    public void delMessageByMid(int mid);
    public void delMessageBySidAndRidAndType(int send_userid,int rece_userid,String type);
    public long getMessageCount(int userid);
}
