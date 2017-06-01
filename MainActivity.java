package com.mp.lab7;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    MediaPlayer mp, mp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout layout = (LinearLayout)findViewById(R.id.audio1);
        final LinearLayout layout2 = (LinearLayout)findViewById(R.id.audio2);
        String tag = (String) layout.getTag();
        String tag2 = (String) layout2.getTag();
        final int id_audio = getResources().getIdentifier(tag, "raw", getPackageName());
        final int id_audio2 = getResources().getIdentifier(tag2, "raw", getPackageName());

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp2 != null) {
                    mp2.pause();
                    layout2.setBackgroundColor(Color.TRANSPARENT);
                }
                if(mp == null)
                    mp = MediaPlayer.create(getApplicationContext(), id_audio);
                mp.start();
                layout.setBackgroundColor(Color.GRAY);
            }
        });

        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp != null) {
                    mp.pause();
                    layout.setBackgroundColor(Color.TRANSPARENT);
                }
                if(mp2 == null)
                    mp2 = MediaPlayer.create(getApplicationContext(), id_audio2);
                mp2.start();
                layout2.setBackgroundColor(Color.GRAY);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.stop();
        mp2.stop();
    }
}
