package com.i4creed.jokeactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        TextView jokeTv = findViewById(R.id.joke_tv);
        Bundle bundle = getIntent().getExtras();
        String joke = null;
        if (bundle != null) {
            joke = (String) bundle.get(getString(R.string.joke_intent_key));
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
        jokeTv.setText(joke);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
