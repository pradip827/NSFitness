package com.nsfitness.ns_splash;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    private DataClass[] listdata;
Context context;

    public MyListAdapter(Protein_other protein_other, DataClass[] myListData) {
        this.context=protein_other;
        this.listdata=myListData;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;      }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DataClass DataClass = listdata[position];
        holder.Name.setText(listdata[position].getDescription());
        holder.Price.setText(listdata[position].getPrice());
        holder.Offer.setText(listdata[position].getOffer());
        holder.imageView.setImageResource(listdata[position].getImgId());
    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView Name,Price,Offer;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.Name = (TextView) itemView.findViewById(R.id.Name);
            this.Price=(TextView) itemView.findViewById(R.id.Price);
            this.Offer=(TextView) itemView.findViewById(R.id.Offer);
            Price.setPaintFlags(Price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
