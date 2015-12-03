package com.example.manuel.peliculas.provider.toprated;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.manuel.peliculas.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code toprated} table.
 */
public class TopratedContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return TopratedColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable TopratedSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable TopratedSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public TopratedContentValues putTitle(@Nullable String value) {
        mContentValues.put(TopratedColumns.TITLE, value);
        return this;
    }

    public TopratedContentValues putTitleNull() {
        mContentValues.putNull(TopratedColumns.TITLE);
        return this;
    }

    public TopratedContentValues putReleaseDate(@Nullable String value) {
        mContentValues.put(TopratedColumns.RELEASE_DATE, value);
        return this;
    }

    public TopratedContentValues putReleaseDateNull() {
        mContentValues.putNull(TopratedColumns.RELEASE_DATE);
        return this;
    }

    public TopratedContentValues putPopularity(@Nullable Double value) {
        mContentValues.put(TopratedColumns.POPULARITY, value);
        return this;
    }

    public TopratedContentValues putPopularityNull() {
        mContentValues.putNull(TopratedColumns.POPULARITY);
        return this;
    }

    public TopratedContentValues putPosterPath(@Nullable String value) {
        mContentValues.put(TopratedColumns.POSTER_PATH, value);
        return this;
    }

    public TopratedContentValues putPosterPathNull() {
        mContentValues.putNull(TopratedColumns.POSTER_PATH);
        return this;
    }

    public TopratedContentValues putSynopsis(@Nullable String value) {
        mContentValues.put(TopratedColumns.SYNOPSIS, value);
        return this;
    }

    public TopratedContentValues putSynopsisNull() {
        mContentValues.putNull(TopratedColumns.SYNOPSIS);
        return this;
    }
}
