package com.google.firebase.database.core.persistence;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class LRUCachePolicy implements CachePolicy {

    /* renamed from: a */
    public final long f17017a;

    public LRUCachePolicy(long j) {
        this.f17017a = j;
    }

    @Override // com.google.firebase.database.core.persistence.CachePolicy
    public float a() {
        return 0.2f;
    }

    @Override // com.google.firebase.database.core.persistence.CachePolicy
    public boolean a(long j) {
        return j > 1000;
    }

    @Override // com.google.firebase.database.core.persistence.CachePolicy
    public boolean a(long j, long j2) {
        return j > this.f17017a || j2 > 1000;
    }

    @Override // com.google.firebase.database.core.persistence.CachePolicy
    public long b() {
        return 1000L;
    }
}
