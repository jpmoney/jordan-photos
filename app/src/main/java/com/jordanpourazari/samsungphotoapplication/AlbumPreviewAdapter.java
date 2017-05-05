package com.jordanpourazari.samsungphotoapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jordanpourazari on 5/4/17.
 */

public class AlbumPreviewAdapter extends PagerAdapter {

    private Album mAlbum;
    private Context mContext;
    private LayoutInflater mInflater;

    public AlbumPreviewAdapter(Context c, Album album)
    {
        mAlbum = album;
        mContext = c;
    }

    @Override
    public int getCount() {
        return mAlbum.getPhotos().size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View photoView = mInflater.inflate(R.layout.photo_preview_item, container, false);

        ImageView photoImageView = (ImageView) photoView.findViewById(R.id.photoPreview);

        Drawable photoPreviewDrawable = mAlbum.getDrawableForIndex(mContext, position);

        photoImageView.setImageDrawable(photoPreviewDrawable);

        container.addView(photoView);
        return photoView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }
}
