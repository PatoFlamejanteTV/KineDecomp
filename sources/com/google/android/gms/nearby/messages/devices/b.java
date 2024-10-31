package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
class b extends a {
    public b(byte[] bArr) {
        super(b(bArr));
    }

    private static byte[] b(byte[] bArr) {
        zzx.b(bArr.length == 10 || bArr.length == 16, "Bytes must be a namespace (10 bytes), or a namespace plus instance ID (16 bytes).");
        return bArr;
    }

    @Override // com.google.android.gms.nearby.messages.devices.a
    public String toString() {
        return "EddystoneUidPrefix{bytes=" + b() + '}';
    }
}
