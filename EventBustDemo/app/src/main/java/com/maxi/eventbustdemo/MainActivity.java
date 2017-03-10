package com.maxi.eventbustdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.maxi.eventbustdemo.event.MgEvent;
import com.maxi.eventbustdemo.event.PersonalActivity;

import org.greenrobot.eventbus.EventBus;

/**
 * 在Activity页面放一个按钮,点击这个按钮会初始化当前页面一个人的身份信息,
 * 然后跳转到PersonActivity,用EventBus将这个人的信息展示在PersonActivity上,
 * 个人信息包括姓名,性别,年龄,生日,爱好.在PersonalActivity接收到上个Activity的信息后,toast一句话出来
 */

public class MainActivity extends AppCompatActivity {
    private Button btn_jump;
    public TextView txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_jump = (Button) findViewById(R.id.btn_jump);
        txtInfo = (TextView) findViewById(R.id.txtInfo);
        btn_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().postSticky(new MgEvent("小张","男",118,"1010","联盟"));
                Intent intent = new Intent(MainActivity.this, PersonalActivity.class);
                startActivity(intent);
//                if (EventBus.getDefault().isRegistered(this)) {
//                    return;
//                }
//                EventBus.getDefault().register(this);
            }
        });


    }

//    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
//    public void personInfo(AActiviity.PersonInfoEvent event){
////        String[] array, List<MsgEvent> msgEvent,List<String> strList
//        txtInfo.setText(event.getArray().toString()+event.getList().toString()+event.getStrList().toString());
//
//    }


//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        EventBus.getDefault().unregister(this);
//    }
}
