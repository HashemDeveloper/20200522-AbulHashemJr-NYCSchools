// Generated by view binder compiler. Do not edit!
package com.project.java.schoollist.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;
import com.project.java.schoollist.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import uk.co.deanwild.flowtextview.FlowTextView;

public final class FragmentSchoolListRecyclerItemLayoutBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Guideline bottomGuideLine;

  @NonNull
  public final Guideline centerGuideLine;

  @NonNull
  public final ConstraintLayout fragmentSchoolListContentContainerId;

  @NonNull
  public final MaterialButton fragmentSchoolListDirectionBtId;

  @NonNull
  public final MaterialCardView fragmentSchoolListItemCardViewId;

  @NonNull
  public final AppCompatImageView fragmentSchoolListMapViewId;

  @NonNull
  public final FlowTextView fragmentSchoolListOverviewTextViewId;

  @NonNull
  public final MaterialTextView fragmentSchoolListSchoolTitleId;

  @NonNull
  public final MaterialButton fragmentSchoolListWebsiteBtId;

  @NonNull
  public final Guideline leftGuideLiine;

  @NonNull
  public final Barrier overViewBarrier;

  @NonNull
  public final Guideline overviewGuideLine;

  @NonNull
  public final Guideline rightGuideLine;

  @NonNull
  public final Guideline titleGuideLine;

  @NonNull
  public final Guideline topGuideLine;

  private FragmentSchoolListRecyclerItemLayoutBinding(@NonNull ConstraintLayout rootView,
      @NonNull Guideline bottomGuideLine, @NonNull Guideline centerGuideLine,
      @NonNull ConstraintLayout fragmentSchoolListContentContainerId,
      @NonNull MaterialButton fragmentSchoolListDirectionBtId,
      @NonNull MaterialCardView fragmentSchoolListItemCardViewId,
      @NonNull AppCompatImageView fragmentSchoolListMapViewId,
      @NonNull FlowTextView fragmentSchoolListOverviewTextViewId,
      @NonNull MaterialTextView fragmentSchoolListSchoolTitleId,
      @NonNull MaterialButton fragmentSchoolListWebsiteBtId, @NonNull Guideline leftGuideLiine,
      @NonNull Barrier overViewBarrier, @NonNull Guideline overviewGuideLine,
      @NonNull Guideline rightGuideLine, @NonNull Guideline titleGuideLine,
      @NonNull Guideline topGuideLine) {
    this.rootView = rootView;
    this.bottomGuideLine = bottomGuideLine;
    this.centerGuideLine = centerGuideLine;
    this.fragmentSchoolListContentContainerId = fragmentSchoolListContentContainerId;
    this.fragmentSchoolListDirectionBtId = fragmentSchoolListDirectionBtId;
    this.fragmentSchoolListItemCardViewId = fragmentSchoolListItemCardViewId;
    this.fragmentSchoolListMapViewId = fragmentSchoolListMapViewId;
    this.fragmentSchoolListOverviewTextViewId = fragmentSchoolListOverviewTextViewId;
    this.fragmentSchoolListSchoolTitleId = fragmentSchoolListSchoolTitleId;
    this.fragmentSchoolListWebsiteBtId = fragmentSchoolListWebsiteBtId;
    this.leftGuideLiine = leftGuideLiine;
    this.overViewBarrier = overViewBarrier;
    this.overviewGuideLine = overviewGuideLine;
    this.rightGuideLine = rightGuideLine;
    this.titleGuideLine = titleGuideLine;
    this.topGuideLine = topGuideLine;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSchoolListRecyclerItemLayoutBinding inflate(
      @NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSchoolListRecyclerItemLayoutBinding inflate(
      @NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_school_list_recycler_item_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSchoolListRecyclerItemLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    String missingId;
    missingId: {
      Guideline bottomGuideLine = rootView.findViewById(R.id.bottomGuideLine);
      if (bottomGuideLine == null) {
        missingId = "bottomGuideLine";
        break missingId;
      }
      Guideline centerGuideLine = rootView.findViewById(R.id.centerGuideLine);
      if (centerGuideLine == null) {
        missingId = "centerGuideLine";
        break missingId;
      }
      ConstraintLayout fragmentSchoolListContentContainerId = rootView.findViewById(R.id.fragment_school_list_content_container_id);
      if (fragmentSchoolListContentContainerId == null) {
        missingId = "fragmentSchoolListContentContainerId";
        break missingId;
      }
      MaterialButton fragmentSchoolListDirectionBtId = rootView.findViewById(R.id.fragment_school_list_direction_bt_id);
      if (fragmentSchoolListDirectionBtId == null) {
        missingId = "fragmentSchoolListDirectionBtId";
        break missingId;
      }
      MaterialCardView fragmentSchoolListItemCardViewId = rootView.findViewById(R.id.fragment_school_list_item_card_view_id);
      if (fragmentSchoolListItemCardViewId == null) {
        missingId = "fragmentSchoolListItemCardViewId";
        break missingId;
      }
      AppCompatImageView fragmentSchoolListMapViewId = rootView.findViewById(R.id.fragment_school_list_map_view_id);
      if (fragmentSchoolListMapViewId == null) {
        missingId = "fragmentSchoolListMapViewId";
        break missingId;
      }
      FlowTextView fragmentSchoolListOverviewTextViewId = rootView.findViewById(R.id.fragment_school_list_overview_text_view_id);
      if (fragmentSchoolListOverviewTextViewId == null) {
        missingId = "fragmentSchoolListOverviewTextViewId";
        break missingId;
      }
      MaterialTextView fragmentSchoolListSchoolTitleId = rootView.findViewById(R.id.fragment_school_list_school_title_id);
      if (fragmentSchoolListSchoolTitleId == null) {
        missingId = "fragmentSchoolListSchoolTitleId";
        break missingId;
      }
      MaterialButton fragmentSchoolListWebsiteBtId = rootView.findViewById(R.id.fragment_school_list_website_bt_id);
      if (fragmentSchoolListWebsiteBtId == null) {
        missingId = "fragmentSchoolListWebsiteBtId";
        break missingId;
      }
      Guideline leftGuideLiine = rootView.findViewById(R.id.leftGuideLiine);
      if (leftGuideLiine == null) {
        missingId = "leftGuideLiine";
        break missingId;
      }
      Barrier overViewBarrier = rootView.findViewById(R.id.overViewBarrier);
      if (overViewBarrier == null) {
        missingId = "overViewBarrier";
        break missingId;
      }
      Guideline overviewGuideLine = rootView.findViewById(R.id.overviewGuideLine);
      if (overviewGuideLine == null) {
        missingId = "overviewGuideLine";
        break missingId;
      }
      Guideline rightGuideLine = rootView.findViewById(R.id.rightGuideLine);
      if (rightGuideLine == null) {
        missingId = "rightGuideLine";
        break missingId;
      }
      Guideline titleGuideLine = rootView.findViewById(R.id.titleGuideLine);
      if (titleGuideLine == null) {
        missingId = "titleGuideLine";
        break missingId;
      }
      Guideline topGuideLine = rootView.findViewById(R.id.topGuideLine);
      if (topGuideLine == null) {
        missingId = "topGuideLine";
        break missingId;
      }
      return new FragmentSchoolListRecyclerItemLayoutBinding((ConstraintLayout) rootView,
          bottomGuideLine, centerGuideLine, fragmentSchoolListContentContainerId,
          fragmentSchoolListDirectionBtId, fragmentSchoolListItemCardViewId,
          fragmentSchoolListMapViewId, fragmentSchoolListOverviewTextViewId,
          fragmentSchoolListSchoolTitleId, fragmentSchoolListWebsiteBtId, leftGuideLiine,
          overViewBarrier, overviewGuideLine, rightGuideLine, titleGuideLine, topGuideLine);
    }
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
