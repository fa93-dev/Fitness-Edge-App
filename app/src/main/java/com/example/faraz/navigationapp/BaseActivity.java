package com.example.faraz.navigationapp;

import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;



public class BaseActivity extends AppCompatActivity {

    protected Toolbar toolbar;


    protected ViewGroup getContentFrame() {
        return (ViewGroup) findViewById(R.id.content_frame);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(R.layout.activity_base);

        getLayoutInflater().inflate(layoutResID, getContentFrame());

        setupToolbar();

        onContentChanged();
    }

    @CallSuper
    protected void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    public final CoordinatorLayout getCoordinatorLayout() {
        return (CoordinatorLayout) findViewById(R.id.coordinator_layout);
    }

    @NonNull
    public FloatingActionButton addFab() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        if (fab == null) {
            getLayoutInflater().inflate(R.layout.fab, getCoordinatorLayout());

            fab = (FloatingActionButton) findViewById(R.id.fab);
        }

        setShowFab(true);

        return fab;
    }

    @Nullable
    public FloatingActionButton setShowFab(boolean show) {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        if (fab == null || fab.getVisibility() == View.VISIBLE && show || fab.getVisibility() == View.GONE && !show) {
            return fab;
        }

        fab.clearAnimation();

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
        if (show) {
//            params.setBehavior(new FloatingActionButtonBehavior(this));
            fab.setVisibility(View.VISIBLE);
        } else {
            params.setBehavior(null);
            fab.setVisibility(View.GONE);
        }

        return fab;
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
