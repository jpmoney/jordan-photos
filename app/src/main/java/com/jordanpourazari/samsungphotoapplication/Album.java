package com.jordanpourazari.samsungphotoapplication;

/**
 * Created by jordanpourazari on 5/2/17.
 */

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Album implements Parcelable {

    private ArrayList<Photo> mPhotos;
    private String mAlbumName = "";

    public Album(String albumName){
        this.mPhotos = new ArrayList<Photo>();
        this.mAlbumName = albumName;
    }

    public ArrayList<Photo> getPhotos(){
        return this.mPhotos;
    }

    public void addPhoto(Photo photo){
        this.mPhotos.add(photo);
    }

    public String getAlbumName(){
        return this.mAlbumName;
    }

    public Drawable getDrawableForIndex(Context context, int index){
        try{
            Photo photo = this.mPhotos.get(index);
            String filePath = this.mAlbumName + "/" + photo.getImagePath();
            InputStream inputStream = context.getAssets().open(filePath);
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            inputStream.close();
            return drawable;
        }
        catch(IOException exception){
            return null;
        }
    }

    public Album(Parcel in){
        this.mAlbumName = in.readString();
        this.mPhotos = new ArrayList<Photo>();
        in.readTypedList(this.mPhotos, Photo.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAlbumName);
        parcel.writeTypedList(this.mPhotos);

    }

    public static Creator<Album> CREATOR =  new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel parcel) {
            return new Album(parcel);
        }

        @Override
        public Album[] newArray(int i) {
            return new Album[i];
        }
    };

}
