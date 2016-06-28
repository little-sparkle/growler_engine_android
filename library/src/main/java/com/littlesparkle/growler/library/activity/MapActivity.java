package com.littlesparkle.growler.library.activity;

import android.os.Bundle;

import com.amap.api.maps2d.MapView;

public abstract class MapActivity extends HandlerActivity {

    protected MapView mMapView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // init map
        mMapView = (MapView) findViewById(getMapViewId());
        mMapView.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    protected abstract int getMapViewId();
}
