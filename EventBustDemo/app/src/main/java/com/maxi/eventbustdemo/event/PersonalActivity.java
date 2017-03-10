package com.maxi.eventbustdemo.event;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.maxi.eventbustdemo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Author: 张智远  PC:MZ
 * Time: 2016/12/23 15:25
 * Email: 826680069@qq.com
 * Instruction: please enter class instruction here
 */
public class PersonalActivity extends AppCompatActivity {
    private Button btn_receive;
    private TextView tv_info;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persional);

        btn_receive = (Button) findViewById(R.id.btn_receive);
        tv_info = (TextView) findViewById(R.id.tv_infos);

        btn_receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EventBus.getDefault().register(PersonalActivity.this);

            }
        });

    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void receive(MgEvent event) {

        tv_info.setText(event.getName() + event.getSex() + event.getAge() + event.getBirthday() + event.getHappy());

        Toast.makeText(PersonalActivity.this, tv_info.getText().toString().trim(), Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
