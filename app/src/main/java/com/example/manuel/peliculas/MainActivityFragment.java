package com.example.manuel.peliculas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.manuel.peliculas.provider.populars.PopularColumns;
import com.example.manuel.peliculas.provider.toprated.TopRatedColumns;



public class MainActivityFragment extends Fragment implements android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor>{

    GridView gridPeliculas;
    GridAdapterDB gridAdapterDB;

    public MainActivityFragment(){
    }

    //Cuando inicia la actividad
    @Override
    public void onStart() {
        super.onStart();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        if (preferences.getString("category_list","0").equals("0")){
           getLoaderManager().restartLoader(0, null, this);
           //GridAdapterDB.setFrom(new String[]{PopularColumns.TITLE, PopularColumns.POSTER_PATH});

        }else if (preferences.getString("category_list","0").equals("1")) {
            getLoaderManager().restartLoader(0, null, this);
            //GridAdapterDB.setFrom(new String[]{TopRatedColumns.TITLE, TopRatedColumns.POSTER_PATH});
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.fragment_main, container, false);

        //Enlazamos el GridView
        gridPeliculas = (GridView) fragment.findViewById(R.id.gridView);

        gridAdapterDB = new GridAdapterDB(getContext(),
                R.layout.gridview_layout,
                null,
                new String[] {
                        PopularColumns.TITLE,
                        PopularColumns.POSTER_PATH
                },
                new int[] {
                        R.id.ad_tvtitulo,
                        R.id.imageView
                },
                0);

        //Inicializamos el Loader
        getLoaderManager().initLoader(0, null, this);

        //Seteamos el GridView con el adaptador
        gridPeliculas.setAdapter(gridAdapterDB);

        //Crea un Listener para que con pulsacion abra otro activity con la informacion de la pelicula
        gridPeliculas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Cogemos la id de la pelicula seleccionada y se la pasamos con un intent a ActivityDetail
                Intent i = new Intent(getContext(), DetailActivity.class);
                i.putExtra("movie_id", id);
                startActivity(i);
            }
        });
        return fragment;
    }


    /*Creamos el onCreate y el OptionItemSelect del menu que hemos creado para el fragment en RES--> MENU,
     para añadir el item (refresh)*/
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_fragment, menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.refresh) {
            //Al presionar el item invoca el metodo refresh
            refresh();
            return true;
        }
        /*if (id == R.id.cambiar) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }



    private void refresh() {

        getContext().getContentResolver().delete(
                PopularColumns.CONTENT_URI,
                null,
                null);
        getContext().getContentResolver().delete(
                TopRatedColumns.CONTENT_URI,
                null,
                null);

        RefreshBackground downloadMoviesTask = new RefreshBackground();
        downloadMoviesTask.execute();
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        //Segun la Setting Preference que elijamos invocara un metodo u otro
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        if (preferences.getString("category_list","0").equals("0")){
            return new CursorLoader(getContext(),
                    PopularColumns.CONTENT_URI,
                    null,
                    null,
                    null,
                    "_id");
        }else if (preferences.getString("category_list","0").equals("1")) {
            return new CursorLoader(getContext(),
                    TopRatedColumns.CONTENT_URI,
                    null,
                    null,
                    null,
                    "_id");
        }else{
            return null;
        }

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        gridAdapterDB.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        gridAdapterDB.swapCursor(null);
    }




    class RefreshBackground extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] params) {

            ApiMovie apiMovie = new ApiMovie();

            apiMovie.mostrarPopulares(getContext());
            apiMovie.mostrarTopRated(getContext());

            return null;
        }
    }
}