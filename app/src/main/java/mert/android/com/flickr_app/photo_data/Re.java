package mert.android.com.flickr_app.photo_data;

import javax.annotation.Generated;
import com.squareup.moshi.Json;

@Generated("com.robohorse.robopojogenerator")
public class Re{

	@Json(name = "stat")
	private String stat;

	@Json(name = "photos")
	private Photos photos;

	public Photos getPhotos() {
		return photos;
	}
}