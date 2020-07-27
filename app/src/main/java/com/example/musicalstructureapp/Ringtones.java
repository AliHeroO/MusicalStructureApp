package com.example.musicalstructureapp;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Ringtones extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        getSupportActionBar().setTitle("Go Back");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final ArrayList<word> music = new ArrayList<word>();

        music.add(new word("set fire", "adele", R.raw.set_fire));
        music.add(new word("aegeon_Sea", "ringtones", R.raw.aegean));
        music.add(new word("alarm", "ringtones", R.raw.alarm));
        music.add(new word("alarm_rooster", "ringtones", R.raw.alarm_rooster));
        music.add(new word("bugle", "ringtones", R.raw.bugle));
        music.add(new word("bule_harbour", "ringtones", R.raw.bule_harbour));
        music.add(new word("wind_dance", "ringtones", R.raw.wind_dance));
        music.add(new word("hawaii", "ringtones", R.raw.hawaii));
        music.add(new word("ripple", "ringtones", R.raw.ripple));
        music.add(new word("sakura_drop", "ringtones", R.raw.sakura_drop));
        music.add(new word("westlake", "ringtones", R.raw.westlake));
        music.add(new word("whistle", "ringtones", R.raw.whistle));
        music.add(new word("sax", "ringtones", R.raw.sax));

        wordAdapter Adapter = new wordAdapter(this, music);

        ListView listView = (ListView) findViewById(R.id.list_item);

        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                word word = music.get(position);

                releaseMediaPlayer();

                mediaPlayer = MediaPlayer.create(Ringtones.this, word.getMediaPlayerId());


                mediaPlayer.start();


            }

        });


    }


    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.

        }
    }

}