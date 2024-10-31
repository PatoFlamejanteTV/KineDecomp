package com.nextreaming.nexvideoeditor;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import java.security.InvalidParameterException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class WrapperForSurfaceTextureListener implements SurfaceTexture.OnFrameAvailableListener {
    private static int c = 0;
    private static Handler e = null;
    private static HandlerThread f = null;
    private final int b;

    /* renamed from: a, reason: collision with root package name */
    private Semaphore f4807a = new Semaphore(0);
    private SurfaceTexture d = null;

    public static SurfaceTexture makeSurfaceTexture(int i) {
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        if (e == null || f == null) {
            f = new HandlerThread("surfaceTextureFactory", -2);
            f.start();
            e = new Handler(f.getLooper());
        }
        e.post(new as(i, synchronousQueue));
        SurfaceTexture surfaceTexture = null;
        while (surfaceTexture == null) {
            try {
                surfaceTexture = (SurfaceTexture) synchronousQueue.take();
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
            }
        }
        return surfaceTexture;
    }

    public WrapperForSurfaceTextureListener(int i) {
        int i2 = c + 1;
        c = i2;
        this.b = i2;
    }

    public void connectListener(SurfaceTexture surfaceTexture) {
        if (this.d != null) {
            throw new IllegalStateException();
        }
        this.f4807a.drainPermits();
        if (Build.VERSION.SDK_INT >= 21) {
            surfaceTexture.setOnFrameAvailableListener(this, e);
        } else {
            e.post(new at(this, surfaceTexture));
        }
        this.d = surfaceTexture;
    }

    public void disconnectListener(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != this.d) {
            throw new InvalidParameterException();
        }
        surfaceTexture.setOnFrameAvailableListener(null);
        this.d = null;
    }

    public int waitFrameAvailable(int i) {
        if (this.d == null) {
            throw new IllegalStateException();
        }
        if (i < 0) {
            i = 2500;
        }
        Log.d("WrapperForSTL", "[W:" + this.b + "] waitFrameAvailable : " + i);
        long nanoTime = System.nanoTime();
        boolean z = false;
        while (true) {
            try {
                break;
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                z = true;
            }
        }
        boolean z2 = this.f4807a.tryAcquire((long) i, TimeUnit.MILLISECONDS) ? false : true;
        long nanoTime2 = System.nanoTime() - nanoTime;
        if (z2) {
            Log.w("WrapperForSTL", "[W:" + this.b + "] waitFrameAvailable : (elapsed=" + nanoTime2 + ") timeout=" + z2 + " interrupted=" + z);
        } else {
            Log.d("WrapperForSTL", "[W:" + this.b + "] waitFrameAvailable : (elapsed=" + nanoTime2 + ") timeout=" + z2 + " interrupted=" + z);
        }
        return (z2 ? 4 : 0) | (z ? 8 : 0);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != this.d) {
            Log.w("WrapperForSTL", "[W:" + this.b + "] WARNING - Frame available to wrong listener : " + surfaceTexture + " != " + String.valueOf(this.d));
        } else {
            this.f4807a.release();
        }
    }
}
