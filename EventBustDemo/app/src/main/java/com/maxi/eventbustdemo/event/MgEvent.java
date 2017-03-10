package com.maxi.eventbustdemo.event;

/**
 * Author: 张智远  PC:MZ
 * Time: 2016/12/23 15:27
 * Email: 826680069@qq.com
 * Instruction: 在Activity页面放一个按钮,点击这个按钮会初始化当前页面一个人的身份信息,
 * 然后跳转到PersonActivity,用EventBus将这个人的信息展示在
 * PersonActivity上,个人信息包括姓名,性别,年龄,生日,爱好.
 * 在PersonalActivity接收到上个Activity的信息后,toast一句话出来
 */
public class MgEvent {
    private int age;
    private String birthday;
    private String happy;
    private String name;
    private String sex;

    public MgEvent(String name, String sex, int age, String birthday, String happy) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
        this.happy = happy;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHappy() {
        return happy;
    }

    public void setHappy(String happy) {
        this.happy = happy;
    }


}
