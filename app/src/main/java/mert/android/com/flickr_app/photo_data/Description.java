package mert.android.com.flickr_app.photo_data;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Description {
    //9.05.18 Content null dönmesi sorunu Moshiden GSON a geçince düzeldi sanırım Moshi de nested objeler için custom adapter kullanmak gerekiyor veya retrofitin GSON converter factorysi yerine başka bir factory kullanmak gerek?
    @SerializedName("_content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}