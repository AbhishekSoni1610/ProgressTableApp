package com.example.progresstableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBarAnimation;
    private ObjectAnimator progressAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();

        progressAnimator.setDuration(7000);

        findViewById(R.id.btnStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressAnimator.start();
            }
        });

        progressAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(getBaseContext(),"Progress Completed",Toast.LENGTH_SHORT).show();
                progressBarAnimation.setVisibility(View.GONE);
            }
        });
    }

    private void init() {
        progressBarAnimation = findViewById(R.id.progressBar1);
        progressAnimator = ObjectAnimator.ofInt(progressBarAnimation,"progress",0,100);
    }
}

