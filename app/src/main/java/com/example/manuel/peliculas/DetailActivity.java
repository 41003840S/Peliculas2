package com.example.manuel.peliculas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manuel.peliculas.popularmovies.Result;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class DetailActivity extends AppCompatActivity {

    ImageView poster;
    TextView titulo, release, overview,popularidad;
    DecimalFormat decimal = new DecimalFormat("#.#");
    final private String POSTERURL = "http://image.tmdb.org/t/p/";
    final private String POSTERSIZE = "w185";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Result peliculaElegida = (Result) getIntent().getExtras().get("pelicula");

        titulo = (TextView) findViewById(R.id.ad_tvtitulo);
        release = (TextView) findViewById(R.id.ad_tvreleasedate);
        overview = (TextView) findViewById(R.id.ad_tvoverview);
        popularidad = (TextView) findViewById(R.id.ad_tvpopulridad);
        poster= (ImageView) findViewById(R.id.ad_ivposter);

        //Metemos los datos de los objetos provinientes del JSON en el layout
        titulo.setText(peliculaElegida.getTitle());
        release.setText(peliculaElegida.getReleaseDate());
        popularidad.setText(decimal.format(peliculaElegida.getPopularity())+"%");
        overview.setText(peliculaElegida.getOverview());
        Picasso.with(this).load(POSTERURL + POSTERSIZE + peliculaElegida.getPosterPath()).fit().into(poster);



    }

}
