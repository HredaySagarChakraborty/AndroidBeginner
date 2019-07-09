package comp.example.hreday.androidbeginner;

public class AndroidPojo1 {
    String Title;
    String description, details;

    public AndroidPojo1() {
    }

    public AndroidPojo1(String title, String description, String details) {
        Title = title;
        this.description = description;
        this.details = details;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
