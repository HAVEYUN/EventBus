package com.maxi.eventbustdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Author: 张智远  PC:MZ
 * Time: 2016/12/23 14:07
 * Email: 826680069@qq.com
 * Instruction: please enter class instruction here
 */
public class BActiviity extends Activity {
    private Button btn_receive_sticky;
    TextView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b);

        btn_receive_sticky = (Button) findViewById(R.id.btn_receive_sticky);
        mView = (TextView) findViewById(R.id.tv_info);


        btn_receive_sticky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (EventBus.getDefault().isRegistered(this)) {
                    return;
                }
                EventBus.getDefault().register(BActiviity.this);

            }
        });
    }


    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void receive(MsgEvent event) {
        mView.setText(event.getName() + event.getAge());
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }
}
