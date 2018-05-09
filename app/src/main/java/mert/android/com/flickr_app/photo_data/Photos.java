package mert.android.com.flickr_app.photo_data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Photos implements Parcelable{

	@SerializedName("perpage")
	private int perpage;

	@SerializedName("total")
	private int total;

	@SerializedName("pages")
	private int pages;

	@SerializedName("photo")
	private List<PhotoItem> photo;

	@SerializedName("page")
	private int page;

	public int getPerpage() {
		return perpage;
	}

	public int getTotal() {
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
		return total;
	}
	//TODO(2) Parcele yazarken sadece photo list yazılıyor düzelt
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