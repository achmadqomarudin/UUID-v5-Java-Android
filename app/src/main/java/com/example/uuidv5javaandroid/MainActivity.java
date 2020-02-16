package com.example.uuidv5javaandroid;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private EditText inputString;
    private TextView textExample, textResult;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
        initViews();
    }

    private void setViews() {
        inputString     = findViewById(R.id.inputText);
        textExample     = findViewById(R.id.example);
        textResult      = findViewById(R.id.result);
        convertButton   = findViewById(R.id.buttonConvert);
    }

    @SuppressLint("SetTextI18n")
    private void initViews() {
        //set text
        textExample.setText("36b6d27f-ced7-5d71-81b0-81befabaecc5");

        //set button
        convertButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                //get text
                String getTexts = inputString.getText().toString();

                //cek condition input null or not
                if (!TextUtils.isEmpty(getTexts)) {
                    //change shopciety with your name space
                    UUID shopciety = UUID.fromString("1b671a64-40d5-491e-99b0-da01ff1f3341");

                    //convert to UUID v5
                    UUID test = UUIDType5.nameUUIDFromNamespaceAndString(shopciety, getTexts);

                    //set to text
                    textResult.setText(test.toString());
                } else {
                    Toast.makeText(MainActivity.this, "Sorry, text cannot be empty!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
