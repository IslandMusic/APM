package islandmusic.apm;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.Toast;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.cognito.CognitoSyncManager;
import com.amazonaws.mobileconnectors.cognito.Dataset;
import com.amazonaws.mobileconnectors.cognito.DefaultSyncCallback;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

import java.util.List;

public class ContPhotoActivity extends AppCompatActivity {
    private static int RESULT_LOAD_IMG = 1;
    private ImageView imageView;
    //May need fixing or removal
    AWSCredentialsProvider credentialsProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont_photo);
        
        imageView = (ImageView) findViewById(R.id.imgView);

        final Button pickGalleryButton;
        pickGalleryButton = (Button) findViewById(R.id.btn_gallery);
        pickGalleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
    }

    private void openGallery() {
        Intent gallery =
                new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, RESULT_LOAD_IMG);
    }
    /** Called when the user clicks the Gallery button*/
    /**
    public void launchGallery(View view) {
        // Create intent to Open Image applications like Gallery, Google Photos
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
    }
     */



     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
         super.onActivityResult(requestCode, resultCode, data);
         if (resultCode == RESULT_OK && requestCode == RESULT_LOAD_IMG) {
             Intent intent = new Intent(ContPhotoActivity.this,S3Upload.class);

/*

       //      Uri imageUri = data.getData();
      //      imageView.setImageURI(imageUri);

             //Summons a AWS credentialsProvider to carry your image
             AmazonS3 s3 = new AmazonS3Client(credentialsProvider);
             TransferUtility transferUtility = new TransferUtility(s3, getApplicationContext());

    //         TransferObserver observer = transferUtility.upload(
    //                 MY_BUCKET,     /* The bucket to upload to */
   //                  OBJECT_KEY,    /* The key for the uploaded object */
   //                  MY_FILE        /* The file where the data to upload exists */
  //           );
/*
             // Initialize the Amazon Cognito credentials provider
             CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                     getApplicationContext(),
                     "us-west-2:d18d3245-afb8-4bba-b010-d38eef72d706", // Identity Pool ID
                     Regions.US_WEST_2 // Region
             );
             // Initialize the Cognito Sync client
             CognitoSyncManager syncClient = new CognitoSyncManager(
                     getApplicationContext(),
                     Regions.US_WEST_2, // Region
                     credentialsProvider);

            // Create a record in a dataset and synchronize with the server
             Dataset dataset = syncClient.openOrCreateDataset("myDataset");
             dataset.put("myKey", "myValue");
             dataset.synchronize(new DefaultSyncCallback() {
                 @Override
                 public void onSuccess(Dataset dataset, List newRecords) {
                     //Your handler code here
                 }
             }); */
         }
     }
}
        /* try {
             // When an Image is picked
             if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                     && null != data) {
                 // Get the Image from data

                 Uri selectedImage = data.getData();
                 String[] filePathColumn = {MediaStore.Images.Media.DATA};

                 // Get the cursor
                 Cursor cursor = getContentResolver().query(selectedImage,
                         filePathColumn, null, null, null);
                 // Move to first row
                 cursor.moveToFirst();

                 int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                 imgDecodableString = cursor.getString(columnIndex);
                 cursor.close();
                 ImageView imgView = (ImageView) findViewById(R.id.imgView);
                 // Set the Image in ImageView after decoding the String
                 imgView.setImageBitmap(BitmapFactory
                         .decodeFile(imgDecodableString));

             } else {
                 Toast.makeText(this, "You haven't picked Image",
                         Toast.LENGTH_LONG).show();
             }
         } catch (Exception e) {
             Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                     .show();
         }
     }*/

