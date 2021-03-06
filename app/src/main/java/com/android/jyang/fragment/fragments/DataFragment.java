package com.android.jyang.fragment.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.jyang.fragment.R;

public class DataFragment extends Fragment {

    private EditText text;
    private Button btnSend;
    private DataListener callback;


    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback = (DataListener) context;

        } catch (Exception e) {
            throw  new ClassCastException(context.toString() +  "Data listener no implementado");
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        // Logica para capturar los elementos de la UI
        text = (EditText) view.findViewById(R.id.editTextData);
        btnSend = (Button) view.findViewById(R.id.send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendText(text.getText().toString());
//                String textToSend = text.getText().toString();
//                callback.sendData(textToSend);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void sendText(String text) {
        callback.sendData(text);
    }

    public interface DataListener {
        void sendData(String text);
    }
}
