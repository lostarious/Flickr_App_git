package mert.android.com.flickr_app;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.io.IOException;

import mert.android.com.flickr_app.databinding.ActivityMainBinding;
import mert.android.com.flickr_app.photo_data.PhotoItem;
import mert.android.com.flickr_app.photo_data.Photos;
import mert.android.com.flickr_app.photo_data.Re;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private String API_KEY = "1b3d11d7d5c5952227c16737d6d97540";
    private String extras = "description";
    PhotoItem newItem = new PhotoItem();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        //setContentView(R.layout.activity_main);
        FlickrClient client = FlickrClient.retrofit.create(FlickrClient.class);
        client.favoritesList(API_KEY, extras).enqueue(new Callback<Re>() {
            @Override
            public void onResponse(Call<Re> call, retrofit2.Response<Re> response) {
                System.out.println(response.body().getPhotos().getPhoto().get(0).getId());
                newItem.setId(response.body().getPhotos().getPhoto().get(0).getId());
                binding.setNewItem(newItem);
                Log.i("info", "onResponse: client Connected");
            }

            @Override
            public void onFailure(Call<Re> call, Throwable t) {
                Log.e("error", "FavoritesListMethodFailed", new IOException());
            }
        });
        InterestingListFragment interestingListFragment = new InterestingListFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fr_interestingnessList,interestingListFragment);
        fragmentTransaction.commit();

    }
}
