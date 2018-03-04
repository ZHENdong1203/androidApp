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

public class SecondActivity extends AppCompatActivity {

    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private Button button1;
    private Button button2;
    private Button button3;
    private CheckBox checkBox;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private RefreshProgress Rprogress1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        textView2=(TextView)findViewById(R.id.textView2);
        textView3=(TextView)findViewById(R.id.textView3);
        textView4=(TextView)findViewById(R.id.textView4);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        checkBox=(CheckBox)findViewById(R.id.checkBox);
        checkBox1=(CheckBox)findViewById(R.id.checkBox1);
        checkBox2=(CheckBox)findViewById(R.id.checkBox2);
        checkBox3=(CheckBox)findViewById(R.id.checkBox3);
        checkBox4=(CheckBox)findViewById(R.id.checkBox4);
        checkBox5=(CheckBox)findViewById(R.id.checkBox5);
        Rprogress1=(RefreshProgress)findViewById(R.id.Rprogress1);

        Rprogress1.Animation();


        Intent intent3 = new Intent(SecondActivity.this,MyService2.class);
        startService(intent3);
        Intent intent = new Intent(SecondActivity.this,MyService.class);
        Intent intent1 = new Intent(SecondActivity.this,MyService1.class);
        stopService(intent);
        stopService(intent1);

        buttonListener1 listener1=new buttonListener1();
        button1.setOnClickListener(listener1);
        buttonListener2 listener2=new buttonListener2();
        button2.setOnClickListener(listener2);
        buttonListener3 listener3=new buttonListener3();
        button3.setOnClickListener(listener3);


    }



    class buttonListener3 implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(checkBox3.isChecked()||checkBox4.isChecked()){
                showbutton5Dialog();
            }else{
                showbutton4Dialog();
            }

        }
    }

    class buttonListener2 implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            showbutton3Dialog();
        }
    }

    private void showbutton3Dialog(){
        new AlertDialog.Builder(this)
                .setMessage("那就再选选")
                .setPositiveButton("好的",null)
                .show();
    }

    private void showbutton4Dialog(){
        new AlertDialog.Builder(this)
                .setMessage("去下个地方")
                .setPositiveButton("好的", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent5=new Intent();
                        intent5.setClass(SecondActivity.this,ThirdActivity.class);
                        startActivity(intent5);
                    }
                })
                .show();
    }

    private void showbutton5Dialog(){
        new AlertDialog.Builder(this)
                .setMessage("没选对，重新选")
                .setPositiveButton("好的",null)
                .show();
    }

    class buttonListener1 implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent3 = new Intent(SecondActivity.this,MyService2.class);
            stopService(intent3);
            Intent intent4 = new Intent(SecondActivity.this,MyService3.class);
            startService(intent4);
        }
    }

    @Override
    protected void onStop() {
        Intent intent3 = new Intent(SecondActivity.this,MyService2.class);
        Intent intent4 = new Intent(SecondActivity.this,MyService3.class);
        stopService(intent3);
        stopService(intent4);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Intent intent3 = new Intent(SecondActivity.this,MyService2.class);
        Intent intent4 = new Intent(SecondActivity.this,MyService3.class);
        stopService(intent3);
        stopService(intent4);
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        Intent intent3 = new Intent(SecondActivity.this,MyService2.class);
        startService(intent3);
        Intent intent6 = new Intent(SecondActivity.this,MyService4.class);
        Intent intent7 = new Intent(SecondActivity.this,MyService5.class);
        stopService(intent6);
        stopService(intent7);
        super.onStart();
    }


}
