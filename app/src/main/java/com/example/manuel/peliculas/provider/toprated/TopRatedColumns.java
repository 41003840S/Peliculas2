package com.example.manuel.peliculas.provider.toprated;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.manuel.peliculas.provider.MovieProvider;

/**
 * Columns for the {@code movies} table.
 */
public class TopRatedColumns implements BaseColumns {
    public static final String TABLE_NAME = "movies";
    public static final Uri CONTENT_URI = Uri.parse(MovieProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String TITLE = "title";

    public static final String RELEASE_DATE = "release_date";

    public static final String POPULARITY = "popularity";

    public static final String POSTER_PATH = "poster_path";

    public static final String SYNOPSIS = "synopsis";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            TITLE,
            RELEASE_DATE,
            POPULARITY,
            POSTER_PATH,
            SYNOPSIS
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(TITLE) || c.contains("." + TITLE)) return true;
            if (c.equals(RELEASE_DATE) || c.contains("." + RELEASE_DATE)) return true;
            if (c.equals(POPULARITY) || c.contains("." + POPULARITY)) return true;
            if (c.equals(POSTER_PATH) || c.contains("." + POSTER_PATH)) return true;
            if (c.equals(SYNOPSIS) || c.contains("." + SYNOPSIS)) return true;
        }
        return false;
    }

}
