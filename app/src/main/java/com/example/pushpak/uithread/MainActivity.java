package com.example.pushpak.uithread;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler((Looper.getMainLooper()));
    }

    public void StartCounter(View view) {

        HandlerCounter();
    }

//    private void Counter() {
//
//
//        for (int i = 0; i < 100; i++) {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//
//        }
//    }
//
//    private void threadcounter() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Counter();
//            }
//        }).start();
//    }
    int i=0;
    private void HandlerCounter() {


        new  Thread(new Runnable() {
            @Override
            public void run() {

                for ( i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            ((TextView) findViewById(R.id.txtCentre)).setText(String.valueOf(i));
                        }
                    });
            }
        }



        }).start();
    }
}