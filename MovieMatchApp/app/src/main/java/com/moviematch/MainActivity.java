package com.moviematch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final Animation fadeOutAnimation = new AlphaAnimation(1.0f, 0.0f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView confirmationText = findViewById(R.id.confirmationText);
        fadeOutAnimation.setDuration(3000);
        fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                confirmationText.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void pressThumbsUp(View view) {
        sendOpinion(true);
    }

    public void pressThumbsDown(View view) {
        sendOpinion(false);
    }

    private void sendOpinion(boolean thumbsUp) {
        EditText movieTextBox = findViewById(R.id.MovieTextBox);
        Editable movieText = movieTextBox.getText();

        MovieOpinionProtos.MovieOpinion opinion = MovieOpinionProtos.MovieOpinion.newBuilder().
                setUserId(0).setMovieName(movieText.toString()).setThumbsUp(thumbsUp).build();

        if (opinion.isInitialized()) {
            signalOpinionSuccess();
            movieText.clear();
        }
        else {
            signalOpinionFail();
        }
    }

    private void signalOpinionFail() {
        final TextView confirmationText = findViewById(R.id.confirmationText);
        confirmationText.setText("Opinion failed to save...");
        confirmationText.setVisibility(View.VISIBLE);
        confirmationText.startAnimation(fadeOutAnimation);
    }

    private void signalOpinionSuccess() {
        final TextView confirmationText = findViewById(R.id.confirmationText);
        confirmationText.setText("Opinion saved!");
        confirmationText.setVisibility(View.VISIBLE);
        confirmationText.startAnimation(fadeOutAnimation);
    }
}
