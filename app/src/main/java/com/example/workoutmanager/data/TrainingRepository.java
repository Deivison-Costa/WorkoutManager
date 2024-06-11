package com.example.workoutmanager.data;

import com.example.workoutmanager.model.Training;
import com.google.firebase.firestore.CollectionReference;

public class TrainingRepository {
    private final TrainingDao trainingDao;

    public TrainingRepository() {
        trainingDao = new TrainingDao();
    }

    public CollectionReference getAllTrainings() {
        return trainingDao.getTrainingCollection();
    }

    public void addTraining(Training training) {
        trainingDao.addTraining(training);
    }

    public void updateTraining(Training training) {
        trainingDao.updateTraining(training);
    }

    public void deleteTraining(String id) {
        trainingDao.deleteTraining(id);
    }
}
