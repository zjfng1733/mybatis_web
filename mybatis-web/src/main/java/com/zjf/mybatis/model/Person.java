package com.zjf.mybatis.model;

/**
 * Created by Administrator on 2017/9/29.
 */
public class Person {
    private int id;
    private String  userName;
    private String  gender1;
    private String mobilephone;

    public Person() {
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }



    public String getMobilephone() {
        return mobilephone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender1() {
        return gender1;
    }

    public void setGender1(String gender1) {
        this.gender1 = gender1;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", gender='" + gender1 + '\'' +
                ", mobilephone='" + mobilephone + '\'' +
                '}';
    }
}
