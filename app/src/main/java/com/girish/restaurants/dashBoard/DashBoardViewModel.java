package com.girish.restaurants.dashBoard;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.girish.restaurants.model.RestaurantsResponse;

import java.util.ArrayList;

public class DashBoardViewModel extends AndroidViewModel {
    private DashBoardRepository dashBoardRepository;

    public DashBoardViewModel(Application application) {
        super(application);
        dashBoardRepository=new DashBoardRepository(application);
    }

    public MutableLiveData<ArrayList<RestaurantsResponse>> getAllRestaurants(String lat, String lng) {
        return dashBoardRepository.getRestaurants(lat,lng);
    }
}