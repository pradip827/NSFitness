package com.nsfitness.ns_splash;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.MyViewHolder> {

    Context context;
    ArrayList<String> days_array,name,time,sets;
    ArrayList<JSONArray> work;

    public WorkoutAdapter(Besic context, ArrayList<String> days_array, ArrayList<JSONArray> work) {

        this.context=context;
        this.days_array=days_array;
        this.work=work;
        this.time=new ArrayList<>();
        this.name=new ArrayList<>();
        this.sets=new ArrayList<>();

    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.daysitem, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.dayno.setText(days_array.get(position));
        holder.dayno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Log.d("","ada"+work.get(position).length());
                try {
                    name.clear();
                    time.clear();
                    sets.clear();

                    for (int i = 0; i < work.get(position).length(); i++) {

                        JSONObject obj = work.get(position).getJSONObject(i);
                        String n= String.valueOf(obj.get("name"));
                        String T= String.valueOf(obj.get("Time"));
                        String S= String.valueOf(obj.get("sets"));



                        name.add(n);
                        time.add(T);
                        sets.add(S);
                        Log.d("","print"+i);



                    }
                    WorkListAdapter adapter= new WorkListAdapter(context,name,time,sets);
                    holder.workrecylear.setAdapter(adapter);
                    if(holder.workrecylear.getVisibility()==View.VISIBLE){
                        holder.workrecylear.setVisibility(View.GONE);
                    }
                    else{
                        holder.workrecylear.setVisibility(View.VISIBLE);
                    }

                }
                catch (Exception e){

                }

            }
        });

    }

    @Override
    public int getItemCount() {
        Log.d("","testdata"+days_array.size());
        return days_array.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView dayno;
        CheckBox allselceted;
        RecyclerView workrecylear;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            dayno=itemView.findViewById(R.id.dayno);
            allselceted=itemView.findViewById(R.id.allselceted);


            workrecylear=itemView.findViewById(R.id.workrecylear);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
            workrecylear.setLayoutManager(mLayoutManager);
            workrecylear.setItemAnimator(new DefaultItemAnimator());


        }
    }

}
