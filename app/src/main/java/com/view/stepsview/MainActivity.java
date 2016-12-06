package com.view.stepsview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private float eventX = 0.0f;
//    private float eventY = 0.0f;

    private StepsView stepsView;
    private Button btn_next, btn_back, btn_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stepsView = (StepsView) findViewById(R.id.stepsView);
        stepsView.setTitle(new String[]{"填写邮箱", "验证邮箱", "填写密码", "完善个人信息"});
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_reset = (Button) findViewById(R.id.btn_reset);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stepsView.next();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stepsView.back();
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stepsView.reset();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //获取手指在屏幕上的坐标
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN://按下
                eventX = event.getX();
//                eventY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE://移动
                break;
            case MotionEvent.ACTION_UP://松开
                if (event.getX() - eventX > 0) {
                    Log.e("sss", "右");
                    stepsView.back();
                } else if (event.getX() - eventX < 0) {
                    Log.e("sss", "左");
                    stepsView.next();
                }
                break;
        }
        return true;
    }
}
