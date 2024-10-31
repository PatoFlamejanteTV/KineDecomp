package io.fabric.sdk.android.services.common;

import android.os.SystemClock;
import android.util.Log;

/* compiled from: TimingMetric.java */
/* loaded from: classes3.dex */
public class z {

    /* renamed from: a */
    private final String f26925a;

    /* renamed from: b */
    private final String f26926b;

    /* renamed from: c */
    private final boolean f26927c;

    /* renamed from: d */
    private long f26928d;

    /* renamed from: e */
    private long f26929e;

    public z(String str, String str2) {
        this.f26925a = str;
        this.f26926b = str2;
        this.f26927c = !Log.isLoggable(str2, 2);
    }

    private void c() {
        Log.v(this.f26926b, this.f26925a + ": " + this.f26929e + "ms");
    }

    public synchronized void a() {
        if (this.f26927c) {
            return;
        }
        this.f26928d = SystemClock.elapsedRealtime();
        this.f26929e = 0L;
    }

    public synchronized void b() {
        if (this.f26927c) {
            return;
        }
        if (this.f26929e != 0) {
            return;
        }
        this.f26929e = SystemClock.elapsedRealtime() - this.f26928d;
        c();
    }
}
