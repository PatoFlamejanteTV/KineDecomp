package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class Zi {

    /* renamed from: a */
    final int f12011a;

    /* renamed from: b */
    final byte[] f12012b;

    public Zi(int i, byte[] bArr) {
        this.f12011a = i;
        this.f12012b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Zi)) {
            return false;
        }
        Zi zi = (Zi) obj;
        return this.f12011a == zi.f12011a && Arrays.equals(this.f12012b, zi.f12012b);
    }

    public final int hashCode() {
        return ((this.f12011a + 527) * 31) + Arrays.hashCode(this.f12012b);
    }
}
