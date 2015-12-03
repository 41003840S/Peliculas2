package com.example.manuel.peliculas.provider.popular;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.manuel.peliculas.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code popular} table.
 */
public class PopularContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return PopularColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable PopularSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable PopularSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public PopularContentValues putTitle(@Nullable String value) {
        mContentValues.put(PopularColumns.TITLE, value);
        return this;
    }

    public PopularContentValues putTitleNull() {
        mContentValues.putNull(PopularColumns.TITLE);
        return this;
    }

    public PopularContentValues putReleaseDate(@Nullable String value) {
        mContentValues.put(PopularColumns.RELEASE_DATE, value);
        return this;
    }

    public PopularContentValues putReleaseDateNull() {
        mContentValues.putNull(PopularColumns.RELEASE_DATE);
        return this;
    }

    public PopularContentValues putPopularity(@Nullable Double value) {
        mContentValues.put(PopularColumns.POPULARITY, value);
        return this;
    }

    public PopularContentValues putPopularityNull() {
        mContentValues.putNull(PopularColumns.POPULARITY);
        return this;
    }

    public PopularContentValues putPosterPath(@Nullable String value) {
        mContentValues.put(PopularColumns.POSTER_PATH, value);
        return this;
    }

    public PopularContentValues putPosterPathNull() {
        mContentValues.putNull(PopularColumns.POSTER_PATH);
        return this;
    }

    public PopularContentValues putSynopsis(@Nullable String value) {
        mContentValues.put(PopularColumns.SYNOPSIS, value);
        return this;
    }

    public PopularContentValues putSynopsisNull() {
        mContentValues.putNull(PopularColumns.SYNOPSIS);
        return this;
    }
}
