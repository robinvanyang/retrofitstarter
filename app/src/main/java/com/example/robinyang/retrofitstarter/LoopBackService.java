package com.example.robinyang.retrofitstarter;


import com.example.robinyang.retrofitstarter.httpmodel.CoffeeShop;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

/**
 * Created by robinyang on 15/8/3.
 */
public interface LoopBackService {
    @POST("/CoffeeShops")
    void postCoffeeShop(@Body CoffeeShop coffeeShop, Callback<CoffeeShop> cb);


    @GET("/CoffeeShops")
    void getCoffeeShop(Callback<List<CoffeeShop>> cb);

    @PUT("/CoffeeShops")
    void putCoffeeShop(@Body CoffeeShop coffeeShop, Callback<CoffeeShop> cb);

    @DELETE("/CoffeeShops/{id}")
    void deleteCoffeeShop(@Path("id") int id, Callback<Object> cb);
}
