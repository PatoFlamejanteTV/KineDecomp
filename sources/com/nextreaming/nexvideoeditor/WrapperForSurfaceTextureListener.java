package com.nextreaming.nexvideoeditor;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.google.protos.datapol.SemanticAnnotations;
import java.security.InvalidParameterException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class WrapperForSurfaceTextureListener implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a */
    private static int f24672a;

    /* renamed from: b */
    private static Handler f24673b;

    /* renamed from: c */
    private static HandlerThread f24674c;

    /* renamed from: e */
    private final int f24676e;

    /* renamed from: d */
    private Semaphore f24675d = new Semaphore(0);

    /* renamed from: f */
    private SurfaceTexture f24677f = null;

    public WrapperForSurfaceTextureListener(int i) {
        int i2 = f24672a + 1;
        f24672a = i2;
        this.f24676e = i2;
    }

    public static SurfaceTexture makeSurfaceTexture(int i) {
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        if (f24673b == null || f24674c == null) {
            f24674c = new HandlerThread("surfaceTextureFactory", -2);
            f24674c.start();
            f24673b = new Handler(f24674c.getLooper());
        }
        f24673b.post(new ka(i, synchronousQueue));
        SurfaceTexture surfaceTexture = null;
        while (surfaceTexture == null) {
            try {
                surfaceTexture = (SurfaceTexture) synchronousQueue.take();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        return surfaceTexture;
    }

    public void connectListener(SurfaceTexture surfaceTexture) {
        if (this.f24677f == null) {
            this.f24675d.drainPermits();
            if (Build.VERSION.SDK_INT >= 21) {
                surfaceTexture.setOnFrameAvailableListener(this, f24673b);
            } else {
                f24673b.post(new la(this, surfaceTexture));
            }
            this.f24677f = surfaceTexture;
            return;
        }
        throw new IllegalStateException();
    }

    public void disconnectListener(SurfaceTexture surfaceTexture) {
        if (surfaceTexture == this.f24677f) {
            surfaceTexture.setOnFrameAvailableListener(null);
            this.f24677f = null;
            return;
        }
        throw new InvalidParameterException();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != this.f24677f) {
            Log.w("WrapperForSTL", "[W:" + this.f24676e + "] WARNING - Frame available to wrong listener : " + surfaceTexture + " != " + String.valueOf(this.f24677f));
            return;
        }
        this.f24675d.release();
    }

    public int waitFrameAvailable(int i) {
        if (this.f24677f != null) {
            if (i < 0) {
                i = SemanticAnnotations.SemanticType.ST_AVOCADO_ID_VALUE;
            }
            Log.d("WrapperForSTL", "[W:" + this.f24676e + "] waitFrameAvailable : " + i);
            long nanoTime = System.nanoTime();
            boolean z = false;
            while (true) {
                try {
                    break;
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    z = true;
                }
            }
            boolean z2 = !this.f24675d.tryAcquire(i, TimeUnit.MILLISECONDS);
            long nanoTime2 = System.nanoTime() - nanoTime;
            if (z2) {
                Log.w("WrapperForSTL", "[W:" + this.f24676e + "] waitFrameAvailable : (elapsed=" + nanoTime2 + ") timeout=" + z2 + " interrupted=" + z);
            } else {
                Log.d("WrapperForSTL", "[W:" + this.f24676e + "] waitFrameAvailable : (elapsed=" + nanoTime2 + ") timeout=" + z2 + " interrupted=" + z);
            }
            return (z2 ? 4 : 0) | (z ? 8 : 0);
        }
        throw new IllegalStateException();
    }
}
