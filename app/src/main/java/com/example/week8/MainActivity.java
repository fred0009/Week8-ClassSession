package com.example.week8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.SecondText);
        tv.setText("Wow");

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

        // Get the data from intent
        Intent intent = getIntent();
        String textFromSubActivityPage = intent.getStringExtra(SubActivity.SUBACTIVITY_KEY);

        // Use the data
        tv.setText(textFromSubActivityPage);
        
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
}