package com.google.android.gms.tagmanager;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class h {

    /* renamed from: a */
    final String f14202a;

    /* renamed from: b */
    final byte[] f14203b;

    public h(String str, byte[] bArr) {
        this.f14202a = str;
        this.f14203b = bArr;
    }

    public final String toString() {
        String str = this.f14202a;
        int hashCode = Arrays.hashCode(this.f14203b);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 54);
        sb.append("KeyAndSerialized: key = ");
        sb.append(str);
        sb.append(" serialized hash = ");
        sb.append(hashCode);
        return sb.toString();
    }
}
