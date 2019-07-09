


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

public class FirebaseActivity7 extends AppCompatActivity implements View.OnClickListener {
    private Button choose6, save6, display6;
    private EditText editText6;
    private ImageView imageView6;
    private Uri imageUri6;
    private static final int IMAGE_REQUEST = 1;

    DatabaseReference databaseReference;
    StorageReference storageReference;
    StorageTask uploadTask;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase7);

        this.setTitle("FirebaseActivity7");


        choose6 = findViewById(R.id.chooseButton6);

        editText6=findViewById(R.id.editTextId6);
        save6 = findViewById(R.id.saveButton6);
        display6 = findViewById(R.id.displayButton6);


        databaseReference = FirebaseDatabase.getInstance().getReference("Upload6:");
        storageReference = FirebaseStorage.getInstance().getReference("Upload6:");

        imageView6 = findViewById(R.id.imageViewId6);


        choose6.setOnClickListener(this);
        save6.setOnClickListener(this);
        display6.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {


        if (view.getId() == R.id.chooseButton6) {
            openFileChooser();


        } else if (view.getId() == R.id.saveButton6) {

            if(uploadTask!=null && uploadTask.isInProgress()){
                Toast.makeText(FirebaseActivity7.this, "Uploading in progress", Toast.LENGTH_SHORT).show();
            }

            else{
                saveData();

            }




        } else if (view.getId() == R.id.displayButton6) {

            Intent intent =new Intent(FirebaseActivity7.this,MenuActivity.class);
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
            imageUri6 = data.getData();
            Picasso.with(this).load(imageUri6).into(imageView6);


        }

    }

    public String getFileExtension(Uri imageUri){

        ContentResolver contentResolver=getContentResolver();

        MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(imageUri));


    }


    private void saveData() {


        final String editText16=editText6.getText().toString().trim();

        if(editText16.isEmpty()){


            editText6.setError("Enter the image name");
            editText6.requestFocus();
            return;
        }

        StorageReference ref=storageReference.child(System.currentTimeMillis()+ " ."+ getFileExtension(imageUri6));

        ref.putFile(imageUri6).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {


                Toast.makeText(FirebaseActivity7.this, "Unsuccessfull", Toast.LENGTH_SHORT).show();
                // Handle unsuccessful uploads
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.

                Toast.makeText(FirebaseActivity7.this, "Succesfull", Toast.LENGTH_SHORT).show();


                Task<Uri> uriTask =taskSnapshot.getStorage().getDownloadUrl();
                while(!uriTask.isSuccessful());


                Uri downloadUri=uriTask.getResult();




                Upload6 upload=new Upload6(editText16,downloadUri.toString());
                String uploadId=databaseReference.push().getKey();

                databaseReference.child(uploadId).setValue(upload);
            }
        });



    }
}
