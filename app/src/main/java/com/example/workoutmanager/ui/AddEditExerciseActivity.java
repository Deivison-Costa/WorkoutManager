package com.example.workoutmanager.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.workoutmanager.R;
import com.example.workoutmanager.model.Exercise;
import com.example.workoutmanager.viewmodel.ExerciseViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class AddEditExerciseActivity extends AppCompatActivity {
    private ExerciseViewModel exerciseViewModel;
    private TextInputEditText editTextName;
    private TextInputEditText editTextObservations;
    private MaterialButton buttonSave;
    private String trainingId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_exercise);

        exerciseViewModel = new ViewModelProvider(this).get(ExerciseViewModel.class);

        editTextName = findViewById(R.id.editTextExerciseName);
        editTextObservations = findViewById(R.id.editTextExerciseObservations);
        buttonSave = findViewById(R.id.buttonSaveExercise);

        trainingId = getIntent().getStringExtra("trainingId");

        buttonSave.setOnClickListener(view -> {
            String name = Objects.requireNonNull(editTextName.getText()).toString();
            String observations = Objects.requireNonNull(editTextObservations.getText()).toString();
            Exercise exercise = new Exercise(null, name, null, observations);

            exerciseViewModel.addExercise(exercise);
            finish();
        });
    }
}
