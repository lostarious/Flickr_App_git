package mert.android.com.flickr_app.photo_data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import javax.annotation.Generated;
import com.squareup.moshi.Json;

@Generated("com.robohorse.robopojogenerator")
public class Photos implements Parcelable{

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

	@Override
	public int describeContents() {
		return Integer.parseInt(total);
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeList(getPhoto());

	}
	public static final Parcelable.Creator<Photos> CREATOR = new Parcelable.Creator<Photos>() {
		public Photos createFromParcel(Parcel in) {
			return new Photos(in);
		}

		public Photos[] newArray(int size) {
			return new Photos[size];
		}
	};

	private Photos(Parcel in) {
		in.readList(getPhoto(),null);
	}
}