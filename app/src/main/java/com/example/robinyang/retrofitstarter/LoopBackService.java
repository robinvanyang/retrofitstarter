package com.example.robinyang.retrofitstarter;


import com.example.robinyang.retrofitstarter.httpmodel.CoffeeShop;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by robinyang on 15/8/3.
 */
public interface LoopBackService {
    @POST("/CoffeeShops")
    void postCoffeeShop(@Body CoffeeShop coffeeShop, Callback<CoffeeShop> cb);


    @GET("/CoffeeShops")
    void getCoffeeShop(Callback<List<CoffeeShop>> cb);
}
