package islandmusic.apm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Contribute extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contribute);
    }
}

/** Called when the user clicks the Looking button*/
 public void launchLook(View view) {
 Intent intent = new Intent(this, ContPhotoActivity.class);
 startActivity(intent);

 }