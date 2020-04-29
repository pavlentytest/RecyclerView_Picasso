package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<Image> android_versions;
    private Context context;

    public DataAdapter(Context context, ArrayList<Image> android_versions) {
        this.context = context;
        this.android_versions = android_versions;

    }
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tv_android.setText(android_versions.get(i).getImage_name());
        Picasso.with(context).load(android_versions.get(i).getImage_url()).resize(128, 128).into(viewHolder.img_android);
    }

    @Override
    public int getItemCount() {
        return android_versions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_android;
        ImageView img_android;
        public ViewHolder(View view) {
            super(view);

            tv_android = view.findViewById(R.id.tv_android);
            img_android = view.findViewById(R.id.img_android);
        }
    }
}