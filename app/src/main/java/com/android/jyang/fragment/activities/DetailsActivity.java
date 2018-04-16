package com.android.jyang.fragment.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.jyang.fragment.R;
import com.android.jyang.fragment.fragments.DetailsFragment;

public class DetailsActivity extends AppCompatActivity {

    private String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().setTitle("Texto");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        if ( getIntent().getExtras() != null ) {
            text = getIntent().getStringExtra("text");
        }
        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
        detailsFragment.renderText(text);
    }
}
