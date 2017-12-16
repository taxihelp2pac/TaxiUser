package com.slipquack.taxiuser.rent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.slipquack.taxiuser.R;
import com.slipquack.taxiuser.customers.GeoKafe;
import com.slipquack.taxiuser.customers.GeoRepair;
import com.slipquack.taxiuser.customers.GeoService;
import com.slipquack.taxiuser.customers.GeoSink;
import com.slipquack.taxiuser.MainActivity;

/**
 * Created by Alex on 14.12.2017.
 */

public class RentSelect extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_select);
    }

    public void rentSelect(View view) {
        Intent intent = new Intent(RentSelect.this, RentActivity.class);
        startActivity(intent);
        clickButtonAnim(view);
    }

    public void rentSale(View view) {
        Intent intent = new Intent(RentSelect.this, SaleActivity.class);
        startActivity(intent);
        clickButtonAnim(view);
    }

    public void rentBuy(View view) {
        Intent intent = new Intent(RentSelect.this, BuyActivity.class);
        startActivity(intent);
        clickButtonAnim(view);
    }

    public void onClickService(View view) {
        Intent intent = new Intent(RentSelect.this, GeoService.class);
        startActivity(intent);
        clickButtonAnim(view);
    }

    public void onClickRepair(View view) {
        Intent intent = new Intent(RentSelect.this, GeoRepair.class);
        startActivity(intent);
        clickButtonAnim(view);
    }

    public void onClickSink(View view) {
        Intent intent = new Intent(RentSelect.this, GeoSink.class);
        startActivity(intent);
        clickButtonAnim(view);
    }

    public void onClickKafe(View view) {
        Intent intent = new Intent(RentSelect.this, GeoKafe.class);
        startActivity(intent);
        clickButtonAnim(view);
    }

    public void clickButtonAnim(View v) {
        Animation animation = AnimationUtils.loadAnimation(RentSelect.this, R.anim.button_click);
        v.startAnimation(animation);
    }
}
