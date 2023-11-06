// Generated by view binder compiler. Do not edit!
package com.example.moneyway.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.moneyway.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityChangePlanBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton buttonToPlans;

  @NonNull
  public final EditText editPlanGoods;

  @NonNull
  public final EditText editPlanOther;

  @NonNull
  public final EditText editPlanProf;

  @NonNull
  public final EditText editPlanRest;

  @NonNull
  public final EditText editPlanServ;

  @NonNull
  public final EditText editPlanSum;

  @NonNull
  public final EditText editPlanTransitions;

  @NonNull
  public final EditText editPlanTransp;

  @NonNull
  public final Button otherRemains;

  @NonNull
  public final Button savePlanButton;

  private ActivityChangePlanBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageButton buttonToPlans, @NonNull EditText editPlanGoods,
      @NonNull EditText editPlanOther, @NonNull EditText editPlanProf,
      @NonNull EditText editPlanRest, @NonNull EditText editPlanServ, @NonNull EditText editPlanSum,
      @NonNull EditText editPlanTransitions, @NonNull EditText editPlanTransp,
      @NonNull Button otherRemains, @NonNull Button savePlanButton) {
    this.rootView = rootView;
    this.buttonToPlans = buttonToPlans;
    this.editPlanGoods = editPlanGoods;
    this.editPlanOther = editPlanOther;
    this.editPlanProf = editPlanProf;
    this.editPlanRest = editPlanRest;
    this.editPlanServ = editPlanServ;
    this.editPlanSum = editPlanSum;
    this.editPlanTransitions = editPlanTransitions;
    this.editPlanTransp = editPlanTransp;
    this.otherRemains = otherRemains;
    this.savePlanButton = savePlanButton;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityChangePlanBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityChangePlanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_change_plan, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityChangePlanBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonToPlans;
      ImageButton buttonToPlans = ViewBindings.findChildViewById(rootView, id);
      if (buttonToPlans == null) {
        break missingId;
      }

      id = R.id.editPlanGoods;
      EditText editPlanGoods = ViewBindings.findChildViewById(rootView, id);
      if (editPlanGoods == null) {
        break missingId;
      }

      id = R.id.editPlanOther;
      EditText editPlanOther = ViewBindings.findChildViewById(rootView, id);
      if (editPlanOther == null) {
        break missingId;
      }

      id = R.id.editPlanProf;
      EditText editPlanProf = ViewBindings.findChildViewById(rootView, id);
      if (editPlanProf == null) {
        break missingId;
      }

      id = R.id.editPlanRest;
      EditText editPlanRest = ViewBindings.findChildViewById(rootView, id);
      if (editPlanRest == null) {
        break missingId;
      }

      id = R.id.editPlanServ;
      EditText editPlanServ = ViewBindings.findChildViewById(rootView, id);
      if (editPlanServ == null) {
        break missingId;
      }

      id = R.id.editPlanSum;
      EditText editPlanSum = ViewBindings.findChildViewById(rootView, id);
      if (editPlanSum == null) {
        break missingId;
      }

      id = R.id.editPlanTransitions;
      EditText editPlanTransitions = ViewBindings.findChildViewById(rootView, id);
      if (editPlanTransitions == null) {
        break missingId;
      }

      id = R.id.editPlanTransp;
      EditText editPlanTransp = ViewBindings.findChildViewById(rootView, id);
      if (editPlanTransp == null) {
        break missingId;
      }

      id = R.id.otherRemains;
      Button otherRemains = ViewBindings.findChildViewById(rootView, id);
      if (otherRemains == null) {
        break missingId;
      }

      id = R.id.savePlanButton;
      Button savePlanButton = ViewBindings.findChildViewById(rootView, id);
      if (savePlanButton == null) {
        break missingId;
      }

      return new ActivityChangePlanBinding((ConstraintLayout) rootView, buttonToPlans,
          editPlanGoods, editPlanOther, editPlanProf, editPlanRest, editPlanServ, editPlanSum,
          editPlanTransitions, editPlanTransp, otherRemains, savePlanButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
