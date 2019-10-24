package com.example.submission3;

import android.os.Parcel;
import android.os.Parcelable;

public class VideoChart implements Parcelable{

    private String title,overview,releaseDate,voteAverage;
    private int posterPath;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(int posterPath) {
        this.posterPath = posterPath;
    }

    protected VideoChart(Parcel in) {
        title = in.readString();
        overview = in.readString();
        releaseDate = in.readString();
        voteAverage = in.readString();
        posterPath = in.readInt();
    }

    public static final Creator<VideoChart> CREATOR = new Creator<VideoChart>() {
        @Override
        public VideoChart createFromParcel(Parcel in) {
            return new VideoChart(in);
        }

        @Override
        public VideoChart[] newArray(int size) {
            return new VideoChart[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(overview);
        parcel.writeString(releaseDate);
        parcel.writeString(voteAverage);
        parcel.writeInt(posterPath);
    }
}
