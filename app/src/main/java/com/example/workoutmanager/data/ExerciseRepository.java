package com.example.workoutmanager.data;

import com.example.workoutmanager.model.Exercise;
import com.google.firebase.firestore.CollectionReference;

public class ExerciseRepository {
    private final ExerciseDao exerciseDao;

    public ExerciseRepository() {
        exerciseDao = new ExerciseDao();
    }

    public CollectionReference getAllExercises() {
        return exerciseDao.getExerciseCollection();
    }

    public void addExercise(Exercise exercise) {
        exerciseDao.addExercise(exercise);
    }

    public void updateExercise(Exercise exercise) {
        exerciseDao.updateExercise(exercise);
    }

    public void deleteExercise(String id) {
        exerciseDao.deleteExercise(id);
    }
}
