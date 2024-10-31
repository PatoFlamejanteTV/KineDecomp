package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* loaded from: assets/audience_network.dex */
public final class AV implements SensorEventListener {
    public final SensorEventListener A00;

    public AV(SensorEventListener sensorEventListener) {
        this.A00 = sensorEventListener;
    }

    @Override // android.hardware.SensorEventListener
    @SuppressLint({"CatchGeneralException"})
    public final void onAccuracyChanged(Sensor sensor, int i) {
        try {
            this.A00.onAccuracyChanged(sensor, i);
        } catch (Throwable th) {
            AK.A03(th);
        }
    }

    @Override // android.hardware.SensorEventListener
    @SuppressLint({"CatchGeneralException"})
    public final void onSensorChanged(SensorEvent sensorEvent) {
        try {
            this.A00.onSensorChanged(sensorEvent);
        } catch (Throwable th) {
            AK.A03(th);
        }
    }
}
