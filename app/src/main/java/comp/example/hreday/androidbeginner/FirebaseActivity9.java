


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

public class FirebaseActivity9 extends AppCompatActivity implements View.OnClickListener {
    private Button choose8, save8, display8;
    private EditText editText8;
    private ImageView imageView8;
    private Uri imageUri8;
    private static final int IMAGE_REQUEST = 1;

    DatabaseReference databaseReference;
    StorageReference storageReference;
    StorageTask uploadTask;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase9);
       // getSupportActionBar().hide();

        this.setTitle("FirebaseActivity9");


        choose8 = findViewById(R.id.chooseButton8);

        editText8=findViewById(R.id.editTextId8);
        save8 = findViewById(R.id.saveButton8);
        display8 = findViewById(R.id.displayButton8);


        databaseReference = FirebaseDatabase.getInstance().getReference("Upload8:");
        storageReference = FirebaseStorage.getInstance().getReference("Upload8:");

        imageView8 = findViewById(R.id.imageViewId8);


        choose8.setOnClickListener(this);
        save8.setOnClickListener(this);
        display8.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {


        if (view.getId() == R.id.chooseButton8) {
            openFileChooser();


        } else if (view.getId() == R.id.saveButton8) {

            if(uploadTask!=null && uploadTask.isInProgress()){
                Toast.makeText(FirebaseActivity9.this, "Uploading in progress", Toast.LENGTH_SHORT).show();
            }

            else{
                saveData();

            }




        } else if (view.getId() == R.id.displayButton8) {

            Intent intent =new Intent(FirebaseActivity9.this,StorageActivity.class);
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
            imageUri8 = data.getData();
            Picasso.with(this).load(imageUri8).into(imageView8);


        }

    }

    public String getFileExtension(Uri imageUri){

        ContentResolver contentResolver=getContentResolver();

        MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(imageUri));


    }


    private void saveData() {


        final String editText18=editText8.getText().toString().trim();

        if(editText18.isEmpty()){


            editText8.setError("Enter the image name");
            editText8.requestFocus();
            return;
        }

        StorageReference ref=storageReference.child(System.currentTimeMillis()+ " ."+ getFileExtension(imageUri8));

        ref.putFile(imageUri8).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {


                Toast.makeText(FirebaseActivity9.this, "Unsuccessfull", Toast.LENGTH_SHORT).show();
                // Handle unsuccessful uploads
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.

                Toast.makeText(FirebaseActivity9.this, "Succesfull", Toast.LENGTH_SHORT).show();


                Task<Uri> uriTask =taskSnapshot.getStorage().getDownloadUrl();
                while(!uriTask.isSuccessful());


                Uri downloadUri=uriTask.getResult();




                Upload8 upload=new Upload8(editText18,downloadUri.toString());
                String uploadId=databaseReference.push().getKey();

                databaseReference.child(uploadId).setValue(upload);
            }
        });



    }
}
