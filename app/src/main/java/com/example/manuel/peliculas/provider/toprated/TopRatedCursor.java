package com.example.manuel.peliculas.provider.toprated;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.manuel.peliculas.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code toprated} table.
 */
public class TopratedCursor extends AbstractCursor implements TopratedModel {
    public TopratedCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(TopratedColumns._ID);
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
        String res = getStringOrNull(TopratedColumns.TITLE);
        return res;
    }

    /**
     * Get the {@code release_date} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getReleaseDate() {
        String res = getStringOrNull(TopratedColumns.RELEASE_DATE);
        return res;
    }

    /**
     * Get the {@code popularity} value.
     * Can be {@code null}.
     */
    @Nullable
    public Double getPopularity() {
        Double res = getDoubleOrNull(TopratedColumns.POPULARITY);
        return res;
    }

    /**
     * Get the {@code poster_path} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getPosterPath() {
        String res = getStringOrNull(TopratedColumns.POSTER_PATH);
        return res;
    }

    /**
     * Get the {@code synopsis} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getSynopsis() {
        String res = getStringOrNull(TopratedColumns.SYNOPSIS);
        return res;
    }
}
