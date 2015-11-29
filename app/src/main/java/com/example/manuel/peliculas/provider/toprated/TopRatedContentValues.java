package com.example.manuel.peliculas.provider.toprated;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.example.manuel.peliculas.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code movies} table.
 */
public class TopRatedContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return TopRatedColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable TopRatedSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable TopRatedSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public TopRatedContentValues putTitle(@Nullable String value) {
        mContentValues.put(TopRatedColumns.TITLE, value);
        return this;
    }

    public TopRatedContentValues putTitleNull() {
        mContentValues.putNull(TopRatedColumns.TITLE);
        return this;
    }

    public TopRatedContentValues putReleaseDate(@Nullable String value) {
        mContentValues.put(TopRatedColumns.RELEASE_DATE, value);
        return this;
    }

    public TopRatedContentValues putReleaseDateNull() {
        mContentValues.putNull(TopRatedColumns.RELEASE_DATE);
        return this;
    }

    public TopRatedContentValues putPopularity(@Nullable Double value) {
        mContentValues.put(TopRatedColumns.POPULARITY, value);
        return this;
    }

    public TopRatedContentValues putPopularityNull() {
        mContentValues.putNull(TopRatedColumns.POPULARITY);
        return this;
    }

    public TopRatedContentValues putPosterPath(@Nullable String value) {
        mContentValues.put(TopRatedColumns.POSTER_PATH, value);
        return this;
    }

    public TopRatedContentValues putPosterPathNull() {
        mContentValues.putNull(TopRatedColumns.POSTER_PATH);
        return this;
    }

    public TopRatedContentValues putSynopsis(@Nullable String value) {
        mContentValues.put(TopRatedColumns.SYNOPSIS, value);
        return this;
    }

    public TopRatedContentValues putSynopsisNull() {
        mContentValues.putNull(TopRatedColumns.SYNOPSIS);
        return this;
    }
}
