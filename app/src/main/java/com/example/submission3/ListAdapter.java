package com.example.submission3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private ArrayList<VideoChart> list;
    private OnItemClickCallback onItemClickCallback;

    public ListAdapter(ArrayList<VideoChart> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListAdapter.ListViewHolder holder, int position) {
        VideoChart video = list.get(position);
        holder.imgPoster.setImageResource(video.getPoster());
        holder.tvTitle.setText(video.getTitle());
        holder.tvRelease.setText(video.getReleaseDate());
        holder.tvStudio.setText(video.getStudio());
        holder.tvSynopsis.setText(video.getSynopsis());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(list.get(holder.getAdapterPosition()));

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle, tvRelease, tvStudio, tvSynopsis;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.poster);
            tvTitle = itemView.findViewById(R.id.titleVideo);
            tvRelease = itemView.findViewById(R.id.release);
            tvStudio = itemView.findViewById(R.id.studio);
            tvSynopsis = itemView.findViewById(R.id.synopsis);
        }
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }
    public interface OnItemClickCallback {
        void onItemClicked(VideoChart data);
    }
}