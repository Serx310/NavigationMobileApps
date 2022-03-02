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

public class MainFragment extends Fragment implements View.OnClickListener{

    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mainfragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.btnViewTransactions).setOnClickListener(this);
        view.findViewById(R.id.btnSendMoney).setOnClickListener(this);
        view.findViewById(R.id.btnViewBalance).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnViewTransactions:
                navController.navigate(R.id.action_mainfragment_to_viewTransactionFragment);
                break;
            case R.id.btnSendMoney:
                navController.navigate(R.id.action_mainfragment_to_chooseRecipeintFragment);
                break;
            case R.id.btnViewBalance:
                navController.navigate(R.id.action_mainfragment_to_viewBalanceFragment);
                break;
        }
    }
}
//                navController.navigate(R.id.);