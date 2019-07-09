
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

public class StructureActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<Upload1> uploadArrayList;
    Adapter2 adapter;
    DatabaseReference databaseReference;
    //  private ProgressBar progressBar;
    FirebaseStorage firebaseStorage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structure);
        this.setTitle("StructureActivity");


        recyclerView = findViewById(R.id.recyclerId1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // progressBar = findViewById(R.id.progId);
        firebaseStorage = FirebaseStorage.getInstance();


        uploadArrayList = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("Upload1:");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {


                uploadArrayList.clear();


                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {


                    Upload1 upload = dataSnapshot1.getValue(Upload1.class);
                    upload.setKey(dataSnapshot1.getKey());
                    uploadArrayList.add(upload);
                }


                adapter = new Adapter2(uploadArrayList, StructureActivity.this);
                recyclerView.setAdapter(adapter);

                adapter.setOnItemClickListener(new Adapter2.onItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        String text = uploadArrayList.get(position).getImageName();
                        Toast.makeText(StructureActivity.this, "text is selected " + position, Toast.LENGTH_SHORT).show();

                        if(position==0){


                            Intent intent=new Intent(StructureActivity.this,StructureActivity1.class);
                            startActivity(intent);

                        }

                        if(position==1){


                            Intent intent=new Intent(StructureActivity.this,StructureActivity2.class);
                            startActivity(intent);

                        }

                        if(position==2){


                            Intent intent=new Intent(StructureActivity.this,StructureActivity3.class);
                            startActivity(intent);

                        }

                        if(position==3){


                            Intent intent=new Intent(StructureActivity.this,StructureActivity4.class);
                            startActivity(intent);

                        }

                        if(position==4){


                            Intent intent=new Intent(StructureActivity.this,StructureActivity5.class);
                            startActivity(intent);

                        }

                        if(position==5){


                            Intent intent=new Intent(StructureActivity.this,StructureActivity6.class);
                            startActivity(intent);

                        }




                    }

                    @Override
                    public void onDoAnyTask(int poition) {
                        Toast.makeText(StructureActivity.this, "Do any task is selected", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDelete(int position) {

                        Upload1 selectedItem = uploadArrayList.get(position);


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

                Toast.makeText(StructureActivity.this, "Error" + databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                //  progressBar.setVisibility(View.INVISIBLE);

            }
        });

    }
}
