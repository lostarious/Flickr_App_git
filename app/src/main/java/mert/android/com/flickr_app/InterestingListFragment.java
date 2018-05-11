package mert.android.com.flickr_app;


import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mert.android.com.flickr_app.RecyclerViewAdapter.recyclerOnClickListener;
import mert.android.com.flickr_app.databinding.FragmentInterestingListBinding;
import mert.android.com.flickr_app.network.RetrofitNetwork;
import mert.android.com.flickr_app.photo_data.PhotoItem;
import mert.android.com.flickr_app.photo_data.Photos;


/**
 * Created by lostarious on 30.04.2018
 * Copyright (c) 2018 YGA to present
 * All rights reserved.
 */

public class InterestingListFragment extends Fragment {

    public static final String TAG = InterestingListFragment.class.getSimpleName();
    // TODO: 11.05.2018 Her fragment'a tag gerekiyor
    private RecyclerView.LayoutManager mLayoutManager;
    private MainActivity mainActivity;
    private FragmentInterestingListBinding binding;
    private RecyclerViewAdapter adapter;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: 11.05.2018 isimleri daha spesifik yap.


        // TODO: 11.05.2018 Lambda expression enable olsun

        // TODO: 11.05.2018 acViewModel projesindeki BaseRecyclerAdapter classini kullanarak icerdeki adapterlari ondan extend edebilirsin.
      /*  adapter = new RecyclerViewAdapter(Collections.emptyList(), new recyclerOnClickListener() {
            @Override
            public void itemClicked(PhotoItem clickedItem) {

            }
        });*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentInterestingListBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.rvInterestingnessList.hasFixedSize();
        mLayoutManager = new LinearLayoutManager(getContext());
        binding.rvInterestingnessList.setLayoutManager(mLayoutManager);


        // TODO: 11.05.2018 Burada cagri yapman lazim. Cagri sonlandiginda da adapter.swapDataSet diyip gelen veriyi recyclera basman lazim.
        //Activity recycleronclicklistener olarak cast edince onun implementasyonunu alıyor

        List<PhotoItem> item = new ArrayList<>();

        RetrofitNetwork retrofitNetwork = new RetrofitNetwork();
        retrofitNetwork.requestFavoritesList();

        binding.rvInterestingnessList.setAdapter(mAdapter);

    }

}
