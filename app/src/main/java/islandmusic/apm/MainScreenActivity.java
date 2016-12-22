package islandmusic.apm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class MainScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    /** Called when the user clicks the Looking button */
    public void launchLook(View view) {
        Intent intent = new Intent(this, MapSelector.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    /** Called when the user clicks the Contribute button */
    public void launchCont(View view) {
        Intent intent = new Intent(this, Contribute.class);// Intent intent = new Intent(this, Contribute.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    /** Called when the user clicks the About button */
    public void launchAbout(View view) {
        Intent intent = new Intent(this, About.class);//  Intent intent = new Intent(this, About.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

}
