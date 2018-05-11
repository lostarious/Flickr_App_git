package mert.android.com.flickr_app.interestinglist;

import android.support.v7.widget.RecyclerView;

import mert.android.com.flickr_app.databinding.InterestingListItemBinding;

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
}

