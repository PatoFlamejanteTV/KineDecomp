package com.google.android.gms.cast.internal;

import android.os.SystemClock;

/* loaded from: classes.dex */
public final class zzp {
    private long b;
    private long c = -1;
    private long d = 0;
    private zzo e;
    private static final zzl f = new zzl("RequestTracker");

    /* renamed from: a, reason: collision with root package name */
    public static final Object f859a = new Object();

    public zzp(long j) {
        this.b = j;
    }

    private void c() {
        this.c = -1L;
        this.e = null;
        this.d = 0L;
    }

    public void a() {
        synchronized (f859a) {
            if (this.c != -1) {
                c();
            }
        }
    }

    public void a(long j, zzo zzoVar) {
        zzo zzoVar2;
        long j2;
        synchronized (f859a) {
            zzoVar2 = this.e;
            j2 = this.c;
            this.c = j;
            this.e = zzoVar;
            this.d = SystemClock.elapsedRealtime();
        }
        if (zzoVar2 != null) {
            zzoVar2.a(j2);
        }
    }

    public boolean a(long j) {
        boolean z;
        synchronized (f859a) {
            z = this.c != -1 && this.c == j;
        }
        return z;
    }

    public boolean a(long j, int i) {
        return a(j, i, null);
    }

    public boolean a(long j, int i, Object obj) {
        boolean z = true;
        zzo zzoVar = null;
        synchronized (f859a) {
            if (this.c == -1 || this.c != j) {
                z = false;
            } else {
                f.b("request %d completed", Long.valueOf(this.c));
                zzoVar = this.e;
                c();
            }
        }
        if (zzoVar != null) {
            zzoVar.a(j, i, obj);
        }
        return z;
    }

    public boolean b() {
        boolean z;
        synchronized (f859a) {
            z = this.c != -1;
        }
        return z;
    }

    public boolean b(long j, int i) {
        zzo zzoVar;
        boolean z = true;
        long j2 = 0;
        synchronized (f859a) {
            if (this.c == -1 || j - this.d < this.b) {
                z = false;
                zzoVar = null;
            } else {
                f.b("request %d timed out", Long.valueOf(this.c));
                j2 = this.c;
                zzoVar = this.e;
                c();
            }
        }
        if (zzoVar != null) {
            zzoVar.a(j2, i, null);
        }
        return z;
    }
}
