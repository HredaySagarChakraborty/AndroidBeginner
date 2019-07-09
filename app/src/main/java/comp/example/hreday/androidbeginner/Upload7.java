package comp.example.hreday.androidbeginner;

import com.google.firebase.database.Exclude;

public class Upload7 {

    String imageName7,imageUrl7;


    String key7;

    @Exclude
    public String getKey() {
        return key7;
    }
    @Exclude
    public void setKey(String key7) {
        this.key7 = key7;
    }

    public Upload7() {
    }

    public Upload7(String imageName7, String imageUrl7) {
        this.imageName7 = imageName7;
        this.imageUrl7 = imageUrl7;
    }

    public String getImageName() {
        return imageName7;
    }

    public void setImageName(String imageName7) {
        this.imageName7 = imageName7;
    }

    public String getImageUrl() {
        return imageUrl7;
    }

    public void setImageUrl(String imageUrl7) {
        this.imageUrl7 = imageUrl7;
    }
}
