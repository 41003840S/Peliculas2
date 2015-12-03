package com.example.manuel.peliculas.provider.toprated;

import com.example.manuel.peliculas.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Data model for the {@code toprated} table.
 */
public interface TopratedModel extends BaseModel {

    /**
     * Get the {@code title} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTitle();

    /**
     * Get the {@code release_date} value.
     * Can be {@code null}.
     */
    @Nullable
    String getReleaseDate();

    /**
     * Get the {@code popularity} value.
     * Can be {@code null}.
     */
    @Nullable
    Double getPopularity();

    /**
     * Get the {@code poster_path} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPosterPath();

    /**
     * Get the {@code synopsis} value.
     * Can be {@code null}.
     */
    @Nullable
    String getSynopsis();
}
