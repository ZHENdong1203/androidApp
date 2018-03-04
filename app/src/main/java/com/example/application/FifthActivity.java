package com.example.application;


import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.TextView;

public class FifthActivity extends AppCompatActivity {

    private TextView textView11;
    private TextView textView12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth);

        textView11=(TextView)findViewById(R.id.textView11);
        textView12=(TextView)findViewById(R.id.textView12);

        Intent intent9 = new Intent(FifthActivity.this,MyService6.class);
        Intent intent10 = new Intent(FifthActivity.this,MyService7.class);
        stopService(intent9);
        stopService(intent10);


    }


}
