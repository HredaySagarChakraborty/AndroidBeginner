package comp.example.hreday.androidbeginner;

import com.google.firebase.database.Exclude;

public class Upload3 {

    String imageName3,imageUrl3;

    String key3;

    @Exclude
    public String getKey() {
        return key3;
    }
    @Exclude
    public void setKey(String key3) {
        this.key3 = key3;
    }

    public Upload3() {
    }

    public Upload3(String imageName3, String imageUrl3) {
        this.imageName3 = imageName3;
        this.imageUrl3 = imageUrl3;
    }

    public String getImageName() {
        return imageName3;
    }

    public void setImageName(String imageName3) {
        this.imageName3 = imageName3;
    }

    public String getImageUrl() {
        return imageUrl3;
    }

    public void setImageUrl(String imageUrl3) {
        this.imageUrl3 = imageUrl3;
    }
}
