package mert.android.com.flickr_app;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import mert.android.com.flickr_app.photo_data.PhotoItem;
import mert.android.com.flickr_app.photo_data.Photos;

/**
 * Created by lostarious on 30.04.2018
 * Copyright (c) 2018 YGA to present
 * All rights reserved.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Photos mDataset;
    recyclerOnClickListener listener;
    public  interface  recyclerOnClickListener{
        void itemClicked(PhotoItem clickedItem);
    }
    public RecyclerViewAdapter(Photos mDataset,recyclerOnClickListener listener) {
        this.mDataset = mDataset;
        this.listener = listener;
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
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        ((TextView)holder.mLinearLayout.getChildAt(1)).setText(mDataset.getPhoto().get(position).getId());
        ((TextView)holder.mLinearLayout.getChildAt(2)).setText(mDataset.getPhoto().get(position).getOwner());
        ((TextView)holder.mLinearLayout.getChildAt(3)).setText(mDataset.getPhoto().get(position).getDescription().getContent());
        holder.mLinearLayout.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.itemClicked(mDataset.getPhoto().get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.getPerpage();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout mLinearLayout;
        public ViewHolder(ViewGroup v){
            super(v);
            mLinearLayout = (LinearLayout) v;

        }
    }


}
