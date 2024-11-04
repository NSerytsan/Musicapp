package com.example.musicapp;

import android.content.Context;

import androidx.media3.exoplayer.ExoPlayer;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;

public class ExoPlayerManager {
    private final ExoPlayer player;

    public ExoPlayerManager(Context context) {
        player = new ExoPlayer.Builder(context).build();
    }

    public void playSong(String path) {
        MediaItem mediaItem = MediaItem.fromUri(path);
        player.setMediaItem(mediaItem);
        player.prepare();
        player.play();
    }

    public void stop() { player.stop(); }
}
