package com.example.manuel.peliculas;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
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

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View fragment = inflater.inflate(R.layout.fragment_main, container, false);

        listaPeliculas = (ListView) fragment.findViewById(R.id.listView);              //Enlazamos el listView

        String data[] = {"Lun 26/10 - Soleado", "Mar 27/10 - Niebla", "Mier 26/10 - Nublado", "Jue 26/10 - Lluvioso",
                "Lun 26/10 - Soleado", "Sab 26/10 - Parcialmente nublado", "Dom 26/10 - Soleado"};

        items = new ArrayList(Arrays.asList(data));                                 //Añadimos el array de Strings a un ArrayList
        adapter = new ArrayAdapter<String>(getContext(),                            //Enlazamos con el adaptador los datos con el ListView
                R.layout.filas_peliculas, R.id.tv_row, items);
        listaPeliculas.setAdapter(adapter);                                            //Seteamos el ListView con el adaptador

        listaPeliculas.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {                                 //Crea un Listener para que con pulsacion prolongada haga algo
                return false;
            }
        });
        return fragment;
    }

}
