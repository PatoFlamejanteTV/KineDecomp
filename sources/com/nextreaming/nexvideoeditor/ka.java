package com.nextreaming.nexvideoeditor;

import android.graphics.SurfaceTexture;
import android.util.Log;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: WrapperForSurfaceTextureListener.java */
/* loaded from: classes3.dex */
class ka implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f24723a;

    /* renamed from: b */
    final /* synthetic */ SynchronousQueue f24724b;

    public ka(int i, SynchronousQueue synchronousQueue) {
        this.f24723a = i;
        this.f24724b = synchronousQueue;
    }

    @Override // java.lang.Runnable
    public void run() {
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f24723a);
        while (true) {
            try {
                break;
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        if (this.f24724b.offer(surfaceTexture, 1000L, TimeUnit.MILLISECONDS)) {
            return;
        }
        surfaceTexture.release();
        Log.w("WrapperForSTL", "Surface texture abandoned");
    }
}
