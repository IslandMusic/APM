package islandmusic.apm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Contribute extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contribute); }

    /** Called when the user clicks the Looking button*/
    public void launchPicture(View view) {
        Intent intent = new Intent(this, ContPhotoActivity.class);
        startActivity(intent);

    }
}
