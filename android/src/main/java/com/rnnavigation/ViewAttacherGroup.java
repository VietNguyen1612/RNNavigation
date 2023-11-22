package com.rnnavigation;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.facebook.react.views.view.ReactViewGroup;

public class ViewAttacherGroup extends ReactViewGroup {
    public ViewAttacherGroup(Context context) {
        super(context);
        setWillNotDraw(true);
        setVisibility(View.VISIBLE);
        setAlpha(0.0f);
        setRemoveClippedSubviews(false);
        setClipBounds(new Rect(0, 0, 0, 0));
        setOverflow("hidden");
    }

    @Override
    public boolean hasOverlappingRendering() {
        return false;
    }
}
