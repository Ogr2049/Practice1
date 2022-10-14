package com.example.activitieslab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnGoToSecAct;
    private TextView yourLink;
    private Button openLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGoToSecAct = (Button) findViewById(R.id.btnGoToSecAct);
        yourLink = (TextView) findViewById(R.id.yourLink);
        openLink = findViewById(R.id.openLink);
        View.OnClickListener oclGoToSecActivity = new View.OnClickListener()
        {
            @Override
            public void onClick(View w)
            {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                startActivity(intent);
            }
        };
        btnGoToSecAct.setOnClickListener(oclGoToSecActivity);
        yourLink.setText(getIntent().getStringExtra("link"));


        openLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Uri urlText = Uri.parse(yourLink.getText().toString());
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, urlText);
                launchBrowser.addCategory(Intent.CATEGORY_BROWSABLE);
                if (launchBrowser.resolveActivity(getPackageManager()) != null) {
                    startActivity(launchBrowser);
                } else {
                    Toast.makeText(getApplicationContext(), "Browser has not found", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}