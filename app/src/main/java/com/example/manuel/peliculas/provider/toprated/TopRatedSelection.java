package com.example.manuel.peliculas.provider.toprated;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.example.manuel.peliculas.provider.base.AbstractSelection;

/**
 * Selection for the {@code toprated} table.
 */
public class TopratedSelection extends AbstractSelection<TopratedSelection> {
    @Override
    protected Uri baseUri() {
        return TopratedColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code TopratedCursor} object, which is positioned before the first entry, or null.
     */
    public TopratedCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new TopratedCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public TopratedCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code TopratedCursor} object, which is positioned before the first entry, or null.
     */
    public TopratedCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new TopratedCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public TopratedCursor query(Context context) {
        return query(context, null);
    }


    public TopratedSelection id(long... value) {
        addEquals("toprated." + TopratedColumns._ID, toObjectArray(value));
        return this;
    }

    public TopratedSelection idNot(long... value) {
        addNotEquals("toprated." + TopratedColumns._ID, toObjectArray(value));
        return this;
    }

    public TopratedSelection orderById(boolean desc) {
        orderBy("toprated." + TopratedColumns._ID, desc);
        return this;
    }

    public TopratedSelection orderById() {
        return orderById(false);
    }

    public TopratedSelection title(String... value) {
        addEquals(TopratedColumns.TITLE, value);
        return this;
    }

    public TopratedSelection titleNot(String... value) {
        addNotEquals(TopratedColumns.TITLE, value);
        return this;
    }

    public TopratedSelection titleLike(String... value) {
        addLike(TopratedColumns.TITLE, value);
        return this;
    }

    public TopratedSelection titleContains(String... value) {
        addContains(TopratedColumns.TITLE, value);
        return this;
    }

    public TopratedSelection titleStartsWith(String... value) {
        addStartsWith(TopratedColumns.TITLE, value);
        return this;
    }

    public TopratedSelection titleEndsWith(String... value) {
        addEndsWith(TopratedColumns.TITLE, value);
        return this;
    }

    public TopratedSelection orderByTitle(boolean desc) {
        orderBy(TopratedColumns.TITLE, desc);
        return this;
    }

    public TopratedSelection orderByTitle() {
        orderBy(TopratedColumns.TITLE, false);
        return this;
    }

    public TopratedSelection releaseDate(String... value) {
        addEquals(TopratedColumns.RELEASE_DATE, value);
        return this;
    }

    public TopratedSelection releaseDateNot(String... value) {
        addNotEquals(TopratedColumns.RELEASE_DATE, value);
        return this;
    }

    public TopratedSelection releaseDateLike(String... value) {
        addLike(TopratedColumns.RELEASE_DATE, value);
        return this;
    }

    public TopratedSelection releaseDateContains(String... value) {
        addContains(TopratedColumns.RELEASE_DATE, value);
        return this;
    }

    public TopratedSelection releaseDateStartsWith(String... value) {
        addStartsWith(TopratedColumns.RELEASE_DATE, value);
        return this;
    }

    public TopratedSelection releaseDateEndsWith(String... value) {
        addEndsWith(TopratedColumns.RELEASE_DATE, value);
        return this;
    }

    public TopratedSelection orderByReleaseDate(boolean desc) {
        orderBy(TopratedColumns.RELEASE_DATE, desc);
        return this;
    }

    public TopratedSelection orderByReleaseDate() {
        orderBy(TopratedColumns.RELEASE_DATE, false);
        return this;
    }

    public TopratedSelection popularity(Double... value) {
        addEquals(TopratedColumns.POPULARITY, value);
        return this;
    }

    public TopratedSelection popularityNot(Double... value) {
        addNotEquals(TopratedColumns.POPULARITY, value);
        return this;
    }

    public TopratedSelection popularityGt(double value) {
        addGreaterThan(TopratedColumns.POPULARITY, value);
        return this;
    }

    public TopratedSelection popularityGtEq(double value) {
        addGreaterThanOrEquals(TopratedColumns.POPULARITY, value);
        return this;
    }

    public TopratedSelection popularityLt(double value) {
        addLessThan(TopratedColumns.POPULARITY, value);
        return this;
    }

    public TopratedSelection popularityLtEq(double value) {
        addLessThanOrEquals(TopratedColumns.POPULARITY, value);
        return this;
    }

    public TopratedSelection orderByPopularity(boolean desc) {
        orderBy(TopratedColumns.POPULARITY, desc);
        return this;
    }

    public TopratedSelection orderByPopularity() {
        orderBy(TopratedColumns.POPULARITY, false);
        return this;
    }

    public TopratedSelection posterPath(String... value) {
        addEquals(TopratedColumns.POSTER_PATH, value);
        return this;
    }

    public TopratedSelection posterPathNot(String... value) {
        addNotEquals(TopratedColumns.POSTER_PATH, value);
        return this;
    }

    public TopratedSelection posterPathLike(String... value) {
        addLike(TopratedColumns.POSTER_PATH, value);
        return this;
    }

    public TopratedSelection posterPathContains(String... value) {
        addContains(TopratedColumns.POSTER_PATH, value);
        return this;
    }

    public TopratedSelection posterPathStartsWith(String... value) {
        addStartsWith(TopratedColumns.POSTER_PATH, value);
        return this;
    }

    public TopratedSelection posterPathEndsWith(String... value) {
        addEndsWith(TopratedColumns.POSTER_PATH, value);
        return this;
    }

    public TopratedSelection orderByPosterPath(boolean desc) {
        orderBy(TopratedColumns.POSTER_PATH, desc);
        return this;
    }

    public TopratedSelection orderByPosterPath() {
        orderBy(TopratedColumns.POSTER_PATH, false);
        return this;
    }

    public TopratedSelection synopsis(String... value) {
        addEquals(TopratedColumns.SYNOPSIS, value);
        return this;
    }

    public TopratedSelection synopsisNot(String... value) {
        addNotEquals(TopratedColumns.SYNOPSIS, value);
        return this;
    }

    public TopratedSelection synopsisLike(String... value) {
        addLike(TopratedColumns.SYNOPSIS, value);
        return this;
    }

    public TopratedSelection synopsisContains(String... value) {
        addContains(TopratedColumns.SYNOPSIS, value);
        return this;
    }

    public TopratedSelection synopsisStartsWith(String... value) {
        addStartsWith(TopratedColumns.SYNOPSIS, value);
        return this;
    }

    public TopratedSelection synopsisEndsWith(String... value) {
        addEndsWith(TopratedColumns.SYNOPSIS, value);
        return this;
    }

    public TopratedSelection orderBySynopsis(boolean desc) {
        orderBy(TopratedColumns.SYNOPSIS, desc);
        return this;
    }

    public TopratedSelection orderBySynopsis() {
        orderBy(TopratedColumns.SYNOPSIS, false);
        return this;
    }
}
