package islandmusic.apm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ContPhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cont_photo);
    }
}

    /** Called when the user clicks the Gallery button*/
    public void launchGallery(View view) {
        Intent intent = new Intent(this, Gallery.class);
        startActivity(intent);

    }