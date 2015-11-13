package com.example.manuel.peliculas;

import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.manuel.peliculas.popularmovies.Result;

import java.util.ArrayList;


public class MainActivityFragment extends Fragment {

    ListView listaPeliculas;
    GridView gridPeliculas;
    TextView categoria;
    ListAdapter listAdapter;
    GridAdapter gridAdapter;
    ArrayList<Result> items;

    public MainActivityFragment(){
    }

    //Cuando inicia la actividad muestra las peliculas populares
    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true);

        View fragment = inflater.inflate(R.layout.fragment_main, container, false);

        //Enlazamos el listView
        gridPeliculas = (GridView) fragment.findViewById(R.id.gridView);
        categoria =(TextView) fragment.findViewById(R.id.tv_categoria);

        items = new ArrayList<>();

        //Enlazamos con el adaptador personalizado los datos con el ListView
        gridAdapter = new GridAdapter(getContext(),R.layout.gridview_layout,items);

        //Seteamos el ListView con el adaptador
        gridPeliculas.setAdapter(gridAdapter);

        //Crea un Listener para que con pulsacion abra otro activity con la informacion de la pelicula
        gridPeliculas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Cogemos la pelicula seleccionada por el itemposition
                Result peliculaElegida = (Result) parent.getItemAtPosition(position);
                //Y se la pasamos con un intent a ActivityDetail
                Intent intent = new Intent(getContext(), ActivityDetail.class);
                intent.putExtra("pelicula", peliculaElegida);
                startActivity(intent);
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

        /*if (id == R.id.refresh) {
            //Al presionar el item invoca el metodo refresh
            refresh();
            return true;
        }*/
        if (id == R.id.cambiar) {


            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void refresh() {

        ApiMovie pelicula = new ApiMovie();

        //Segun la Setting Preference que elijamos invocara un metodo u otro
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        if (preferences.getString("category_list","0").equals("0")){
            pelicula.mostrarPopulares(gridAdapter);
            categoria.setText("Popular Movies");
        }else if (preferences.getString("category_list","0").equals("1")) {
            pelicula.mostrarTopRated(gridAdapter);
            categoria.setText("Top Rated Movies");
        }

    }

}