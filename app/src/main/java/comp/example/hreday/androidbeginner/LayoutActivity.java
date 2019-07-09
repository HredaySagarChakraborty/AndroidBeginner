
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

public class LayoutActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<Upload2> uploadArrayList;
    Adapter3 adapter;
    DatabaseReference databaseReference;
    //  private ProgressBar progressBar;
    FirebaseStorage firebaseStorage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        this.setTitle("LayoutActivity");


        recyclerView = findViewById(R.id.recyclerId2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // progressBar = findViewById(R.id.progId);
        firebaseStorage = FirebaseStorage.getInstance();


        uploadArrayList = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("Upload2:");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {


                uploadArrayList.clear();


                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {


                    Upload2 upload = dataSnapshot1.getValue(Upload2.class);
                    upload.setKey(dataSnapshot1.getKey());
                    uploadArrayList.add(upload);
                }


                adapter = new Adapter3(uploadArrayList, LayoutActivity .this);
                recyclerView.setAdapter(adapter);

                adapter.setOnItemClickListener(new Adapter3.onItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        String text = uploadArrayList.get(position).getImageName();
                        Toast.makeText(LayoutActivity .this, "text is selected " + position, Toast.LENGTH_SHORT).show();

                        if(position==0){


                            Intent intent=new Intent(LayoutActivity .this,LayoutActivity1.class);
                            startActivity(intent);

                        }


                        if(position==1){


                            Intent intent=new Intent(LayoutActivity .this,LayoutActivity2.class);
                            startActivity(intent);

                        }


                        if(position==2){


                            Intent intent=new Intent(LayoutActivity .this,LayoutActivity3.class);
                            startActivity(intent);

                        }

                        if(position==3){


                            Intent intent=new Intent(LayoutActivity .this,LayoutActivity4.class);
                            startActivity(intent);

                        }

                        if(position==4){


                            Intent intent=new Intent(LayoutActivity .this,LayoutActivity5.class);
                            startActivity(intent);

                        }

                        if(position==5){


                            Intent intent=new Intent(LayoutActivity .this,LayoutActivity6.class);
                            startActivity(intent);

                        }











                    }

                    @Override
                    public void onDoAnyTask(int poition) {
                        Toast.makeText(LayoutActivity .this, "Do any task is selected", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDelete(int position) {

                        Upload2 selectedItem = uploadArrayList.get(position);


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

                Toast.makeText(LayoutActivity .this, "Error" + databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                //  progressBar.setVisibility(View.INVISIBLE);

            }
        });

    }
}
