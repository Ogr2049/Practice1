package com.example.activitieslab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button btnGoToMainAct = (Button) findViewById(R.id.btnGoToMainAct);
        EditText yourMessage = (EditText) findViewById(R.id.yourMessage);
        View.OnClickListener oclGoToMainAct = new View.OnClickListener()
        {
            @Override
            public void onClick(View w)
            {
                Intent intent = new Intent(Activity2.this, MainActivity.class);
                if (yourMessage.getText().toString().isEmpty()) {
                    intent.putExtra("link", "Вы отправили пустое сообщение!");
                }
                else {
                    intent.putExtra("link", yourMessage.getText().toString());
                }
                startActivity(intent);
            }
        };
        btnGoToMainAct.setOnClickListener(oclGoToMainAct);

    }
}