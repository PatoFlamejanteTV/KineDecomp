package com.nextreaming.nexvideoeditor;

import android.graphics.SurfaceTexture;
import android.util.Log;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: WrapperForSurfaceTextureListener.java */
/* loaded from: classes.dex */
final class as implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4825a;
    final /* synthetic */ SynchronousQueue b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(int i, SynchronousQueue synchronousQueue) {
        this.f4825a = i;
        this.b = synchronousQueue;
    }

    @Override // java.lang.Runnable
    public void run() {
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f4825a);
        while (true) {
            try {
                break;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        if (!this.b.offer(surfaceTexture, 1000L, TimeUnit.MILLISECONDS)) {
            surfaceTexture.release();
            Log.w("WrapperForSTL", "Surface texture abandoned");
        }
    }
}
