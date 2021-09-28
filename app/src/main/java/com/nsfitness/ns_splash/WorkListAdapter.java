package com.nsfitness.ns_splash;

import android.content.Context;
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

import java.util.ArrayList;

public class WorkListAdapter extends RecyclerView.Adapter<WorkListAdapter.MyViewHolder>{
    //ArrayList<JSONArray> work;
    Context context;
    ArrayList <String> name,time,sets;

    public WorkListAdapter(Context context, ArrayList<String> name, ArrayList<String> time, ArrayList<String> sets) {
        this.context=context;
        this.name=name;
        this.time=time;
        this.sets=sets;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.basicworkitem, parent, false);
        return new WorkListAdapter.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.Exc.setText(name.get(position));
    holder.time.setText(time.get(position));
    holder.sets.setText(sets.get(position));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Exc,time,sets;
        CheckBox allselceted;
        RecyclerView workrecylear;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Exc=itemView.findViewById(R.id.Exc);
            time=itemView.findViewById(R.id.time);
            sets=itemView.findViewById(R.id.sets);
          //  allselceted=itemView.findViewById(R.id.allselceted);



        }
    }

}
