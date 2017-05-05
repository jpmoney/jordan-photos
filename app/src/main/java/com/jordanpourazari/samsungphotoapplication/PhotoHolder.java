package com.jordanpourazari.samsungphotoapplication;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jordanpourazari on 5/2/17.
 */

public class PhotoHolder extends RecyclerView.ViewHolder {

    private TextView mNameTextView;
    private ImageView mPhotoImage;
    private int mIndex;
    private Album mAlbum;

    public PhotoHolder(View photoView){
        super(photoView);
        mNameTextView = (TextView) photoView.findViewById(R.id.photoNameTextView);
        mPhotoImage = (ImageView) photoView.findViewById(R.id.photoImageView);
    }

    public void bindPhotoToHolder(Album album, int index){
        this.mAlbum = album;
        this.mIndex = index;
        this.mNameTextView.setText(this.mAlbum.getPhotos().get(index).getImagePath());
        Drawable albumCoverDrawable = this.mAlbum.getDrawableForIndex(this.mPhotoImage.getContext(), index);
        this.mPhotoImage.setImageDrawable(albumCoverDrawable);
    }



}
