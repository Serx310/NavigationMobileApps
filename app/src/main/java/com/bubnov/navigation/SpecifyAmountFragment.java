package com.bubnov.navigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textfield.TextInputEditText;

public class SpecifyAmountFragment extends Fragment implements View.OnClickListener{

    NavController navController;
    TextInputEditText etAmount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.btnSend).setOnClickListener(this);
        view.findViewById(R.id.btnCancel).setOnClickListener(this);
        etAmount = view.findViewById(R.id.input_amount);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnSend) navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment);
    }
}