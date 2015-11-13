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

public class ActivityDetail extends AppCompatActivity {

    ImageView poster;
    TextView titulo, release, overview,popularidad;
    DecimalFormat decimal = new DecimalFormat("#.#");
    final private String POSTERURL = "http://image.tmdb.org/t/p/";
    final private String POSTERSIZE = "w185";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_detail);
        //Recibimos el intent con la pelicula que habiamos elegido
        Result peliculaElegida = (Result) getIntent().getExtras().get("pelicula");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //Seteamos el titulo del toolbar con el titulo de la pelicula
        toolbar.setTitle(peliculaElegida.getTitle());
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        titulo = (TextView) findViewById(R.id.ad_tvtitulo);
        release = (TextView) findViewById(R.id.ad_tvreleasedate);
        overview = (TextView) findViewById(R.id.ad_tvoverview);
        popularidad = (TextView) findViewById(R.id.ad_tvpopulridad);
        poster= (ImageView) findViewById(R.id.ad_ivposter);

        //Metemos los datos de los objetos provinientes del JSON en el layout
        titulo.setText(peliculaElegida.getTitle());
        release.setText("Release date: " + peliculaElegida.getReleaseDate());
        popularidad.setText("Popularity: " + decimal.format(peliculaElegida.getPopularity())+"%");
        overview.setText(peliculaElegida.getOverview());
        Picasso.with(this).load(POSTERURL + POSTERSIZE + peliculaElegida.getPosterPath()).fit().into(poster);

    }

}
