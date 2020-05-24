package com.project.java.schoollist.recycler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.project.java.core.base.BaseViewHolder;
import com.project.java.models.SchoolDirectory;

public class SchoolListAdapter extends PagedListAdapter<SchoolDirectory, BaseViewHolder<?>> {

    protected SchoolListAdapter(@NonNull DiffUtil.ItemCallback<SchoolDirectory> diffCallback) {
        super(new DiffUtils());
    }

    @NonNull
    @Override
    public BaseViewHolder<?> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<?> holder, int position) {

    }

    class SchoolListViewHolder extends BaseViewHolder<SchoolDirectory> {
        private Context context;
        public SchoolListViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
        }

        @Override
        protected void bindView(SchoolDirectory item) {

        }
    }
}
