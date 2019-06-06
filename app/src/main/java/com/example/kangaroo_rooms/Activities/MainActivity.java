package com.example.kangaroo_rooms.Activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.example.kangaroo_rooms.R;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class MainActivity extends AwesomeSplash {
    boolean isConnected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ConnectivityManager cm =
                (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        isConnected = activeNetwork !=   null &&
                activeNetwork.isConnectedOrConnecting();

    }





    @Override
    public void initSplash(ConfigSplash configSplash) {
        //hide the actionBar
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
        //Setting Fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Background Animation
        configSplash.setBackgroundColor(R.color.bg_color);
        configSplash.setAnimCircularRevealDuration(3000);
        configSplash.setRevealFlagX(Flags.REVEAL_LEFT);
        configSplash.setRevealFlagX(Flags.REVEAL_BOTTOM);

        //kangaroo
        configSplash.setLogoSplash(R.drawable.kang);
        configSplash.setAnimLogoSplashDuration(5000);
        configSplash.setAnimLogoSplashTechnique(Techniques.BounceInRight);

        //text
        configSplash.setTitleSplash("Complete Rental Solution");
        configSplash.setTitleTextColor(R.color.txt_color);
        configSplash.setTitleTextSize(30f);
        configSplash.setAnimTitleDuration(3000);
        configSplash.setAnimTitleTechnique(Techniques.FlipInX);

    }

    @Override
    public void animationsFinished() {
        if (isConnected){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));

        }
        else{
            //internet connection is not there
            Toast.makeText(this, "No internet connection.Please check your network and try again", Toast.LENGTH_SHORT).show();
        }
    }

//    Handler handler;

//        // Adding a delay
//        handler=new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
//                startActivity(intent);
//            }
//        },2000);

}

