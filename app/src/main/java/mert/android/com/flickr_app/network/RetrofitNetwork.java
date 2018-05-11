package mert.android.com.flickr_app.network;


import mert.android.com.flickr_app.photo_data.Re;
import mert.android.com.flickr_app.user_data.ProfileResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lostarious on 08.05.2018
 * Copyright (c) 2018 YGA to present
 * All rights reserved.
 */
public class RetrofitNetwork {
    private static final String API_KEY = "1b3d11d7d5c5952227c16737d6d97540";
    private static final String EXTRAS = "description";
    private static final String BASE_URL = "https://api.flickr.com/services/rest/";
    private static Retrofit mRetrofit;
    private static FlickrClient mClient;

    public RetrofitNetwork() {
        mRetrofit = createRetrofitInstance();
        mClient = createClient(mRetrofit);

    }

    //  11.05.2018 transaction burada yapilmayacak
    public static Call<Re> requestFavoritesList() {
        return mClient.favoritesList(API_KEY, EXTRAS);
    }

    //  11.05.2018 sadece parametreleri gonder.
    public static Call<ProfileResponse> requestUserInfo(String user_id) {

        return mClient.userInfo(API_KEY, user_id);

    }

    public Retrofit createRetrofitInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public FlickrClient createClient(Retrofit retrofit) {
        return retrofit.create(FlickrClient.class);
    }
}


