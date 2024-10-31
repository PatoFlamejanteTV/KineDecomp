package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

/* loaded from: classes2.dex */
public final class Tl extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {

    /* renamed from: a */
    private final int[] f11859a;

    /* renamed from: b */
    private Handler f11860b;

    /* renamed from: c */
    private SurfaceTexture f11861c;

    /* renamed from: d */
    private Error f11862d;

    /* renamed from: e */
    private RuntimeException f11863e;

    /* renamed from: f */
    private zzqk f11864f;

    public Tl() {
        super("dummySurface");
        this.f11859a = new int[1];
    }

    public final zzqk a(boolean z) {
        boolean z2;
        start();
        this.f11860b = new Handler(getLooper(), this);
        synchronized (this) {
            z2 = false;
            this.f11860b.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
            while (this.f11864f == null && this.f11863e == null && this.f11862d == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.f11863e;
        if (runtimeException == null) {
            Error error = this.f11862d;
            if (error == null) {
                return this.f11864f;
            }
            throw error;
        }
        throw runtimeException;
    }

    public final void b() {
        this.f11860b.sendEmptyMessage(3);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int[] iArr;
        int[] iArr2;
        int i = message.what;
        try {
            if (i != 1) {
                if (i != 2) {
                    try {
                    } catch (Throwable th) {
                        Log.e("DummySurface", "Failed to release dummy surface", th);
                    } finally {
                        quit();
                    }
                    if (i != 3) {
                        return true;
                    }
                    try {
                        this.f11861c.release();
                        return true;
                    } finally {
                        this.f11864f = null;
                        this.f11861c = null;
                        GLES20.glDeleteTextures(1, this.f11859a, 0);
                    }
                }
                this.f11861c.updateTexImage();
                return true;
            }
            try {
                boolean z = message.arg1 != 0;
                EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                zzpo.checkState(eglGetDisplay != null, "eglGetDisplay failed");
                int[] iArr3 = new int[2];
                zzpo.checkState(EGL14.eglInitialize(eglGetDisplay, iArr3, 0, iArr3, 1), "eglInitialize failed");
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                int[] iArr4 = new int[1];
                zzpo.checkState(EGL14.eglChooseConfig(eglGetDisplay, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr4, 0) && iArr4[0] > 0 && eGLConfigArr[0] != null, "eglChooseConfig failed");
                EGLConfig eGLConfig = eGLConfigArr[0];
                if (z) {
                    iArr = new int[]{12440, 2, 12992, 1, 12344};
                } else {
                    iArr = new int[]{12440, 2, 12344};
                }
                EGLContext eglCreateContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr, 0);
                zzpo.checkState(eglCreateContext != null, "eglCreateContext failed");
                if (z) {
                    iArr2 = new int[]{12375, 1, 12374, 1, 12992, 1, 12344};
                } else {
                    iArr2 = new int[]{12375, 1, 12374, 1, 12344};
                }
                EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, iArr2, 0);
                zzpo.checkState(eglCreatePbufferSurface != null, "eglCreatePbufferSurface failed");
                zzpo.checkState(EGL14.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext), "eglMakeCurrent failed");
                GLES20.glGenTextures(1, this.f11859a, 0);
                this.f11861c = new SurfaceTexture(this.f11859a[0]);
                this.f11861c.setOnFrameAvailableListener(this);
                this.f11864f = new zzqk(this, this.f11861c, z);
                synchronized (this) {
                    notify();
                }
            } catch (Error e2) {
                Log.e("DummySurface", "Failed to initialize dummy surface", e2);
                this.f11862d = e2;
                synchronized (this) {
                    notify();
                }
            } catch (RuntimeException e3) {
                Log.e("DummySurface", "Failed to initialize dummy surface", e3);
                this.f11863e = e3;
                synchronized (this) {
                    notify();
                }
            }
            return true;
        } catch (Throwable th2) {
            synchronized (this) {
                notify();
                throw th2;
            }
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f11860b.sendEmptyMessage(2);
    }
}
