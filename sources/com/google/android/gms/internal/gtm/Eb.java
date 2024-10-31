package com.google.android.gms.internal.gtm;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Eb {

    /* renamed from: a */
    final int f13143a;

    /* renamed from: b */
    final byte[] f13144b;

    public Eb(int i, byte[] bArr) {
        this.f13143a = i;
        this.f13144b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Eb)) {
            return false;
        }
        Eb eb = (Eb) obj;
        return this.f13143a == eb.f13143a && Arrays.equals(this.f13144b, eb.f13144b);
    }

    public final int hashCode() {
        return ((this.f13143a + 527) * 31) + Arrays.hashCode(this.f13144b);
    }
}
