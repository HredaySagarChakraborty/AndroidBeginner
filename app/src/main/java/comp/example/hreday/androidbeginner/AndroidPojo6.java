package comp.example.hreday.androidbeginner;

    public class AndroidPojo6 {
        String Title1;
        String description1, dscription2,description3;

        public AndroidPojo6() {
        }

        public AndroidPojo6(String title1, String description1, String dscription2, String description3) {
            Title1 = title1;
            this.description1 = description1;
            this.dscription2 = dscription2;
            this.description3 = description3;
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

        public String getDscription2() {
            return dscription2;
        }

        public void setDscription2(String dscription2) {
            this.dscription2 = dscription2;
        }

        public String getDescription3() {
            return description3;
        }

        public void setDescription3(String description3) {
            this.description3 = description3;
        }
    }
