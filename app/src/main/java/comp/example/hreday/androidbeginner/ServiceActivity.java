
package comp.example.hreday.androidbeginner;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class ServiceActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<Upload5> uploadArrayList;
    Adapter6 adapter;
    DatabaseReference databaseReference;
    //  private ProgressBar progressBar;
    FirebaseStorage firebaseStorage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        this.setTitle("ServiceActivity");


        recyclerView = findViewById(R.id.recyclerId5);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // progressBar = findViewById(R.id.progId);
        firebaseStorage = FirebaseStorage.getInstance();


        uploadArrayList = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("Upload5:");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {


                uploadArrayList.clear();


                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {


                    Upload5 upload = dataSnapshot1.getValue(Upload5.class);
                    upload.setKey(dataSnapshot1.getKey());
                    uploadArrayList.add(upload);
                }


                adapter = new Adapter6(uploadArrayList,  ServiceActivity.this);
                recyclerView.setAdapter(adapter);

                adapter.setOnItemClickListener(new Adapter6.onItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        String text = uploadArrayList.get(position).getImageName();
                        Toast.makeText( ServiceActivity  .this, "text is selected " + position, Toast.LENGTH_SHORT).show();

                        if(position==0){


                            Intent intent=new Intent( ServiceActivity  .this, ServiceActivity1.class);
                            startActivity(intent);

                        }


                        if(position==1){


                            Intent intent=new Intent( ServiceActivity .this, ServiceActivity2.class);
                            startActivity(intent);

                        }





                    }

                    @Override
                    public void onDoAnyTask(int poition) {
                        Toast.makeText( ServiceActivity .this, "Do any task is selected", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDelete(int position) {

                        Upload5 selectedItem = uploadArrayList.get(position);


                        final String key = selectedItem.getKey();
                        StorageReference storageReference = firebaseStorage.getReferenceFromUrl(selectedItem.getImageUrl());
                        storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {


                                databaseReference.child(key).removeValue();

                            }
                        });
                    }
                });

                //    progressBar.setVisibility(View.INVISIBLE);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText( ServiceActivity  .this, "Error" + databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                //  progressBar.setVisibility(View.INVISIBLE);

            }
        });

    }
}
