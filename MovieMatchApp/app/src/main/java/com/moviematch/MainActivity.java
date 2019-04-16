package com.moviematch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    final Animation fadeOutAnimation = new AlphaAnimation(1.0f, 0.0f);
    Socket clientSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            clientSocket = new Socket("localhost", 44444);
        } catch (IOException e) {
            System.out.println("FAILED TO CREATE CLIENT SOCKET: " + e.getStackTrace().toString());
        }

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
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                opinion.writeTo(clientSocket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                signalOpinionFail();
            }
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
