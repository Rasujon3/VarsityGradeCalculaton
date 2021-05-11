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
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.sujon.varsitygradecalculaton.GradeRepository;
import com.sujon.varsitygradecalculaton.R;
import com.sujon.varsitygradecalculaton.model.Semister;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeFragment extends Fragment {
    View root;
    GradeRepository repository;
    RecyclerView recyclerView;
    HomeRecyclerAdapter adapter;

    List<Semister> allSemisters = new ArrayList<>();

    @Nullable
    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_home, container, false);
        repository = new GradeRepository(getContext());

        recyclerView = root.findViewById(R.id.home_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        for (int i=1;i<100;i++){
            allSemisters.add(new Semister("Semister Name"+i,00.00));
        }
        adapter=new HomeRecyclerAdapter(allSemisters);
        recyclerView.setAdapter(adapter);
        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.custom_user_input_dialog);
                EditText semisterNameEditText = dialog.findViewById(R.id.dialog_semisterName_edittext);
                Button createButton = dialog.findViewById(R.id.dialog_create_button);
                createButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (semisterNameEditText.getText().toString().equals("")) {
                            Toast.makeText(getContext(), "Please Insert Semister Name", Toast.LENGTH_LONG).show();
                        } else {
                            String semisterName = semisterNameEditText.getText().toString();
                            Toast.makeText(getContext(), "Semister Name : " + semisterName, Toast.LENGTH_LONG).show();
                            insertSemister(semisterName);
                            dialog.dismiss();
                        }
                    }
                });

                dialog.show();
            }
        });

        return root;
    }

    private void insertSemister(String semisterName) {
        Semister temp = new Semister(semisterName, 0.0);
        repository.InsertSemister(temp);

    }


}

