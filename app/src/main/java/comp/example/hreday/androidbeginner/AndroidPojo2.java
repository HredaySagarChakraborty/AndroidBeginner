package comp.example.hreday.androidbeginner;

public class AndroidPojo2 {
    String Title1;
    String description1, details1;

    public AndroidPojo2() {
    }

    public AndroidPojo2(String title1, String description1, String details1) {
        Title1 = title1;
        this.description1 = description1;
        this.details1 = details1;
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

    public String getDetails1() {
        return details1;
    }

    public void setDetails1(String details1) {
        this.details1 = details1;
    }
}
