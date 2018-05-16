package mert.android.com.flickr_app.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import mert.android.com.flickr_app.R;
import mert.android.com.flickr_app.interestinglist.InterestingListFragment;
import mert.android.com.flickr_app.network.RetrofitNetwork;


public class MainActivity extends AppCompatActivity {

    // 3.05.2018 Bunlari da bir asagidaki to do da belirledigim classin icinde tanimlayabilirsin.
    // TODO: 16.05.2018 Application'da 1 kere initle
    RetrofitNetwork mRetrofitNetwork = new RetrofitNetwork();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //3.05.2018 Retrofit objesini baska bir class'da olusturup oradan ulasman gerekiyor. Bu activity'nin lifecycle'i her yenilendiginde gereksiz yere objec olusturmus olacaksin.
        setContentView(R.layout.activity_main);
        //BUGFIX: Portre-landscape arası gider gelirken liste fragmenti üstüne yeni birtane oluşturmamak için
        if(savedInstanceState==null) {
            addFragment(InterestingListFragment.newInstance(), InterestingListFragment.TAG);
            //3.05.2018 Main Activityde sadece fragmentlarin gorunumunu saglayacak frame lgitayout'a ihtiyacin var. DataBinding'de tanimli olan PhotoItem'i silebilirsin.
        }


    }



    // 11.05.2018 random parametre verdim. acViewModel projesinde var
    // TODO: 16.05.2018 bu proje icin replace'e ihtiyac yok. Add yapilacak
    public void replaceFragment(Fragment fragment, String fragmentTag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_fragment_display, fragment)
                .addToBackStack(fragmentTag);
        fragmentTransaction.commit();
    }

    // 11.05.2018 detaya giderken bu tetiklenecek. Detaya tasimak istedigin parametreleri newInstance metoduna gec ve oradan bundle'a ekleyip onCreateView'da? al
    public void addFragment(Fragment fragment, String fragmentTag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_fragment_display, fragment)
                .addToBackStack(fragmentTag);
        fragmentTransaction.commit();
    }


}



