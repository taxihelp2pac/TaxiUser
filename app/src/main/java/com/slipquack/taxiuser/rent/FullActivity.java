package com.slipquack.taxiuser.rent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slipquack.taxiuser.R;
import com.slipquack.taxiuser.model.Artist;
import com.squareup.picasso.Picasso;

import java.io.IOException;

/**
 * Created by Alex on 13.12.2017.
 */

public class FullActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_full);
        String artistString = getIntent().getStringExtra("artist");
        ProgressBar progressBarFull = (ProgressBar) findViewById(R.id.progressBarFull);
        progressBarFull.setVisibility(ProgressBar.VISIBLE);



        Artist artist;
        try {
            ObjectMapper mapper = new ObjectMapper();
            artist = mapper.readValue(artistString, Artist.class);


            getSupportActionBar().setDisplayHomeAsUpEnabled(true);



            TextView genres, price, bio, link;
            Button phone;

            ImageView big = (ImageView) findViewById(R.id.bigImg);
            ImageView bigTwo = (ImageView) findViewById(R.id.bigTwoImg);
            genres = (TextView) findViewById(R.id.genersText);
            //track = (TextView) findViewById(R.id.tracksText);
            bio = (TextView) findViewById(R.id.bioText);
            //link = (TextView) findViewById(R.id.linkText);
            phone = (Button) findViewById(R.id.phone);
            price = (TextView) findViewById(R.id.priceText);



            //устанавливаем полученные значения
            setTitle(artist.getName());

            Picasso.with(getApplicationContext())
                    .load(artist.getCover().getBig())
                    .into(big);
            Picasso.with(getApplicationContext())
                    .load(artist.getCover().getBig1())
                    .into(bigTwo);
            genres.setText(artist.style());
            //track.setText(artist.music());
            bio.setText(artist.getDescription());
            //link.setText(artist.getLink());
            phone.setText(artist.getPhone());
            price.setText(artist.getPrice());
            progressBarFull.setVisibility(ProgressBar.INVISIBLE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/****
    public void onClick(View view){
        TextView link = (TextView) findViewById(R.id.linkText);
        Intent browserIntent = null;
        if (link != null) {
            browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link.getText().toString()));
        }
        startActivity(browserIntent);
    }
****/
    public void onClickPhone(View view) {
        Button phone = (Button) findViewById(R.id.phone);
        Intent intent = null;
        if (phone != null) {
            intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone.getText().toString()));
        }
        startActivity(intent);
    }

    //кнопка "Домой" - как кнопка "Назад" чтобы не скролить заного вниз листа
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return(super.onOptionsItemSelected(item));
    }


}
