package com.hesheng.myapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private RelativeLayout activity_main;
    private Button btn;
    private PaintView dw;
    private Boolean f = false;
    final Handler handler = new Handler();
    Runnable runnable = new Runnable() {

        @Override
        public void run() {
            // handler自带方法实现定时器
            try {
                handler.postDelayed(this, 10);
                btn.setText((dw.getPx() + 200)  + ", " + (dw.getPy() + 600));
                System.out.println((dw.getPx() + 200)  + ", " + (dw.getPy() + 600));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("exception...");
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity_main = (RelativeLayout) findViewById(R.id.activity_main);
        img = (ImageView) findViewById(R.id.img);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (f) {
                    dw.stop();
                    f = false;
                }else{
                    dw.start();
                    f = true;
                }

            }
        });
        dw = new PaintView(this);
        activity_main.addView(dw);
//        dw.start();
        handler.postDelayed(runnable,10);

    }
}
