package mert.android.com.flickr_app.user_data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Profile implements Parcelable {
    private String[] mDetails;

    @SerializedName("country")
    private String country;

    @SerializedName("hometown")
    private String hometown;

    @SerializedName("occupation")
    private String occupation;

    @SerializedName("city")
    private String city;

    @SerializedName("join_date")
    private String joinDate;

    @SerializedName("facebook")
    private String facebook;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("tumblr")
    private String tumblr;

    @SerializedName("pinterest")
    private String pinterest;

    @SerializedName("instagram")
    private String instagram;

    @SerializedName("profile_description")
    private String profileDescription;

    @SerializedName("twitter")
    private String twitter;

    @SerializedName("nsid")
    private String nsid;

    @SerializedName("showcase_set")
    private String showcaseSet;

    @SerializedName("showcase_set_title")
    private String showcaseSetTitle;

    @SerializedName("id")
    private String id;

    @SerializedName("first_name")
    private String firstName;

    public String getCountry() {
        return country;
    }

    public String getHometown() {
        return hometown;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getCity() {
        return city;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTumblr() {
        return tumblr;
    }

    public String getPinterest() {
        return pinterest;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getNsid() {
        return nsid;
    }

    public String getShowcaseSet() {
        return showcaseSet;
    }

    public String getShowcaseSetTitle() {
        return showcaseSetTitle;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String[] getmDetails() {
        return mDetails;
    }

    public void setmDetails() {
        StringBuilder builder = new StringBuilder();
        builder.append("Uploaded By: ")
                .append(getFirstName())
                .append(" ")
                .append(getLastName());
        String name = builder.toString();
        builder.setLength(0);

        builder.append("User is from: ")
                .append(getHometown());
        String origin = builder.toString();
        builder.setLength(0);

        builder.append("Profile Descripton:\n")
                .append(getProfileDescription());
        String profDescription = builder.toString();
        this.mDetails = new String[3];
        this.mDetails[0] = name;
        this.mDetails[1] = origin;
        this.mDetails[2] = profDescription;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    //setter getterlar sayesinde parcelleri doldurmama gerek yok
    @Override
    public void writeToParcel(Parcel dest, int flags) {


    }

    public Profile(Parcel in) {

    }

    Parcelable.Creator<Profile> CREATOR = new Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel source) {
            return new Profile(source);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };
}