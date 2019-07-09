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

public class StorageActivity5 extends AppCompatActivity {
    String title,desc1,desc2;
    private TextView textView1,textView2,textView3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage5);
        this.setTitle("StorageActivity5");

        textView1=findViewById(R.id.storageImageActivity5text1Id);
        textView2=findViewById(R.id.storageImageActivity5text2Id);
        textView3=findViewById(R.id.storageImageActivity5text3Id);


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        StorageApiInterface5 apiInterface=retrofit.create( StorageApiInterface5 .class);
        Call<StoragePojo5>call=apiInterface.getData();
        call.enqueue(new Callback<StoragePojo5>() {
            @Override
            public void onResponse(Call<StoragePojo5> call, Response<StoragePojo5> response) {
                title=response.body().getTitle1();
                desc1=response.body().getDescription1();
                desc2=response.body().getDescription2();



                textView1.setText(title);
                textView2.setText(desc1);
                textView3.setText(desc2);


            }

            @Override
            public void onFailure(Call<StoragePojo5> call, Throwable t) {
                Toast.makeText(StorageActivity5.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
