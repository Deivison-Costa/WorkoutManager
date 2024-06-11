package com.example.workoutmanager.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workoutmanager.R;
import com.example.workoutmanager.model.Exercise;
import com.example.workoutmanager.viewmodel.ExerciseViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.example.workoutmanager.ui.adapter.ExerciseAdapter;

public class TrainingDetailsActivity extends AppCompatActivity {
    private ExerciseViewModel exerciseViewModel;
    private ExerciseAdapter exerciseAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_details);

        exerciseViewModel = new ViewModelProvider(this).get(ExerciseViewModel.class);
        exerciseAdapter = new ExerciseAdapter();

        RecyclerView recyclerView = findViewById(R.id.recyclerViewExercises);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(exerciseAdapter);

        exerciseViewModel.getExercises().observe(this, queryDocumentSnapshots -> {
            if (queryDocumentSnapshots != null) {
                exerciseAdapter.setExercises(queryDocumentSnapshots.toObjects(Exercise.class));
            }
        });

        FloatingActionButton fabAddExercise = findViewById(R.id.fabAddExercise);
        fabAddExercise.setOnClickListener(view -> {
            Intent intent = new Intent(TrainingDetailsActivity.this, AddEditExerciseActivity.class);
            intent.putExtra("trainingId", getIntent().getStringExtra("trainingId"));
            startActivity(intent);
        });
    }
}
