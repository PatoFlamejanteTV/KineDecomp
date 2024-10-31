package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzx;
import java.nio.ByteBuffer;
import java.util.UUID;

/* loaded from: classes.dex */
class c extends a {
    public c(byte[] bArr) {
        super(b(bArr));
    }

    private static byte[] b(byte[] bArr) {
        zzx.b(bArr.length == 16 || bArr.length == 18 || bArr.length == 20, "Prefix must be a UUID, a UUID and a major, or a UUID, a major, and a minor.");
        return bArr;
    }

    public UUID c() {
        ByteBuffer wrap = ByteBuffer.wrap(a());
        return new UUID(wrap.getLong(), wrap.getLong());
    }

    public Short d() {
        byte[] a2 = a();
        if (a2.length >= 18) {
            return Short.valueOf(ByteBuffer.wrap(a2).getShort(16));
        }
        return null;
    }

    public Short e() {
        byte[] a2 = a();
        if (a2.length == 20) {
            return Short.valueOf(ByteBuffer.wrap(a2).getShort(18));
        }
        return null;
    }

    @Override // com.google.android.gms.nearby.messages.devices.a
    public String toString() {
        return "IBeaconIdPrefix{proximityUuid=" + c() + ", major=" + d() + ", minor=" + e() + '}';
    }
}
