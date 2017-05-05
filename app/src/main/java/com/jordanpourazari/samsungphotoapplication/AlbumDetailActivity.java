package com.jordanpourazari.samsungphotoapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by jordanpourazari on 5/2/17.
 */

public class AlbumDetailActivity extends AppCompatActivity{

    RecyclerView mPhotoList;
    PhotoListAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    Album mAlbum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_detail_layout);

        this.getSupportActionBar().setHomeButtonEnabled(true);
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);

        mPhotoList = (RecyclerView) findViewById(R.id.photoList);
        mPhotoList.setHasFixedSize(true);

        Bundle b = getIntent().getExtras();
        mAlbum = b.getParcelable("album");

        mLayoutManager = new LinearLayoutManager(this);

        mPhotoList.setLayoutManager(mLayoutManager);

        mAdapter = new PhotoListAdapter(mAlbum);

        mPhotoList.setAdapter(mAdapter);
    }


}
