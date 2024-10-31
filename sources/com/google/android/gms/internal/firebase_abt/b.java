package com.google.android.gms.internal.firebase_abt;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class b {

    /* renamed from: a */
    final int f12948a;

    /* renamed from: b */
    final byte[] f12949b;

    public b(int i, byte[] bArr) {
        this.f12948a = i;
        this.f12949b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f12948a == bVar.f12948a && Arrays.equals(this.f12949b, bVar.f12949b);
    }

    public final int hashCode() {
        return ((this.f12948a + 527) * 31) + Arrays.hashCode(this.f12949b);
    }
}
