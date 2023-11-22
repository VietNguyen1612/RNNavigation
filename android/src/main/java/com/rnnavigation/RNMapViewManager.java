package com.rnnavigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNNavigationManagerInterface;
import com.facebook.react.viewmanagers.RNNavigationTextManagerDelegate;

@ReactModule(name = RNMapViewManager.NAME)
public class RNMapViewManager extends ViewGroupManager<RNMapView>
        implements RNNavigationManagerInterface<RNMapView> {

    private final ViewManagerDelegate<RNMapView> mDelegate;

    static final String NAME = "RNNavigation";

    public RNMapViewManager(ReactApplicationContext context) {
        mDelegate = new RNNavigationTextManagerDelegate<>(this);
    }

    @Nullable
    @Override
    protected ViewManagerDelegate<RNMapView> getDelegate() {
        return mDelegate;
    }

    @NonNull
    @Override
    public String getName() {
        return RNMapViewManager.NAME;
    }

    @NonNull
    @Override
    protected RNMapFragment createViewInstance(@NonNull ThemedReactContext context) {
        return new RNMapViews(context);
    }
}