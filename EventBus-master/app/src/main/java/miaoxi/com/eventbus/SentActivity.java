package miaoxi.com.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

/**
 * Author: 张智远  PC:MZ
 * Time: 2017/1/13 9:45
 * Email: 826680069@qq.com
 * Instruction: please enter class instruction here
 */
public class SentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sent_layout);

        Button btnSent = (Button) findViewById(R.id.btnSent);
        btnSent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().postSticky(new MsgEvent("淼溪",1));
                Intent intent = new Intent(SentActivity.this, ReceiveActivity.class);
                startActivity(intent);
            }

        });


    }
}
