package com.google.android.gms.vision.face;

import android.util.Log;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.face.internal.client.zzg;
import com.google.android.gms.vision.zza;

/* loaded from: classes.dex */
public final class FaceDetector extends Detector<Face> {
    private final zzg b;

    /* renamed from: a, reason: collision with root package name */
    private final zza f2270a = new zza();
    private final Object c = new Object();
    private boolean d = true;

    /* loaded from: classes.dex */
    public static class Builder {
    }

    private FaceDetector() {
        throw new IllegalStateException("Default constructor called");
    }

    @Override // com.google.android.gms.vision.Detector
    public void a() {
        synchronized (this.c) {
            if (this.d) {
                this.b.a();
                this.d = false;
            }
        }
    }

    protected void finalize() throws Throwable {
        try {
            synchronized (this.c) {
                if (this.d) {
                    Log.w("FaceDetector", "FaceDetector was not released with FaceDetector.release()");
                    a();
                }
            }
        } finally {
            super.finalize();
        }
    }
}
