package com.bubnov.navigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConfirmationFragment extends Fragment  implements View.OnClickListener{
    private static final String TAG = "ARGS:";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView info = view.findViewById(R.id.txtConfirmationMessage);
        if(getArguments() != null){
            String recipient = getArguments().getString("recipient");
            String amount = getArguments().getString("amount");
            Log.i(TAG, recipient + amount);
            BigDecimal decimal = new BigDecimal(amount);
            decimal = decimal.setScale(2, RoundingMode.HALF_UP);
            info.setText(getString(R.string.sendInfo, decimal, recipient));
        }else{
            Toast.makeText(getActivity(), "Missing arguments", Toast.LENGTH_SHORT).show();
        }
    }
}