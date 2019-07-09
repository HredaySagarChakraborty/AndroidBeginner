package comp.example.hreday.androidbeginner;

public class MenuPojo2 {
    String Title1;
    String description1, description2;

    public MenuPojo2() {
    }

    public MenuPojo2(String title1, String description1, String description2) {
        Title1 = title1;
        this.description1 = description1;
        this.description2 = description2;
    }

    public String getTitle1() {
        return Title1;
    }

    public void setTitle1(String title1) {
        Title1 = title1;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }
}
