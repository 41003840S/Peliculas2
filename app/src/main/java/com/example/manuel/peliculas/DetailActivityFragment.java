package com.example.manuel.peliculas;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.manuel.peliculas.provider.popular.PopularColumns;
import com.example.manuel.peliculas.provider.popular.PopularCursor;
import com.example.manuel.peliculas.provider.toprated.TopratedColumns;
import com.example.manuel.peliculas.provider.toprated.TopratedCursor;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;


public class DetailActivityFragment extends Fragment {

    final private String POSTERURL = "http://image.tmdb.org/t/p/";
    final private String POSTERSIZE = "w185";
    ImageView ivPosterImage;
    TextView tvTitle, tvSynopsis, tvCriticsScore;
    LinearLayout llTitleScores;
    DecimalFormat decimal = new DecimalFormat("#.#");
    Cursor cursor;
    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_detail, container, false);

        super.onCreate(savedInstanceState);

        // Fetch views
         ivPosterImage = (ImageView) view.findViewById(R.id.ivPoster);
         tvTitle = (TextView) view.findViewById(R.id.tvTitle);
         tvSynopsis = (TextView) view.findViewById(R.id.tvSynopsis);
         tvCriticsScore = (TextView) view.findViewById(R.id.tvCriticsScore);
         llTitleScores = (LinearLayout) view.findViewById(R.id.llTitleScores);

        //Recogemos el intent con la id de la pelicula
        Long movie_id = getActivity().getIntent().getLongExtra("movie_id", -1);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        if (preferences.getString("category_list","0").equals("0")){
            cursor = getContext().getContentResolver().query(
                    PopularColumns.CONTENT_URI,
                    null,
                    PopularColumns._ID + " = ?",
                    new String[]{String.valueOf(movie_id)},
                    null);
            PopularCursor popularCursor = new PopularCursor(cursor);
            cursor.moveToNext();
            tvTitle.setText(popularCursor.getTitle());
            tvSynopsis.setText(Html.fromHtml("<b>Synopsis:</b> " + popularCursor.getSynopsis()));
            tvCriticsScore.setText(
                    Html.fromHtml("<b>Critics Score:</b> " +
                            decimal.format(popularCursor.getPopularity()) + "%")
            );
            Picasso.with(getContext()).load(POSTERURL + POSTERSIZE + popularCursor.getPosterPath()).fit().into(ivPosterImage);


        }else if (preferences.getString("category_list","0").equals("1")) {
            cursor = getContext().getContentResolver().query(
                    TopratedColumns.CONTENT_URI,
                    null,
                    TopratedColumns._ID + " = ?",
                    new String[]{String.valueOf(movie_id)},
                    null);
            TopratedCursor topratedCursor = new TopratedCursor(cursor);
            cursor.moveToNext();
            tvTitle.setText(topratedCursor.getTitle());
            tvSynopsis.setText(Html.fromHtml("<b>Synopsis:</b> " + topratedCursor.getSynopsis()));
            tvCriticsScore.setText(
                    Html.fromHtml("<b>Critics Score:</b> " +
                            decimal.format(topratedCursor.getPopularity()) + "%")
            );
            Picasso.with(getContext()).load(POSTERURL + POSTERSIZE + topratedCursor.getPosterPath()).fit().into(ivPosterImage);

        }

        return view;
    }
}
