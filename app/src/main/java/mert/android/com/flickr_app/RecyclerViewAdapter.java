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
    //onclicklistener interface oluştur
    public  interface  recyclerOnClickListener{
        void itemClicked(PhotoItem clickedItem);
    }
    //veri almayı vermeyi fragment idare edecegi için listeneri oradan al
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
        //TODO(1) Daha iyi nasıl yapılabilir?


        //TODO(1-CEVAP)Oncelikle elinde view holder objesi var orada bu isi yapman gerekiyor. Oraya gectikten sonra ise; ilk yontem klasik olan, findViewById üzerinden viewlari tanimlayip, islem yapacaksin. 2. yontem ise DataBinding ile interesting_list_item'in icine PhotoItem'i variable olarak tanimlayip burada sadece binding.setPhoto(...) yapacaksin
        holder.tvContent.setText(mDataset.getPhoto().get(position).getOwner());
        ((TextView)holder.mLinearLayout.getChildAt(3)).setText(mDataset.getPhoto().get(position).getTitle());
        ((TextView)holder.mLinearLayout.getChildAt(1)).setText(mDataset.getPhoto().get(position).getId());
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
        public final TextView tvContent;
        LinearLayout mLinearLayout;

        public ViewHolder(ViewGroup v){
            super(v);
            mLinearLayout = (LinearLayout) v;
            tvContent = v.findViewById(R.id.tv_list_item_id);

        }
    }


}
