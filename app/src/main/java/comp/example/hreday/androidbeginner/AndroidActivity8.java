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

public class AndroidActivity8 extends AppCompatActivity {
    String title;
    String title1, desc11;
    String title2, desc12;
    String title3, desc13;
    String title4, desc14;


    private TextView androidImageActivity8text1, androidImageActivity8text2, androidImageActivity8text3, androidImageActivity8text4;
    private TextView androidImageActivity8text5,
            androidImageActivity8text6, androidImageActivity8text7, androidImageActivity8text8, androidImageActivity8text9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android8);
        this.setTitle("AndroidActivity8");

        androidImageActivity8text1 = findViewById(R.id.androidImageActivity8text1Id);
        androidImageActivity8text2 = findViewById(R.id.androidImageActivity8text2Id);
        androidImageActivity8text3 = findViewById(R.id.androidImageActivity8text3Id);
        androidImageActivity8text4 = findViewById(R.id.androidImageActivity8text4Id);
        androidImageActivity8text5 = findViewById(R.id.androidImageActivity8text5Id);
        androidImageActivity8text6 = findViewById(R.id.androidImageActivity8text6Id);
        androidImageActivity8text7 = findViewById(R.id.androidImageActivity8text7Id);
        androidImageActivity8text8 = findViewById(R.id.androidImageActivity8text8Id);
        androidImageActivity8text9 = findViewById(R.id.androidImageActivity8text9Id);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create()).build();


        AndroidApiInterface8 apiInterface = retrofit.create(AndroidApiInterface8.class);
        Call<AndroidPojo8> call = apiInterface.getData();
        call.enqueue(new Callback<AndroidPojo8>() {
            @Override
            public void onResponse(Call<AndroidPojo8> call, Response<AndroidPojo8> response) {
                title = response.body().getTitle1();


                title1 = response.body().getSubtitle1();
                desc11 = response.body().getDescription1();


                title2 = response.body().getSubtitle2();
                desc12 = response.body().getDescription2();

                title3 = response.body().getSubtitle3();
                desc13 = response.body().getDescription3();

                title4 = response.body().getSubtitle4();
                desc14 = response.body().getDescription4();


                androidImageActivity8text1.setText(title);


                androidImageActivity8text2.setText(title1);
                androidImageActivity8text3.setText(desc11);

                androidImageActivity8text4.setText(title2);
                androidImageActivity8text5.setText(desc12);

                androidImageActivity8text6.setText(title3);
                androidImageActivity8text7.setText(desc13);

                androidImageActivity8text8.setText(title4);
                androidImageActivity8text9.setText(desc14);


            }

            @Override
            public void onFailure(Call<AndroidPojo8> call, Throwable t) {
                Toast.makeText(AndroidActivity8.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
