package muzhou.com.bean;

import java.sql.Timestamp;

public class QuestionBean {

    private int qid;
    private int userId;
    private String username;
    private String category;
    private String keyword;
    private String title;
    private String content;
    private Timestamp time;//
    private int integral;
    private int likeCount;
    private Timestamp lastAnswerTime;//
    private int answerCount;//
    private int visitCount;
    private int bestAid;
    private int solved = 0;
    private String visible;


    public int getSolved() {
        return solved;
    }

    public void setSolved(int solved) {
        this.solved = solved;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public int getQid() {
        return qid;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public int getIntegral() {
        return integral;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setBestAid(int bestAid) {
        this.bestAid = bestAid;
    }

    public int getBestAid() {
        return bestAid;
    }
    public void setLastAnswerTime(Timestamp lastAnswerTime) {
        this.lastAnswerTime = lastAnswerTime;
    }

    public Timestamp getLastAnswerTime() {
        return lastAnswerTime;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "QuestionBean{" +
                "qid=" + qid +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", category='" + category + '\'' +
                ", keyword='" + keyword + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", integral=" + integral +
                ", likeCount=" + likeCount +
                ", lastAnswerTime=" + lastAnswerTime +
                ", answerCount=" + answerCount +
                ", visitCount=" + visitCount +
                ", bestAid=" + bestAid +
                ", solved=" + solved +
                ", visible='" + visible + '\'' +
                '}';
    }
}
