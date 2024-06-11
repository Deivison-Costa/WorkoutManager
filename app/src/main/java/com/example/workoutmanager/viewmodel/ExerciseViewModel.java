package com.example.workoutmanager.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.workoutmanager.data.ExerciseRepository;
import com.example.workoutmanager.model.Exercise;
import com.google.firebase.firestore.QuerySnapshot;

public class ExerciseViewModel extends ViewModel {
    private final ExerciseRepository exerciseRepository;
    private final MutableLiveData<QuerySnapshot> exercises;

    public ExerciseViewModel() {
        exerciseRepository = new ExerciseRepository();
        exercises = new MutableLiveData<>();
    }

    public LiveData<QuerySnapshot> getExercises() {
        loadExercises();
        return exercises;
    }

    private void loadExercises() {
        exerciseRepository.getAllExercises().addSnapshotListener((queryDocumentSnapshots, e) -> {
            if (e != null) {
                return;
            }
            exercises.setValue(queryDocumentSnapshots);
        });
    }

    public void addExercise(Exercise exercise) {
        exerciseRepository.addExercise(exercise);
    }

    public void updateExercise(Exercise exercise) {
        exerciseRepository.updateExercise(exercise);
    }

    public void deleteExercise(String id) {
        exerciseRepository.deleteExercise(id);
    }
}
