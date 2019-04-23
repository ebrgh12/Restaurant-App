package com.girish.restaurants;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.girish.restaurants.gps.GPSTracker;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class MainActivity extends AppCompatActivity {

    private GPSTracker gps;
    private static final int REQUEST_CODE_PERMISSION = 2;
    private String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGPS();
    }

    private void initGPS() {
        try {
            if (ActivityCompat.checkSelfPermission(this, mPermission)
                    !=PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{mPermission},
                        REQUEST_CODE_PERMISSION);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        gps = new GPSTracker(MainActivity.this);
        if (gps.canGetLocation()) {

            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();

            Intent intent = new Intent(this, DashBoardActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("LAT", String.valueOf(latitude));
            bundle.putString("LNG", String.valueOf(longitude));
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        } else {
            gps.showSettingsAlert();
        }

    }
}
