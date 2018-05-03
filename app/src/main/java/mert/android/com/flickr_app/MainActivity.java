package mert.android.com.flickr_app;



import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import java.io.IOException;
import java.util.function.ToDoubleBiFunction;

import mert.android.com.flickr_app.databinding.ActivityMainBinding;
import mert.android.com.flickr_app.photo_data.PhotoItem;

import mert.android.com.flickr_app.photo_data.Re;
import retrofit2.Call;
import retrofit2.Callback;


public class MainActivity extends AppCompatActivity implements  RecyclerViewAdapter.recyclerOnClickListener,ItemDetailsFragment.detailsFragmentDetailSetter{
    private String API_KEY = "1b3d11d7d5c5952227c16737d6d97540";
    private String extras = "description";
    // TODO: 3.05.2018 Bunlari da bir asagidaki todo da belirledigim classin icinde tanimlayabilirsin.
    Bundle bundle = new Bundle();
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // TODO: 3.05.2018 Retrofit objesini baska bir class'da olusturup oradan ulasman gerekiyor. Bu activity'nin lifecycle'i her yenilendiginde gereksiz yere objec olusturmus olacaksin.
        FlickrClient client = FlickrClient.retrofit.create(FlickrClient.class);
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
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

                fragmentTransaction.add(R.id.fl_interestingness_list, interestingListFragment);
                fragmentTransaction.commit();
            }

            @Override
            public void onFailure(Call<Re> call, Throwable t) {
                Log.e("error", "FavoritesListMethodFailed", new IOException());
            }
        });
        super.onCreate(savedInstanceState);
        //TODO(3) Binding şuan için yok fragmentleri tamamladıktan sonra ekle
        //TODO(3-CEVAP) Main Activityde sadece fragmentlarin gorunumunu saglayacak frame layout'a ihtiyacin var. DataBinding'de tanimli olan PhotoItem'i silebilirsin.
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ItemDetailsFragment itemDetailsFragment = new ItemDetailsFragment();
        FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
        fragmentTransaction1.add(R.id.fl_item_details,itemDetailsFragment).commit();


    }

    //interface override
    @Override
    public void itemClicked(PhotoItem clickedItem) {
            setDetails(clickedItem);
    }
    //interface override
    // TODO: 3.05.2018 Bunlar detail fragmentin viewlari. Activity'nin bunlara ulasmamasi gerekiyor. Burada daha farkli bir yapi kurmamiz lazim. Ben gosteririm sana.
    @Override
    public void setDetails(PhotoItem clickedItem) {

            TextView title = findViewById(R.id.tv_item_details_title);
            title.setText(clickedItem.getTitle());
            TextView owner = findViewById(R.id.tv_item_details_owner);
            owner.setText(clickedItem.getOwner());
            TextView description = findViewById(R.id.tv_item_details_description);
            description.setText(clickedItem.getDescription().getContent());

    }
}



