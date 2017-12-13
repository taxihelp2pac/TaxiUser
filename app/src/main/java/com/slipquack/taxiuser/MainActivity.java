package com.slipquack.taxiuser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.slipquack.taxiuser.customers.GeoKafe;
import com.slipquack.taxiuser.customers.GeoRepair;
import com.slipquack.taxiuser.customers.GeoService;
import com.slipquack.taxiuser.customers.GeoSink;
import com.slipquack.taxiuser.rent.RentActivity;

/**
 * Created by Alex on 13.12.2017.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickButtonRent(View view) {
        Intent intent = new Intent(MainActivity.this, RentActivity.class);
        startActivity(intent);
        clickButton(view);
    }

    public void clickButtonRepair(View view) {
        Intent intent = new Intent(MainActivity.this, GeoRepair.class);
        startActivity(intent);
        clickButton(view);
    }

    public void clickButtonKafe(View view) {
        Intent intent = new Intent(MainActivity.this, GeoKafe.class);
        startActivity(intent);
        clickButton(view);
    }

    public void clickButtonService(View view) {
        Intent intent = new Intent(MainActivity.this, GeoService.class);
        startActivity(intent);
        clickButton(view);
    }

    public void clickButtonSink(View view) {
        Intent intent = new Intent(MainActivity.this, GeoSink.class);
        startActivity(intent);
        clickButton(view);
    }

    public void clickButton(View v) {
        Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.button_click);
        v.startAnimation(anim);
    }
}
