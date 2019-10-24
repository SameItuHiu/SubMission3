package com.example.submission3;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class VideoDetail extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "Movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);

        ActionBar action = getSupportActionBar();
        action.setTitle(R.string.detail);
        action.setIcon(R.drawable.ic_arrow_back_black_24dp);
        action.setDisplayHomeAsUpEnabled(true);

        VideoChart video = getIntent().getParcelableExtra(EXTRA_MOVIE);

        ImageView poster = findViewById(R.id.imgPoster);
        ImageView poster1 = findViewById(R.id.imgPoster1);
        TextView title = findViewById(R.id.tvTitle);
        TextView date = findViewById(R.id.tvDate);
        TextView studio = findViewById(R.id.tvStudio);
        TextView synopsis = findViewById(R.id.tvSynopsis);

        poster.setImageResource(video.getPoster());
        poster1.setImageResource(video.getPoster());
        title.setText(video.getTitle());
        date.setText(video.getReleaseDate());
        studio.setText(video.getStudio());
        synopsis.setText(video.getSynopsis());
    }

}
