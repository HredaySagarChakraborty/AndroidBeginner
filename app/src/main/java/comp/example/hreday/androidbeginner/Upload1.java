package comp.example.hreday.androidbeginner;

import com.google.firebase.database.Exclude;

public class Upload1 {

    String imageName1,imageUrl1;

    String key1;

    @Exclude
    public String getKey() {
        return key1;
    }
    @Exclude
    public void setKey(String key1) {
        this.key1 = key1;
    }

    public Upload1() {
    }

    public Upload1(String imageName1, String imageUrl1) {
        this.imageName1 = imageName1;
        this.imageUrl1 = imageUrl1;
    }

    public String getImageName() {
        return imageName1;
    }

    public void setImageName(String imageName1) {
        this.imageName1 = imageName1;
    }

    public String getImageUrl() {
        return imageUrl1;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl1 = imageUrl1;
    }
}
