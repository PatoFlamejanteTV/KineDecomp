package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: Access modifiers changed from: package-private */
@zzark
/* loaded from: classes2.dex */
public final class Re implements SensorEventListener {

    /* renamed from: a */
    private final SensorManager f11802a;

    /* renamed from: c */
    private final Display f11804c;

    /* renamed from: f */
    private float[] f11807f;

    /* renamed from: g */
    private Handler f11808g;

    /* renamed from: h */
    private Te f11809h;

    /* renamed from: d */
    private final float[] f11805d = new float[9];

    /* renamed from: e */
    private final float[] f11806e = new float[9];

    /* renamed from: b */
    private final Object f11803b = new Object();

    public Re(Context context) {
        this.f11802a = (SensorManager) context.getSystemService(com.umeng.commonsdk.proguard.e.aa);
        this.f11804c = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    public final void a() {
        if (this.f11808g != null) {
            return;
        }
        Sensor defaultSensor = this.f11802a.getDefaultSensor(11);
        if (defaultSensor == null) {
            zzbbd.e("No Sensor of TYPE_ROTATION_VECTOR");
            return;
        }
        HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
        handlerThread.start();
        this.f11808g = new Handler(handlerThread.getLooper());
        if (this.f11802a.registerListener(this, defaultSensor, 0, this.f11808g)) {
            return;
        }
        zzbbd.e("SensorManager.registerListener failed.");
        b();
    }

    public final void b() {
        if (this.f11808g == null) {
            return;
        }
        this.f11802a.unregisterListener(this);
        this.f11808g.post(new Se(this));
        this.f11808g = null;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] == 0.0f && fArr[1] == 0.0f && fArr[2] == 0.0f) {
            return;
        }
        synchronized (this.f11803b) {
            if (this.f11807f == null) {
                this.f11807f = new float[9];
            }
        }
        SensorManager.getRotationMatrixFromVector(this.f11805d, fArr);
        int rotation = this.f11804c.getRotation();
        if (rotation == 1) {
            SensorManager.remapCoordinateSystem(this.f11805d, 2, 129, this.f11806e);
        } else if (rotation == 2) {
            SensorManager.remapCoordinateSystem(this.f11805d, 129, 130, this.f11806e);
        } else if (rotation != 3) {
            System.arraycopy(this.f11805d, 0, this.f11806e, 0, 9);
        } else {
            SensorManager.remapCoordinateSystem(this.f11805d, 130, 1, this.f11806e);
        }
        a(1, 3);
        a(2, 6);
        a(5, 7);
        synchronized (this.f11803b) {
            System.arraycopy(this.f11806e, 0, this.f11807f, 0, 9);
        }
        Te te = this.f11809h;
        if (te != null) {
            te.zzvu();
        }
    }

    public final void a(Te te) {
        this.f11809h = te;
    }

    public final boolean a(float[] fArr) {
        synchronized (this.f11803b) {
            if (this.f11807f == null) {
                return false;
            }
            System.arraycopy(this.f11807f, 0, fArr, 0, this.f11807f.length);
            return true;
        }
    }

    private final void a(int i, int i2) {
        float[] fArr = this.f11806e;
        float f2 = fArr[i];
        fArr[i] = fArr[i2];
        fArr[i2] = f2;
    }
}
