package com.example.workoutmanager.model;

public class Exercise {
    private String id;
    private String name;
    private String imageUrl;
    private String observations;

    public Exercise() {

    }

    public Exercise(String id, String name, String imageUrl, String observations) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.observations = observations;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
