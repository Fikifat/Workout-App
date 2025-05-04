package com.example.workoutapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.workoutapp.Domain.Workout;
import com.example.workoutapp.databinding.ViewholderWorkoutBinding;

import java.util.ArrayList;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.Viewholder> {
    private final ArrayList<Workout> list;
    private Context context;

    public WorkoutAdapter(ArrayList<Workout> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public WorkoutAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ViewholderWorkoutBinding binding = ViewholderWorkoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutAdapter.Viewholder holder, int position) {

        holder.binding.titleTxt.setText(list.get(position).getTitle());
        int resId=context.getResources().getIdentifier(list.get(position).getPicPath(),"drawable",context.getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(resId)
                .into(holder.binding.pic);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ViewholderWorkoutBinding binding;

        public Viewholder(ViewholderWorkoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
