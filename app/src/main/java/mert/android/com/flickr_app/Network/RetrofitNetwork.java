package mert.android.com.flickr_app.Network;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import java.io.IOException;

import mert.android.com.flickr_app.InterestingListFragment;
import mert.android.com.flickr_app.R;
import mert.android.com.flickr_app.photo_data.Photos;
import mert.android.com.flickr_app.photo_data.Re;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lostarious on 08.05.2018
 * Copyright (c) 2018 YGA to present
 * All rights reserved.
 */
public class RetrofitNetwork{
    private static final String API_KEY = "1b3d11d7d5c5952227c16737d6d97540";
    private static final String EXTRAS = "description";
    private static final String BASE_URL = "https://api.flickr.com/services/rest/";
    private Retrofit mRetrofit;
    private FlickrClient mClient;
    private Bundle mBundle = new Bundle();
    public Retrofit createRetrofitInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public FlickrClient createClient(Retrofit retrofit){
            return retrofit.create(FlickrClient.class);
            }
    public RetrofitNetwork(){
        mRetrofit = createRetrofitInstance();
        mClient = createClient(mRetrofit);

    }
    public void requestFavoritesList(final FragmentTransaction fragmentTransaction){
        mClient.favoritesList(API_KEY, EXTRAS).enqueue(new Callback<Re>() {
            @Override
            public void onResponse(Call<Re> call, retrofit2.Response<Re> response) {
                System.out.println(response.body().getPhotos().getPhoto().get(0).getId());
                Log.i("info", "onResponse: client Connected");
                Photos retrievedPhotos = response.body().getPhotos();
                mBundle.putParcelable("Photos_response",retrievedPhotos);
                InterestingListFragment interestingListFragment = new InterestingListFragment();
                interestingListFragment.setArguments(mBundle);
                fragmentTransaction.add(R.id.fl_interestingness_list,interestingListFragment);
                fragmentTransaction.commit();
            }

            @Override
            public void onFailure(Call<Re> call, Throwable t) {
                Log.e("error", "FavoritesListMethodFailed", new IOException());
            }
        });
    }

}
