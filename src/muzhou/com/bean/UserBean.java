package muzhou.com.bean;

import java.sql.Timestamp;
import java.util.*;
import javax.xml.crypto.Data;

public class UserBean {

    private int userId;
    private String userName;
    private String passWord;
    private String email;
    private int level;
    private int integral = 50;
    private int contribute;
    private String school;
    private String major;
    private String telephone;
    private Timestamp birthday;
    private String sex;
    private String signature;
    private String head;
    private int signin;

    public int getSignin() {
        return signin;
    }

    public void setSignin(int signin) {
        this.signin = signin;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setContribute(int contribute) {
        this.contribute = contribute;
    }

    public int getContribute() {
        return contribute;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "userId:" + userId +
                ", userName:" +userName  +
                ", passWord:" + passWord  +
                ", email:" + email +
                ", level:" + level +
                ", integral:" + integral +
                ", contribute:" + contribute +
                ", school:" + school  +
                ", major:" + major +
                ", telephone:" + telephone  +
                ", birthday:" + birthday.toString() +
                ", sex:" + sex  +
                ", signature:" + signature +
                ", head:" + head+
                ", signin:" + signin +
                '}';
    }
}
