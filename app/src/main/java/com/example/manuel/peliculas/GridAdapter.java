package com.example.manuel.peliculas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.manuel.peliculas.popularmovies.Result;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GridAdapter extends ArrayAdapter<Result> {

    final private String POSTERURL = "http://image.tmdb.org/t/p/";
    final private String POSTERSIZE = "w185";
    DecimalFormat decimal = new DecimalFormat("#.#");
    ImageView ivPosterImage;
    TextView tvTitulo;

    public GridAdapter(Context context, int resource, ArrayList<Result> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Obtenemos el objeto de la posicion correspondiente
        Result resultItem = getItem(position);

        //Miramos si la View la esta reusando, sino es asi hinchamos la vista
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.gridview_layout, parent, false);

        }
        //Enlazamos las variables con las ids
         tvTitulo = (TextView) convertView.findViewById(R.id.ad_tvtitulo);
         ivPosterImage = (ImageView) convertView.findViewById(R.id.imageView);


        //Metemos los datos de los objetos provinientes del JSON en el layout
        tvTitulo.setText(resultItem.getTitle());
        Picasso.with(getContext()).load(POSTERURL + POSTERSIZE + resultItem.getPosterPath()).fit().into(ivPosterImage);

        return convertView;

    }
}
