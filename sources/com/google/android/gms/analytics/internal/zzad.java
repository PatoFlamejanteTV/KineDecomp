package com.google.android.gms.analytics.internal;

/* loaded from: classes.dex */
public class zzad {

    /* renamed from: a, reason: collision with root package name */
    private final long f729a;
    private final int b;
    private double c;
    private long d;
    private final Object e;
    private final String f;

    public zzad(int i, long j, String str) {
        this.e = new Object();
        this.b = i;
        this.c = this.b;
        this.f729a = j;
        this.f = str;
    }

    public zzad(String str) {
        this(60, 2000L, str);
    }

    public boolean a() {
        boolean z;
        synchronized (this.e) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.c < this.b) {
                double d = (currentTimeMillis - this.d) / this.f729a;
                if (d > 0.0d) {
                    this.c = Math.min(this.b, d + this.c);
                }
            }
            this.d = currentTimeMillis;
            if (this.c >= 1.0d) {
                this.c -= 1.0d;
                z = true;
            } else {
                zzae.b("Excessive " + this.f + " detected; call ignored.");
                z = false;
            }
        }
        return z;
    }
}
