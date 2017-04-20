package islandmusic.apm;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Gallery;
import android.widget.ImageView;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.Toast;

public class ContPhotoActivity extends AppCompatActivity {
    private static int RESULT_LOAD_IMG = 1;
    String imgDecodableString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont_photo);

        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 2);

    }

    /**
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

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

        }
    }
*/

    /** Called when the user clicks the Gallery button*/
    public void launchGallery(View view) {
        Intent intent = new Intent(this, Gallery.class);
        startActivity(intent);

    }


 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     super.onActivityResult(requestCode, resultCode, data);
     try {
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
 }
}

