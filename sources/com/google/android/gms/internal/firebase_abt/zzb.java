package com.google.android.gms.internal.firebase_abt;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public final class zzb {
    private final ByteBuffer zzr;

    private zzb(ByteBuffer byteBuffer) {
        this.zzr = byteBuffer;
        this.zzr.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzb(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, 0, i2));
    }

    public static zzb zzb(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    private final void zzd(int i) throws IOException {
        byte b2 = (byte) i;
        if (!this.zzr.hasRemaining()) {
            throw new zzc(this.zzr.position(), this.zzr.limit());
        }
        this.zzr.put(b2);
    }

    public static int zzf(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public final void zzc(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.zzr.remaining() < length) {
            throw new zzc(this.zzr.position(), this.zzr.limit());
        }
        this.zzr.put(bArr, 0, length);
    }

    public final void zze(int i) throws IOException {
        while ((i & (-128)) != 0) {
            zzd((i & 127) | 128);
            i >>>= 7;
        }
        zzd(i);
    }
}
