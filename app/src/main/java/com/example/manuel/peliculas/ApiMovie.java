package com.example.manuel.peliculas;

import android.content.Context;
import android.util.Log;

import com.example.manuel.peliculas.provider.popular.PopularColumns;
import com.example.manuel.peliculas.provider.popular.PopularContentValues;
import com.example.manuel.peliculas.provider.toprated.TopratedColumns;
import com.example.manuel.peliculas.provider.toprated.TopratedContentValues;
import com.example.manuel.peliculas.retrofit.List;
import com.example.manuel.peliculas.retrofit.Result;


import java.util.Arrays;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;


//Interfaz con dos metodos uno para hacer la llamada a peliculasPopulares y el otro para peliculasTopRated
 interface InterfazMovies {

    @GET("popular")
    Call<List> peliculasPopulares(
            @Query("api_key") String api_key);

     @GET("top_rated")
     Call<List> peliculasTopRated(
             @Query("api_key") String api_key);

}

public class ApiMovie {

    private final InterfazMovies service;                                           //Constante objeto de la interfaz
    private final String BASE_URL = "https://api.themoviedb.org/3/movie/";          //Constante URL parte que no cambia
    private final String APPID = "13bc649b4be786a5459437a47ac059a5";                //Api Key de la API de Moviedb

    //Constructor de la clase con el builder
    public ApiMovie() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(InterfazMovies.class);
    }

    //Metodo para mostrar las peliculas populares
    public void mostrarPopulares(final Context context) {
        //Llamada al servicio Moviedb con el metodo de la interfaz
        Call<List> llamadaPelicula = service.peliculasPopulares(APPID);

        //Cuando recibe la respuesta la pone en cola
        llamadaPelicula.enqueue(new Callback<List>() {

            @Override
            public void onResponse(Response<List> response, Retrofit retrofit) {

                List film = response.body();

                //Para cada resultado de una pelicula cogemos los atributos que nos interesan para meterlos en la BD
                for (Result movie : film.getResults())
                {
                    PopularContentValues valores = new PopularContentValues();

                    valores.putTitle(movie.getTitle().toString());
                    valores.putReleaseDate(movie.getReleaseDate().toString());
                    valores.putPopularity(movie.getPopularity());
                    valores.putSynopsis(movie.getOverview().toString());
                    valores.putPosterPath(movie.getPosterPath().toString());
                    context.getContentResolver().insert(PopularColumns.CONTENT_URI, valores.values());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("Update Films", Arrays.toString(t.getStackTrace()));
            }
        });
    }

    //Metodo para mostrar topRated igual que el anterior solo cambia la llmada al metodo de la interfaz
    public void mostrarTopRated(final Context context) {

        //Cambia el metodo de la interfaz
        Call<List> llamadaPelicula = service.peliculasTopRated(APPID);

        llamadaPelicula.enqueue(new Callback<List>() {

            @Override
            public void onResponse(Response<List> response, Retrofit retrofit) {

                List film = response.body();

                for (Result movie : film.getResults())
                {
                    TopratedContentValues valores = new TopratedContentValues();

                    valores.putTitle(movie.getTitle().toString());
                    valores.putReleaseDate(movie.getReleaseDate().toString());
                    valores.putPopularity(movie.getPopularity());
                    valores.putSynopsis(movie.getOverview().toString());
                    valores.putPosterPath(movie.getPosterPath().toString());
                    context.getContentResolver().insert(TopratedColumns.CONTENT_URI, valores.values());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("Update Films", Arrays.toString(t.getStackTrace()));
            }
        });
    }
}