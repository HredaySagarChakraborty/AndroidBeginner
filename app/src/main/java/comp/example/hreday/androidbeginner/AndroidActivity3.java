package comp.example.hreday.androidbeginner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AndroidActivity3 extends AppCompatActivity {
    String title1,desc11;
    String title2,desc12;
    String title3,desc13;
    String title4,desc14;
    String title5,desc15;
    String title6,desc16;
    String title7,desc17;
    String title8,desc18;
    String title9,desc19;
    String title10,desc110;
    private TextView imageTitle1,imageTitle2,imageTitle3,imageTitle4,imageTitle5,imageTitle6,imageTitle7,imageTitle8,imageTitle9,imageTitle10;
    private TextView imageDescription1,imageDescription2,imageDescription3,imageDescription4,imageDescription5,imageDescription6,
            imageDescription7,imageDescription8,imageDescription9,imageDescription10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android3);
        this.setTitle("AndroidActivity3");

       imageTitle1=findViewById(R.id.imageTitle1Id);
       imageTitle2=findViewById(R.id.imageTitle2Id);
       imageTitle3=findViewById(R.id.imageTitle3Id);
       imageTitle4=findViewById(R.id.imageTitle4Id);
       imageTitle5=findViewById(R.id.imageTitle5Id);
       imageTitle6=findViewById(R.id.imageTitle6Id);
       imageTitle7=findViewById(R.id.imageTitle7Id);
       imageTitle8=findViewById(R.id.imageTitle8Id);
       imageTitle9=findViewById(R.id.imageTitle9Id);
       imageTitle10=findViewById(R.id.imageTitle10Id);

       imageDescription1=findViewById(R.id.imageDescription1Id);
       imageDescription2=findViewById(R.id.imageDescription2Id);
       imageDescription3=findViewById(R.id.imageDescription3Id);
       imageDescription4=findViewById(R.id.imageDescription4Id);
       imageDescription5=findViewById(R.id.imageDescription5Id);
       imageDescription6=findViewById(R.id.imageDescription6Id);
       imageDescription7=findViewById(R.id.imageDescription7Id);
       imageDescription8=findViewById(R.id.imageDescription8Id);
       imageDescription9=findViewById(R.id.imageDescription9Id);
       imageDescription10=findViewById(R.id.imageDescription10Id);


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create()).build();


        AndroidApiInterface3 apiInterface=retrofit.create(AndroidApiInterface3.class);
        Call<AndroidPojo3>call=apiInterface.getData();
        call.enqueue(new Callback<AndroidPojo3>() {
            @Override
            public void onResponse(Call<AndroidPojo3> call, Response<AndroidPojo3> response) {
                title1=response.body().getTitle1();
                desc11=response.body().getDescription1();

                title2=response.body().getTitle2();
                desc12=response.body().getDescription2();

                title3=response.body().getTitle3();
                desc13=response.body().getDescription3();



                title4=response.body().getTitle4();
                desc14=response.body().getDescription4();

                title5=response.body().getTitle5();
                desc15=response.body().getDescription5();

                title6=response.body().getTitle6();
                desc16=response.body().getDescription6();

                title7=response.body().getTitle7();
                desc17=response.body().getDescription7();


                title8=response.body().getTitle8();
                desc18=response.body().getDescription8();


                title9=response.body().getTitle9();
                desc19=response.body().getDescription9();

                title10=response.body().getTitle10();
                desc110=response.body().getDescription10();





                imageTitle1.setText(title1);
                imageDescription1.setText(desc11);


                imageTitle2.setText(title2);
                imageDescription2.setText(desc12);


                imageTitle3.setText(title3);
                imageDescription3.setText(desc13);


                imageTitle4.setText(title4);
                imageDescription4.setText(desc14);

                imageTitle5.setText(title5);
                imageDescription5.setText(desc15);

                imageTitle6.setText(title6);
                imageDescription6.setText(desc16);

                imageTitle7.setText(title7);
                imageDescription7.setText(desc17);

                imageTitle8.setText(title8);
                imageDescription8.setText(desc18);

                imageTitle9.setText(title9);
                imageDescription9.setText(desc19);

                imageTitle10.setText(title10);
                imageDescription10.setText(desc110);


            }

            @Override
            public void onFailure(Call<AndroidPojo3> call, Throwable t) {
                Toast.makeText(AndroidActivity3.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
