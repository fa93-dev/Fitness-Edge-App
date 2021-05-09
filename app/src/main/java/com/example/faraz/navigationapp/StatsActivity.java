package com.example.faraz.navigationapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.EdgeDetail;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.charts.SeriesLabel;
import com.hookedonplay.decoviewlib.events.DecoEvent;

import java.text.NumberFormat;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Optional;

public class StatsActivity extends AppCompatActivity {

    private static final int STEPS_GOAL = 10000;
    private static final String TAG = StatsActivity.class.getSimpleName();

    @Nullable
    @BindView(R.id.dynamicArcView) DecoView mArcView;
    @BindView(R.id.numStepsLeftText) TextView mNumStepsLeftText;






    private int mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ped);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);

        int numSteps = getIntent().getIntExtra("numSteps", 0);
        mProgress = numSteps * 100 / STEPS_GOAL;
        mNumStepsLeftText.setText(formatNumStepsLeft(numSteps));

        // Create background track
        mArcView.addSeries(new SeriesItem.Builder(Color.argb(255, 218, 218, 218))
                .setRange(0, 100, 100)
                .setInitialVisibility(false)
                .setLineWidth(64f)
                .build());

        // Create data series track
        SeriesItem steps = new SeriesItem.Builder(Color.argb(255, 242, 80, 25))
                .setRange(0, 100, 0)
                .setLineWidth(64f)
                .addEdgeDetail(new EdgeDetail(EdgeDetail.EdgeType.EDGE_OUTER, Color.parseColor("#22000000"), 0.4f))
                .setSeriesLabel(new SeriesLabel.Builder("%.0f%% complete").build())
                .setShowPointWhenEmpty(false)
                .setDrawAsPoint(false)
                .setSpinClockwise(true)
                .setSpinDuration(6000)
                .setChartStyle(SeriesItem.ChartStyle.STYLE_DONUT)
                .build();

        int stepsIndex = mArcView.addSeries(steps);

        mArcView.addEvent(new DecoEvent.Builder(DecoEvent.EventType.EVENT_SHOW, true)
                .setDelay(0)
                .setDuration(0)
                .build());

        mArcView.addEvent(new DecoEvent.Builder(mProgress).setIndex(stepsIndex).setDelay(0).build());
    }

    private String formatNumStepsLeft(int numSteps) {
        return NumberFormat.getNumberInstance(Locale.US).format(STEPS_GOAL - numSteps);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
