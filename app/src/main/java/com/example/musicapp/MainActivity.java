package com.example.musicapp;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView songListView;
    private ExoPlayerManager exoPlayerManager;
    private SearchView searchView;
    private PlaylistDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songListView = findViewById(R.id.songListView);
        searchView = findViewById(R.id.searchView);
        db = new PlaylistDatabaseHelper(this);

        exoPlayerManager = new ExoPlayerManager(this);
        loadSongs();
        setupSearch();
    }

    private void loadSongs() {
        List<Song> songs = Song.fetchLocalSongs();
        SongAdapter adapter = new SongAdapter(this, songs, exoPlayerManager);
        songListView.setAdapter(adapter);
    }

    private void setupSearch() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) { return false; }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<Song> filteredSongs = db.searchSongs(newText);
                songListView.setAdapter(new SongAdapter(MainActivity.this, filteredSongs, exoPlayerManager));
                return true;
            }
        });
    }
}
