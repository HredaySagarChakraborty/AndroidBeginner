package comp.example.hreday.androidbeginner;

import com.google.firebase.database.Exclude;

public class Upload9 {

    String imageName9,imageUrl9;


    String key9;

    @Exclude
    public String getKey() {
        return key9;
    }
    @Exclude
    public void setKey(String key9) {
        this.key9 = key9;
    }

    public Upload9() {
    }

    public Upload9(String imageName9, String imageUrl9) {
        this.imageName9 = imageName9;
        this.imageUrl9 = imageUrl9;
    }

    public String getImageName() {
        return imageName9;
    }

    public void setImageName(String imageName9) {
        this.imageName9 = imageName9;
    }

    public String getImageUrl() {
        return imageUrl9;
    }

    public void setImageUrl(String imageUrl9) {
        this.imageUrl9 = imageUrl9;
    }
}
