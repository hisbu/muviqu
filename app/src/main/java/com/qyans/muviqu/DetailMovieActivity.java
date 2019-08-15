package com.qyans.muviqu;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);


        Movies movies = getIntent().getParcelableExtra("EXTRA_MOVIE");
        TextView tvDetailTitle = findViewById(R.id.tv_detail_title);
        TextView tvDetailYear = findViewById(R.id.tv_detail_year);
        TextView tvDetailRating = findViewById(R.id.tv_detail_rating);
        TextView tvDetailRuntime = findViewById(R.id.tv_detail_runtime);
        TextView tvDetailGenre = findViewById(R.id.tv_detail_genre);
        TextView tvDetailOverview = findViewById(R.id.tv_detail_overview);
        TextView tvDetailDirector = findViewById(R.id.tv_detail_director);
        TextView tvDetailCast = findViewById(R.id.tv_detail_cast);
        ImageView imgDetailPoster = findViewById(R.id.img_detail_poster);

        Glide.with(this)
                .load(movies.getPoster())
                .into(imgDetailPoster);

        tvDetailTitle.setText(movies.getTitle());
        tvDetailYear.setText(movies.getYear());
        tvDetailRating.setText(movies.getRating());
        tvDetailRuntime.setText(movies.getRuntime());
        tvDetailGenre.setText(movies.getGenre());
        tvDetailOverview.setText(movies.getOverview());
        tvDetailDirector.setText(movies.getDirector());
        tvDetailCast.setText(movies.getCast());

    }
}
