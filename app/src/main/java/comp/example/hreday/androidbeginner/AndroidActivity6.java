package comp.example.hreday.androidbeginner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AndroidActivity6 extends AppCompatActivity {
    String title1,desc11,desc2,desc3;
    private TextView androidImageActivity6text1,androidImageActivity6text2,androidImageActivity6text3,androidImageActivity6text4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android6);
        this.setTitle("AndroidActivity6");

        androidImageActivity6text1=findViewById(R.id.androidImageActivity6text1Id);
        androidImageActivity6text2=findViewById(R.id.androidImageActivity6text2Id);
        androidImageActivity6text3=findViewById(R.id.androidImageActivity6text3Id);
        androidImageActivity6text4=findViewById(R.id.androidImageActivity6text4Id);


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create()).build();


        AndroidApiInterface6 apiInterface=retrofit.create(AndroidApiInterface6.class);
        Call<AndroidPojo6>call=apiInterface.getData();
        call.enqueue(new Callback<AndroidPojo6>() {
            @Override
            public void onResponse(Call<AndroidPojo6> call, Response<AndroidPojo6> response) {
                title1=response.body().getTitle1();
                desc11=response.body().getDescription1();
                desc2=response.body().getDscription2();
                desc3=response.body().getDescription3();




                androidImageActivity6text1.setText(title1);
                androidImageActivity6text2.setText(desc11);
                androidImageActivity6text3.setText(desc2  );
                androidImageActivity6text4.setText(desc3  );
            }

            @Override
            public void onFailure(Call<AndroidPojo6> call, Throwable t) {

            }
        });


    }
}
