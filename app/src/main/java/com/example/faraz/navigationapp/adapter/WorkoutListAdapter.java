package com.example.faraz.navigationapp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.faraz.navigationapp.R;
import com.example.faraz.navigationapp.data.WorkoutContent;
import com.example.faraz.navigationapp.data.WorkoutContent.Workout;

public class WorkoutListAdapter extends BaseAdapter {

    private static LayoutInflater mLayoutInflater = null;

    public WorkoutListAdapter(Activity ctx) {
        this.mLayoutInflater = ctx.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return WorkoutContent.WORKOUTS.size();
    }

    @Override
    public Object getItem(int position) {
        return WorkoutContent.WORKOUTS.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Workout workout = (Workout) getItem(position);

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.adapter_workout_row, parent, false);

            holder = new ViewHolder();
            holder.id = (TextView) convertView.findViewById(R.id.workout_id);
            holder.name = (TextView) convertView.findViewById(R.id.workout_name);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Set the content for the ListView row
        holder.id.setText(workout.id);
        holder.name.setText(workout.name);

        // Set the color for the ListView row
        holder.id.setBackgroundColor(workout.dark);
        holder.name.setBackgroundColor(workout.light);

        return convertView;
    }

    private static class ViewHolder {

        public TextView id;

        public TextView name;
    }
}
