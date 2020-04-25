package android.example.deltahacker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;



public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Context context = MainActivity2.this;

        final SharedPreferences sharedPref = MainActivity2.this.getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();


        final Intent intent = getIntent();
        final int[] count = {intent.getIntExtra("int_value", 0)};
        final int[] scoreTotal = {intent.getIntExtra("scoreTotal", 0)};



        final Button button2 = (Button) findViewById(R.id.button2);
        final Button button3 = (Button) findViewById(R.id.button3);
        final Button button4 = (Button) findViewById(R.id.button4);
        final Button button6 = (Button) findViewById(R.id.button6);
        final ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        Button button5 = (Button) findViewById(R.id.button5);


        final TextView textView5 = (TextView) findViewById(R.id.textView5);
        final TextView textView3 = (TextView) findViewById(R.id.textView3);

        Random r = new Random();

        int randomQuestion = r.nextInt(50);
        int[] Factors = {1,1,1,1,1,1,1,1,1,1};
        int j = 1;


        textView3.setText(String.valueOf(randomQuestion));

        for (int i = 2; i < (randomQuestion / 2) + 1; i++) {
            if (randomQuestion % i == 0) {
                Factors[j] = i;
                j++;
            }
        }

        int choice1 = r.nextInt((100 - 1) + 1);
        int choice2 = r.nextInt((100 - 1) + 1);
        int randomDigit = r.nextInt(10);
        final int correctChoice = Factors[randomDigit];

        int[] choices = {choice1, choice2, correctChoice};

        int randomNumber = r.nextInt(3);

        button2.setText(String.valueOf(choices[randomNumber]));
        if (randomNumber == 0) {
            button3.setText(String.valueOf(choices[2]));
            button4.setText(String.valueOf(choices[1]));
        } else if (randomNumber == 1) {
            button3.setText(String.valueOf(choices[2]));
            button4.setText(String.valueOf(choices[0]));
        } else {
            button3.setText(String.valueOf(choices[0]));
            button4.setText(String.valueOf(choices[1]));

        }


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (button2.getText().toString() == String.valueOf(correctChoice)) {

                    Toast.makeText(MainActivity2.this, "CORRECT", Toast.LENGTH_SHORT).show();

                    imageView2.setBackgroundColor(Color.GREEN);


                    editor.putInt(getString(R.string.saved_high_score_key), 50*count[0]);
                    editor.apply();

                    int highScore = sharedPref.getInt(getString(R.string.saved_high_score_key), 0);
                    textView5.setText(String.valueOf(highScore));

                    count[0] +=1;


                } else {
                    Toast.makeText(MainActivity2.this, "WRONG", Toast.LENGTH_SHORT).show();
                    imageView2.setBackgroundColor(Color.RED);


                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (button3.getText().toString() == String.valueOf(correctChoice)) {

                    Toast.makeText(MainActivity2.this, "CORRECT", Toast.LENGTH_SHORT).show();
                    imageView2.setBackgroundColor(Color.GREEN);
                    editor.putInt(getString(R.string.saved_high_score_key), 50*count[0]);
                    editor.apply();

                    int highScore = sharedPref.getInt(getString(R.string.saved_high_score_key), 0);
                    textView5.setText(String.valueOf(highScore));
                    count[0] +=1;


                } else {
                    Toast.makeText(MainActivity2.this, "WRONG", Toast.LENGTH_SHORT).show();
                    imageView2.setBackgroundColor(Color.RED);
                    editor.putInt("answer_value", 0);

                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (button4.getText().toString() == String.valueOf(correctChoice)) {
                    Toast.makeText(MainActivity2.this, "CORRECT", Toast.LENGTH_SHORT).show();
                    imageView2.setBackgroundColor(Color.GREEN);

                    editor.putInt(getString(R.string.saved_high_score_key), 50*count[0]);
                    editor.apply();

                    int highScore = sharedPref.getInt(getString(R.string.saved_high_score_key), 0);
                    textView5.setText(String.valueOf(highScore));
                    count[0] +=1;
                } else {
                    Toast.makeText(MainActivity2.this, "WRONG", Toast.LENGTH_SHORT).show();
                    imageView2.setBackgroundColor(Color.RED);


                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent1);
                intent1.putExtra(String.valueOf(count[0]),count[0]);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(MainActivity2.this, MainActivity2.class);
                startActivity(intent2);
            }
        });


    }
}






