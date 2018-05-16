package mert.android.com.flickr_app.interestinglist;

import android.support.v7.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import mert.android.com.flickr_app.databinding.InterestingListItemBinding;
import mert.android.com.flickr_app.photo_data.PhotoItem;

/**
 * Created by lostarious on 11.05.2018
 * Copyright (c) 2018 YGA to present
 * All rights reserved.
 */

public class DataViewHolder extends RecyclerView.ViewHolder {
    //her VH nin kendi bindingi olacağı için member
    InterestingListItemBinding mBinding;

    public DataViewHolder(InterestingListItemBinding binding) {
        super(binding.getRoot());
        this.mBinding = binding;
    }

    public void setItem(PhotoItem photoItem) {
        mBinding.setDisplayedItem(photoItem);
        //Picasso implementasyonu
        ///imageview run edilmeden önce match_parent ile getWidth ve getHeight kullanamayacağımız için picassoyu böyle implemente et
        mBinding.ivPlaceHolder.post(() -> Picasso.get().load(mBinding.getDisplayedItem().getUrl())
                .resize(mBinding.ivPlaceHolder.getWidth(), mBinding.ivPlaceHolder.getHeight())
                .into(mBinding.ivPlaceHolder));
    }
}

