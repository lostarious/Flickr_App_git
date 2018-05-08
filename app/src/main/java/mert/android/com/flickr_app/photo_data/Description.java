package mert.android.com.flickr_app.photo_data;

import android.support.annotation.Nullable;

import javax.annotation.Generated;
import com.squareup.moshi.Json;


@Generated("com.robohorse.robopojogenerator")
public class Description{

	@Nullable
	@Json (name = "_content")
	private String content;

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}