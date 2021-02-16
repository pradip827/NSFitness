package com.nsfitness.ns_splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class NS_Home extends AppCompatActivity {
LinearLayout Besic,Beginer,Intermediate,Advance,Protin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_s__home);

        getSupportActionBar().hide();

        Besic = findViewById(R.id.Besic);
        Beginer =findViewById(R.id.Beginer);
        Intermediate =findViewById(R.id.Intermediate);
        Advance = findViewById(R.id.Advance);
        Protin = findViewById(R.id.Protin);



        Protin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(NS_Home.this,Protein_other.class);
                startActivity(newIntent);

            }
        });

        Besic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(NS_Home.this,Besic.class);
                startActivity(newIntent);

            }
        });
    }
}