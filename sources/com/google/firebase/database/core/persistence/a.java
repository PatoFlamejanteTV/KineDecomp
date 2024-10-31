package com.google.firebase.database.core.persistence;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class a implements CachePolicy {
    @Override // com.google.firebase.database.core.persistence.CachePolicy
    public float a() {
        return 0.0f;
    }

    @Override // com.google.firebase.database.core.persistence.CachePolicy
    public boolean a(long j) {
        return false;
    }

    @Override // com.google.firebase.database.core.persistence.CachePolicy
    public boolean a(long j, long j2) {
        return false;
    }

    @Override // com.google.firebase.database.core.persistence.CachePolicy
    public long b() {
        return Long.MAX_VALUE;
    }
}
