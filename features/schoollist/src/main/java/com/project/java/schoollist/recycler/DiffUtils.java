package com.project.java.schoollist.recycler;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.project.java.models.SchoolDirectory;

public class DiffUtils extends DiffUtil.ItemCallback<SchoolDirectory> {
    @Override
    public boolean areItemsTheSame(@NonNull SchoolDirectory oldItem, @NonNull SchoolDirectory newItem) {
        return oldItem.getDbn().equals(newItem.getDbn());
    }

    @Override
    public boolean areContentsTheSame(@NonNull SchoolDirectory oldItem, @NonNull SchoolDirectory newItem) {
        return oldItem.equals(newItem);
    }
}
