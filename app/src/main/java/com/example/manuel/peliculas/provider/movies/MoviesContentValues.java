package com.example.manuel.peliculas.provider.movies;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.manuel.peliculas.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code movies} table.
 */
public class MoviesContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return MoviesColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable MoviesSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable MoviesSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public MoviesContentValues putTitle(@Nullable String value) {
        mContentValues.put(MoviesColumns.TITLE, value);
        return this;
    }

    public MoviesContentValues putTitleNull() {
        mContentValues.putNull(MoviesColumns.TITLE);
        return this;
    }

    public MoviesContentValues putReleaseDate(@Nullable String value) {
        mContentValues.put(MoviesColumns.RELEASE_DATE, value);
        return this;
    }

    public MoviesContentValues putReleaseDateNull() {
        mContentValues.putNull(MoviesColumns.RELEASE_DATE);
        return this;
    }

    public MoviesContentValues putPopularity(@Nullable Double value) {
        mContentValues.put(MoviesColumns.POPULARITY, value);
        return this;
    }

    public MoviesContentValues putPopularityNull() {
        mContentValues.putNull(MoviesColumns.POPULARITY);
        return this;
    }

    public MoviesContentValues putPosterPath(@Nullable String value) {
        mContentValues.put(MoviesColumns.POSTER_PATH, value);
        return this;
    }

    public MoviesContentValues putPosterPathNull() {
        mContentValues.putNull(MoviesColumns.POSTER_PATH);
        return this;
    }

    public MoviesContentValues putSynopsis(@Nullable String value) {
        mContentValues.put(MoviesColumns.SYNOPSIS, value);
        return this;
    }

    public MoviesContentValues putSynopsisNull() {
        mContentValues.putNull(MoviesColumns.SYNOPSIS);
        return this;
    }
}
