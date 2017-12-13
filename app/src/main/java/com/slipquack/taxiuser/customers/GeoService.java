package com.slipquack.taxiuser.customers;

import android.content.Intent;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.geojson.GeoJsonFeature;
import com.google.maps.android.data.geojson.GeoJsonLayer;
import com.google.maps.android.data.geojson.GeoJsonPointStyle;
import com.slipquack.taxiuser.MapsActivity;
import com.slipquack.taxiuser.R;

/**
 * Created by Quack-Do on 03.10.2017.
 */

public class GeoService extends MapsActivity {

    @Override
    public void onMapReady(GoogleMap googleMap) {
        super.onMapReady(googleMap);

        retriverFileFromUrl();
    }

    protected DownloadGeoJsonFile retriverFileFromUrl() {
        new DownloadGeoJsonFile().execute(getString(R.string.url_service));
        return null;
    }

    protected void addToMarker(GeoJsonLayer layer) {

        for (GeoJsonFeature feature : layer.getFeatures())

            if ((feature.getProperty("address") != null) && feature.hasProperty("phone")) {

                BitmapDescriptor marker = BitmapDescriptorFactory.fromResource(R.mipmap.service);
                GeoJsonPointStyle pointStyle = new GeoJsonPointStyle();
                pointStyle.setIcon(marker);
                feature.setPointStyle(pointStyle);

                layer.setOnFeatureClickListener(new GeoJsonLayer.GeoJsonOnFeatureClickListener() {
                    @Override
                    public void onFeatureClick(Feature feature) {

                        Intent intent = new Intent(GeoService. this, Customers.class);
                        intent.putExtra("label", feature.getProperty("label"));
                        intent.putExtra("address", feature.getProperty("address"));
                        intent.putExtra("phone", feature.getProperty("phone"));
                        intent.putExtra("img", feature.getProperty("img"));
                        intent.putExtra("text", feature.getProperty("text"));
                        intent.putExtra("site", feature.getProperty("site"));
                        startActivity(intent);
                    }
                });
            }
    }
}
