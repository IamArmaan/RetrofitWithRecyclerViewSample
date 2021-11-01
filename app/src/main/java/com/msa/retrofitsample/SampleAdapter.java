package com.msa.retrofitsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.MyViewHolder> {

    List<SamplePojo> samplePojoList;
    Context context;


    public SampleAdapter(Context context ,List<SamplePojo> samplePojoList) {
        this.context =  context;
        this.samplePojoList = samplePojoList;
    }

    @NonNull
    @Override
    public SampleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SampleAdapter.MyViewHolder holder, int position) {

        holder.tv_title.setText(samplePojoList.get(position).getTitle());



    }

    @Override
    public int getItemCount() {
        return samplePojoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title =  itemView.findViewById(R.id.title);
        }
    }
}
