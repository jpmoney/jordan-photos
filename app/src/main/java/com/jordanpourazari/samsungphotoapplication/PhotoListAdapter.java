package com.jordanpourazari.samsungphotoapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by jordanpourazari on 5/2/17.
 */

public class PhotoListAdapter extends RecyclerView.Adapter<PhotoHolder> {

    private Album mAlbum;

    public PhotoListAdapter(Album album){
        this.mAlbum = album;
    }

    @Override
    public PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View photoView = layoutInflater.inflate(R.layout.photo_list_item, parent, false);
        return new PhotoHolder(photoView);
    }

    @Override
    public void onBindViewHolder(PhotoHolder holder, int position) {
        holder.bindPhotoToHolder(this.mAlbum, position);
    }

    @Override
    public int getItemCount() {
        return this.mAlbum.getPhotos().size();
    }

}
