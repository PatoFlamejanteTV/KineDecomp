package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.f.i;
import android.util.Log;

/* loaded from: classes.dex */
public class zze {

    /* renamed from: a, reason: collision with root package name */
    private final long f1045a;
    private final int b;
    private final i<String, Long> c;

    public zze() {
        this.f1045a = 60000L;
        this.b = 10;
        this.c = new i<>(10);
    }

    public zze(int i, long j) {
        this.f1045a = j;
        this.b = i;
        this.c = new i<>();
    }

    private void a(long j, long j2) {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            if (j2 - this.c.c(size).longValue() > j) {
                this.c.d(size);
            }
        }
    }

    public Long a(String str) {
        Long put;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f1045a;
        synchronized (this) {
            while (this.c.size() >= this.b) {
                a(j, elapsedRealtime);
                j /= 2;
                Log.w("ConnectionTracker", "The max capacity " + this.b + " is not enough. Current durationThreshold is: " + j);
            }
            put = this.c.put(str, Long.valueOf(elapsedRealtime));
        }
        return put;
    }

    public boolean b(String str) {
        boolean z;
        synchronized (this) {
            z = this.c.remove(str) != null;
        }
        return z;
    }
}
