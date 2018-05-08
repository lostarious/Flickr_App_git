package mert.android.com.flickr_app;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import mert.android.com.flickr_app.databinding.InterestingListItemBinding;
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
    ;
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
        //contextten inflateri al
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //binding objesi oluştur
        InterestingListItemBinding binding = DataBindingUtil.inflate(layoutInflater,R.layout.interesting_list_item,parent,false);
        //bnding objesini viewholderin olarak return et
        return new ViewHolder(binding);
    }
    //View içini doldur
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mBinding.setDisplayedItem(mDataset.getPhoto().get(position));
        //Picasso implementasyonu
        ///imageview run edilmeden önce match_parent ile getWidth ve getHeight kullanamayacağımız için picassoyu böyle implemente et
        holder.mBinding.ivPlaceHolder.post(new Runnable() {
            @Override
            public void run() {
                Picasso.get().load(sourceUrlConstructor(
                        Integer.toString(holder.mBinding.getDisplayedItem().getFarm()),
                        holder.mBinding.getDisplayedItem().getServer(),
                        holder.mBinding.getDisplayedItem().getId(),
                        holder.mBinding.getDisplayedItem().getSecret(),
                        "m"
                )).resize(holder.mBinding.ivPlaceHolder.getWidth(),holder.mBinding.ivPlaceHolder.getHeight()).into(holder.mBinding.ivPlaceHolder);
            }
        });

        //DONE
        //Oncelikle elinde view holder objesi var
        // orada bu isi yapman gerekiyor.
        // Oraya gectikten sonra ise; ilk yontem klasik olan,
        // findViewById üzerinden viewlari tanimlayip, islem yapacaksin.
        // 2. yontem ise DataBinding ile interesting_list_item'in icine
        // PhotoItem'i variable olarak tanimlayip burada sadece binding.setPhoto(...) yapacaksin
        //TODO(10) Onclicklisteneri databinding kısmına nasıl gömebilirim?
        holder.mBinding.ivPlaceHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.itemClicked(holder.mBinding.getDisplayedItem());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.getPerpage();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //her VH nin kendi bindingi olacağı için member
        InterestingListItemBinding mBinding;
        public ViewHolder(InterestingListItemBinding binding){
            super(binding.getRoot());
            mBinding = binding;
        }
    }
    //Picasso load için url constructor
    private String sourceUrlConstructor(String farm_id, String server_id, String id, String secret, String size){
        StringBuilder builder = new StringBuilder();
        builder.append("https://farm")
                .append(farm_id)
                .append(".staticflickr.com/")
                .append(server_id)
                .append("/")
                .append(id)
                .append("_")
                .append(secret)
                .append("_")
                .append(size)
                .append(".jpg");
        return builder.toString();
    }

}
