package com.girish.restaurants;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.girish.restaurants.dashBoard.DashBoardViewModel;
import com.girish.restaurants.model.RestaurantsResponse;

import java.util.ArrayList;

public class DashBoardActivity extends AppCompatActivity {
    private DashBoardViewModel mainActivityViewModel;
    private ArrayList<RestaurantsResponse> restaurants;
    private RecyclerView recyclerView;
    private RestaurantAdapter restaurantAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Bundle mBundle;

    @Override
    protected void onCreate(Bundle bundle) {
        mBundle = getIntent().getExtras();
        setContentView(R.layout.activity_dashboard);
        mainActivityViewModel=ViewModelProviders.of(this).get(DashBoardViewModel.class);
        getResturants();
        super.onCreate(bundle);
    }

    public void getResturants() {
        mainActivityViewModel.getAllRestaurants(mBundle.getString("LAT"),mBundle.getString("LNG")).observe(this, response -> {
            if (response != null) {
                restaurants = response;
                Toast.makeText(getApplicationContext(), restaurants.toString(),Toast.LENGTH_LONG).show();
                showOnRecyclerView();
            }
        });
    }

    private void showOnRecyclerView() {

        recyclerView = (RecyclerView) findViewById(R.id.rvMovies);
        restaurantAdapter = new RestaurantAdapter(this, restaurants);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        }

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(restaurantAdapter);
        restaurantAdapter.notifyDataSetChanged();

    }
}
