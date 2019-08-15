package com.qyans.muviqu;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] movieTitle;
    private String[] movieYear;
    private String[] movieGenre;
    private String[] movieRuntime;
    private String[] movieRating;
    private String[] movieOverview;
    private String[] movieDirector;
    private String[] movieCast;
    private TypedArray moviePoster;
    private MovieAdapter adapter;
    private ArrayList<Movies> movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> perent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, movie.get(i).getTitle(), Toast.LENGTH_SHORT).show();
                Intent moveToDetail = new Intent(MainActivity.this, DetailMovieActivity.class);
                moveToDetail.putExtra("EXTRA_MOVIE", movie.get(position));
                startActivity(moveToDetail);
            }
        });
    }

    private void addItem(){
        movie = new ArrayList<>();

        for (int i=0; i< movieTitle.length; i++){
            Movies movies = new Movies();
            movies.setPoster(moviePoster.getResourceId(i, -1));
            movies.setTitle(movieTitle[i]);
            movies.setYear(movieYear[i]);
            movies.setGenre(movieGenre[i]);
            movies.setRuntime(movieRuntime[i]);
            movies.setRating(movieRating[i]);
            movies.setOverview(movieOverview[i]);
            movies.setDirector(movieDirector[i]);
            movies.setCast(movieCast[i]);
            movie.add(movies);
        }
        adapter.setMovies(movie);

    }

    private void prepare(){
        movieTitle      = getResources().getStringArray(R.array.movie_title);
        movieGenre      = getResources().getStringArray(R.array.movie_genre);
        movieYear       = getResources().getStringArray(R.array.movie_year);
        movieRuntime    = getResources().getStringArray(R.array.movie_runtime);
        movieRating     = getResources().getStringArray(R.array.movie_rating);
        movieOverview   = getResources().getStringArray(R.array.movie_overview);
        movieDirector   = getResources().getStringArray(R.array.movie_director);
        movieCast       = getResources().getStringArray(R.array.movie_cast);
        moviePoster     = getResources().obtainTypedArray(R.array.movie_poster);

    }

}
