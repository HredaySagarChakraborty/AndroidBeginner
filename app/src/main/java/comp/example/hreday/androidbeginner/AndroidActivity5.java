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

public class AndroidActivity5 extends AppCompatActivity {
    String title1;
    String subtitle1,subtitle2,subtitle3,subtitle4,subtitle5;
    String desc1,desc2,desc3,desc4,desc5;
    private TextView androidImageActivity5text1,androidImageActivity5text2,androidImageActivity5text3,androidImageActivity5text4,
    androidImageActivity5text5,androidImageActivity5text6,androidImageActivity5text7,androidImageActivity5text8,
            androidImageActivity5text9,androidImageActivity5text10,androidImageActivity5text11

            ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android5);
        this.setTitle("AndroidActivity5");

        androidImageActivity5text1=findViewById(R.id.androidImageActivity5text1Id);
        androidImageActivity5text2=findViewById(R.id.androidImageActivity5text2Id);
        androidImageActivity5text3=findViewById(R.id.androidImageActivity5text3Id);
        androidImageActivity5text4=findViewById(R.id.androidImageActivity5text4Id);
        androidImageActivity5text5=findViewById(R.id.androidImageActivity5text5Id);
        androidImageActivity5text6=findViewById(R.id.androidImageActivity5text6Id);
        androidImageActivity5text7=findViewById(R.id.androidImageActivity5text7Id);
        androidImageActivity5text8=findViewById(R.id.androidImageActivity5text8Id);
        androidImageActivity5text9=findViewById(R.id.androidImageActivity5text9Id);
        androidImageActivity5text10=findViewById(R.id.androidImageActivity5text10Id);
        androidImageActivity5text11=findViewById(R.id.androidImageActivity5text11Id);


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create()).build();


        AndroidApiInterface5 apiInterface=retrofit.create(AndroidApiInterface5.class);
        Call<AndroidPojo5>call=apiInterface.getData();
        call.enqueue(new Callback<AndroidPojo5>() {
            @Override
            public void onResponse(Call<AndroidPojo5> call, Response<AndroidPojo5> response) {
                title1=response.body().getTitle1();

                subtitle1=response.body().getSubTitle1();
                desc1=response.body().getDescription1();

                subtitle2=response.body().getSubTitle2();
                desc2=response.body().getDescription2();

                subtitle3=response.body().getSubTitle3();
                desc3=response.body().getDescription3();

                subtitle4=response.body().getSubTitle4();
                desc4=response.body().getDescription4();

                subtitle5=response.body().getSubTitle5();
                desc5=response.body().getDescription5();




                androidImageActivity5text1.setText(title1);


                androidImageActivity5text2.setText(subtitle1);
                androidImageActivity5text3.setText(desc1);

                androidImageActivity5text4.setText(subtitle2);
                androidImageActivity5text5.setText(desc2);


                androidImageActivity5text6.setText(subtitle3);
                androidImageActivity5text7.setText(desc3);


                androidImageActivity5text8.setText(subtitle4);
                androidImageActivity5text9.setText(desc4);


                androidImageActivity5text10.setText(subtitle5);
                androidImageActivity5text11.setText(desc5);




            }

            @Override
            public void onFailure(Call<AndroidPojo5> call, Throwable t) {
                Toast.makeText(AndroidActivity5.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
