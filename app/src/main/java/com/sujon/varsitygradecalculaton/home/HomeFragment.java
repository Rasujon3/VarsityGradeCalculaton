package com.sujon.varsitygradecalculaton.home;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.sujon.varsitygradecalculaton.R;

public class HomeFragment extends Fragment {
    View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_home, container, false);

        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.custom_user_input_dialog);
                EditText semisterNameEditText = dialog.findViewById(R.id.dialog_semisterName_edittext);
                Button createButton = dialog.findViewById(R.id.dialog_create_button);

                createButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (semisterNameEditText.getText().toString().equals("")){
                            Toast.makeText(getActivity(),"Please Insert Semister Name",Toast.LENGTH_LONG).show();
                        }else {
                            String semisterName = semisterNameEditText.getText().toString();
                            Toast.makeText(getActivity(),"Semister Name : "+semisterName,Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                        }
                    }
                });

                dialog.show();
            }
        });

        return root;
    }


}

