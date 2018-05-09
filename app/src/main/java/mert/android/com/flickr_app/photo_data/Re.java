package mert.android.com.flickr_app.photo_data;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Re {

    @SerializedName("stat")
    private String stat;

    @SerializedName("photos")
    private Photos photos;

    public String getStat() {
        return stat;
    }

    public Photos getPhotos() {
        return photos;
    }
}