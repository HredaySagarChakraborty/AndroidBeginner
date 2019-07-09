package comp.example.hreday.androidbeginner;

import com.google.firebase.database.Exclude;

public class Upload4 {

    String imageName4,imageUrl4;

    String key4;

    @Exclude
    public String getKey() {
        return key4;
    }
    @Exclude
    public void setKey(String key4) {
        this.key4 = key4;
    }

    public Upload4() {
    }

    public Upload4(String imageName4, String imageUrl4) {
        this.imageName4 = imageName4;
        this.imageUrl4 = imageUrl4;
    }

    public String getImageName() {
        return imageName4;
    }

    public void setImageName(String imageName4) {
        this.imageName4 = imageName4;
    }

    public String getImageUrl() {
        return imageUrl4;
    }

    public void setImageUrl(String imageUrl4) {
        this.imageUrl4 = imageUrl4;
    }
}
