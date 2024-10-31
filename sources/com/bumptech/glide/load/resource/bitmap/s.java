package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;

/* compiled from: HardwareConfigState.java */
/* loaded from: classes.dex */
final class s {

    /* renamed from: a */
    private static final File f9040a = new File("/proc/self/fd");

    /* renamed from: b */
    private static volatile s f9041b;

    /* renamed from: c */
    private volatile int f9042c;

    /* renamed from: d */
    private volatile boolean f9043d = true;

    private s() {
    }

    public static s a() {
        if (f9041b == null) {
            synchronized (s.class) {
                if (f9041b == null) {
                    f9041b = new s();
                }
            }
        }
        return f9041b;
    }

    private synchronized boolean b() {
        int i = this.f9042c + 1;
        this.f9042c = i;
        if (i >= 50) {
            this.f9042c = 0;
            int length = f9040a.list().length;
            this.f9043d = length < 700;
            if (!this.f9043d && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit 700");
            }
        }
        return this.f9043d;
    }

    @TargetApi(26)
    public boolean a(int i, int i2, BitmapFactory.Options options, DecodeFormat decodeFormat, boolean z, boolean z2) {
        if (!z || Build.VERSION.SDK_INT < 26 || z2) {
            return false;
        }
        boolean z3 = i >= 128 && i2 >= 128 && b();
        if (z3) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return z3;
    }
}
