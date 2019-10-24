package com.example.submission3;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMovies extends Fragment {
    private String[] dataTitle,dataRelease,dataStudio,dataSysnopsis;
    private TypedArray dataPhoto;
    private RecyclerView rvMovie;
    private ArrayList<VideoChart> movie;

    public FragmentMovies() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_movies, container, false);

        rvMovie = v.findViewById(R.id.rvMovie);
        rvMovie.setHasFixedSize(true);

        prepare();
        addItem();

        rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
        ListAdapter adapter = new ListAdapter(movie);
        rvMovie.setAdapter(adapter);

        adapter.setOnItemClickCallback(new ListAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(VideoChart data) {
                Intent moveWithObjectIntent = new Intent(getActivity(), VideoDetail.class);
                moveWithObjectIntent.putExtra(VideoDetail.EXTRA_MOVIE, data);
                startActivity(moveWithObjectIntent);
            }
        });

        return v;
    }

    private void addItem() {
        movie = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            VideoChart video = new VideoChart();
            video.setPoster(dataPhoto.getResourceId(i, -1));
            video.setTitle(dataTitle[i]);
            video.setSynopsis(dataSysnopsis[i]);
            video.setReleaseDate(dataRelease[i]);
            video.setStudio(dataStudio[i]);
            movie.add(video);
        }
    }

    private void prepare() {
        dataPhoto = getResources().obtainTypedArray(R.array.poster);
        dataTitle = getResources().getStringArray(R.array.title);
        dataSysnopsis = getResources().getStringArray(R.array.description);
        dataRelease = getResources().getStringArray(R.array.release_date);
        dataStudio = getResources().getStringArray(R.array.studio);
    }

}