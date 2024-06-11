package com.example.workoutmanager.data;

import com.example.workoutmanager.model.Training;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class TrainingDao {
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final CollectionReference trainingCollection = db.collection("trainings");

    public Task<Void> addTraining(Training training) {
        return trainingCollection.document(training.getId()).set(training);
    }

    public CollectionReference getTrainingCollection() {
        return trainingCollection;
    }

    public Task<Void> updateTraining(Training training) {
        return trainingCollection.document(training.getId()).set(training);
    }

    public Task<Void> deleteTraining(String id) {
        return trainingCollection.document(id).delete();
    }
}
