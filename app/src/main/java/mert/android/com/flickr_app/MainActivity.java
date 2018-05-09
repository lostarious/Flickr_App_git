package mert.android.com.flickr_app;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import mert.android.com.flickr_app.Network.RetrofitNetwork;
import mert.android.com.flickr_app.photo_data.PhotoItem;


public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.recyclerOnClickListener {

    // 3.05.2018 Bunlari da bir asagidaki to do da belirledigim classin icinde tanimlayabilirsin.
    FragmentManager fragmentManager = getSupportFragmentManager();
    RetrofitNetwork mRetrofitNetwork = new RetrofitNetwork();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //3.05.2018 Retrofit objesini baska bir class'da olusturup oradan ulasman gerekiyor. Bu activity'nin lifecycle'i her yenilendiginde gereksiz yere objec olusturmus olacaksin.

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //TODO: 8.05.2018 Bu şekilde member variable olarak doğru mu?
        //TODO:8.05.2018 async olması sebebiyle null dönmemesi için içeride yapmam ve networke alakası olmayan parametreler girmem gerekiyor nasıl farklı yapabilirim?
        mRetrofitNetwork.requestFavoritesList(fragmentTransaction);
        //3.05.2018 Main Activityde sadece fragmentlarin gorunumunu saglayacak frame lgitayout'a ihtiyacin var. DataBinding'de tanimli olan PhotoItem'i silebilirsin.


    }

    //interface override
    @Override
    public void itemClicked(PhotoItem clickedItem) {
        //TODO: 8.05.2018 Bu kullanım doğru mu?
        ItemDetailsFragment newFragment = new ItemDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("selectedItem", clickedItem);
        newFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_fragment_display, newFragment)
                .addToBackStack("newFragment")
                .commit();
    }
    // 3.05.2018 Bunlar detail fragmentin viewlari. Activity'nin bunlara ulasmamasi gerekiyor. Burada daha farkli bir yapi kurmamiz lazim. Ben gosteririm sana.


}



