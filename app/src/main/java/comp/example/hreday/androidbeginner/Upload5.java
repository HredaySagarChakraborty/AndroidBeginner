package comp.example.hreday.androidbeginner;

import com.google.firebase.database.Exclude;

public class Upload5 {

    String imageName5,imageUrl5;

    String key5;

    @Exclude
    public String getKey() {
        return key5;
    }
    @Exclude
    public void setKey(String key5) {
        this.key5 = key5;
    }

    public Upload5() {
    }

    public Upload5(String imageName5, String imageUrl5) {
        this.imageName5 = imageName5;
        this.imageUrl5 = imageUrl5;
    }

    public String getImageName() {
        return imageName5;
    }

    public void setImageName(String imageName5) {
        this.imageName5 = imageName5;
    }

    public String getImageUrl() {
        return imageUrl5;
    }

    public void setImageUrl(String imageUrl5) {
        this.imageUrl5 = imageUrl5;
    }
}
