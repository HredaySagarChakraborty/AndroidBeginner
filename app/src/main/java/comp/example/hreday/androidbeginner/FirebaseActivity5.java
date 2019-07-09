


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

public class FirebaseActivity5 extends AppCompatActivity implements View.OnClickListener {
    private Button choose4, save4, display4;
    private EditText editText4;
    private ImageView imageView4;
    private Uri imageUri4;
    private static final int IMAGE_REQUEST = 1;

    DatabaseReference databaseReference;
    StorageReference storageReference;
    StorageTask uploadTask;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase5);

        this.setTitle("FirebaseActivity5");


        choose4 = findViewById(R.id.chooseButton4);

        editText4=findViewById(R.id.editTextId4);
        save4 = findViewById(R.id.saveButton4);
        display4 = findViewById(R.id.displayButton4);


        databaseReference = FirebaseDatabase.getInstance().getReference("Upload4:");
        storageReference = FirebaseStorage.getInstance().getReference("Upload4:");

        imageView4 = findViewById(R.id.imageViewId4);


        choose4.setOnClickListener(this);
        save4.setOnClickListener(this);
        display4.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {


        if (view.getId() == R.id.chooseButton4) {
            openFileChooser();


        } else if (view.getId() == R.id.saveButton4) {

            if(uploadTask!=null && uploadTask.isInProgress()){
                Toast.makeText(FirebaseActivity5.this, "Uploading in progress", Toast.LENGTH_SHORT).show();
            }

            else{
                saveData();

            }




        } else if (view.getId() == R.id.displayButton4) {

            Intent intent =new Intent(FirebaseActivity5.this,FragmentActivity.class);
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
            imageUri4 = data.getData();
            Picasso.with(this).load(imageUri4).into(imageView4);


        }

    }

    public String getFileExtension(Uri imageUri){

        ContentResolver contentResolver=getContentResolver();

        MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(imageUri));


    }


    private void saveData() {


        final String editText14=editText4.getText().toString().trim();

        if(editText14.isEmpty()){


            editText4.setError("Enter the image name");
            editText4.requestFocus();
            return;
        }

        StorageReference ref=storageReference.child(System.currentTimeMillis()+ " ."+ getFileExtension(imageUri4));

        ref.putFile(imageUri4).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {


                Toast.makeText(FirebaseActivity5.this, "Unsuccessfull", Toast.LENGTH_SHORT).show();
                // Handle unsuccessful uploads
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.

                Toast.makeText(FirebaseActivity5.this, "Succesfull", Toast.LENGTH_SHORT).show();


                Task<Uri> uriTask =taskSnapshot.getStorage().getDownloadUrl();
                while(!uriTask.isSuccessful());


                Uri downloadUri=uriTask.getResult();




                Upload4 upload=new Upload4(editText14,downloadUri.toString());
                String uploadId=databaseReference.push().getKey();

                databaseReference.child(uploadId).setValue(upload);
            }
        });



    }
}
