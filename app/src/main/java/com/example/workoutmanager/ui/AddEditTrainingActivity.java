package com.example.workoutmanager.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.workoutmanager.R;
import com.example.workoutmanager.model.Training;
import com.example.workoutmanager.viewmodel.TrainingViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Date;
import java.util.Objects;

public class AddEditTrainingActivity extends AppCompatActivity {
    private TrainingViewModel trainingViewModel;
    private TextInputEditText editTextName;
    private TextInputEditText editTextDescription;
    private MaterialButton buttonSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_training);

        trainingViewModel = new ViewModelProvider(this).get(TrainingViewModel.class);

        editTextName = findViewById(R.id.editTextTrainingName);
        editTextDescription = findViewById(R.id.editTextTrainingDescription);
        buttonSave = findViewById(R.id.buttonSaveTraining);

        buttonSave.setOnClickListener(view -> {
            String name = Objects.requireNonNull(editTextName.getText()).toString();
            String description = Objects.requireNonNull(editTextDescription.getText()).toString();
            Training training = new Training(null, name, description, new Date());

            trainingViewModel.addTraining(training);
            finish();
        });
    }
}
