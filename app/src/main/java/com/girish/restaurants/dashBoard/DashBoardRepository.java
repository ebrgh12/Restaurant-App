package com.girish.restaurants.dashBoard;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.girish.restaurants.model.RestaurantsResponse;
import com.girish.restaurants.service.Service;
import com.girish.restaurants.service.ServiceManager;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;

public class DashBoardRepository {

    public DashBoardRepository(Application application) {

    }

    public MutableLiveData<ArrayList<RestaurantsResponse>> getRestaurants(String lat, String lng) {
        ServiceManager mServiceManager = new ServiceManager();
        Service service = mServiceManager.getServiceManager();

        MutableLiveData<ArrayList<RestaurantsResponse>> restaurentResponse = new MutableLiveData();
        Observable observable = service.getRestaurants(lat,lng);
        observable.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<ArrayList<RestaurantsResponse>>) response -> restaurentResponse.setValue(response), new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
        return restaurentResponse;
    }
}
