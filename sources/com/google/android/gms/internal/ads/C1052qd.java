package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.qd, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1052qd {

    /* renamed from: a, reason: collision with root package name */
    private final Object f12451a;

    /* renamed from: b, reason: collision with root package name */
    private volatile int f12452b;

    /* renamed from: c, reason: collision with root package name */
    private volatile long f12453c;

    private C1052qd() {
        this.f12451a = new Object();
        this.f12452b = C1065rd.f12483a;
        this.f12453c = 0L;
    }

    private final void a(int i, int i2) {
        d();
        long a2 = com.google.android.gms.ads.internal.zzbv.l().a();
        synchronized (this.f12451a) {
            if (this.f12452b != i) {
                return;
            }
            this.f12452b = i2;
            if (this.f12452b == C1065rd.f12485c) {
                this.f12453c = a2;
            }
        }
    }

    private final void d() {
        long a2 = com.google.android.gms.ads.internal.zzbv.l().a();
        synchronized (this.f12451a) {
            if (this.f12452b == C1065rd.f12485c) {
                if (this.f12453c + ((Long) zzwu.zzpz().zzd(zzaan.zzcye)).longValue() <= a2) {
                    this.f12452b = C1065rd.f12483a;
                }
            }
        }
    }

    public final boolean b() {
        d();
        return this.f12452b == C1065rd.f12485c;
    }

    public final void c() {
        a(C1065rd.f12484b, C1065rd.f12485c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C1052qd(C1038pd c1038pd) {
        this();
    }

    public final void a(boolean z) {
        if (z) {
            a(C1065rd.f12483a, C1065rd.f12484b);
        } else {
            a(C1065rd.f12484b, C1065rd.f12483a);
        }
    }

    public final boolean a() {
        d();
        return this.f12452b == C1065rd.f12484b;
    }
}
