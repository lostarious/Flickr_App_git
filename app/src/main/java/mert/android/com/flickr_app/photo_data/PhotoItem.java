package mert.android.com.flickr_app.photo_data;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.squareup.moshi.Json;

import mert.android.com.flickr_app.photo_data.Description;

@Generated("com.robohorse.robopojogenerator")
public class PhotoItem implements Parcelable{

	@Json(name = "owner")
	private String owner;

	@Json(name = "server")
	private String server;

	@Json(name = "ispublic")
	private int ispublic;

	@Json(name = "isfriend")
	private int isfriend;

	@Json(name = "farm")
	private int farm;

	@Json(name = "description")
	private Description description;

	@Json(name = "id")
	private String id;

	@Json(name = "secret")
	private String secret;

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

	@Json(name = "title")
	private String title;

	@Json(name = "isfamily")
	private int isfamily;

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public void setIspublic(int ispublic) {
		this.ispublic = ispublic;
	}

	public void setIsfriend(int isfriend) {
		this.isfriend = isfriend;
	}

	public void setFarm(int farm) {
		this.farm = farm;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setIsfamily(int isfamily) {
		this.isfamily = isfamily;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
			String data[] = {title,owner,description.getContent()};
			dest.writeStringArray(data);
	}
	public static final Parcelable.Creator<PhotoItem> CREATOR = new Parcelable.Creator<PhotoItem>() {
		public PhotoItem createFromParcel(Parcel in) {
			return new PhotoItem(in);
		}

		public PhotoItem[] newArray(int size) {
			return new PhotoItem[size];
		}
	};
	public PhotoItem(Parcel in){
		//TODO(4) şuan sadece işe yaran kısımlar parcel olarak yazılıp okunuyor
		String[] data = new String[3];
		in.readStringArray(data);
		this.title = data[0];
		this.owner = data[1];
		this.description.setContent(data[2]);
	}
}