package mert.android.com.flickr_app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mert.android.com.flickr_app.photo_data.PhotoItem;

/**
 * Created by lostarious on 02.05.2018
 * Copyright (c) 2018 YGA to present
 * All rights reserved.
 */
public class ItemDetailsFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_details,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public interface detailsFragmentDetailSetter{
        void setDetails(PhotoItem clickedItem);
    }


}
