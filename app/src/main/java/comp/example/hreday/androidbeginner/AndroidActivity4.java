package comp.example.hreday.androidbeginner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AndroidActivity4 extends AppCompatActivity {
    String title1,desc15,desc2,desc3;
    private TextView androidImageActivity4text1,androidImageActivity4text2,androidImageActivity4text3,androidImageActivity4text4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android4);
        this.setTitle("AndroidActivity4");

        androidImageActivity4text1=findViewById(R.id.androidImageActivity4text1Id);
        androidImageActivity4text2=findViewById(R.id.androidImageActivity4text2Id);
        androidImageActivity4text3=findViewById(R.id.androidImageActivity4text3Id);
        androidImageActivity4text4=findViewById(R.id.androidImageActivity4text4Id);


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create()).build();


        AndroidApiInterface4 apiInterface=retrofit.create(AndroidApiInterface4.class);
        Call<AndroidPojo4>call=apiInterface.getData();
        call.enqueue(new Callback<AndroidPojo4>() {
            @Override
            public void onResponse(Call<AndroidPojo4> call, Response<AndroidPojo4> response) {
                title1=response.body().getTitle1();
                desc15=response.body().getDescription1();
                desc2=response.body().getDescription2();
                desc3=response.body().getDescription3();




                androidImageActivity4text1.setText(title1);
                androidImageActivity4text2.setText(desc15);
                androidImageActivity4text3.setText(desc2);
                androidImageActivity4text4.setText(desc3);
            }

            @Override
            public void onFailure(Call<AndroidPojo4> call, Throwable t) {

            }
        });


    }
}
