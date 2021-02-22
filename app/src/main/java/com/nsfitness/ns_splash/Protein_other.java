package com.nsfitness.ns_splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Protein_other extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protein_other);
        getSupportActionBar().setTitle("Protins");

        DataClass[] myListData = new DataClass[] {
                new DataClass("Email","1000","200", android.R.drawable.ic_dialog_email),
                new DataClass("Info","1000","200", android.R.drawable.ic_dialog_info),
                new DataClass("Delete","1000","200", android.R.drawable.ic_delete),
                new DataClass("Dialer","1000","200", android.R.drawable.ic_dialog_dialer),
                new DataClass("Alert","1000","200", android.R.drawable.ic_dialog_alert),
                new DataClass("Map","1000","200", android.R.drawable.ic_dialog_map),
                new DataClass("Email","1000","200", android.R.drawable.ic_dialog_email),
                new DataClass("Info","1000","200", android.R.drawable.ic_dialog_info),
                new DataClass("Delete","1000","200", android.R.drawable.ic_delete),
                new DataClass("Dialer", "1000","200",android.R.drawable.ic_dialog_dialer),
                new DataClass("Alert","1000","200", android.R.drawable.ic_dialog_alert),
                new DataClass("Test","1000","200", android.R.drawable.ic_dialog_map),
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(this,myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}