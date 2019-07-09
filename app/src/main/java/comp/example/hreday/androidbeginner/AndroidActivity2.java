package comp.example.hreday.androidbeginner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AndroidActivity2 extends AppCompatActivity {
    String title1,desc11,details1;
    private TextView android2Text1,android2Text2,android2Text3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android2);
        this.setTitle("AndroidActivity2");

        android2Text1=findViewById(R.id.androidImage1Id);
        android2Text2=findViewById(R.id.androidImage2Id);
        android2Text3=findViewById(R.id.androidImage3Id);


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create()).build();


        AndroidApiInterface2 apiInterface=retrofit.create(AndroidApiInterface2.class);
        Call<AndroidPojo2>call=apiInterface.getData();
       call.enqueue(new Callback<AndroidPojo2>() {
           @Override
           public void onResponse(Call<AndroidPojo2> call, Response<AndroidPojo2> response) {
              title1=response.body().getTitle1();
               desc11=response.body().getDescription1();
               details1=response.body().getDetails1();



               android2Text1.setText(title1);
               android2Text2.setText(desc11);
               android2Text3.setText(details1  );
           }

           @Override
           public void onFailure(Call<AndroidPojo2> call, Throwable t) {

           }
       });


    }
}
