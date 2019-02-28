package com.andaratech.myapplication;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String dataNama[] ;
    String dataRilis[];
    TypedArray dataPhoto;
    String dataDescripsi[];
    MovieAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv_list);

        adapter = new MovieAdapter(this);
        listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        setArr();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie = new Movie();
                movie.setJudul(dataNama[position]);
                movie.setTglliris(dataRilis[position]);
                movie.setDeskripsi(dataDescripsi[position]);
                movie.setImage(dataPhoto.getResourceId(position,-1));

                Intent moveWithObjectIntent = new Intent(MainActivity.this, DetailMovieActivity.class);
                moveWithObjectIntent.putExtra(DetailMovieActivity.EXTRA_MOVIE,movie);
                startActivity(moveWithObjectIntent);

                Toast.makeText(MainActivity.this, dataNama[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addItem(){
        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 0 ; i < dataNama.length; i++){
            Movie movie = new Movie();
            movie.setImage(dataPhoto.getResourceId(i,-1));
            movie.setJudul(dataNama[i]);
            movie.setTglliris(dataRilis[i]);
            movie.setDeskripsi(dataDescripsi[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void setArr(){
        dataNama = getResources().getStringArray(R.array.data_name);
        dataRilis = getResources().getStringArray(R.array.data_rilis);
        dataDescripsi = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }


}
