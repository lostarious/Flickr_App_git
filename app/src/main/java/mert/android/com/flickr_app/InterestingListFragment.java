package mert.android.com.flickr_app;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import mert.android.com.flickr_app.RecyclerViewAdapter.recyclerOnClickListener;

import mert.android.com.flickr_app.databinding.FragmentInterestingListBinding;
import mert.android.com.flickr_app.photo_data.PhotoItem;
import mert.android.com.flickr_app.photo_data.Photos;


/**
 * Created by lostarious on 30.04.2018
 * Copyright (c) 2018 YGA to present
 * All rights reserved.
 */

public class InterestingListFragment extends Fragment implements  RecyclerViewAdapter.recyclerOnClickListener{

    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private MainActivity mainActivity;
    private FragmentInterestingListBinding binding;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding =  FragmentInterestingListBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
    //Container activitynin implemente etmesi için bir interface




    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.rvInterestingnessList.hasFixedSize();
        mLayoutManager = new LinearLayoutManager(getContext());
        binding.rvInterestingnessList.setLayoutManager(mLayoutManager);
        //Activity recycleronclicklistener olarak cast edince onun implementasyonunu alıyor
        mAdapter = new RecyclerViewAdapter((Photos) getArguments().getParcelable("Photos_response"),(recyclerOnClickListener)getActivity());
        binding.rvInterestingnessList.setAdapter(mAdapter);

    }


    @Override
    public void itemClicked(PhotoItem clickedItem) {
        mainActivity.replaceFragment(ItemDetailsFragment.new);
    }
}
