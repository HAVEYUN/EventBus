package miaoxi.com.eventbus;

/**
 * Author: 张智远  PC:MZ
 * Time: 2017/1/13 10:32
 * Email: 826680069@qq.com
 * Instruction: please enter class instruction here
 */
public class MsgEvent {
    private String name;
    private int age;

    public MsgEvent(String name, int age) {
        this.name = name;
        this.age = age;
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
}
