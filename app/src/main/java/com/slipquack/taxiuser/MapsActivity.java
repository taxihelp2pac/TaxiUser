package com.slipquack.taxiuser;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.data.geojson.GeoJsonLayer;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            printLocation(location);
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {
        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };
    private LocationManager locationManager;
    private double lat;
    private double lng;
    private Location location;
    private String mLog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        locationManager = (LocationManager) getSystemService(
                Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling

            return;
        }
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, 10 * 3000, 5, locationListener);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        location = locationManager.getLastKnownLocation(
                LocationManager.GPS_PROVIDER);

        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10 * 3000, 5, locationListener);
        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng startPosition = new LatLng(59.932031, 30.323078);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(startPosition));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        if (location != null) {
            Toast.makeText(this, "Определям Ваше местоположение", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Включитье GPS", Toast.LENGTH_LONG).show();
        }
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);

    }

    protected GoogleMap getmMap() {
        return mMap;
    }

    private void printLocation(Location location) {
        if (location != null) {
            lat = location.getLatitude();
            lng = location.getLongitude();
            LatLng position = new LatLng(lat, lng);
            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(position)
                    .zoom(18)
                    .bearing(270)
                    .tilt(45)
                    .build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 3000, null);
        }
    }

    public class DownloadGeoJsonFile extends AsyncTask<String, Void, GeoJsonLayer> {

        @Override
        protected GeoJsonLayer doInBackground(String... params) {
            try {
                InputStream stream = new URL(params[0]).openStream();

                String line;
                StringBuilder result = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                reader.close();
                stream.close();

                return new GeoJsonLayer(getmMap(), new JSONObject(result.toString()));
            } catch (IOException e) {
                Log.e(mLog, "Не удалось прочитать файл GeoJSON");
            } catch (JSONException e) {
                Log.e(mLog, "Файл GeoJSON не может быть преобразован в JSONObject");
            }
            return null;
        }

        @Override
        protected void onPostExecute(GeoJsonLayer layer) {
            if (layer != null) {
                layer.addLayerToMap();
                addToMarker(layer);
            }
        }
    }

    protected DownloadGeoJsonFile retriverFileFromUrl() {
        return new DownloadGeoJsonFile();
    }

    protected void addToMarker(GeoJsonLayer layer) {
    }
}