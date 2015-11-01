package com.example.manuel.peliculas;

import android.widget.ArrayAdapter;
import com.example.manuel.peliculas.popularmovies.FilmServicePopular;
import com.example.manuel.peliculas.popularmovies.Result;
import java.util.ArrayList;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

 interface MoviedbServicePopular {

    @GET("popular")
    Call<FilmServicePopular> peliculasPopulares(
            @Query("api_key") String api_key);
}

public class PopularMovies {

    private final MoviedbServicePopular service;
    private final String POPULAR_BASE_URL = "https://api.themoviedb.org/3/movie/";
    private final String APPID = "13bc649b4be786a5459437a47ac059a5";

    public PopularMovies() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(POPULAR_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(MoviedbServicePopular.class);
    }

    public void updateMovies(final ArrayAdapter<String> adapter) {
        Call<FilmServicePopular> moviesCall = service.peliculasPopulares(APPID);
        moviesCall.enqueue(new Callback<FilmServicePopular>() {

            @Override
            public void onResponse(Response<FilmServicePopular> response, Retrofit retrofit) {
                ArrayList<String> peliculas = new ArrayList<>();
                FilmServicePopular film = response.body();
                for (Result list : film.getResults()) {
                    String titulo = list.getTitle();
                    Double popularidad = list.getPopularity();
                    peliculas.add(titulo + ": " + String.valueOf(popularidad)+"Popular"); //Se meten en un array list para despues mostrarlos todos de una vez y no ir refrescando una a una
                }

                adapter.clear();
                adapter.addAll(peliculas);
            }

            @Override
            public void onFailure(Throwable t) {
               // Log.e("Update Films", Arrays.toString(t.getStackTrace()));
            }
        });

    }

    /*private String getForecastString(List list) {
        Long dt = list.getDt();
        java.util.Date date = new java.util.Date(dt * 1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("E d/M");
        String dateString = dateFormat.format(date);

        String description = list.getWeather().get(0).getDescription();

        Long min = Math.round(list.getTemp().getMin());
        Long max = Math.round(list.getTemp().getMax());

        return String.format("%s - %s - %s/%s",
                dateString, description, min, max
        );
    }*/
}

