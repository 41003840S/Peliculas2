package com.example.manuel.peliculas.provider.movies;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.example.manuel.peliculas.provider.base.AbstractSelection;

/**
 * Selection for the {@code movies} table.
 */
public class MoviesSelection extends AbstractSelection<MoviesSelection> {
    @Override
    protected Uri baseUri() {
        return MoviesColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MoviesCursor} object, which is positioned before the first entry, or null.
     */
    public MoviesCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MoviesCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public MoviesCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MoviesCursor} object, which is positioned before the first entry, or null.
     */
    public MoviesCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MoviesCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public MoviesCursor query(Context context) {
        return query(context, null);
    }


    public MoviesSelection id(long... value) {
        addEquals("movies." + MoviesColumns._ID, toObjectArray(value));
        return this;
    }

    public MoviesSelection idNot(long... value) {
        addNotEquals("movies." + MoviesColumns._ID, toObjectArray(value));
        return this;
    }

    public MoviesSelection orderById(boolean desc) {
        orderBy("movies." + MoviesColumns._ID, desc);
        return this;
    }

    public MoviesSelection orderById() {
        return orderById(false);
    }

    public MoviesSelection title(String... value) {
        addEquals(MoviesColumns.TITLE, value);
        return this;
    }

    public MoviesSelection titleNot(String... value) {
        addNotEquals(MoviesColumns.TITLE, value);
        return this;
    }

    public MoviesSelection titleLike(String... value) {
        addLike(MoviesColumns.TITLE, value);
        return this;
    }

    public MoviesSelection titleContains(String... value) {
        addContains(MoviesColumns.TITLE, value);
        return this;
    }

    public MoviesSelection titleStartsWith(String... value) {
        addStartsWith(MoviesColumns.TITLE, value);
        return this;
    }

    public MoviesSelection titleEndsWith(String... value) {
        addEndsWith(MoviesColumns.TITLE, value);
        return this;
    }

    public MoviesSelection orderByTitle(boolean desc) {
        orderBy(MoviesColumns.TITLE, desc);
        return this;
    }

    public MoviesSelection orderByTitle() {
        orderBy(MoviesColumns.TITLE, false);
        return this;
    }

    public MoviesSelection releaseDate(String... value) {
        addEquals(MoviesColumns.RELEASE_DATE, value);
        return this;
    }

    public MoviesSelection releaseDateNot(String... value) {
        addNotEquals(MoviesColumns.RELEASE_DATE, value);
        return this;
    }

    public MoviesSelection releaseDateLike(String... value) {
        addLike(MoviesColumns.RELEASE_DATE, value);
        return this;
    }

    public MoviesSelection releaseDateContains(String... value) {
        addContains(MoviesColumns.RELEASE_DATE, value);
        return this;
    }

    public MoviesSelection releaseDateStartsWith(String... value) {
        addStartsWith(MoviesColumns.RELEASE_DATE, value);
        return this;
    }

    public MoviesSelection releaseDateEndsWith(String... value) {
        addEndsWith(MoviesColumns.RELEASE_DATE, value);
        return this;
    }

    public MoviesSelection orderByReleaseDate(boolean desc) {
        orderBy(MoviesColumns.RELEASE_DATE, desc);
        return this;
    }

    public MoviesSelection orderByReleaseDate() {
        orderBy(MoviesColumns.RELEASE_DATE, false);
        return this;
    }

    public MoviesSelection popularity(Double... value) {
        addEquals(MoviesColumns.POPULARITY, value);
        return this;
    }

    public MoviesSelection popularityNot(Double... value) {
        addNotEquals(MoviesColumns.POPULARITY, value);
        return this;
    }

    public MoviesSelection popularityGt(double value) {
        addGreaterThan(MoviesColumns.POPULARITY, value);
        return this;
    }

    public MoviesSelection popularityGtEq(double value) {
        addGreaterThanOrEquals(MoviesColumns.POPULARITY, value);
        return this;
    }

    public MoviesSelection popularityLt(double value) {
        addLessThan(MoviesColumns.POPULARITY, value);
        return this;
    }

    public MoviesSelection popularityLtEq(double value) {
        addLessThanOrEquals(MoviesColumns.POPULARITY, value);
        return this;
    }

    public MoviesSelection orderByPopularity(boolean desc) {
        orderBy(MoviesColumns.POPULARITY, desc);
        return this;
    }

    public MoviesSelection orderByPopularity() {
        orderBy(MoviesColumns.POPULARITY, false);
        return this;
    }

    public MoviesSelection posterPath(String... value) {
        addEquals(MoviesColumns.POSTER_PATH, value);
        return this;
    }

    public MoviesSelection posterPathNot(String... value) {
        addNotEquals(MoviesColumns.POSTER_PATH, value);
        return this;
    }

    public MoviesSelection posterPathLike(String... value) {
        addLike(MoviesColumns.POSTER_PATH, value);
        return this;
    }

    public MoviesSelection posterPathContains(String... value) {
        addContains(MoviesColumns.POSTER_PATH, value);
        return this;
    }

    public MoviesSelection posterPathStartsWith(String... value) {
        addStartsWith(MoviesColumns.POSTER_PATH, value);
        return this;
    }

    public MoviesSelection posterPathEndsWith(String... value) {
        addEndsWith(MoviesColumns.POSTER_PATH, value);
        return this;
    }

    public MoviesSelection orderByPosterPath(boolean desc) {
        orderBy(MoviesColumns.POSTER_PATH, desc);
        return this;
    }

    public MoviesSelection orderByPosterPath() {
        orderBy(MoviesColumns.POSTER_PATH, false);
        return this;
    }

    public MoviesSelection synopsis(String... value) {
        addEquals(MoviesColumns.SYNOPSIS, value);
        return this;
    }

    public MoviesSelection synopsisNot(String... value) {
        addNotEquals(MoviesColumns.SYNOPSIS, value);
        return this;
    }

    public MoviesSelection synopsisLike(String... value) {
        addLike(MoviesColumns.SYNOPSIS, value);
        return this;
    }

    public MoviesSelection synopsisContains(String... value) {
        addContains(MoviesColumns.SYNOPSIS, value);
        return this;
    }

    public MoviesSelection synopsisStartsWith(String... value) {
        addStartsWith(MoviesColumns.SYNOPSIS, value);
        return this;
    }

    public MoviesSelection synopsisEndsWith(String... value) {
        addEndsWith(MoviesColumns.SYNOPSIS, value);
        return this;
    }

    public MoviesSelection orderBySynopsis(boolean desc) {
        orderBy(MoviesColumns.SYNOPSIS, desc);
        return this;
    }

    public MoviesSelection orderBySynopsis() {
        orderBy(MoviesColumns.SYNOPSIS, false);
        return this;
    }
}
