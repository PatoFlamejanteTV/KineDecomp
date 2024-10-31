package com.birbit.android.jobqueue;

/* compiled from: RetryConstraint.java */
/* loaded from: classes.dex */
public class y {

    /* renamed from: a */
    public static final y f8327a = new a(true);

    /* renamed from: b */
    public static final y f8328b = new a(false);

    /* renamed from: c */
    private boolean f8329c;

    /* renamed from: d */
    private Long f8330d;

    /* renamed from: e */
    private Integer f8331e;

    /* renamed from: f */
    private boolean f8332f = false;

    /* compiled from: RetryConstraint.java */
    /* loaded from: classes.dex */
    static class a extends y {
        public a(boolean z) {
            super(z);
        }
    }

    public y(boolean z) {
        this.f8329c = z;
    }

    public Long a() {
        return this.f8330d;
    }

    public Integer b() {
        return this.f8331e;
    }

    public boolean c() {
        return this.f8329c;
    }

    public boolean d() {
        return this.f8332f;
    }
}
