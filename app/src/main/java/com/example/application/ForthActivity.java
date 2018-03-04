package com.example.application;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


public class ForthActivity extends AppCompatActivity {

    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    private Button button7;
    private Button button8;
    private Button button9;
    private CheckBox checkBox11;
    private CheckBox checkBox12;
    private CheckBox checkBox13;
    private CheckBox checkBox14;
    private CheckBox checkBox15;
    private RefreshProgress Rprogress3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forth);

        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        checkBox11 = (CheckBox) findViewById(R.id.checkBox11);
        checkBox12 = (CheckBox) findViewById(R.id.checkBox12);
        checkBox13 = (CheckBox) findViewById(R.id.checkBox13);
        checkBox14 = (CheckBox) findViewById(R.id.checkBox14);
        checkBox15 = (CheckBox) findViewById(R.id.checkBox15);
        Rprogress3 = (RefreshProgress) findViewById(R.id.Rprogress3);

        Rprogress3.Animation();

        Intent intent9 = new Intent(ForthActivity.this, MyService6.class);
        startService(intent9);
        Intent intent6 = new Intent(ForthActivity.this, MyService4.class);
        Intent intent7 = new Intent(ForthActivity.this, MyService5.class);
        stopService(intent6);
        stopService(intent7);

        buttonListener7 listener7 = new buttonListener7();
        button9.setOnClickListener(listener7);
        buttonListener8 listener8 = new buttonListener8();
        button7.setOnClickListener(listener8);
        buttonListener9 listener9 = new buttonListener9();
        button8.setOnClickListener(listener9);

    }

    class buttonListener9 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (checkBox15.isChecked()) {
                showbutton10Dialog();
            } else {
                showbutton11Dialog();
            }

        }
    }

    private void showbutton11Dialog() {
        new AlertDialog.Builder(this)
                .setMessage("走啦")
                .setPositiveButton("好的", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent11 = new Intent();
                        intent11.setClass(ForthActivity.this, FifthActivity.class);
                        startActivity(intent11);
                    }
                })
                .show();
    }

    private void showbutton10Dialog() {
        new AlertDialog.Builder(this)
                .setMessage("没选对，重新选")
                .setPositiveButton("好的", null)
                .show();
    }

    class buttonListener8 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            showbutton9Dialog();
        }
    }

    private void showbutton9Dialog() {
        new AlertDialog.Builder(this)
                .setMessage("那就再选选")
                .setPositiveButton("好的", null)
                .show();
    }

    class buttonListener7 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent9 = new Intent(ForthActivity.this, MyService6.class);
            stopService(intent9);
            Intent intent10 = new Intent(ForthActivity.this, MyService7.class);
            startService(intent10);
        }
    }


    @Override
    protected void onStop() {
        Intent intent9 = new Intent(ForthActivity.this, MyService6.class);
        Intent intent10 = new Intent(ForthActivity.this, MyService7.class);
        stopService(intent9);
        stopService(intent10);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Intent intent9 = new Intent(ForthActivity.this, MyService6.class);
        Intent intent10 = new Intent(ForthActivity.this, MyService7.class);
        stopService(intent9);
        stopService(intent10);
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        Intent intent9 = new Intent(ForthActivity.this, MyService6.class);
        startService(intent9);
        super.onStart();
    }

}


