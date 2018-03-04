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

public class ThirdActivity extends AppCompatActivity {

    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private Button button4;
    private Button button5;
    private Button button6;
    private CheckBox checkBox6;
    private CheckBox checkBox7;
    private CheckBox checkBox8;
    private CheckBox checkBox9;
    private CheckBox checkBox10;
    private RefreshProgress Rprogress2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);

        textView5=(TextView)findViewById(R.id.textView5);
        textView6=(TextView)findViewById(R.id.textView6);
        textView7=(TextView)findViewById(R.id.textView7);
        button4=(Button)findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);
        button6=(Button)findViewById(R.id.button6);
        checkBox6=(CheckBox)findViewById(R.id.checkBox6);
        checkBox7=(CheckBox)findViewById(R.id.checkBox7);
        checkBox8=(CheckBox)findViewById(R.id.checkBox8);
        checkBox9=(CheckBox)findViewById(R.id.checkBox9);
        checkBox10=(CheckBox)findViewById(R.id.checkBox10);
        Rprogress2=(RefreshProgress)findViewById(R.id.Rprogress2);

        Rprogress2.Animation();

        Intent intent6 = new Intent(ThirdActivity.this,MyService4.class);
        startService(intent6);
        Intent intent3 = new Intent(ThirdActivity.this,MyService2.class);
        Intent intent4 = new Intent(ThirdActivity.this,MyService3.class);
        stopService(intent3);
        stopService(intent4);

        buttonListener4 listener4=new buttonListener4();
        button6.setOnClickListener(listener4);
        buttonListener5 listener5=new buttonListener5();
        button4.setOnClickListener(listener5);
        buttonListener6 listener6=new buttonListener6();
        button5.setOnClickListener(listener6);
    }


    class buttonListener6 implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(checkBox6.isChecked()){
                showbutton8Dialog();
            }else{
                showbutton7Dialog();
            }

        }
    }

    private void showbutton7Dialog(){
        new AlertDialog.Builder(this)
                .setMessage("去下个地方")
                .setPositiveButton("好的", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent8=new Intent();
                        intent8.setClass(ThirdActivity.this,ForthActivity.class);
                        startActivity(intent8);
                    }
                })
                .show();
    }

    private void showbutton8Dialog(){
        new AlertDialog.Builder(this)
                .setMessage("没选对，重新选")
                .setPositiveButton("好的",null)
                .show();
    }


    class buttonListener5 implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            showbutton6Dialog();
        }
    }

    private void showbutton6Dialog(){
        new AlertDialog.Builder(this)
                .setMessage("那就再选选")
                .setPositiveButton("好的",null)
                .show();
    }


    class buttonListener4 implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent6 = new Intent(ThirdActivity.this,MyService4.class);
            stopService(intent6);
            Intent intent7 = new Intent(ThirdActivity.this,MyService5.class);
            startService(intent7);
        }
    }



    @Override
    protected void onStop() {
        Intent intent6 = new Intent(ThirdActivity.this,MyService4.class);
        Intent intent7 = new Intent(ThirdActivity.this,MyService5.class);
        stopService(intent6);
        stopService(intent7);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Intent intent6 = new Intent(ThirdActivity.this,MyService4.class);
        Intent intent7 = new Intent(ThirdActivity.this,MyService5.class);
        stopService(intent6);
        stopService(intent7);
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        Intent intent6 = new Intent(ThirdActivity.this,MyService4.class);
        startService(intent6);
        Intent intent9 = new Intent(ThirdActivity.this, MyService6.class);
        Intent intent10 = new Intent(ThirdActivity.this, MyService7.class);
        stopService(intent9);
        stopService(intent10);
        super.onStart();
    }


}
