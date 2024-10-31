package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.UUID;

/* loaded from: classes.dex */
public class zzd {

    /* renamed from: a, reason: collision with root package name */
    private final c f2110a;

    public zzd(byte[] bArr) {
        this.f2110a = new c(a(bArr));
    }

    private static byte[] a(byte[] bArr) {
        zzx.b(bArr.length == 20, "iBeacon ID must be a UUID, a major, and a minor (20 total bytes).");
        return bArr;
    }

    public UUID a() {
        return this.f2110a.c();
    }

    public short b() {
        return this.f2110a.d().shortValue();
    }

    public short c() {
        return this.f2110a.e().shortValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzd) {
            return zzw.a(this.f2110a, ((zzd) obj).f2110a);
        }
        return false;
    }

    public int hashCode() {
        return zzw.a(this.f2110a);
    }

    public String toString() {
        return "IBeaconId{proximityUuid=" + a() + ", major=" + ((int) b()) + ", minor=" + ((int) c()) + '}';
    }
}
