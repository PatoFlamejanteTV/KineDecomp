package com.nextreaming.nexvideoeditor;

import android.util.Log;
import android.view.Surface;

/* loaded from: classes.dex */
public class NexThemeRenderer {

    /* renamed from: a, reason: collision with root package name */
    private long f4803a = 0;

    public native int aquireContext();

    public native void clearClipEffect();

    public native void clearSurface(int i);

    public native void clearTransitionEffect();

    public native void deinit(boolean z);

    public native void init(NexImageLoader nexImageLoader);

    public native void loadThemes(String str);

    public native void prepareSurface(Surface surface);

    public native void recycleRenderer();

    public native int releaseContext(boolean z);

    public native void render();

    public native void setCTS(int i);

    public native void setClipEffect(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6);

    public native void setPlaceholders(String str, String str2);

    public native void setTransitionEffect(String str, String str2, int i, int i2, int i3, int i4);

    public native void surfaceChange(int i, int i2);

    public void a(String str) {
        loadThemes(str);
    }

    void setThemeInstanceHandle(long j) {
        this.f4803a = j;
    }

    long getThemeInstanceHandle() {
        return this.f4803a;
    }

    static {
        try {
            System.loadLibrary("stlport_shared");
            System.loadLibrary("nexeditorsdk");
        } catch (UnsatisfiedLinkError e) {
            Log.e("NexThemeRenderer", "[NexThemeRenderer.java] nexeditor load failed : " + e);
        }
    }
}
