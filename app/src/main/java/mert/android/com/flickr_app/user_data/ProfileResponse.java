package mert.android.com.flickr_app.user_data;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ProfileResponse {

    @SerializedName("stat")
    private String stat;

    @SerializedName("profile")
    private Profile profile;

    public String getStat() {
        return stat;
    }

    public Profile getProfile() {
        return profile;
    }
}