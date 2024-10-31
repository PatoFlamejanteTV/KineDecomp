package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public class zzb {

    /* renamed from: a, reason: collision with root package name */
    private final b f2109a;

    public zzb(byte[] bArr) {
        this.f2109a = new b(a(bArr));
    }

    private static byte[] a(byte[] bArr) {
        zzx.b(bArr.length == 16, "Bytes must be a namespace plus instance ID (16 bytes).");
        return bArr;
    }

    public String a() {
        return this.f2109a.b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzb) {
            return zzw.a(this.f2109a, ((zzb) obj).f2109a);
        }
        return false;
    }

    public int hashCode() {
        return zzw.a(this.f2109a);
    }

    public String toString() {
        return "EddystoneUid{id=" + a() + '}';
    }
}
