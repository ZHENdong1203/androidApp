 package com.example.application;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RefreshProgress Rprogress;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.textView);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        radioButton1=(RadioButton)findViewById(R.id.radioButton1);
        radioButton2=(RadioButton)findViewById(R.id.radioButton2);
        Rprogress=(RefreshProgress)findViewById(R.id.Rprogress);
        button=(Button)findViewById(R.id.button);

        Rprogress.Animation();

        Intent intent = new Intent(MainActivity.this,MyService.class);
        startService(intent);
        buttonListener Listener=new buttonListener();
        button.setOnClickListener(Listener);
        radioButtonListener listener=new radioButtonListener();
        radioGroup.setOnCheckedChangeListener(listener);


    }




    class radioButtonListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
               if(i==radioButton1.getId()){
                    showbutton1Dialog();
               }else if(i==radioButton2.getId()){
                   showbutton2Dialog();
               }
        }
    }

    class buttonListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,MyService.class);
            stopService(intent);
            Intent intent1 = new Intent(MainActivity.this,MyService1.class);
            startService(intent1);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0,1,1,"关于");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==1){
            showAboutDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAboutDialog(){
        new AlertDialog.Builder(this)
                .setTitle("关于")
                .setMessage("ver 1.0"+"\n"+"by ZHENdong"+"\n"
                        +"software:AS"+"\n"+"image:PS"+"\n"
                        +"music:QQ music")
                .setPositiveButton("确定", null)
                .show();
    }

    private void showbutton1Dialog(){
        new AlertDialog.Builder(this)
                .setMessage("那就到下一页吧")
                .setPositiveButton("好的", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent2=new Intent();
                        intent2.setClass(MainActivity.this,SecondActivity.class);
                        startActivity(intent2);
                    }
                })
                .show();
    }

    private void showbutton2Dialog(){
        new AlertDialog.Builder(this)
                .setMessage("那就再看一会")
                .setPositiveButton("好的",null)
                .show();
    }


    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if (keyCode==KeyEvent.KEYCODE_BACK) {
            AlertDialog.Builder isExit=new AlertDialog.Builder(this);
            isExit.setTitle("提醒");
            isExit.setMessage("真的打算离开了么o(*￣3￣)o ");
            isExit.setPositiveButton("溜了溜了",diaListener);
            isExit.setNegativeButton("再看一遍",diaListener);
            isExit.show();
        }
        return false;
    }

    DialogInterface.OnClickListener diaListener=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int buttonId) {
            switch (buttonId) {
                case AlertDialog.BUTTON_POSITIVE:
                    finish();
                    break;
                case AlertDialog.BUTTON_NEGATIVE:
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onStop() {
        Intent intent = new Intent(MainActivity.this,MyService.class);
        Intent intent1 = new Intent(MainActivity.this,MyService1.class);
        stopService(intent);
        stopService(intent1);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Intent intent = new Intent(MainActivity.this,MyService.class);
        Intent intent1 = new Intent(MainActivity.this,MyService1.class);
        stopService(intent);
        stopService(intent1);
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        Intent intent = new Intent(MainActivity.this,MyService.class);
        startService(intent);
        Intent intent3 = new Intent(MainActivity.this,MyService2.class);
        Intent intent4 = new Intent(MainActivity.this,MyService3.class);
        stopService(intent3);
        stopService(intent4);
        super.onStart();
    }


}
