package muzhou.com.bean;

import java.sql.Timestamp;

public class FollowBean {

    private int fid;
    private int userid;
    private int followed_userid;
    private Timestamp time;
    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getFollowed_userid() {
        return followed_userid;
    }

    public void setFollowed_userid(int followed_userid) {
        this.followed_userid = followed_userid;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "FollowBean{" +
                "fid=" + fid +
                ", userid=" + userid +
                ", followed_userid=" + followed_userid +
                ", time=" + time +
                '}';
    }
}
