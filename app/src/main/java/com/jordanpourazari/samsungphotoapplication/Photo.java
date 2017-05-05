package com.jordanpourazari.samsungphotoapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jordanpourazari on 5/2/17.
 */

public class Photo implements Parcelable {

    private String mImagePath = "";

    public Photo(String imagePath){
        this.mImagePath = imagePath;
    }

    public String getImagePath(){
        return this.mImagePath;
    }

    public Photo(Parcel in){
        mImagePath = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mImagePath);
    }

    public static Creator<Photo> CREATOR =  new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel parcel) {
            return new Photo(parcel);
        }

        @Override
        public Photo[] newArray(int i) {
            return new Photo[i];
        }
    };

}
