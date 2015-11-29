package com.example.manuel.peliculas;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.manuel.peliculas.provider.populars.PopularColumns;
import com.example.manuel.peliculas.provider.populars.PopularCursor;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;


public class DetailActivityFragment extends Fragment {

    final private String POSTERURL = "http://image.tmdb.org/t/p/";
    final private String POSTERSIZE = "w185";
    ImageView ivPosterImage;
    TextView tvTitle, tvSynopsis, tvCriticsScore;
    LinearLayout llTitleScores;
    DecimalFormat decimal = new DecimalFormat("#.#");

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

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
        Cursor cursor = getContext().getContentResolver().query(
                PopularColumns.CONTENT_URI,
                null,
                PopularColumns._ID + " = ?",
                new String[]{String.valueOf(movie_id)},
                null
        );

        PopularCursor moviesCursor = new PopularCursor(cursor);
        moviesCursor.moveToNext();

        tvTitle.setText(moviesCursor.getTitle());
        tvCriticsScore.setText(
                Html.fromHtml("<b>Critics Score:</b> " +
                        decimal.format(moviesCursor.getPopularity()) + "%")
        );


        tvSynopsis.setText(Html.fromHtml("<b>Synopsis:</b> " + moviesCursor.getSynopsis()));


        Picasso.with(getContext()).load(POSTERURL + POSTERSIZE + moviesCursor.getPosterPath()).fit().centerCrop().into(ivPosterImage);

        /*Picasso.with(getContext())
                .load(moviesCursor.getPosterPath())
                .fit()
                .centerInside()
                .into(ivPosterImage, PicassoPalette.with(moviesCursor.getPosterPath(), ivPosterImage)
                        .use(PicassoPalette.Profile.MUTED_LIGHT)
                        .intoBackground(llTitleScores)
                        .intoTextColor(tvTitle)
                        .intoTextColor(tvSynopsis)
                        .intoTextColor(tvCriticsScore));*/

        return view;
    }
}
