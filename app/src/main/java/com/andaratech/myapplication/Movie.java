package com.andaratech.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private  int image;
    private String judul;
    private String deskripsi;
    private String tglliris;


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getTglliris() {
        return tglliris;
    }

    public void setTglliris(String tglliris) {
        this.tglliris = tglliris;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.image);
        dest.writeString(this.judul);
        dest.writeString(this.deskripsi);
        dest.writeString(this.tglliris);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.image = in.readInt();
        this.judul = in.readString();
        this.deskripsi = in.readString();
        this.tglliris = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
