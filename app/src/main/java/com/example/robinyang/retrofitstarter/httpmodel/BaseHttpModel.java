package com.example.robinyang.retrofitstarter.httpmodel;

import com.google.gson.Gson;

/**
 * Created by robinyang on 15/8/4.
 */
public class BaseHttpModel {
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
