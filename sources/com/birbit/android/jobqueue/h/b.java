package com.birbit.android.jobqueue.h;

/* compiled from: SchedulerConstraint.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    private String f8168a;

    /* renamed from: b */
    private long f8169b;

    /* renamed from: c */
    private int f8170c;

    /* renamed from: d */
    private Long f8171d;

    /* renamed from: e */
    private Object f8172e;

    public b(String str) {
        this.f8168a = str;
    }

    public long a() {
        return this.f8169b;
    }

    public int b() {
        return this.f8170c;
    }

    public Long c() {
        return this.f8171d;
    }

    public String d() {
        return this.f8168a;
    }

    public String toString() {
        return "SchedulerConstraint{uuid='" + this.f8168a + "', delayInMs=" + this.f8169b + ", networkStatus=" + this.f8170c + ", overrideDeadlineInMs=" + this.f8171d + ", data=" + this.f8172e + '}';
    }

    public void a(long j) {
        this.f8169b = j;
    }

    public void a(int i) {
        this.f8170c = i;
    }

    public void a(Long l) {
        this.f8171d = l;
    }
}
