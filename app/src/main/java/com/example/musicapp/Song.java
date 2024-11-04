package com.example.musicapp;

public class Song {
    private String title;
    private String artist;
    private String path;

    public Song(String title, String artist, String path) {
        this.title = title;
        this.artist = artist;
        this.path = path;
    }

    public static List<Song> fetchLocalSongs() {
        // Code to retrieve songs from local storage
    }

    // Getters and Setters
}
