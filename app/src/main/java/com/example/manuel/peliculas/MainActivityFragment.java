package com.example.manuel.peliculas;

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

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    ListView listaPeliculas;
    ArrayList items;
    ArrayAdapter adapter;

    /*@Override
    public void onStart() {
        super.onStart();
        muestraPopulares();
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View fragment = inflater.inflate(R.layout.fragment_main, container, false);

        listaPeliculas = (ListView) fragment.findViewById(R.id.listView);              //Enlazamos el listView

        String data[] = {"Peli1", "Peli2", "Peli3", "Peli4", "Peli5", "Peli6", "Peli7", "Peli8", "Peli9", "Peli10"};

        items = new ArrayList(Arrays.asList(data));                                 //Añadimos el array de Strings a un ArrayList
        adapter = new ArrayAdapter<String>(getContext(),                            //Enlazamos con el adaptador los datos con el ListView
                R.layout.filas_peliculas, R.id.tv_row, items);
        listaPeliculas.setAdapter(adapter);                                            //Seteamos el ListView con el adaptador

       /* listaPeliculas.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {                                 //Crea un Listener para que con pulsacion prolongada haga algo
                return false;
            }
        });*/
        return fragment;
    }

    //Creamos el onCreate y el OptionItemSelect del menu que hemos creado para el fragment en RES--> MENU, para añadir el item (muestraPopulares)
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

        if (id == R.id.peliculas_populares) {
            muestraPopulares();                                      //Al presionar el item muestraPopulares invoca el metodo muestraPopulares
            return true;
        }

        if (id == R.id.peliculas_top) {
            muestraTop();                                      //Al presionar el item muestraPopulares invoca el metodo muestraPopulares
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void muestraPopulares() {
        PopularMovies populares = new PopularMovies();
        populares.updateMovies(adapter);
    }

    private void muestraTop() {
        TopRatedMovies mvaloradas = new TopRatedMovies();
        mvaloradas.updateMovies(adapter);
    }

}
