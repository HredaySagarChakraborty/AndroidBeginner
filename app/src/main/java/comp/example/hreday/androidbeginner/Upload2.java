package comp.example.hreday.androidbeginner;

import com.google.firebase.database.Exclude;

public class Upload2 {

    String imageName2,imageUrl2;

    String key2;

    @Exclude
    public String getKey() {
        return key2;
    }
    @Exclude
    public void setKey(String key2) {
        this.key2 = key2;
    }

    public Upload2() {
    }

    public Upload2(String imageName2, String imageUrl2) {
        this.imageName2 = imageName2;
        this.imageUrl2 = imageUrl2;
    }

    public String getImageName() {
        return imageName2;
    }

    public void setImageName(String imageName1) {
        this.imageName2 = imageName2;
    }

    public String getImageUrl() {
        return imageUrl2;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl2 = imageUrl2;
    }
}
