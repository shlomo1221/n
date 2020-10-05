package shlomo.com.s;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import shlomo.com.R;


public class
Activity2 extends AppCompatActivity {
    private AdView mAdView;

     private   Button bt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        bt = (Button) findViewById(R.id.share);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "שתפו אותנו עם חברים";
                String shareSub = "Your subject here";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "שתפו אותנו עם חברים"));
            }
        });





        Button button6 = (Button) findViewById(R.id.notification);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity2.this, Statistics.class));
            }
        });




        Button button8 = (Button) findViewById(R.id.b);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity2.this, About.class));
            }
        });


        MobileAds.initialize(this, new OnInitializationCompleteListener() {

            @Override

            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-5024939896479661/9534172418");



        bt = (Button) findViewById(R.id.btn);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.sample);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp.isPlaying()) {
                    mp.pause();

                } else {
                    mp.start();
                }

            }

        });

    showStartDialog();

    }
 private void  showStartDialog() {
        new AlertDialog.Builder(this)
                .setTitle("שלום")
                .setMessage("התראות ")
                .setPositiveButton("בסדר", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create().show();
 }
}








