package com.example.week8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String sharedPrefFile = "com.example.android.myapplication" ;
    public static final String KEY = "MyKey" ;
    SharedPreferences mPreferences;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Infosys", "onCreate: is here");
        setContentView(R.layout.activity_main);
        
        // Initiate sharedPreferences
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        String aText = mPreferences.getString(KEY, "Default Value");
        
        tv = findViewById(R.id.SecondText);
        tv.setText(aText);

        // Get the data from intent
        Intent intent = getIntent();
        String textFromSubActivityPage = intent.getStringExtra(SubActivity.SUBACTIVITY_KEY);
        if (textFromSubActivityPage != null) {
        // Use the data
        tv.setText(textFromSubActivityPage);
        }

        Button btn = findViewById(R.id.btnChangeText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                tv.setText("INFOSYS!!!");
//                Log.d("Pokemon", "onClick: a button is clicked!!");

                // Use intent to go to subactivity page
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
            }
        });


        
        // Implicit Intent Example
        Button btnMAP = findViewById(R.id.btnMAP);
        btnMAP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = "SUTD";
                Uri.Builder builder = new Uri.Builder();
                builder.scheme( "geo" ).opaquePart( "0.0" ).appendQueryParameter( "q" ,location);
                Uri geoLocation = builder.build();

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(geoLocation);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Infosys", "onStart is triggered");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Infosys", "onPause is triggered ");
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putString(KEY, tv.getText().toString());
        preferencesEditor.apply();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Infosys", "onDestroy is triggered ");
    }
}