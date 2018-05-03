package mert.android.com.flickr_app.photo_data;

import javax.annotation.Generated;
import com.squareup.moshi.Json;


@Generated("com.robohorse.robopojogenerator")
public class Description{
	//TODO(0) Content neden null dönüyor?
	//TODO(0-CEVAP) Fotografa content eklenmemis olabilir. Burada nullable olabilecegini belirtmen gerekiyor.
	@Json(name = "_content")
	private String content;

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}