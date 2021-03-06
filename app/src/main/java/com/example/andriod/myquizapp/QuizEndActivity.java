package com.example.andriod.myquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class QuizEndActivity extends AppCompatActivity {
// Private Constants

    private static final String TAG = "QuizEndActivity";



    // Private member variables

    private int correctAnswers;

    private int incorrectAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the values for correctAnswers and incorrectAnswers

        if (null != savedInstanceState && savedInstanceState.containsKey("correctAnswers") && savedInstanceState.containsKey("incorrectAnswers")) {

            correctAnswers = savedInstanceState.getInt("correctAnswers");

            incorrectAnswers = savedInstanceState.getInt("incorrectAnswers");

        } else if (null != getIntent().getExtras() && getIntent().getExtras().containsKey("correctAnswers") && getIntent().getExtras().containsKey("incorrectAnswers")) {

            correctAnswers = getIntent().getExtras().getInt("correctAnswers");

            incorrectAnswers = getIntent().getExtras().getInt("incorrectAnswers");

        } else {

            Log.w(TAG, "Data for the number of correct/incorrect answers was not provided. This indicates that this Activity was started incorrectly.");

            correctAnswers = 0;

            incorrectAnswers = 0;

        }



        // Display the end of quiz summary

        setContentView(R.layout.activity_quiz_end);
    }

    @Override

    protected void onSaveInstanceState(final Bundle outState) {

        outState.putInt("correctAnswers", correctAnswers);

        outState.putInt("incorrectAnswers", incorrectAnswers);

        super.onSaveInstanceState(outState);
    }
    }

