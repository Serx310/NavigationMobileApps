package com.bubnov.navigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SpecifyAmountFragment extends Fragment implements View.OnClickListener{

    private static final String TAG = "ARGS:";
    NavController navController;
    TextInputEditText etAmount;
    String recipient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            recipient = getArguments().getString("recipient");
            Log.i(TAG, recipient);
        }else{
            Toast.makeText(getActivity(), "Missing arguments", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.btnSend).setOnClickListener(this);
        view.findViewById(R.id.btnCancel2).setOnClickListener(this);
        etAmount = view.findViewById(R.id.input_amount);
        TextView message = view.findViewById(R.id.recipient);
        message.setText(getString(R.string.sending, recipient));
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnSend){
            if(!TextUtils.isEmpty(etAmount.getText())){
                Bundle args = new Bundle();
                String amount = String.valueOf(etAmount.getText());
                args.putString("amount", amount);
                args.putString("recipient", recipient);
                navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment, args);
            }else{
                etAmount.setError("Enter the amount!");
            }
        }else{
            requireActivity().onBackPressed();
        }
    }
}
