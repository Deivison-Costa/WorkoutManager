package com.example.workoutmanager.data;

import com.example.workoutmanager.model.Exercise;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class ExerciseDao {
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final CollectionReference exerciseCollection = db.collection("exercises");

    public Task<Void> addExercise(Exercise exercise) {
        return exerciseCollection.document(exercise.getId()).set(exercise);
    }

    public CollectionReference getExerciseCollection() {
        return exerciseCollection;
    }

    public Task<Void> updateExercise(Exercise exercise) {
        return exerciseCollection.document(exercise.getId()).set(exercise);
    }

    public Task<Void> deleteExercise(String id) {
        return exerciseCollection.document(id).delete();
    }
}
