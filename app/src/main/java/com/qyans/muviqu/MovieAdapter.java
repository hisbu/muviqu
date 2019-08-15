package com.qyans.muviqu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movies> movies;

    public void setMovies(ArrayList<Movies> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.listview_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Movies movies = (Movies) getItem(i);
        viewHolder.bind(movies);
        return view;

    }

    private class ViewHolder {
        private ImageView imgPoster;
        private TextView txtTitle;
        private TextView txtGenre;
        private TextView txtCast;
        private TextView txtDirector;
        private TextView txtOverview;
        private TextView txtRating;
        private TextView txtYear;
        private TextView txtRuntime;
//        private ImageView imgPoster;
        private ImageView imgBackdrop;

        ViewHolder(View view){
            txtTitle = view.findViewById(R.id.tv_title);
            txtGenre = view.findViewById(R.id.tv_genre);
            txtYear = view.findViewById(R.id.tv_year);
            txtRuntime = view.findViewById(R.id.tv_runtime);
            txtRating = view.findViewById(R.id.tv_rating);
            imgPoster = view.findViewById(R.id.img_poster);
        }

        void bind(Movies movies){
            txtTitle.setText(movies.getTitle());
            txtYear.setText(movies.getYear());
            txtGenre.setText(movies.getGenre());
            txtRuntime.setText(movies.getRuntime());
            txtRating.setText(movies.getRating());
//            Glide.with(context)
//                    .load(movies.getPoster())
//                    .apply(new RequestOptions().override(100, 150))
//                    .into(ViewHolder.imgPoster);
//            Picasso.get().load(movies.getPoster()).fit().centerCrop().into(imgPoster);
            Picasso.get().load(movies.getPoster()).fit().centerCrop().into(imgPoster);
//            imgPoster.setImageResource(movies.getPoster());
        }

    }
}
