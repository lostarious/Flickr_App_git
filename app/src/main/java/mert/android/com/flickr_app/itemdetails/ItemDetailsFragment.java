package mert.android.com.flickr_app.itemdetails;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mert.android.com.flickr_app.R;
import mert.android.com.flickr_app.databinding.FragmentItemDetailsBinding;
import mert.android.com.flickr_app.network.RetrofitNetwork;
import mert.android.com.flickr_app.photo_data.PhotoItem;
import mert.android.com.flickr_app.user_data.Profile;
import mert.android.com.flickr_app.user_data.ProfileResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lostarious on 02.05.2018
 * Copyright (c) 2018 YGA to present
 * All rights reserved.
 */
public class ItemDetailsFragment extends Fragment {
    public static final String TAG = ItemDetailsFragment.class.getSimpleName();
    FragmentItemDetailsBinding mBinding;

    public static ItemDetailsFragment newInstance(PhotoItem item) {
        Bundle args = new Bundle();
        args.putParcelable("selected_item", item);
        ItemDetailsFragment fragment = new ItemDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_item_details, container, false);
        mBinding.linearLayout.setVisibility(View.INVISIBLE);
        mBinding.pbLoading.setVisibility(View.VISIBLE);
        if (savedInstanceState != null) {
            mBinding.setSelectedItem((savedInstanceState.getParcelable("selected_item")));
        } else {
            mBinding.setSelectedItem(getArguments().getParcelable("selected_item"));
        }

        RetrofitNetwork.requestUserInfo(mBinding.getSelectedItem().getOwner()).enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                Profile user_data = response.body().getProfile();
                user_data.setmDetails();
                mBinding.setUserData(user_data);
                mBinding.linearLayout.setVisibility(View.VISIBLE);
                mBinding.pbLoading.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                Log.i("info:", "onFailure: Kullanıcı bilgisine erişilemedi");
            }
        });
        //Floating action button listener
        mBinding.FAB.setOnClickListener(v -> getFragmentManager().popBackStack());
        // 11.05.2018 onstartta yapilanlari buraya tasi
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


}
