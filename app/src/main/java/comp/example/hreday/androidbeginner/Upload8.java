package comp.example.hreday.androidbeginner;

import com.google.firebase.database.Exclude;

public class Upload8 {

    String imageName8,imageUrl8;


    String key8;

    @Exclude
    public String getKey() {
        return key8;
    }
    @Exclude
    public void setKey(String key8) {
        this.key8 = key8;
    }

    public Upload8() {
    }

    public Upload8(String imageName8, String imageUrl8) {
        this.imageName8 = imageName8;
        this.imageUrl8 = imageUrl8;
    }

    public String getImageName() {
        return imageName8;
    }

    public void setImageName(String imageName8) {
        this.imageName8 = imageName8;
    }

    public String getImageUrl() {
        return imageUrl8;
    }

    public void setImageUrl(String imageUrl8) {
        this.imageUrl8 = imageUrl8;
    }
}
