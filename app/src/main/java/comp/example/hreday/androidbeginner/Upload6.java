package comp.example.hreday.androidbeginner;

import com.google.firebase.database.Exclude;

public class Upload6 {

    String imageName6,imageUrl6;

    String key6;

    @Exclude
    public String getKey() {
        return key6;
    }
    @Exclude
    public void setKey(String key6) {
        this.key6 = key6;
    }

    public Upload6() {
    }

    public Upload6(String imageName6, String imageUrl6) {
        this.imageName6 = imageName6;
        this.imageUrl6 = imageUrl6;
    }

    public String getImageName() {
        return imageName6;
    }

    public void setImageName(String imageName6) {
        this.imageName6 = imageName6;
    }

    public String getImageUrl() {
        return imageUrl6;
    }

    public void setImageUrl(String imageUrl6) {
        this.imageUrl6 = imageUrl6;
    }
}
