package com.google.android.gms.auth.api.signin.internal;

/* loaded from: classes.dex */
public class zzc {

    /* renamed from: a, reason: collision with root package name */
    static int f810a = 31;
    private int b = 1;

    public int a() {
        return this.b;
    }

    public zzc a(Object obj) {
        this.b = (obj == null ? 0 : obj.hashCode()) + (this.b * f810a);
        return this;
    }

    public zzc a(boolean z) {
        this.b = (z ? 1 : 0) + (this.b * f810a);
        return this;
    }
}
