package com.mydistroapps.api;

import com.mydistroapps.model.BasePojo;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Dedi Dot on 8/25/2018.
 * Happy Coding!
 */

public class ApiRequest {

    private EndpointRequest endpointRequest;

    public ApiRequest() {
        endpointRequest = RestClient.createService(EndpointRequest.class);
    }

    public Observable<BasePojo> getHat() {
        return endpointRequest.getHat()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<BasePojo> getJeans() {
        return endpointRequest.getJeans()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .asObservable();
    }

    public Observable<BasePojo> getShirt() {
        return endpointRequest.getShirt()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .asObservable();
    }


}
