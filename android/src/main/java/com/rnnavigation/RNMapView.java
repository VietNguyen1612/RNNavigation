// replace with your package
package com.rnnavigation;

import android.content.Context;
import android.graphics.Color;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.mapbox.mapboxsdk.maps.MapView;
import com.rnnavigation.ViewAttacherGroup;
public class RNMapView extends MapView {
  private ViewAttacherGroup attacherGroup;
  public RNMapView(Context context, ) {
    super(context);
  }

  public RNMapView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public RNMapView(Context context,@Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  private boolean contextHasBug(Context context) {
    return context == null || context.getResources() == null || context.getResources().getConfiguration() == null;
  }

  private Context getNonBuggyContext(ThemedReactContext reactContext, ReactApplicationContext appContext) {
    Context superContext = reactContext;
    if (!contextHasBug(appContext.getCurrentActivity())) {
        superContext = appContext.getCurrentActivity();
    } else if (contextHasBug(superContext)) {
        // we have the bug! let's try to find a better context to use
        if (!contextHasBug(reactContext.getCurrentActivity())) {
            superContext = reactContext.getCurrentActivity();
        } else if (!contextHasBug(reactContext.getApplicationContext())) {
            superContext = reactContext.getApplicationContext();
        }
    }
    return superContext;
  }


  public RNMapView(ThemedReactContext context, ReactApplicationContext appContext) {
    super(getNonBuggyContext(context, appContext));
    super.onCreate(null);
    super.onResume();
    super.getMapAsync(this);

    attacherGroup = new ViewAttacherGroup(context);
    LayoutParams attacherLayoutParams = new LayoutParams(0, 0);
    attacherLayoutParams.width = 0;
    attacherLayoutParams.height = 0;
    attacherLayoutParams.leftMargin = 99999999;
    attacherLayoutParams.topMargin = 99999999;
    attacherGroup.setLayoutParams(attacherLayoutParams);
    addView(attacherGroup);
  }

  @Override
  public void addView(View child) {
    super.addView(child);
  }


}