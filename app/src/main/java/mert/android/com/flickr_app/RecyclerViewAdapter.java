package mert.android.com.flickr_app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import mert.android.com.flickr_app.photo_data.Photos;

/**
 * Created by lostarious on 30.04.2018
 * Copyright (c) 2018 YGA to present
 * All rights reserved.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Photos mDataset;

    public RecyclerViewAdapter(Photos mDataset) {
        this.mDataset = mDataset;
    }
    //Yeni view oluştur
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.interesting_list_item,parent,false);
        ViewHolder vh = new ViewHolder((LinearLayout)v);
        return vh;
    }
    //View içini doldur
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ((TextView)holder.mLinearLayout.getChildAt(1)).setText(mDataset.getPhoto().get(position).getId());
        ((TextView)holder.mLinearLayout.getChildAt(2)).setText(mDataset.getPhoto().get(position).getOwner());
        ((TextView)holder.mLinearLayout.getChildAt(3)).setText(mDataset.getPhoto().get(position).getDescription().getContent());
    }

    @Override
    public int getItemCount() {
        return 500;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout mLinearLayout;
        public ViewHolder(ViewGroup v){
            super(v);
            mLinearLayout = (LinearLayout) v;

        }
    }
}
