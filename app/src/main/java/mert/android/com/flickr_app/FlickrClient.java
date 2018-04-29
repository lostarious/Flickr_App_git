package mert.android.com.flickr_app;

import mert.android.com.flickr_app.photo_data.Photos;
import mert.android.com.flickr_app.photo_data.Re;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by lostarious on 27.04.2018.
 */

public interface FlickrClient {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.flickr.com/services/rest/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("?method=flickr.interestingness.getList&format=json&nojsoncallback=1")
    Call<Re> favoritesList(

                                @Query("api_key") String api_key,
                               @Query("extras") String extras);

}
