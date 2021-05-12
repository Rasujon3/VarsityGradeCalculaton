package com.sujon.varsitygradecalculaton.calculation;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sujon.varsitygradecalculaton.DataController;
import com.sujon.varsitygradecalculaton.R;
import com.sujon.varsitygradecalculaton.model.Course;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {
    View rootview;
    DataController controller;

    EditText creditText,gpaText;
    Button addButton;
    TextView cgpaTextView;

    double totalCredit=0;
    double productofGPAandCredit=0;
    RecyclerView recyclerView;
    CourseRecyclerAdapter adapter;
    List<Course> myCourses = new ArrayList<>();
    FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview=inflater.inflate(R.layout.fragment_second, container, false);
        controller=DataController.getInstance();
        creditText = rootview.findViewById(R.id.editTextTextPersonName);
        gpaText = rootview.findViewById(R.id.editTextTextPersonName2);
        addButton = rootview.findViewById(R.id.button);
        cgpaTextView = rootview.findViewById(R.id.textView3);
        recyclerView=rootview.findViewById(R.id.courseRecyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CourseRecyclerAdapter(myCourses);
        recyclerView.setAdapter(adapter);

        fab = rootview.findViewById(R.id.fab_courseFragment);

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

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext())
                        .setMessage("Do you want to save?")
                        .setTitle("Warning")
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
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

        Course course = new Course(gpaValue,creditValue,controller.getCurrentSemister().getId());

        myCourses.add(course);
        adapter.notifyDataSetChanged();
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