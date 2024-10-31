package com.google.firebase.iid;

import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.VisibleForTesting;
import java.security.KeyPair;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class P {

    /* renamed from: a */
    private final KeyPair f17340a;

    /* renamed from: b */
    private final long f17341b;

    @VisibleForTesting
    public P(KeyPair keyPair, long j) {
        this.f17340a = keyPair;
        this.f17341b = j;
    }

    public final String b() {
        return Base64.encodeToString(this.f17340a.getPublic().getEncoded(), 11);
    }

    public final String c() {
        return Base64.encodeToString(this.f17340a.getPrivate().getEncoded(), 11);
    }

    public final KeyPair a() {
        return this.f17340a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof P)) {
            return false;
        }
        P p = (P) obj;
        return this.f17341b == p.f17341b && this.f17340a.getPublic().equals(p.f17340a.getPublic()) && this.f17340a.getPrivate().equals(p.f17340a.getPrivate());
    }

    public final int hashCode() {
        return Objects.a(this.f17340a.getPublic(), this.f17340a.getPrivate(), Long.valueOf(this.f17341b));
    }
}
