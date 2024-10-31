package com.mixpanel.android.viewcrawler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;

/* compiled from: FlipGesture.java */
/* loaded from: classes.dex */
class e implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private int f3089a = -1;
    private int b = 0;
    private long c = -1;
    private final float[] d = new float[3];
    private final a e;

    /* compiled from: FlipGesture.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public e(a aVar) {
        this.e = aVar;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] a2 = a(sensorEvent.values);
        int i = this.b;
        float f = (a2[0] * a2[0]) + (a2[1] * a2[1]) + (a2[2] * a2[2]);
        this.b = 0;
        if (a2[2] > 7.8f && a2[2] < 11.8f) {
            this.b = -1;
        }
        if (a2[2] < -7.8f && a2[2] > -11.8f) {
            this.b = 1;
        }
        if (f < 60.840004f || f > 139.24f) {
            this.b = 0;
        }
        if (i != this.b) {
            this.c = sensorEvent.timestamp;
        }
        long j = sensorEvent.timestamp - this.c;
        switch (this.b) {
            case -1:
                if (j > 250000000 && this.f3089a == 1) {
                    if (com.mixpanel.android.mpmetrics.m.f3036a) {
                        Log.v("MixpanelAPI.FlipGesture", "Flip gesture completed");
                    }
                    this.f3089a = 0;
                    this.e.a();
                    return;
                }
                return;
            case 0:
                if (j > 1000000000 && this.f3089a != 0) {
                    if (com.mixpanel.android.mpmetrics.m.f3036a) {
                        Log.v("MixpanelAPI.FlipGesture", "Flip gesture abandoned");
                    }
                    this.f3089a = 0;
                    return;
                }
                return;
            case 1:
                if (j > 250000000 && this.f3089a == 0) {
                    if (com.mixpanel.android.mpmetrics.m.f3036a) {
                        Log.v("MixpanelAPI.FlipGesture", "Flip gesture begun");
                    }
                    this.f3089a = 1;
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    private float[] a(float[] fArr) {
        for (int i = 0; i < 3; i++) {
            float f = this.d[i];
            this.d[i] = f + (0.7f * (fArr[i] - f));
        }
        return this.d;
    }
}
