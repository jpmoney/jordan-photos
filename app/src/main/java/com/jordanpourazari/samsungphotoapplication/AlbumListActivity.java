package com.jordanpourazari.samsungphotoapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

public class AlbumListActivity extends AppCompatActivity {

    RecyclerView mAlbumList;
    AlbumListAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_album);

        getSupportActionBar().hide();

        AlbumAPI albumAPI = new AlbumAPI();

        mAlbumList = (RecyclerView) findViewById(R.id.albumList);
        mAlbumList.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);

        mAlbumList.setLayoutManager(mLayoutManager);

        mAdapter = new AlbumListAdapter(albumAPI.getAppAlbums());

        mAlbumList.setAdapter(mAdapter);
    }
}
