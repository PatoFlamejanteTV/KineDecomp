package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.view.QuerySpec;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class TrackedQuery {

    /* renamed from: a */
    public final long f17024a;

    /* renamed from: b */
    public final QuerySpec f17025b;

    /* renamed from: c */
    public final long f17026c;

    /* renamed from: d */
    public final boolean f17027d;

    /* renamed from: e */
    public final boolean f17028e;

    public TrackedQuery(long j, QuerySpec querySpec, long j2, boolean z, boolean z2) {
        this.f17024a = j;
        if (querySpec.e() && !querySpec.d()) {
            throw new IllegalArgumentException("Can't create TrackedQuery for a non-default query that loads all data");
        }
        this.f17025b = querySpec;
        this.f17026c = j2;
        this.f17027d = z;
        this.f17028e = z2;
    }

    public TrackedQuery a(long j) {
        return new TrackedQuery(this.f17024a, this.f17025b, j, this.f17027d, this.f17028e);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != TrackedQuery.class) {
            return false;
        }
        TrackedQuery trackedQuery = (TrackedQuery) obj;
        return this.f17024a == trackedQuery.f17024a && this.f17025b.equals(trackedQuery.f17025b) && this.f17026c == trackedQuery.f17026c && this.f17027d == trackedQuery.f17027d && this.f17028e == trackedQuery.f17028e;
    }

    public int hashCode() {
        return (((((((Long.valueOf(this.f17024a).hashCode() * 31) + this.f17025b.hashCode()) * 31) + Long.valueOf(this.f17026c).hashCode()) * 31) + Boolean.valueOf(this.f17027d).hashCode()) * 31) + Boolean.valueOf(this.f17028e).hashCode();
    }

    public String toString() {
        return "TrackedQuery{id=" + this.f17024a + ", querySpec=" + this.f17025b + ", lastUse=" + this.f17026c + ", complete=" + this.f17027d + ", active=" + this.f17028e + "}";
    }

    public TrackedQuery a() {
        return new TrackedQuery(this.f17024a, this.f17025b, this.f17026c, true, this.f17028e);
    }

    public TrackedQuery a(boolean z) {
        return new TrackedQuery(this.f17024a, this.f17025b, this.f17026c, this.f17027d, z);
    }
}
