


package comp.example.hreday.androidbeginner;


import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class FirebaseActivity10 extends AppCompatActivity implements View.OnClickListener {
    private Button choose9, save9, display9;
    private EditText editText9;
    private ImageView imageView9;
    private Uri imageUri9;
    private static final int IMAGE_REQUEST = 1;

    DatabaseReference databaseReference;
    StorageReference storageReference;
    StorageTask uploadTask;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase10);
        // getSupportActionBar().hide();

        this.setTitle("FirebaseActivity10");


        choose9 = findViewById(R.id.chooseButton9);

        editText9=findViewById(R.id.editTextId9);
        save9 = findViewById(R.id.saveButton9);
        display9 = findViewById(R.id.displayButton9);


        databaseReference = FirebaseDatabase.getInstance().getReference("Upload9:");
        storageReference = FirebaseStorage.getInstance().getReference("Upload9:");

        imageView9 = findViewById(R.id.imageViewId9);


        choose9.setOnClickListener(this);
        save9.setOnClickListener(this);
        display9.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {


        if (view.getId() == R.id.chooseButton9) {
            openFileChooser();


        } else if (view.getId() == R.id.saveButton9) {

            if(uploadTask!=null && uploadTask.isInProgress()){
                Toast.makeText(FirebaseActivity10.this, "Uploading in progress", Toast.LENGTH_SHORT).show();
            }

            else{
                saveData();

            }




        } else if (view.getId() == R.id.displayButton9) {

            Intent intent =new Intent(FirebaseActivity10.this,SqliteActivity.class);
            startActivity(intent);


        }


    }



    private void openFileChooser() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri9 = data.getData();
            Picasso.with(this).load(imageUri9).into(imageView9);


        }

    }

    public String getFileExtension(Uri imageUri){

        ContentResolver contentResolver=getContentResolver();

        MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(imageUri));


    }


    private void saveData() {


        final String editText19=editText9.getText().toString().trim();

        if(editText19.isEmpty()){


            editText9.setError("Enter the image name");
            editText9.requestFocus();
            return;
        }

        StorageReference ref=storageReference.child(System.currentTimeMillis()+ " ."+ getFileExtension(imageUri9));

        ref.putFile(imageUri9).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {


                Toast.makeText(FirebaseActivity10.this, "Unsuccessfull", Toast.LENGTH_SHORT).show();
                // Handle unsuccessful uploads
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.

                Toast.makeText(FirebaseActivity10.this, "Succesfull", Toast.LENGTH_SHORT).show();


                Task<Uri> uriTask =taskSnapshot.getStorage().getDownloadUrl();
                while(!uriTask.isSuccessful());


                Uri downloadUri=uriTask.getResult();




                Upload8 upload=new Upload8(editText19,downloadUri.toString());
                String uploadId=databaseReference.push().getKey();

                databaseReference.child(uploadId).setValue(upload);
            }
        });



    }
}
