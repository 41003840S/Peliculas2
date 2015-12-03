package com.example.manuel.peliculas;


import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class GridAdapterDB extends SimpleCursorAdapter {

    final private String POSTERURL = "http://image.tmdb.org/t/p/";
    final private String POSTERSIZE = "w185";
    DecimalFormat decimal = new DecimalFormat("#.#");
    ImageView iv_PosterImage;
    TextView tv_Titulo;
    Context context;
    public String[] from;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public GridAdapterDB(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        this.context = context;
        this.from=from;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Cursor myCursor = getCursor();
        myCursor.moveToPosition(position);

        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.gridview_layout, parent, false);
        }

        //Enlazamos las variables con las ids
        tv_Titulo = (TextView) convertView.findViewById(R.id.ad_tvtitulo);
        iv_PosterImage = (ImageView) convertView.findViewById(R.id.imageView);


        //Metemos los datos de los objetos provinientes de la BD en el layout
        tv_Titulo.setText(myCursor.getString(myCursor.getColumnIndex(from[0])));
        String posterPath = myCursor.getString(myCursor.getColumnIndex(from[1]));

        Picasso.with(context).load(POSTERURL + POSTERSIZE + posterPath).fit().into(iv_PosterImage);

        return convertView;
    }

    public void setFrom(String[] from) {
        this.from = from;
    }
}
