package com.android.jyang.fragment.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.android.jyang.fragment.R;
import com.android.jyang.fragment.fragments.DataFragment;
import com.android.jyang.fragment.fragments.DetailsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity implements DataFragment.DataListener {

//    @BindView(R.id.editTextData)
//    EditText editText;
//    @BindView(R.id.textViewDetails)
//    TextView textView;
    private boolean isMultiPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
        setMultiPanel();
    }

    @Override
    public void sendData(String text) {
        // Llamar al metodo renderizarTexto de el DetailsFragment
        // pasando el text que recibimos por parametro
        if (this.isMultiPanel) {
            DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
            detailsFragment.renderText(text);
        } else {

            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("text", text);
            startActivity(intent);
        }
    }

    private void setMultiPanel() {
        this.isMultiPanel = (getSupportFragmentManager().findFragmentById(R.id.detailsFragment) != null);
    }

}
