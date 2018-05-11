package mert.android.com.flickr_app.network;

import mert.android.com.flickr_app.photo_data.Re;
import mert.android.com.flickr_app.user_data.ProfileResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by lostarious on 27.04.2018.
 */

public interface FlickrClient {


    @GET("?method=flickr.interestingness.getList&format=json&nojsoncallback=1")
    Call<Re> favoritesList(

            @Query("api_key") String api_key,
            @Query("extras") String extras);

    @GET("?method=flickr.profile.getProfile&format=json&nojsoncallback=1")
    Call<ProfileResponse> userInfo(
            @Query("api_key") String api_key,
            @Query("user_id") String user_id
    );
}
