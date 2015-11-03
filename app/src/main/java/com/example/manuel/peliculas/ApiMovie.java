package com.example.manuel.peliculas;

import android.util.Log;
import android.widget.ArrayAdapter;
import com.example.manuel.peliculas.popularmovies.MovieService;
import com.example.manuel.peliculas.popularmovies.Result;
import java.util.ArrayList;
import java.util.Arrays;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;
//Interfaz con dos metodos uno para hacer la llamada a peliculasPopulares y el otro para peliculasTopRated
 interface MoviedbService {

    @GET("popular")
    Call<MovieService> peliculasPopulares(
            @Query("api_key") String api_key);

     @GET("top_rated")
     Call<MovieService> peliculasTopRated(
             @Query("api_key") String api_key);

}

public class ApiMovie {

    private final MoviedbService service;                                    //Constante objeto de la interfaz
    private final String BASE_URL = "https://api.themoviedb.org/3/movie/";          //Constante URL parte que no cambia
    private final String APPID = "13bc649b4be786a5459437a47ac059a5";                //Api Key de la API de Moviedb

    //Constructor de la clase con el builder
    public ApiMovie() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(MoviedbService.class);
    }

    //Metodo para mostrar las peliculas populares
    public void mostrarPopulares(final ArrayAdapter<String> adapter) {

        //Llamada al servicio Moviedb con el metodo de la interfaz
        Call<MovieService> llamadaPelicula = service.peliculasPopulares(APPID);

        //Cuando recibe la respuesta la pone en cola
        llamadaPelicula.enqueue(new Callback<MovieService>() {

            @Override
            public void onResponse(Response<MovieService> response, Retrofit retrofit) {

                //ArrayList que guarda las descripciones de las peliculas
                ArrayList<String> descripcionPeliculas = new ArrayList<>();

                MovieService film = response.body();
                for (Result list : film.getResults()) {
                    //De esta manera metemos en variables las partes de la descripcion para despues juntarlas en el array
                    /*String titulo = list.getTitle();
                    Double popularidad = list.getPopularity();
                    descripcionPeliculas.add(titulo + ": " + String.valueOf(popularidad)+"Popular");*/

                    //Metemos en una variable la descripcion que nos da el metodo getFilmDescription
                    String filmDescritionString = getFilmDescrition(list);
                    //Y las añadimos al arrayList
                    //Se meten en un array list para despues mostrarlos todos de una vez y no ir refrescando una a una
                    descripcionPeliculas.add(filmDescritionString);
                }
                //Limpiamos el adaptador
                adapter.clear();
                //Y añadimos aladaptador el arrayList de las descripciones
                adapter.addAll(descripcionPeliculas);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("Update Films", Arrays.toString(t.getStackTrace()));
            }
        });
    }

    //Metodo para mostrar topRated igual que el anterior solo cambia la llmada al metodo de la interfaz
    public void mostrarTopRated(final ArrayAdapter<String> adapter) {

        //Cambia el metodo de la interfaz
        Call<MovieService> llamadaPelicula = service.peliculasTopRated(APPID);

        llamadaPelicula.enqueue(new Callback<MovieService>() {

            @Override
            public void onResponse(Response<MovieService> response, Retrofit retrofit) {

                ArrayList<String> descripcionPeliculas = new ArrayList<>();

                MovieService film = response.body();
                for (Result list : film.getResults()) {

                    String filmDescritionString = getFilmDescrition(list);
                    descripcionPeliculas.add(filmDescritionString);
                }

                adapter.clear();
                adapter.addAll(descripcionPeliculas);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("Update Films", Arrays.toString(t.getStackTrace()));
            }
        });
    }

    //Metodo que hace las descripciones de las peliculas
    private String getFilmDescrition (Result list) {
        String titulo = list.getTitle();
        Long popularidad = Math.round(list.getPopularity());
        String sinopsis = list.getOverview();
        boolean adulto = list.getAdult();
        String adulto1;
        if(adulto){
            adulto1 = "+ 18 years";
        }else{
            adulto1 = "- 18 years";
        }
        return String.format("Title: %s\nSynopsis: %s\nAdult: %s\nPopularity: %s\n",
                titulo, sinopsis, adulto1, popularidad
        );
    }

}

