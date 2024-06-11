package com.example.workoutmanager.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.workoutmanager.R;
import com.example.workoutmanager.model.Training;
import com.google.android.material.textview.MaterialTextView;
import java.util.List;

public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder> {
    private List<Training> trainings;

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TrainingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_training, parent, false);
        return new TrainingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingViewHolder holder, int position) {
        Training training = trainings.get(position);
        holder.textViewName.setText(training.getName());
        holder.textViewDescription.setText(training.getDescription());
        holder.textViewDate.setText(training.getDate().toString());
    }

    @Override
    public int getItemCount() {
        return trainings == null ? 0 : trainings.size();
    }

    static class TrainingViewHolder extends RecyclerView.ViewHolder {
        MaterialTextView textViewName;
        MaterialTextView textViewDescription;
        MaterialTextView textViewDate;

        TrainingViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewTrainingName);
            textViewDescription = itemView.findViewById(R.id.textViewTrainingDescription);
            textViewDate = itemView.findViewById(R.id.textViewTrainingDate);
        }
    }
}
