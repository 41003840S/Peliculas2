package com.example.manuel.peliculas;


import android.util.Log;
import android.widget.ArrayAdapter;
import com.example.manuel.peliculas.topratedmovies.FilmServiceTopRated;
import com.example.manuel.peliculas.topratedmovies.Result;
import java.util.ArrayList;
import java.util.Arrays;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

interface MoviedbServiceTop {

    @GET("top_rated")
    Call<FilmServiceTopRated> peliculasPopulares(
            @Query("api_key") String api_key);
}

public class TopRatedMovies {


    private final MoviedbServiceTop service;
    private final String POPULAR_BASE_URL = "https://api.themoviedb.org/3/movie/";
    private final String APPID = "13bc649b4be786a5459437a47ac059a5";

    public TopRatedMovies() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(POPULAR_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(MoviedbServiceTop.class);
    }

    public void updateMovies(final ArrayAdapter<String> adapter) {
        Call<FilmServiceTopRated> moviesCall = service.peliculasPopulares(APPID);
        moviesCall.enqueue(new Callback<FilmServiceTopRated>() {

            @Override
            public void onResponse(Response<FilmServiceTopRated> response, Retrofit retrofit) {
                ArrayList<String> peliculas = new ArrayList<>();
                FilmServiceTopRated film = response.body();
                for (Result list : film.getResults()) {
                    //String titulo = list.getTitle();
                    //Double popularidad = list.getPopularity();
                    //peliculas.add(titulo + ": " + String.valueOf(popularidad)+"Top Rated"); //Se meten en un array list para despues mostrarlos todos de una vez y no ir refrescando una a una
                    String filmDescritionString = getFilmDescrition(list);
                    peliculas.add(filmDescritionString);
                }

                adapter.clear();
                adapter.addAll(peliculas);
            }

            @Override
            public void onFailure(Throwable t) {
                 Log.e("Update Films", Arrays.toString(t.getStackTrace()));
            }
        });

    }

    private String getFilmDescrition (Result list) {
        String titulo = list.getTitle();
        String sinopsis = list.getOverview();
        boolean adulto = list.getAdult();
        String adulto1;
        if(adulto){
            adulto1 = "+ 18 years";
        }else{
            adulto1 = "- 18 years";
        }
        //double mediaVotos = (double)list.getVoteAverage();
        //int votos = list.getVoteCount();

        return String.format("Title: %s\nSynopsis: %s\nAdult: %s\n",
                titulo, sinopsis, adulto1);
    }
}
