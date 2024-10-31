package com.birbit.android.jobqueue;

import java.util.HashSet;

/* compiled from: Params.java */
/* loaded from: classes.dex */
public class w {

    /* renamed from: e */
    private int f8323e;

    /* renamed from: f */
    private long f8324f;

    /* renamed from: g */
    private HashSet<String> f8325g;
    private Boolean i;

    /* renamed from: a */
    int f8319a = 0;

    /* renamed from: b */
    private String f8320b = null;

    /* renamed from: c */
    private String f8321c = null;

    /* renamed from: d */
    private boolean f8322d = false;

    /* renamed from: h */
    private long f8326h = 0;

    public w(int i) {
        this.f8323e = i;
    }

    public long a() {
        return this.f8326h;
    }

    public long b() {
        return this.f8324f;
    }

    public String c() {
        return this.f8320b;
    }

    public int d() {
        return this.f8323e;
    }

    public String e() {
        return this.f8321c;
    }

    public HashSet<String> f() {
        return this.f8325g;
    }

    public boolean g() {
        return this.f8322d;
    }

    public w h() {
        if (this.f8319a != 2) {
            this.f8319a = 1;
        }
        return this;
    }

    public boolean i() {
        return Boolean.TRUE.equals(this.i);
    }
}
