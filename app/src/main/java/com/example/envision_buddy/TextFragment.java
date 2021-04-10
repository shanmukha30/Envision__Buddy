package com.example.envision_buddy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;
import com.teaminversion.envisionbuddy.R;

public class TextFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /*notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);*/
        View root = inflater.inflate(R.layout.fragment_text, container, false);
        /*final TextView textView = root.findViewById(R.id.text_notifications);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        TextInputLayout inputLayout = root.findViewById(R.id.filledTextField);
        EditText editText = root.findViewById(R.id.editText);
        inputLayout.setError(null);
        editText.setText(HomeFragment.resultText);
        Button continueButton = root.findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().isEmpty()){
                    inputLayout.setError("Field cannot be empty");
                }else {
                    inputLayout.setError(null);
                    InputMethodManager manager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    manager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                    Intent intent = new Intent(getActivity(), ChoiceActivity.class);
                    intent.putExtra("text", editText.getText().toString());
                    intent.putExtra("status", false);
                    startActivity(intent);
                }
            }
        });
        return root;
    }
}