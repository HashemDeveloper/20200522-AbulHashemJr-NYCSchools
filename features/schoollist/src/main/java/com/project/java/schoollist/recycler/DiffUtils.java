package com.project.java.schoollist.recycler;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.project.java.models.SchoolDirectory;

public class DiffUtils extends DiffUtil.ItemCallback<SchoolDirectory> {
    @Override
    public boolean areItemsTheSame(@NonNull SchoolDirectory oldItem, @NonNull SchoolDirectory newItem) {
        int oldId = Integer.parseInt(oldItem.getDbn());
        int newId = Integer.parseInt(newItem.getDbn());
        return oldId == newId;
    }

    @Override
    public boolean areContentsTheSame(@NonNull SchoolDirectory oldItem, @NonNull SchoolDirectory newItem) {
        return oldItem.equals(newItem);
    }
}
