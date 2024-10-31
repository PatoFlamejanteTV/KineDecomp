package com.google.android.gms.vision.face.internal.client;

import android.os.RemoteException;
import android.util.Log;

/* loaded from: classes.dex */
public class zzg {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2274a;
    private zzc b;

    public void a() {
        synchronized (this.f2274a) {
            if (this.b == null) {
                return;
            }
            try {
                this.b.a();
            } catch (RemoteException e) {
                Log.e("FaceDetectorHandle", "Could not finalize native face detector", e);
            }
        }
    }
}
