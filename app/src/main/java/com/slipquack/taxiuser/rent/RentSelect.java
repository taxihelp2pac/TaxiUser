package com.slipquack.taxiuser.rent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.slipquack.taxiuser.R;

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

    }

    public void rentSale(View view) {
        Intent intent = new Intent(RentSelect.this, SaleActivity.class);
        startActivity(intent);
    }

    public void rentBuy(View view) {
        Intent intent = new Intent(RentSelect.this, BuyActivity.class);
        startActivity(intent);
    }
}
