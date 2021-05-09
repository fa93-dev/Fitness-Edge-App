package com.example.faraz.navigationapp;

/**
 * Created by Faraz on 09-04-2017.
 */

import android.app.Application;
import android.content.res.Resources;

import com.example.faraz.navigationapp.data.WorkoutContent;

public class MyApplication extends Application {

    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;


            Resources resources = getResources();
            final String[] workoutNames = resources.getStringArray(R.array.workout_names);
            final String[] workoutDescriptions = resources.getStringArray(R.array.workout_descriptions);
            final String[] workoutVideos = resources.getStringArray(R.array.workout_videos);
            final int[] darkColors = resources.getIntArray(R.array.darkColors);
            final int[] lightColors = resources.getIntArray(R.array.lightColors);

            if (WorkoutContent.WORKOUTS.isEmpty()) {
                for (int i = 0; i < workoutNames.length; i++) {
                    WorkoutContent.addWorkout(
                            new WorkoutContent.Workout(
                                    String.valueOf(i + 1),
                                    workoutNames[i],
                                    workoutDescriptions[i],
                                    workoutVideos[i],
                                    darkColors[i],
                                    lightColors[i]
                            )
                    );
                }

            }
    }

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }


}