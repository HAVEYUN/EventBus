package com.maxi.eventbustdemo;

/**
 * Author: 张智远  PC:MZ
 * Time: 2016/12/23 14:27
 * Email: 826680069@qq.com
 * Instruction: please enter class instruction here
 */
public class MsgEvent {
    public MsgEvent(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;
    private  String name;
}
