package com.nexstreaming.app.general.util;

/* compiled from: Profiler.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private final String f3238a;
    private final String b;
    private long c = System.nanoTime();
    private long d = this.c;
    private int e = 0;
    private final boolean f;

    public s(String str, boolean z) {
        this.f3238a = str;
        this.f = z;
        this.b = "NexProfile_" + this.f3238a;
    }

    public void a() {
        this.c = System.nanoTime();
        this.d = this.c;
        this.e++;
    }

    public void a(int i) {
        if (this.f) {
            long nanoTime = System.nanoTime();
            long j = nanoTime - this.d;
            long j2 = nanoTime - this.c;
            this.d = nanoTime;
        }
    }
}
