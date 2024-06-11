package com.example.workoutmanager.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workoutmanager.R;
import com.example.workoutmanager.model.Training;
import com.example.workoutmanager.viewmodel.TrainingViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.workoutmanager.ui.adapter.TrainingAdapter;

public class MainActivity extends AppCompatActivity {
    private TrainingViewModel trainingViewModel;
    private TrainingAdapter trainingAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trainingViewModel = new ViewModelProvider(this).get(TrainingViewModel.class);
        trainingAdapter = new TrainingAdapter();

        RecyclerView recyclerView = findViewById(R.id.recyclerViewTrainings);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(trainingAdapter);

        trainingViewModel.getTrainings().observe(this, queryDocumentSnapshots -> {
            if (queryDocumentSnapshots != null) {
                trainingAdapter.setTrainings(queryDocumentSnapshots.toObjects(Training.class));
            }
        });

        FloatingActionButton fabAddTraining = findViewById(R.id.fabAddTraining);
        fabAddTraining.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, AddEditTrainingActivity.class)));
    }
}
