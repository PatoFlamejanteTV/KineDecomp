package com.google.android.gms.internal.config;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class b {

    /* renamed from: a */
    final int f12939a;

    /* renamed from: b */
    final byte[] f12940b;

    public b(int i, byte[] bArr) {
        this.f12939a = i;
        this.f12940b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f12939a == bVar.f12939a && Arrays.equals(this.f12940b, bVar.f12940b);
    }

    public final int hashCode() {
        return ((this.f12939a + 527) * 31) + Arrays.hashCode(this.f12940b);
    }
}
