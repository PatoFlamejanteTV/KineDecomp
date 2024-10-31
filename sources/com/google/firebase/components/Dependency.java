package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.firebase:firebase-common@@16.0.4 */
@KeepForSdk
/* loaded from: classes2.dex */
public final class Dependency {

    /* renamed from: a */
    private final Class<?> f16578a;

    /* renamed from: b */
    private final int f16579b;

    /* renamed from: c */
    private final int f16580c;

    private Dependency(Class<?> cls, int i, int i2) {
        Preconditions.a(cls, "Null dependency anInterface.");
        this.f16578a = cls;
        this.f16579b = i;
        this.f16580c = i2;
    }

    @KeepForSdk
    public static Dependency a(Class<?> cls) {
        return new Dependency(cls, 0, 0);
    }

    @KeepForSdk
    public static Dependency b(Class<?> cls) {
        return new Dependency(cls, 1, 0);
    }

    public boolean c() {
        return this.f16579b == 1;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Dependency)) {
            return false;
        }
        Dependency dependency = (Dependency) obj;
        return this.f16578a == dependency.f16578a && this.f16579b == dependency.f16579b && this.f16580c == dependency.f16580c;
    }

    public int hashCode() {
        return ((((this.f16578a.hashCode() ^ 1000003) * 1000003) ^ this.f16579b) * 1000003) ^ this.f16580c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f16578a);
        sb.append(", required=");
        sb.append(this.f16579b == 1);
        sb.append(", direct=");
        sb.append(this.f16580c == 0);
        sb.append("}");
        return sb.toString();
    }

    public Class<?> a() {
        return this.f16578a;
    }

    public boolean b() {
        return this.f16580c == 0;
    }
}
