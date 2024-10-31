package com.nexstreaming.app.general.util;

/* compiled from: Profiler.java */
/* loaded from: classes2.dex */
public class C {

    /* renamed from: a */
    private final String f19798a;

    /* renamed from: b */
    private final String f19799b;

    /* renamed from: c */
    private long f19800c = System.nanoTime();

    /* renamed from: d */
    private long f19801d = this.f19800c;

    /* renamed from: e */
    private int f19802e = 0;

    /* renamed from: f */
    private final boolean f19803f;

    public C(String str, boolean z) {
        this.f19798a = str;
        this.f19803f = z;
        this.f19799b = "NexProfile_" + this.f19798a;
    }

    public void a() {
        this.f19800c = System.nanoTime();
        this.f19801d = this.f19800c;
        this.f19802e++;
    }

    public void a(int i) {
        if (this.f19803f) {
            long nanoTime = System.nanoTime();
            long j = this.f19801d;
            long j2 = this.f19800c;
            this.f19801d = nanoTime;
        }
    }
}
