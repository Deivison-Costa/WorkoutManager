package com.example.workoutmanager.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.workoutmanager.data.TrainingRepository;
import com.example.workoutmanager.model.Training;
import com.google.firebase.firestore.QuerySnapshot;

public class TrainingViewModel extends ViewModel {
    private final TrainingRepository trainingRepository;
    private final MutableLiveData<QuerySnapshot> trainings;

    public TrainingViewModel() {
        trainingRepository = new TrainingRepository();
        trainings = new MutableLiveData<>();
    }

    public LiveData<QuerySnapshot> getTrainings() {
        loadTrainings();
        return trainings;
    }

    private void loadTrainings() {
        trainingRepository.getAllTrainings().addSnapshotListener((queryDocumentSnapshots, e) -> {
            if (e != null) {
                return;
            }
            trainings.setValue(queryDocumentSnapshots);
        });
    }

    public void addTraining(Training training) {
        trainingRepository.addTraining(training);
    }

    public void updateTraining(Training training) {
        trainingRepository.updateTraining(training);
    }

    public void deleteTraining(String id) {
        trainingRepository.deleteTraining(id);
    }
}
