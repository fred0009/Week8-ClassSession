package com.example.week8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {
    EditText editText;
    Button btnOK;
    public final static String SUBACTIVITY_KEY = "SUBACTIVITY_KEY";

    private final String sharedPrefFile = "com.example.android.myapplication" ;
    public static final String KEY = "MyKey" ;
    SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity);

        // Get reference to each widgets
        editText = findViewById(R.id.etChangeText);
        btnOK = findViewById(R.id.btnSubActivityChangeText);

        // Define what happen when the button is clicked
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the text typed in the editText widget
                String text = editText.getText().toString();

                // Bring the text back to the mainactivity page
                Intent intent = new Intent(SubActivity.this, MainActivity.class);
                intent.putExtra(SUBACTIVITY_KEY, text);

                startActivity(intent);

            }
        });

    }


}