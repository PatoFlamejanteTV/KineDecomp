package com.facebook.marketing;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* loaded from: classes.dex */
public class ViewIndexingTrigger implements SensorEventListener {
    private static final int SHAKE_COUNT_RESET_TIME_MS = 3000;
    private static final int SHAKE_SLOP_TIME_MS = 500;
    private static final double SHAKE_THRESHOLD_GRAVITY = 2.700000047683716d;
    private OnShakeListener mListener;
    private int mShakeCount;
    private long mShakeTimestamp;

    /* loaded from: classes.dex */
    public interface OnShakeListener {
        void onShake(int i);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (this.mListener != null) {
            float[] fArr = sensorEvent.values;
            double d2 = fArr[0] / 9.80665f;
            double d3 = fArr[1] / 9.80665f;
            double d4 = fArr[2] / 9.80665f;
            Double.isNaN(d2);
            Double.isNaN(d2);
            Double.isNaN(d3);
            Double.isNaN(d3);
            Double.isNaN(d4);
            Double.isNaN(d4);
            if (Math.sqrt((d2 * d2) + (d3 * d3) + (d4 * d4)) > SHAKE_THRESHOLD_GRAVITY) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = this.mShakeTimestamp;
                if (500 + j > currentTimeMillis) {
                    return;
                }
                if (j + 3000 < currentTimeMillis) {
                    this.mShakeCount = 0;
                }
                this.mShakeTimestamp = currentTimeMillis;
                this.mShakeCount++;
                this.mListener.onShake(this.mShakeCount);
            }
        }
    }

    public void resetCount() {
        this.mShakeCount = 0;
    }

    public void setOnShakeListener(OnShakeListener onShakeListener) {
        this.mListener = onShakeListener;
    }
}
