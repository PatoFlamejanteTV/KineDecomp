package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@zzark
@TargetApi(14)
/* loaded from: classes2.dex */
public final class zzbdx extends Thread implements SurfaceTexture.OnFrameAvailableListener, Te {
    private static final float[] zzesl = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private final float[] zzesi;
    private final Re zzesm;
    private final float[] zzesn;
    private final float[] zzeso;
    private final float[] zzesp;
    private final float[] zzesq;
    private final float[] zzesr;
    private final float[] zzess;
    private float zzest;
    private float zzesu;
    private float zzesv;
    private SurfaceTexture zzesw;
    private SurfaceTexture zzesx;
    private int zzesy;
    private int zzesz;
    private int zzeta;
    private FloatBuffer zzetb;
    private final CountDownLatch zzetc;
    private final Object zzetd;
    private EGL10 zzete;
    private EGLDisplay zzetf;
    private EGLContext zzetg;
    private EGLSurface zzeth;
    private volatile boolean zzeti;
    private volatile boolean zzetj;
    private int zzvt;
    private int zzvu;

    public zzbdx(Context context) {
        super("SphericalVideoProcessor");
        this.zzetb = ByteBuffer.allocateDirect(zzesl.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.zzetb.put(zzesl).position(0);
        this.zzesi = new float[9];
        this.zzesn = new float[9];
        this.zzeso = new float[9];
        this.zzesp = new float[9];
        this.zzesq = new float[9];
        this.zzesr = new float[9];
        this.zzess = new float[9];
        this.zzest = Float.NaN;
        this.zzesm = new Re(context);
        this.zzesm.a(this);
        this.zzetc = new CountDownLatch(1);
        this.zzetd = new Object();
    }

    @VisibleForTesting
    private final boolean zzabs() {
        EGLSurface eGLSurface;
        EGLSurface eGLSurface2 = this.zzeth;
        boolean z = false;
        if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
            z = this.zzete.eglDestroySurface(this.zzetf, this.zzeth) | this.zzete.eglMakeCurrent(this.zzetf, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT) | false;
            this.zzeth = null;
        }
        EGLContext eGLContext = this.zzetg;
        if (eGLContext != null) {
            z |= this.zzete.eglDestroyContext(this.zzetf, eGLContext);
            this.zzetg = null;
        }
        EGLDisplay eGLDisplay = this.zzetf;
        if (eGLDisplay == null) {
            return z;
        }
        boolean eglTerminate = z | this.zzete.eglTerminate(eGLDisplay);
        this.zzetf = null;
        return eglTerminate;
    }

    private static int zze(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        zzes("createShader");
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        zzes("shaderSource");
        GLES20.glCompileShader(glCreateShader);
        zzes("compileShader");
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        zzes("getShaderiv");
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Could not compile shader ");
        sb.append(i);
        sb.append(":");
        Log.e("SphericalVideoRenderer", sb.toString());
        Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        zzes("deleteShader");
        return 0;
    }

    private static void zzes(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21);
            sb.append(str);
            sb.append(": glError ");
            sb.append(glGetError);
            Log.e("SphericalVideoRenderer", sb.toString());
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzeta++;
        synchronized (this.zzetd) {
            this.zzetd.notifyAll();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01db A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00be  */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 1040
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdx.run():void");
    }

    public final void zza(SurfaceTexture surfaceTexture, int i, int i2) {
        this.zzvt = i;
        this.zzvu = i2;
        this.zzesx = surfaceTexture;
    }

    public final void zzabq() {
        synchronized (this.zzetd) {
            this.zzetj = true;
            this.zzesx = null;
            this.zzetd.notifyAll();
        }
    }

    public final SurfaceTexture zzabr() {
        if (this.zzesx == null) {
            return null;
        }
        try {
            this.zzetc.await();
        } catch (InterruptedException unused) {
        }
        return this.zzesw;
    }

    public final void zzb(float f2, float f3) {
        float f4;
        float f5;
        float f6;
        int i = this.zzvt;
        int i2 = this.zzvu;
        if (i > i2) {
            f4 = (f2 * 1.7453293f) / i;
            f5 = f3 * 1.7453293f;
            f6 = i;
        } else {
            f4 = (f2 * 1.7453293f) / i2;
            f5 = f3 * 1.7453293f;
            f6 = i2;
        }
        this.zzesu -= f4;
        this.zzesv -= f5 / f6;
        if (this.zzesv < -1.5707964f) {
            this.zzesv = -1.5707964f;
        }
        if (this.zzesv > 1.5707964f) {
            this.zzesv = 1.5707964f;
        }
    }

    public final void zzo(int i, int i2) {
        synchronized (this.zzetd) {
            this.zzvt = i;
            this.zzvu = i2;
            this.zzeti = true;
            this.zzetd.notifyAll();
        }
    }

    @Override // com.google.android.gms.internal.ads.Te
    public final void zzvu() {
        synchronized (this.zzetd) {
            this.zzetd.notifyAll();
        }
    }

    private static void zza(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3]) + (fArr2[2] * fArr3[6]);
        fArr[1] = (fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4]) + (fArr2[2] * fArr3[7]);
        fArr[2] = (fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5]) + (fArr2[2] * fArr3[8]);
        fArr[3] = (fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3]) + (fArr2[5] * fArr3[6]);
        fArr[4] = (fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4]) + (fArr2[5] * fArr3[7]);
        fArr[5] = (fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5]) + (fArr2[5] * fArr3[8]);
        fArr[6] = (fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3]) + (fArr2[8] * fArr3[6]);
        fArr[7] = (fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4]) + (fArr2[8] * fArr3[7]);
        fArr[8] = (fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5]) + (fArr2[8] * fArr3[8]);
    }

    private static void zzb(float[] fArr, float f2) {
        double d2 = f2;
        fArr[0] = (float) Math.cos(d2);
        fArr[1] = (float) (-Math.sin(d2));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d2);
        fArr[4] = (float) Math.cos(d2);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static void zza(float[] fArr, float f2) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d2 = f2;
        fArr[4] = (float) Math.cos(d2);
        fArr[5] = (float) (-Math.sin(d2));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d2);
        fArr[8] = (float) Math.cos(d2);
    }
}
