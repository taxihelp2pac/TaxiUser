package com.slipquack.taxiuser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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
    }
}
