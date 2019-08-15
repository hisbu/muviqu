package com.qyans.muviqu;

import android.os.Parcel;
import android.os.Parcelable;

public class Movies implements Parcelable {
    private String title;
    private String genre;
    private String year;
    private String rating;
    private String runtime;
    private String director;
    private String cast;
    private String overview;
    private int poster;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.genre);
        dest.writeString(this.year);
        dest.writeString(this.rating);
        dest.writeString(this.runtime);
        dest.writeString(this.director);
        dest.writeString(this.cast);
        dest.writeString(this.overview);
        dest.writeInt(this.poster);

    }

    public Movies() {
    }

    protected Movies(Parcel in) {
        this.title = in.readString();
        this.genre = in.readString();
        this.year = in.readString();
        this.rating = in.readString();
        this.runtime = in.readString();
        this.director = in.readString();
        this.cast = in.readString();
        this.overview = in.readString();
        this.poster = in.readInt();

    }

    public static final Parcelable.Creator<Movies> CREATOR = new Parcelable.Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel source) {
            return new Movies(source);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };
}
