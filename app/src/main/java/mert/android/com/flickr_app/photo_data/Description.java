package mert.android.com.flickr_app.photo_data;

import javax.annotation.Generated;
import com.squareup.moshi.Json;


@Generated("com.robohorse.robopojogenerator")
public class Description{
	//TODO(0) Content neden null dönüyor?
	@Json(name = "_content")
	private String content;

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}