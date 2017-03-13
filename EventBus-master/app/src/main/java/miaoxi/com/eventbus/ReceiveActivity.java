package miaoxi.com.eventbus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Author: 张智远  PC:MZ
 * Time: 2017/1/13 9:45
 * Email: 826680069@qq.com
 * Instruction: please enter class instruction here
 */
public class ReceiveActivity extends AppCompatActivity {
    public Button btnRes;
    public TextView txtMsg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receive_layout);
        btnRes = (Button) findViewById(R.id.btnRes);
        txtMsg = (TextView) findViewById(R.id.txtMsg);
        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().register(ReceiveActivity.this);


            }
        });

    }

        @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void MsgReceive(MsgEvent event) {
        txtMsg.setText(event.getName() + event.getAge());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
