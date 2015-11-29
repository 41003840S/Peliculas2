package com.example.manuel.peliculas.provider.populars;

import android.database.Cursor;
import android.support.annotation.Nullable;

import com.example.manuel.peliculas.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code movies} table.
 */
public class PopularCursor extends AbstractCursor implements PopularModel {
    public PopularCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(PopularColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code title} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getTitle() {
        String res = getStringOrNull(PopularColumns.TITLE);
        return res;
    }

    /**
     * Get the {@code release_date} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getReleaseDate() {
        String res = getStringOrNull(PopularColumns.RELEASE_DATE);
        return res;
    }

    /**
     * Get the {@code popularity} value.
     * Can be {@code null}.
     */
    @Nullable
    public Double getPopularity() {
        Double res = getDoubleOrNull(PopularColumns.POPULARITY);
        return res;
    }

    /**
     * Get the {@code poster_path} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getPosterPath() {
        String res = getStringOrNull(PopularColumns.POSTER_PATH);
        return res;
    }

    /**
     * Get the {@code synopsis} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getSynopsis() {
        String res = getStringOrNull(PopularColumns.SYNOPSIS);
        return res;
    }
}
