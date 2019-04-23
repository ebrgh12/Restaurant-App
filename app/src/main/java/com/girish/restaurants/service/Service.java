package com.girish.restaurants.service;

import com.girish.restaurants.model.RestaurantsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import java.util.ArrayList;

public interface Service {

    String BASE_URL = "https://api.doordash.com/";

    //https://api.doordash.com/v2/restaurant/?lat=37.366660&lng=-121.910075

    @GET("v2/restaurant/")
    Observable<ArrayList<RestaurantsResponse>> getRestaurants(
            @Query("lat") String lat, @Query("lng") String lng);
}
