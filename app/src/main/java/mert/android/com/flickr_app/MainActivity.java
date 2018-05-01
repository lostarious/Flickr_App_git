package mert.android.com.flickr_app;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import mert.android.com.flickr_app.databinding.ActivityMainBinding;
import mert.android.com.flickr_app.photo_data.PhotoItem;
import mert.android.com.flickr_app.photo_data.Photos;
import mert.android.com.flickr_app.photo_data.Re;
import retrofit2.Call;
import retrofit2.Callback;
import mert.android.com.flickr_app.RecyclerViewAdapter.recyclerOnClickListener;

public class MainActivity extends AppCompatActivity implements  RecyclerViewAdapter.recyclerOnClickListener{
    private String API_KEY = "1b3d11d7d5c5952227c16737d6d97540";
    private String extras = "description";
    PhotoItem newItem = new PhotoItem();
    Bundle bundle = new Bundle();
    private  recyclerOnClickListener recyclerOnClickListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        FlickrClient client = FlickrClient.retrofit.create(FlickrClient.class);
        client.favoritesList(API_KEY, extras).enqueue(new Callback<Re>() {
            @Override
            public void onResponse(Call<Re> call, retrofit2.Response<Re> response) {
                System.out.println(response.body().getPhotos().getPhoto().get(0).getId());
                //newItem.setId(response.body().getPhotos().getPhoto().get(0).getId());
                //binding.setNewItem(newItem);
                Log.i("info", "onResponse: client Connected");
                bundle.putParcelable("Photos_response",response.body().getPhotos());
                InterestingListFragment interestingListFragment = new InterestingListFragment();
                interestingListFragment.setArguments(bundle);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fl_interestingness_list, interestingListFragment);
                //fragmentTransaction.replace(R.layout.fragment_interesting_list,interestingListFragment);
                fragmentTransaction.commit();
                //mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Re> call, Throwable t) {
                Log.e("error", "FavoritesListMethodFailed", new IOException());
            }
        });
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);



    }


    @Override
    public void itemClicked(PhotoItem clickedItem) {
        System.out.println(clickedItem.getId());
        System.out.println(clickedItem.getOwner());
        System.out.println(clickedItem.getDescription().getContent());
    }
}



