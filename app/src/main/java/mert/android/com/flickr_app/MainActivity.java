package mert.android.com.flickr_app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import mert.android.com.flickr_app.network.RetrofitNetwork;
import mert.android.com.flickr_app.photo_data.PhotoItem;
import mert.android.com.flickr_app.user_data.ProfileResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

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


    // TODO: 11.05.2018 random parametre verdim. acViewModel projesinde var
    public void replaceFragment(Fragment fragment){

    }

    // TODO: 11.05.2018 detaya giderken bu tetiklenecek. Detaya tasimak istedigin parametreleri newInstance metoduna gec ve oradan bundle'a ekleyip onCreateView'da? al
    public void addFragment(Fragment fragment, String TAG){

    }



}



