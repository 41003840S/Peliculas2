package com.example.manuel.peliculas;

import android.util.Log;

import com.example.manuel.peliculas.popularmovies.List;

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

    private final InterfazMovies service;                                    //Constante objeto de la interfaz
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
    public void mostrarPopulares(final GridAdapter adapter) {
        //Llamada al servicio Moviedb con el metodo de la interfaz
        Call<List> llamadaPelicula = service.peliculasPopulares(APPID);

        //Cuando recibe la respuesta la pone en cola
        llamadaPelicula.enqueue(new Callback<List>() {

            @Override
            public void onResponse(Response<List> response, Retrofit retrofit) {

                List film = response.body();

                Log.w("pelis", film.getResults().toString());
                //Limpiamos el adaptador
                adapter.clear();
                adapter.addAll(film.getResults());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("Update Films", Arrays.toString(t.getStackTrace()));
            }
        });
    }

    //Metodo para mostrar topRated igual que el anterior solo cambia la llmada al metodo de la interfaz
    public void mostrarTopRated(final GridAdapter adapter) {

        //Cambia el metodo de la interfaz
        Call<List> llamadaPelicula = service.peliculasTopRated(APPID);

        llamadaPelicula.enqueue(new Callback<List>() {

            @Override
            public void onResponse(Response<List> response, Retrofit retrofit) {

                List film = response.body();

                adapter.clear();

                adapter.addAll(film.getResults());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("Update Films", Arrays.toString(t.getStackTrace()));
            }
        });
    }
}