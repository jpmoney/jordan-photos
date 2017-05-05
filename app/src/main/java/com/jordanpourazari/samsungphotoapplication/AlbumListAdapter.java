package com.jordanpourazari.samsungphotoapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by jordanpourazari on 5/2/17.
 */

public class AlbumListAdapter extends RecyclerView.Adapter<AlbumHolder> {

    private ArrayList<Album> mAlbums;

    public AlbumListAdapter(ArrayList<Album> albums){
        this.mAlbums = albums;
    }

    @Override
    public AlbumHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View albumView = layoutInflater.inflate(R.layout.album_list_item, parent, false);
        return new AlbumHolder(albumView);
    }

    @Override
    public void onBindViewHolder(AlbumHolder holder, int position) {
        holder.bindAlbumToHolder(this.mAlbums.get(position));
    }

    @Override
    public int getItemCount() {
        return this.mAlbums.size();
    }
}
