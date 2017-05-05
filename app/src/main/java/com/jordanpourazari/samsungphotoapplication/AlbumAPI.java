package com.jordanpourazari.samsungphotoapplication;

import java.util.ArrayList;

/**
 * Created by jordanpourazari on 5/2/17.
 */

public class AlbumAPI {

    private ArrayList<Album> mAppAlbums;

    public AlbumAPI(){
        this.mAppAlbums = new ArrayList<Album>();
        this.initialize();
    }

    public ArrayList<Album> getAppAlbums(){
        return this.mAppAlbums;
    }

    private void initialize(){
        this.mAppAlbums.add(createAlbum("Animals", 6));
        this.mAppAlbums.add(createAlbum("Architecture", 4));
        this.mAppAlbums.add(createAlbum("Food", 5));
        this.mAppAlbums.add(createAlbum("Posters", 5));
        this.mAppAlbums.add(createAlbum("Scenery", 6));
    }

    private Album createAlbum(String name, int size){
        Album album = new Album(name);
        for(int i = 1; i <= size; i++){
            album.addPhoto(new Photo(String.valueOf(i) + ".jpg"));
        }
        return album;
    }

}
