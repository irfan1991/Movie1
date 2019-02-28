package com.andaratech.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMovieActivity extends AppCompatActivity {

    public TextView txtNama, txtRilis, txtDeskripsi;
    public ImageView imgPhoto;
    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        txtNama = (TextView) findViewById(R.id.txt_name_detail);
        txtRilis = (TextView) findViewById(R.id.txt_rilis_detail);
        txtDeskripsi = (TextView) findViewById(R.id.txt_detail);
        imgPhoto = (ImageView) findViewById(R.id.img_photo_detail);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        txtNama.setText(movie.getJudul());
        txtRilis.setText(movie.getTglliris());
        txtDeskripsi.setText(movie.getDeskripsi());
        imgPhoto.setImageResource(movie.getImage());
    }



}
