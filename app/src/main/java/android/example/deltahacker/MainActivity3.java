package android.example.deltahacker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent3 = getIntent();
        final int[] counter = {intent3.getIntExtra("int_value", 0)};


        Button button8 = (Button) findViewById(R.id.button8);
        TextView textView7 = (TextView) findViewById(R.id.textView7);

        SharedPreferences sharedPref = MainActivity3.this.getPreferences(Context.MODE_PRIVATE);
        int highScore = sharedPref.getInt(getString(R.string.saved_high_score_key), 0);

        textView7.setText(String.valueOf(highScore));

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent3);
            }
        });
    }
}
