package mert.android.com.flickr_app.photo_data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class PhotoItem implements Parcelable {

    public static final Parcelable.Creator<PhotoItem> CREATOR = new Parcelable.Creator<PhotoItem>() {
        public PhotoItem createFromParcel(Parcel in) {
            return new PhotoItem(in);
        }

        public PhotoItem[] newArray(int size) {
            return new PhotoItem[size];
        }
    };
    @SerializedName("owner")
    private String owner;
    @SerializedName("server")
    private String server;
    @SerializedName("ispublic")
    private int ispublic;
    @SerializedName("isfriend")
    private int isfriend;
    @SerializedName("farm")
    private int farm;
    @SerializedName("description")
    private Description description;
    @SerializedName("id")
    private String id;
    @SerializedName("secret")
    private String secret;
    @SerializedName("title")
    private String title;
    @SerializedName("isfamily")
    private int isfamily;

    public PhotoItem(Parcel in) {
        //TODO(4) şuan sadece işe yaran kısımlar parcel olarak yazılıp okunuyor
        String[] data = new String[3];
        in.readStringArray(data);
        this.title = data[0];
        this.owner = data[1];
        this.description.setContent(data[2]);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        String data[] = {title, owner, description.getContent()};
        dest.writeStringArray(data);
    }

    public String getOwner() {
        return owner;
    }

    public String getServer() {
        return server;
    }

    public int getIspublic() {
        return ispublic;
    }

    public int getIsfriend() {
        return isfriend;
    }

    public int getFarm() {
        return farm;
    }

    public Description getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getSecret() {
        return secret;
    }

    public String getTitle() {
        return title;
    }

    public int getIsfamily() {
        return isfamily;
    }
}
