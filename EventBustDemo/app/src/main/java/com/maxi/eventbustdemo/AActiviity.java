package com.maxi.eventbustdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: 张智远  PC:MZ
 * Time: 2016/12/23 14:07
 * Email: 826680069@qq.com
 * Instruction: please enter class instruction here
 */
public class AActiviity extends Activity {
    public Button btn_put;
    public Button btn_put2;

    String [] array=new String[]{"張志遠","男","23歲","Android"};
    List<MsgEvent> mList;
    List<String> strList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a);
        btn_put = ((Button) findViewById(R.id.btn_send));
        btn_put2 = ((Button) findViewById(R.id.btn_send2));
        mList = new ArrayList<>();
        strList= new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            MsgEvent event = new MsgEvent(i,"張志遠"+i);
        }
        for (int i = 0; i < 4; i++) {
            strList.add("test data" +i);
        }

        btn_put.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EventBus.getDefault().postSticky(new PersonInfoEvent(array,mList,strList));

//                EventBus.getDefault().postSticky(new MsgEvent(23,"张智远"));
//                EventBus.getDefault().post(new MsgEvent());
                Intent intent = new Intent(AActiviity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btn_put2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().postSticky(new MsgEvent(23,"zhang"));
                Intent intent=new Intent(AActiviity.this,BActiviity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


public class PersonInfoEvent{
        String [] array;
    List<MsgEvent> mList;
    List<String> strList;

    public PersonInfoEvent(String[] array, List<MsgEvent> list, List<String> strList) {
        this.array = array;
        mList = list;
        this.strList = strList;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public List<MsgEvent> getList() {
        return mList;
    }

    public void setList(List<MsgEvent> list) {
        mList = list;
    }

    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }
}

}
