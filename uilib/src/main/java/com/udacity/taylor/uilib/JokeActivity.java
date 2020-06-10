package com.udacity.taylor.uilib;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView textViewJoke = findViewById(R.id.textViewJoke);

        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey(JOKE)) {
                String joke = extras.getString(JOKE);
                textViewJoke.setText(joke);
        }
    }
}
