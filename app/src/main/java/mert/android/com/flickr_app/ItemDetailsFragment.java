package mert.android.com.flickr_app;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mert.android.com.flickr_app.databinding.FragmentItemDetailsBinding;
import mert.android.com.flickr_app.photo_data.PhotoItem;
import mert.android.com.flickr_app.user_data.Profile;

/**
 * Created by lostarious on 02.05.2018
 * Copyright (c) 2018 YGA to present
 * All rights reserved.
 */
public class ItemDetailsFragment extends Fragment {
    FragmentItemDetailsBinding mBinding;

    public static ItemDetailsFragment newInstance(PhotoItem item) {

        Bundle args = new Bundle();

        ItemDetailsFragment.item = item;
        args.putParcelable("...", item)

        ItemDetailsFragment fragment = new ItemDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_item_details, container, false);

        PhotoItem item = (PhotoItem) savedInstanceState.getParcelable("...");

        // TODO: 11.05.2018 onstartta yapilanlari buraya tasi
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
        mBinding.setSelectedItem((PhotoItem) getArguments().get("selectedItem"));
        mBinding.setUserData((Profile) getArguments().get("profile_response"));
        mBinding.getUserData().getmDetails();
        //Floating action button listener
        mBinding.FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //geri tuşuna basılmış gibi çalışacak
                getFragmentManager().popBackStack();
            }
        });
    }

}
