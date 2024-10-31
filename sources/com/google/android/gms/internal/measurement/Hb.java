package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class Hb {

    /* renamed from: a */
    final int f13370a;

    /* renamed from: b */
    final byte[] f13371b;

    public Hb(int i, byte[] bArr) {
        this.f13370a = i;
        this.f13371b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Hb)) {
            return false;
        }
        Hb hb = (Hb) obj;
        return this.f13370a == hb.f13370a && Arrays.equals(this.f13371b, hb.f13371b);
    }

    public final int hashCode() {
        return ((this.f13370a + 527) * 31) + Arrays.hashCode(this.f13371b);
    }
}
