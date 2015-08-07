package com.example.robinyang.retrofitstarter;

import retrofit.RestAdapter;

/**
 * Created by robinyang on 15/8/4.
 */
public class RestClient {
    private static LoopBackService service;

    private RestClient() {};

    public static LoopBackService getService() {
        if (null == service) {
            service = new RestAdapter.Builder()
                    .setEndpoint(Config.API_HOST)
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build()
                    .create(LoopBackService.class);
        }
        return service;
    }
}
