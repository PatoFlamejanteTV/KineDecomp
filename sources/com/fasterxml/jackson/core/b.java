package com.fasterxml.jackson.core;

/* compiled from: JsonStreamContext.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected int f420a;
    protected int b;

    public final boolean a() {
        return this.f420a == 1;
    }

    public final boolean b() {
        return this.f420a == 0;
    }

    public final boolean c() {
        return this.f420a == 2;
    }

    public final String d() {
        switch (this.f420a) {
            case 0:
                return "ROOT";
            case 1:
                return "ARRAY";
            case 2:
                return "OBJECT";
            default:
                return "?";
        }
    }

    public final int e() {
        return this.b + 1;
    }

    public final int f() {
        if (this.b < 0) {
            return 0;
        }
        return this.b;
    }
}
