package com.example.application;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.io.IOException;

public class MyService7 extends Service {
    private MediaPlayer mp;

    @Override
    public void onStart(Intent intent10, int startId) {
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                try {
                    mp.start();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        });
        mp.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            public boolean onError(MediaPlayer mp, int what, int extra) {
                try {
                    mp.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });
        super.onStart(intent10, startId);
    }

    @Override
    public void onCreate() {
        try {
            mp = new MediaPlayer();
            mp = MediaPlayer.create(MyService7.this, R.raw.music7);
            mp.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onCreate();
    }

    @Override
    public void onDestroy() {

        mp.stop();
        mp.release();

        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent10) {
        return null;
    }

}

