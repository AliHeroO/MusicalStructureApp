package com.example.musicalstructureapp;

import android.media.MediaPlayer;

public class word {

    private int mediaPlayerId;

    private String name;

    private String artist;

    public word(String name, String artist, int mediaPlayerId) {

        this.name = name;

      this.artist = artist;

        this.mediaPlayerId = mediaPlayerId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String number) {
        this.artist = number;
    }

    public int getMediaPlayerId() {
        return mediaPlayerId;
    }

    public void setMediaPlayerId(int mediaPlayer) {
        this.mediaPlayerId = mediaPlayer;
    }
}
