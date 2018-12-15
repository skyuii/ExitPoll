package com.example.exitpoll.model;

import java.util.Locale;

public class NumberItems {
    public final long _id;
    public final String image;
    public final String title;
    public final Number result;


    public NumberItems(long _id, String image ,Number result ,String title) {
        this._id = _id;
        this.image = image;
        this.result = result;
        this.title = title;
    }

    @Override
    public String toString() {
        String msg = String.format(
                Locale.getDefault(),
                "%s (%s)",
                this.result,
                this.title
        );
        return msg;
    }
}
