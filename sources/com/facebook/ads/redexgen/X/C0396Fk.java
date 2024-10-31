package com.facebook.ads.redexgen.X;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* renamed from: com.facebook.ads.redexgen.X.Fk, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0396Fk implements SensorEventListener {
    public C0396Fk() {
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        C0398Fm.A0D(sensorEvent.values);
        C0398Fm.A04();
    }
}
