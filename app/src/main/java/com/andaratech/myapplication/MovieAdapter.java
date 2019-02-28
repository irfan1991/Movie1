package com.andaratech.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> movies;

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        }
        Movie movie = (Movie) getItem(position);
        TextView txtNama = convertView.findViewById(R.id.txt_name);
        TextView txtRilis = convertView.findViewById(R.id.txt_rilis);
        ImageView imgPhoto = convertView.findViewById(R.id.img_photo);
        txtNama.setText(movie.getJudul());
        txtRilis.setText(movie.getTglliris());
        imgPhoto.setImageResource(movie.getImage());
        return convertView;
    }
}
