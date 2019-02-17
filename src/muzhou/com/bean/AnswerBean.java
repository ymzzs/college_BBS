package muzhou.com.bean;

import java.sql.Timestamp;

public class AnswerBean {

    private int aid;
    private int userId;
    private int qid;
    private String content;
    private Timestamp time;//
    private int likeCount;
    private int dislikeCount;
    private String visible;
    private String likedUserId = "";
    private String dislikedUserId = "";

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getLikedUserId() {
        return likedUserId;
    }

    public void setLikedUserId(String likedUserId) {
        this.likedUserId = likedUserId;
    }

    public String getDislikedUserId() {
        return dislikedUserId;
    }

    public void setDislikedUserId(String dislikedUserId) {
        this.dislikedUserId = dislikedUserId;
    }

    @Override
    public String toString() {
        return "AnswerBean{" +
                "aid=" + aid +
                ", userId=" + userId +
                ", qid=" + qid +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", likeCount=" + likeCount +
                ", dislikeCount=" + dislikeCount +
                ", visible='" + visible + '\'' +
                ", likedUserId='" + likedUserId + '\'' +
                ", dislikedUserId='" + dislikedUserId + '\'' +
                '}';
    }
}
