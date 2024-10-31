package com.google.firebase.database.core;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class Tag {

    /* renamed from: a */
    private final long f16945a;

    public Tag(long j) {
        this.f16945a = j;
    }

    public long a() {
        return this.f16945a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Tag.class == obj.getClass() && this.f16945a == ((Tag) obj).f16945a;
    }

    public int hashCode() {
        long j = this.f16945a;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        return "Tag{tagNumber=" + this.f16945a + '}';
    }
}
