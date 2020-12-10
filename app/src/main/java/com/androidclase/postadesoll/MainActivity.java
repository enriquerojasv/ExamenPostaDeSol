package com.androidclase.postadesoll;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView circleIV;
    private FrameLayout skyFL;

    private ObjectAnimator animatorY;

    private long animationDuration = 3000;

    private AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        animatorSet = new AnimatorSet();

        circleIV = findViewById(R.id.circleIV);
        skyFL = findViewById(R.id.skyFL);
        skyFL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacion(skyFL);
                startColorAnimation(skyFL);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.moon:
                setContentView(R.layout.activity_main);
                return true;

            case R.id.face:
                setContentView(R.layout.hello_world);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    private void startColorAnimation(View v) {
        int colorStart = 0xFF217FD3;
        int color2 = 0xFF9E8D84;
        int color3 = 0xFFF2A523;
        int colorEnd = 0xFF1A1A3A;

        ValueAnimator colorAnim = ObjectAnimator.ofInt(v, "backgroundColor", colorStart, color2, color3, colorEnd);

        colorAnim.setDuration(animationDuration+1500);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.start();
    }

    private void animacion(FrameLayout skyFL) {
        animatorY = ObjectAnimator.ofFloat(circleIV, "y", 1100f);
        animatorY.setDuration(animationDuration);
        AnimatorSet animatorSetY = new AnimatorSet();
        animatorSetY.play(animatorY);
        animatorSetY.start();
    }
}