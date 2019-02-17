package muzhou.com.bean;

import java.sql.Timestamp;

public class CollectionBean {

    private int colid;
    private int userid;
    private int qid;
    private Timestamp time;
    public int getColid() {
        return colid;
    }

    public void setColid(int colid) {
        this.colid = colid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int aid) {
        this.qid = aid;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "CollectionBean{" +
                "colid=" + colid +
                ", userid=" + userid +
                ", Qid=" + qid +
                ", time=" + time +
                '}';
    }
}
