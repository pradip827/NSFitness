package com.nsfitness.ns_splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Basic extends AppCompatActivity {

    int pStatus = 0;
    private Handler handler = new Handler();
    TextView tv,complite,Exc1;
    View view1,view2;
    int viewHeight=0,width=6;
    LinearLayout viewLay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beg__chest);

        getSupportActionBar().setTitle("Chest");
        complite=findViewById(R.id.complite);
        view1=findViewById(R.id.view1);
        view2=findViewById(R.id.view2);
        Exc1=findViewById(R.id.Exc1);
        viewLay=findViewById(R.id.viewLay);

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (viewHeight < 110) {
                    viewHeight += 5;

                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            //mProgress.setProgress(pStatus);
                            //tv.setText(pStatus + "%");
                            //complite.setText("You have Complited Your Excecary  "+pStatus+"%");
                            LinearLayout.LayoutParams layoutParams =new LinearLayout.LayoutParams(width,viewHeight);
                            layoutParams.height = viewHeight;
                            //layoutParams.width = (1);
                            viewLay.setLayoutParams(layoutParams);
                            layoutParams.setMargins(19, 0, 0, 0);
                            viewLay.setLayoutParams(layoutParams);




                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        // Just to display the progress slowly
                        Thread.sleep(1000); //thread will take approx 1.5 seconds to finish
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        /*Exc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });*/

        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.progress);
        final ProgressBar mProgress = (ProgressBar) findViewById(R.id.circularProgressbar);
        mProgress.setProgress(0);   // Main Progress
        mProgress.setSecondaryProgress(100); // Secondary Progress
        mProgress.setMax(100); // Maximum Progress
        mProgress.setProgressDrawable(drawable);

      /*  ObjectAnimator animation = ObjectAnimator.ofInt(mProgress, "progress", 0, 100);
        animation.setDuration(50000);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();*/

        tv = (TextView) findViewById(R.id.tv);
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (pStatus < 100) {
                    pStatus += 1;

                    handler.post(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            mProgress.setProgress(pStatus);
                            tv.setText(pStatus + "%");
                            complite.setText("You have Complited Your Excecary  "+pStatus+"%");


                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        // Just to display the progress slowly
                        Thread.sleep(3000); //thread will take approx 1.5 seconds to finish
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
