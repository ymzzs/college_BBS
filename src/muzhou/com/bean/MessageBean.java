package muzhou.com.bean;

import java.sql.Timestamp;

public class MessageBean {

    private int mid;
    private int send_userid;
    private int rece_userid;
    private String type;
    private int qid;
    private Timestamp time;

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getSend_userid() {
        return send_userid;
    }

    public void setSend_userid(int send_userid) {
        this.send_userid = send_userid;
    }

    public int getRece_userid() {
        return rece_userid;
    }

    public void setRece_userid(int rece_userid) {
        this.rece_userid = rece_userid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return "MessageBean{" +
                "mid=" + mid +
                ", send_userid=" + send_userid +
                ", rece_userid=" + rece_userid +
                ", type='" + type + '\'' +
                ", qid=" + qid +
                ", time=" + time +
                '}';
    }
}
