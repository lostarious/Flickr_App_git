package mert.android.com.flickr_app.photo_data;

import java.util.List;
import javax.annotation.Generated;
import com.squareup.moshi.Json;

@Generated("com.robohorse.robopojogenerator")
public class Photos{

	@Json(name = "perpage")
	private int perpage;

	@Json(name = "total")
	private String total;

	@Json(name = "pages")
	private int pages;

	@Json(name = "photo")
	private List<PhotoItem> photo;

	@Json(name = "page")
	private int page;

	public int getPerpage() {
		return perpage;
	}

	public String getTotal() {
		return total;
	}

	public int getPages() {
		return pages;
	}

	public List<PhotoItem> getPhoto() {
		return photo;
	}

	public int getPage() {
		return page;
	}
}