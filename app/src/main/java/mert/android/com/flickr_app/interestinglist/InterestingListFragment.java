package mert.android.com.flickr_app.interestinglist;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;

import mert.android.com.flickr_app.databinding.FragmentInterestingListBinding;
import mert.android.com.flickr_app.home.MainActivity;
import mert.android.com.flickr_app.itemdetails.ItemDetailsFragment;
import mert.android.com.flickr_app.network.RetrofitNetwork;
import mert.android.com.flickr_app.photo_data.Re;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by lostarious on 30.04.2018
 * Copyright (c) 2018 YGA to present
 * All rights reserved.
 */

public class InterestingListFragment extends Fragment {

    public static final String TAG = InterestingListFragment.class.getSimpleName();

    private MainActivity mainActivity;
    private FragmentInterestingListBinding binding;
    private DataViewAdapter adapter;

    public static InterestingListFragment newInstance() {

        return new InterestingListFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 11.05.2018 isimleri daha spesifik yap.


        // 11.05.2018 Lambda expression enable olsun

        //  acViewModel projesindeki BaseRecyclerAdapter classini kullanarak icerdeki adapterlari ondan extend edebilirsin.
        adapter = new DataViewAdapter(Collections.emptyList(), clickedItem -> {
            ItemDetailsFragment itemDetailsFragment = ItemDetailsFragment.newInstance(clickedItem);
            mainActivity.replaceFragment(itemDetailsFragment, ItemDetailsFragment.TAG);
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentInterestingListBinding.inflate(inflater, container, false);
        binding.rvInterestingnessList.setAdapter(adapter);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.rvInterestingnessList.hasFixedSize();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        binding.rvInterestingnessList.setLayoutManager(mLayoutManager);

        //Pop Back stackten sonra tekrar değişmemesi gereken adapteri değiştirip garip bir görüntü ortaya çıkarmaması için
        if (adapter.getItemCount() == 0) {
            RetrofitNetwork.requestFavoritesList().enqueue(new Callback<Re>() {
                @Override
                public void onResponse(Call<Re> call, Response<Re> response) {
                    adapter.swapDataSet(response.body().getPhotos().getPhoto());
                }

                @Override
                public void onFailure(Call<Re> call, Throwable t) {
                    Log.i("info", "onFailure: Can't get photo list");
                }
            });
        }

        // 11.05.2018 Burada cagri yapman lazim. Cagri sonlandiginda da adapter.swapDataSet diyip gelen veriyi recyclera basman lazim.


    }

}
