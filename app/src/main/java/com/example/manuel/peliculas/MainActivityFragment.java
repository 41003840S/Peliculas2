package com.example.manuel.peliculas;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;


public class MainActivityFragment extends Fragment {

    ListView listaPeliculas;
    ArrayList items;
    ArrayAdapter adapter;

    //Cuando inicia la actividad muestra las peliculas populares
    @Override
    public void onStart() {
        super.onStart();
        ApiMovie pelicula = new ApiMovie();
        pelicula.mostrarPopulares(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View fragment = inflater.inflate(R.layout.fragment_main, container, false);

        //Enlazamos el listView
        listaPeliculas = (ListView) fragment.findViewById(R.id.listView);

        String data[] = {"Peli1", "Peli2", "Peli3", "Peli4", "Peli5", "Peli6", "Peli7", "Peli8", "Peli9", "Peli10"};

        //Añadimos el array de Strings a un ArrayList
        items = new ArrayList(Arrays.asList(data));

        //Enlazamos con el adaptador los datos con el ListView
        adapter = new ArrayAdapter<String>(getContext(),
                R.layout.filas_peliculas, R.id.tv_row, items);

        //Seteamos el ListView con el adaptador
        listaPeliculas.setAdapter(adapter);

        //Crea un Listener para que con pulsacion prolongada haga algo
       /* listaPeliculas.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });*/

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

        return super.onOptionsItemSelected(item);
    }

    private void refresh() {

        ApiMovie pelicula = new ApiMovie();

        //Segun la Setting Preference que elijamos invocara un metodo u otro
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        if (preferences.getString("category_list","0").equals("0")){
            pelicula.mostrarPopulares(adapter);
        }else if (preferences.getString("category_list","0").equals("1")) {
            pelicula.mostrarTopRated(adapter);
        }

    }

}
