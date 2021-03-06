package com.udacity_capstone.pointslib;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.onearticleoneweek.wahadatkashmiri.roomlib.database.domain.User;

import org.parceler.Parcels;

public class PointsActivity extends AppCompatActivity {

    ConstraintLayout mainLayout;
    TextView mPointsLabel, mMotivationLabel;
    MaterialButton mGoBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_points_module);

        setupActivity();
    }

    private void setupActivity() {

        mainLayout = findViewById(R.id.main_layout);
        mPointsLabel = findViewById(R.id.your_points_label);
        mMotivationLabel = findViewById(R.id.motivation_label);
        mGoBackButton = findViewById(R.id.go_back_btn);

        Intent intent = getIntent();

        User user = Parcels.unwrap(intent.
                getParcelableExtra(getResources().
                        getString(R.string.current_user)));

        setupPoints(user);

        mMotivationLabel.setText("This is your current score. \n Let's keep on scoring more. Click on the button below.");



    }

    private void setupPoints(final User user) {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ValueAnimator animator = ValueAnimator.ofInt(0, user.getScore());
        animator.setDuration(500);
        animator.start();

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {

                mPointsLabel.setText(String.valueOf(valueAnimator.getAnimatedValue()));

            }
        });



    }

    public void goBack(View view) {

        Snackbar.make(mainLayout, "Let's keep on scoring more!", Snackbar.LENGTH_LONG).show();

        finish();

    }
}
