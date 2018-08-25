package com.mydistroapps.api;

import com.mydistroapps.model.BasePojo;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Dedi Dot on 8/25/2018.
 * Happy Coding!
 */

public interface EndpointRequest {

    @GET("/list/jeans")
    Observable<BasePojo> getJeans();

    @GET("/list/shirt")
    Observable<BasePojo> getShirt();

    @GET("/list/hat")
    Observable<BasePojo> getHat();

}
