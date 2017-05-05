package com.jordanpourazari.samsungphotoapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by jordanpourazari on 5/2/17.
 */

public class AlbumHolder extends RecyclerView.ViewHolder implements  View.OnClickListener, View.OnLongClickListener, View.OnTouchListener{

    private TextView mNameTextView;
    private ImageView mAlbumImage;
    private Album mAlbum;
    private View mAlbumView;
    private PreviewPager mAlbumPreview;
    private boolean mLongPressed;
    private float initialTouchX = 0.0f;

    public AlbumHolder(View albumView){
        super(albumView);
        albumView.setOnClickListener(this);
        albumView.setOnLongClickListener(this);
        albumView.setOnTouchListener(this);
        mAlbumView = albumView;
        mNameTextView = (TextView) albumView.findViewById(R.id.albumNameTextView);
        mAlbumImage = (ImageView) albumView.findViewById(R.id.albumImageView);
        mLongPressed = false;
    }

    public void bindAlbumToHolder(Album album){
        this.mAlbum = album;
        this.mNameTextView.setText(this.mAlbum.getAlbumName());
        Drawable albumCoverDrawable = this.mAlbum.getDrawableForIndex(this.mAlbumImage.getContext(), 0);
        this.mAlbumImage.setImageDrawable(albumCoverDrawable);
    }

    @Override
    public void onClick(View view) {
        Intent detailIntent = new Intent(view.getContext(), AlbumDetailActivity.class);
        detailIntent.putExtra("album", this.mAlbum);
        view.getContext().startActivity(detailIntent);
        Log.d("Album Debug", this.mAlbum.getAlbumName() + " clicked!");
    }

    @Override
    public boolean onLongClick(View v){
        mLongPressed = true;
        this.addPreviewPanel();
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            initialTouchX = event.getX();
        }

        if(event.getAction() == MotionEvent.ACTION_MOVE){
            if(mLongPressed) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                float currentX = event.getX();
                float currentY = event.getY();

                //moved to the right
                if(currentX - initialTouchX > 50){
                    mAlbumPreview.previousPage();
                    initialTouchX = currentX;
                }

                //moved to the left
                if(initialTouchX - currentX > 50){
                    mAlbumPreview.nextPage();
                    initialTouchX = currentX;
                }

                return true;
            }
        }

        if (event.getAction() == MotionEvent.ACTION_UP) {
            Log.d("Album Debug", "ACTION_UP");
            if (mLongPressed) {
                Log.d("Album Debug", "Long press ended");
                this.removePreviewPanel();
            }
            mLongPressed = false;
        }
        return false;
    }

    private void addPreviewPanel(){
        RelativeLayout albumListLayout = (RelativeLayout) mAlbumView.getParent().getParent();
        PreviewPager previewPager = new PreviewPager(albumListLayout.getContext());
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                albumListLayout.getWidth(), albumListLayout.getWidth());
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);

        AlbumPreviewAdapter albumPreviewAdapter = new AlbumPreviewAdapter(albumListLayout.getContext(), mAlbum);
        previewPager.setAdapter(albumPreviewAdapter);

        albumListLayout.addView(previewPager, params);
        mAlbumPreview = previewPager;
    }

    private void removePreviewPanel(){
        RelativeLayout albumListLayout = (RelativeLayout) mAlbumView.getParent().getParent();
        albumListLayout.removeViewInLayout(mAlbumPreview);
        mAlbumPreview = null;
    }

}
