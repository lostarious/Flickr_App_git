package mert.android.com.flickr_app.interestinglist;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import mert.android.com.flickr_app.R;
import mert.android.com.flickr_app.databinding.InterestingListItemBinding;
import mert.android.com.flickr_app.photo_data.PhotoItem;

/**
 * Created by lostarious on 30.04.2018
 * Copyright (c) 2018 YGA to present
 * All rights reserved.
 */
public class DataViewAdapter extends BaseRecyclerAdapter<DataViewHolder, PhotoItem> {
    private RecyclerOnClickListener listener;

    //veri almayı vermeyi fragment idare edecegi için listeneri oradan al
    public DataViewAdapter(List<PhotoItem> mDataset, RecyclerOnClickListener listener) {
        super(mDataset);
        this.listener = listener;
    }

    //Yeni view oluştur
    @Override
    public DataViewHolder createView(ViewGroup parent, int viewType) {
        //contextten inflateri al
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //binding objesi oluştur
        InterestingListItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.interesting_list_item, parent, false);
        //bnding objesini viewholderin olarak return et
        binding.setOnClickListener(listener);
        return new DataViewHolder(binding);

    }

    //View içini doldur
    @Override
    public void bindView(DataViewHolder holder, int position) {
        holder.setItem(mDataSet.get(position));
    }


    @Override
    public int getItemCount() {
        return this.mDataSet.size();
    }

    //onclicklistener interface oluştur
    //  11.05.2018 interface, class isimleri buyuk harfle baslat
    public interface RecyclerOnClickListener {
        void itemClicked(PhotoItem clickedItem);
    }

    // 11.05.2018 Generic isim problemi
    // 11.05.2018 Farkli bir folderin altinda tanimlayalim


}
