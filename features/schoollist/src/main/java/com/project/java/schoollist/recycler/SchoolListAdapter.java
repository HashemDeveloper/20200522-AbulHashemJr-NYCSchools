package com.project.java.schoollist.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.paging.PagedListAdapter;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.project.java.core.base.BaseViewHolder;
import com.project.java.core.utils.Constants;
import com.project.java.core.utils.GlideApp;
import com.project.java.models.SchoolDirectory;
import com.project.java.schoollist.R;

import uk.co.deanwild.flowtextview.FlowTextView;

public class SchoolListAdapter extends PagedListAdapter<SchoolDirectory, BaseViewHolder<?>> {
    private String mapApiKey;
    private int zoomSize;
    private String imageSize;
    private SchoolListItemClickListener listener;

    public SchoolListAdapter(int zoomSize, String imageSize, String mapApiKey, SchoolListItemClickListener listener) {
        super(new DiffUtils());
        this.imageSize = imageSize;
        this.zoomSize = zoomSize;
        this.mapApiKey = mapApiKey;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BaseViewHolder<?> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_school_list_recycler_item_layout, parent, false);
        SchoolListViewHolder schoolListViewHolder = new SchoolListViewHolder(view, parent.getContext(), this.zoomSize, this.imageSize, this.mapApiKey);
        schoolListViewHolder.getWebsiteBt().setOnClickListener(view1 -> {
            SchoolDirectory schoolDirectory = (SchoolDirectory) schoolListViewHolder.itemView.getTag();
            this.listener.onItemClicked(ItemClickType.WEBSITE, schoolDirectory.getWebsite() != null ? schoolDirectory.getWebsite() : "");
        });
        schoolListViewHolder.getDirectionBt().setOnClickListener(view2 -> {
            SchoolDirectory schoolDirectory = (SchoolDirectory) schoolListViewHolder.itemView.getTag();
            String destination = schoolDirectory.getLatitude() + "," + schoolDirectory.getLongitude();
            this.listener.onItemClicked(ItemClickType.DIRECTION, destination);
        });
        return schoolListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<?> holder, int position) {
        SchoolDirectory schoolDirectory = getItem(position);
        ((SchoolListViewHolder) holder).bindView(schoolDirectory);
    }

    static class SchoolListViewHolder extends BaseViewHolder<SchoolDirectory> {
        private String mapApiKey;
        private int zoomSize;
        private String imageSize;
        private Context context;
        private MaterialTextView titleView;
        private FlowTextView overviewTextView;
        private MaterialButton websiteBt;
        private MaterialButton directionBt;
        private AppCompatImageView addressSnapShotView;

        SchoolListViewHolder(@NonNull View itemView, Context context, int zoomSize, String imageSize, String mapApiKey) {
            super(itemView);
            this.context = context;
            this.titleView = itemView.findViewById(R.id.fragment_school_list_school_title_id);
            this.overviewTextView = itemView.findViewById(R.id.fragment_school_list_overview_text_view_id);
            this.websiteBt = itemView.findViewById(R.id.fragment_school_list_website_bt_id);
            this.directionBt = itemView.findViewById(R.id.fragment_school_list_direction_bt_id);
            this.addressSnapShotView = itemView.findViewById(R.id.fragment_school_list_map_view_id);
            this.zoomSize = zoomSize;
            this.imageSize = imageSize;
            this.mapApiKey = mapApiKey;
        }

        @Override
        protected void bindView(SchoolDirectory item) {
            this.itemView.setTag(item);
            if (item != null) {
                String title = item.getSchoolName() != null ? item.getSchoolName() : "";
                String overView = item.getOverviewParagraph() != null ? item.getOverviewParagraph() : item.getEllPrograms();
                if (this.titleView != null) {
                    this.titleView.setText(title);
                }
                if (this.overviewTextView != null) {
                    this.overviewTextView.setText(overView);
                }
                String snapShotMapUrl = "https://maps.googleapis.com/maps/api/staticmap?center=" + item.getLatitude() + ","
                        + item.getLongitude() + "&zoom=" + this.zoomSize + "&size=" + this.imageSize + "&key=" + this.mapApiKey;
                CircularProgressDrawable circularProgressDrawable = Constants.Companion.glideCircularAnim(this.context);
                GlideApp.with(this.itemView).load(snapShotMapUrl)
                        .placeholder(circularProgressDrawable)
                        .into(this.addressSnapShotView);
            }
        }

        public MaterialButton getWebsiteBt() {
            return this.websiteBt;
        }
        public MaterialButton getDirectionBt() {
            return this.directionBt;
        }
    }
    public interface SchoolListItemClickListener {
        <T> void onItemClicked(ItemClickType type, T data);
    }

    public enum ItemClickType {
        WEBSITE,
        DIRECTION
    }
}
