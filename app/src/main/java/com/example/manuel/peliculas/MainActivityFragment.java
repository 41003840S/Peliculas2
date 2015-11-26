package com.example.manuel.peliculas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
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
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.manuel.peliculas.popularmovies.Result;
import com.example.manuel.peliculas.provider.movies.MoviesColumns;

import java.util.ArrayList;


public class MainActivityFragment extends Fragment implements android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor>{

    ListView listaPeliculas;
    GridView gridPeliculas;
    ArrayList<Result> items;
    GridAdapterDB gridAdapterDB;
    Cursor cursor;

    public MainActivityFragment(){
    }

    //Cuando inicia la actividad muestra las peliculas populares
    @Override
    public void onStart() {
        super.onStart();
        //refresh();
        getLoaderManager().restartLoader(0, null, this);
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

        //Enlazamos el GridView y el listView
        gridPeliculas = (GridView) fragment.findViewById(R.id.gridView);
        //items = new ArrayList<>();

        //Enlazamos con el adaptador personalizado los datos con el GridView
        gridAdapterDB = new GridAdapterDB(getContext(),
                R.layout.gridview_layout,
                null,
                new String[] {
                        MoviesColumns.TITLE,
                        MoviesColumns.POSTER_PATH
                },
                new int[] {
                        R.id.ad_tvtitulo,
                        R.id.imageView
                },
                0);

        //Inicialitzem el Loader
        getLoaderManager().initLoader(0, null, this);

        //Seteamos el GridView/ListView con el adaptador
        gridPeliculas.setAdapter(gridAdapterDB);

        //Crea un Listener para que con pulsacion abra otro activity con la informacion de la pelicula
        gridPeliculas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Cogemos la id de la pelicula seleccionada por el itemposition y se la pasamos con un intent a ActivityDetail
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

        //Segun la Setting Preference que elijamos invocara un metodo u otro
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        if (preferences.getString("category_list","0").equals("0")){

        }else if (preferences.getString("category_list","0").equals("1")) {

        }


    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getContext(),
                MoviesColumns.CONTENT_URI,
                null,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        gridAdapterDB.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        gridAdapterDB.swapCursor(null);
    }
}