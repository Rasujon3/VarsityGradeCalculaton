package com.sujon.varsitygradecalculaton.calculation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.sujon.varsitygradecalculaton.DataController;
import com.sujon.varsitygradecalculaton.R;

public class SecondFragment extends Fragment {
    View rootview;
    DataController controller;

    EditText creditText,gpaText;
    Button addButton;
    TextView cgpaTextView;

    double totalCredit=0;
    double productofGPAandCredit=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview=inflater.inflate(R.layout.fragment_second, container, false);
        controller=DataController.getInstance();
        creditText = rootview.findViewById(R.id.editTextTextPersonName);
        gpaText = rootview.findViewById(R.id.editTextTextPersonName2);
        addButton = rootview.findViewById(R.id.button);
        cgpaTextView = rootview.findViewById(R.id.textView3);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (creditText.getText().toString().equals("") || gpaText.getText().equals("")) {
                    Toast.makeText(getContext(), "Insert Credit & GPA", Toast.LENGTH_SHORT).show();
                } else {
                    CalculateCGPA(gpaText.getText().toString(), creditText.getText().toString());

                }
            }
        });

        Toast.makeText(getContext(),controller.getCurrentSemister().getSemisterName(),Toast.LENGTH_SHORT).show();
        return rootview;
    }

    public void CalculateCGPA(String gpa,String credit){
        double gpaValue = Double.parseDouble(gpa);
        double creditValue = Double.parseDouble(credit);

        productofGPAandCredit += (gpaValue * creditValue);
        totalCredit += creditValue;
        double cgpa = productofGPAandCredit / totalCredit;
        cgpaTextView.setText(String.format("CGPA: %.2f",cgpa));

    }

//    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(SecondFragment.this)
//                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
//            }
//        });
//    }
}