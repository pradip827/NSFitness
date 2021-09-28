package com.nsfitness.ns_splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Besic extends AppCompatActivity {

    int pStatus = 0;
    private Handler handler = new Handler();
    TextView tv,complite;
    CheckBox day1;
    RecyclerView dyasrecylear;
    ArrayList <String> Days_Array = new ArrayList<>();
    ArrayList<JSONArray> worklist;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beg__chest);

        getSupportActionBar().setTitle("Basic");
        complite=findViewById(R.id.complite);

        dyasrecylear=findViewById(R.id.dyasrecylear)  ;


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        dyasrecylear.setLayoutManager(mLayoutManager);
        dyasrecylear.setItemAnimator(new DefaultItemAnimator());
        worklist= new ArrayList<>();

        try {


            JSONObject json = new JSONObject(loadJSONFromAssets());
            JSONArray Days= json.getJSONArray("Days");

            Log.d("","Days"+Days.length());
            for(int i=0; i<Days.length() ; i++){


                JSONObject daysindex= Days.getJSONObject(i);
                String day=daysindex.getString("Day");
                Days_Array.add(day);
                Log.d("","Dssssays"+day);

                JSONArray work = daysindex.getJSONArray("work");
                worklist.add(work);
            }


            Log.d("","Dssssaysjjj"+Days_Array.size());

            WorkoutAdapter adapter= new WorkoutAdapter(Besic.this,Days_Array,worklist);
            dyasrecylear.setAdapter(adapter);


        }
        catch (Exception e)    {

        }


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
       // day1=findViewById(R.id.day1);

                // TODO Auto-generated method stub
//        day1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(day1.isChecked()) {
//                    pStatus = 20;
//                    Log.d("check","check1"+pStatus);
//                    handler.post(new Runnable() {
//
//                        @Override
//                        public void run() {
//                            // TODO Auto-generated method stub
//                            mProgress.setProgress(pStatus);
//                            tv.setText(pStatus + "%");
//                            complite.setText("You have Complited Your Excecary  "+pStatus+"%");
//
//
//                        }
//                    });
//
//                }
//                else{
//                    pStatus=2;
//
//                    handler.post(new Runnable() {
//
//                        @Override
//                        public void run() {
//                            // TODO Auto-generated method stub
//                            mProgress.setProgress(pStatus);
//                            tv.setText(pStatus + "%");
//                            complite.setText("You have Complited Your Excecary  "+pStatus+"%");
//
//
//                        }
//                    });
//                }
//            }
//        });



    }

    private String loadJSONFromAssets() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream is = getAssets().open("basicjson.json");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(is));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            bufferedReader.close();

            Log.d("X", "Response Ready:" + stringBuilder.toString());

            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
}