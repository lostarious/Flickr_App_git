package mert.android.com.flickr_app.photo_data;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Re{

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