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
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class ChooseRecipientFragment extends Fragment  implements View.OnClickListener{

    private static final String TAG = "ARGS:";
    NavController navController;
    TextInputEditText etRecipient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.btnNext).setOnClickListener(this);
        view.findViewById(R.id.btnCancel).setOnClickListener(this);
        etRecipient = view.findViewById(R.id.input_recipent);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnNext){
            if(!TextUtils.isEmpty(etRecipient.getText())) {
                Log.i(TAG, String.valueOf(etRecipient.getText()));
                Bundle args = new Bundle();
                args.putString("recipient", String.valueOf(etRecipient.getText()));
                navController.navigate(R.id.action_chooseRecipeintFragment_to_specifyAmountFragment, args);
            }else{
                etRecipient.setError("Enter a recipient!");
                //Toast.makeText(getActivity(), "Enter a recipient!", Toast.LENGTH_SHORT).show();
            }
        }else{
            requireActivity().onBackPressed();
        }
    }
}