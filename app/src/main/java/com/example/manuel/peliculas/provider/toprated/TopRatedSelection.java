package com.example.manuel.peliculas.provider.toprated;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.example.manuel.peliculas.provider.base.AbstractSelection;

/**
 * Selection for the {@code movies} table.
 */
public class TopRatedSelection extends AbstractSelection<TopRatedSelection> {
    @Override
    protected Uri baseUri() {
        return TopRatedColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code TopRatedCursor} object, which is positioned before the first entry, or null.
     */
    public TopRatedCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new TopRatedCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public TopRatedCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code TopRatedCursor} object, which is positioned before the first entry, or null.
     */
    public TopRatedCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new TopRatedCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public TopRatedCursor query(Context context) {
        return query(context, null);
    }


    public TopRatedSelection id(long... value) {
        addEquals("movies." + TopRatedColumns._ID, toObjectArray(value));
        return this;
    }

    public TopRatedSelection idNot(long... value) {
        addNotEquals("movies." + TopRatedColumns._ID, toObjectArray(value));
        return this;
    }

    public TopRatedSelection orderById(boolean desc) {
        orderBy("movies." + TopRatedColumns._ID, desc);
        return this;
    }

    public TopRatedSelection orderById() {
        return orderById(false);
    }

    public TopRatedSelection title(String... value) {
        addEquals(TopRatedColumns.TITLE, value);
        return this;
    }

    public TopRatedSelection titleNot(String... value) {
        addNotEquals(TopRatedColumns.TITLE, value);
        return this;
    }

    public TopRatedSelection titleLike(String... value) {
        addLike(TopRatedColumns.TITLE, value);
        return this;
    }

    public TopRatedSelection titleContains(String... value) {
        addContains(TopRatedColumns.TITLE, value);
        return this;
    }

    public TopRatedSelection titleStartsWith(String... value) {
        addStartsWith(TopRatedColumns.TITLE, value);
        return this;
    }

    public TopRatedSelection titleEndsWith(String... value) {
        addEndsWith(TopRatedColumns.TITLE, value);
        return this;
    }

    public TopRatedSelection orderByTitle(boolean desc) {
        orderBy(TopRatedColumns.TITLE, desc);
        return this;
    }

    public TopRatedSelection orderByTitle() {
        orderBy(TopRatedColumns.TITLE, false);
        return this;
    }

    public TopRatedSelection releaseDate(String... value) {
        addEquals(TopRatedColumns.RELEASE_DATE, value);
        return this;
    }

    public TopRatedSelection releaseDateNot(String... value) {
        addNotEquals(TopRatedColumns.RELEASE_DATE, value);
        return this;
    }

    public TopRatedSelection releaseDateLike(String... value) {
        addLike(TopRatedColumns.RELEASE_DATE, value);
        return this;
    }

    public TopRatedSelection releaseDateContains(String... value) {
        addContains(TopRatedColumns.RELEASE_DATE, value);
        return this;
    }

    public TopRatedSelection releaseDateStartsWith(String... value) {
        addStartsWith(TopRatedColumns.RELEASE_DATE, value);
        return this;
    }

    public TopRatedSelection releaseDateEndsWith(String... value) {
        addEndsWith(TopRatedColumns.RELEASE_DATE, value);
        return this;
    }

    public TopRatedSelection orderByReleaseDate(boolean desc) {
        orderBy(TopRatedColumns.RELEASE_DATE, desc);
        return this;
    }

    public TopRatedSelection orderByReleaseDate() {
        orderBy(TopRatedColumns.RELEASE_DATE, false);
        return this;
    }

    public TopRatedSelection popularity(Double... value) {
        addEquals(TopRatedColumns.POPULARITY, value);
        return this;
    }

    public TopRatedSelection popularityNot(Double... value) {
        addNotEquals(TopRatedColumns.POPULARITY, value);
        return this;
    }

    public TopRatedSelection popularityGt(double value) {
        addGreaterThan(TopRatedColumns.POPULARITY, value);
        return this;
    }

    public TopRatedSelection popularityGtEq(double value) {
        addGreaterThanOrEquals(TopRatedColumns.POPULARITY, value);
        return this;
    }

    public TopRatedSelection popularityLt(double value) {
        addLessThan(TopRatedColumns.POPULARITY, value);
        return this;
    }

    public TopRatedSelection popularityLtEq(double value) {
        addLessThanOrEquals(TopRatedColumns.POPULARITY, value);
        return this;
    }

    public TopRatedSelection orderByPopularity(boolean desc) {
        orderBy(TopRatedColumns.POPULARITY, desc);
        return this;
    }

    public TopRatedSelection orderByPopularity() {
        orderBy(TopRatedColumns.POPULARITY, false);
        return this;
    }

    public TopRatedSelection posterPath(String... value) {
        addEquals(TopRatedColumns.POSTER_PATH, value);
        return this;
    }

    public TopRatedSelection posterPathNot(String... value) {
        addNotEquals(TopRatedColumns.POSTER_PATH, value);
        return this;
    }

    public TopRatedSelection posterPathLike(String... value) {
        addLike(TopRatedColumns.POSTER_PATH, value);
        return this;
    }

    public TopRatedSelection posterPathContains(String... value) {
        addContains(TopRatedColumns.POSTER_PATH, value);
        return this;
    }

    public TopRatedSelection posterPathStartsWith(String... value) {
        addStartsWith(TopRatedColumns.POSTER_PATH, value);
        return this;
    }

    public TopRatedSelection posterPathEndsWith(String... value) {
        addEndsWith(TopRatedColumns.POSTER_PATH, value);
        return this;
    }

    public TopRatedSelection orderByPosterPath(boolean desc) {
        orderBy(TopRatedColumns.POSTER_PATH, desc);
        return this;
    }

    public TopRatedSelection orderByPosterPath() {
        orderBy(TopRatedColumns.POSTER_PATH, false);
        return this;
    }

    public TopRatedSelection synopsis(String... value) {
        addEquals(TopRatedColumns.SYNOPSIS, value);
        return this;
    }

    public TopRatedSelection synopsisNot(String... value) {
        addNotEquals(TopRatedColumns.SYNOPSIS, value);
        return this;
    }

    public TopRatedSelection synopsisLike(String... value) {
        addLike(TopRatedColumns.SYNOPSIS, value);
        return this;
    }

    public TopRatedSelection synopsisContains(String... value) {
        addContains(TopRatedColumns.SYNOPSIS, value);
        return this;
    }

    public TopRatedSelection synopsisStartsWith(String... value) {
        addStartsWith(TopRatedColumns.SYNOPSIS, value);
        return this;
    }

    public TopRatedSelection synopsisEndsWith(String... value) {
        addEndsWith(TopRatedColumns.SYNOPSIS, value);
        return this;
    }

    public TopRatedSelection orderBySynopsis(boolean desc) {
        orderBy(TopRatedColumns.SYNOPSIS, desc);
        return this;
    }

    public TopRatedSelection orderBySynopsis() {
        orderBy(TopRatedColumns.SYNOPSIS, false);
        return this;
    }
}
