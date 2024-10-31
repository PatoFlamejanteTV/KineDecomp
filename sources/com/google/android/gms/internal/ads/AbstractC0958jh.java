package com.google.android.gms.internal.ads;

import com.facebook.stetho.dumpapp.Framer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* renamed from: com.google.android.gms.internal.ads.jh */
/* loaded from: classes2.dex */
abstract class AbstractC0958jh implements zzbov {

    /* renamed from: a */
    static final int[] f12227a = a(ByteBuffer.wrap(new byte[]{101, Framer.EXIT_FRAME_PREFIX, 112, 97, 110, 100, 32, 51, Framer.STDERR_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 98, 121, 116, 101, 32, 107}));

    /* renamed from: b */
    final zzbou f12228b;

    /* renamed from: c */
    private final int f12229c;

    public AbstractC0958jh(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length == 32) {
            this.f12228b = zzbou.zzp(bArr);
            this.f12229c = i;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    public static int a(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    public abstract int a();

    public abstract ByteBuffer a(byte[] bArr, int i);

    public final void a(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
        if (byteBuffer.remaining() - a() >= bArr.length) {
            byte[] zzeg = zzboy.zzeg(a());
            byteBuffer.put(zzeg);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int remaining = wrap.remaining();
            int i = (remaining / 64) + 1;
            for (int i2 = 0; i2 < i; i2++) {
                ByteBuffer a2 = a(zzeg, this.f12229c + i2);
                if (i2 == i - 1) {
                    zzbnx.zza(byteBuffer, wrap, a2, remaining % 64);
                } else {
                    zzbnx.zza(byteBuffer, wrap, a2, 64);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final byte[] zzn(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        a();
        if (length <= 2147483635) {
            ByteBuffer allocate = ByteBuffer.allocate(a() + bArr.length);
            a(allocate, bArr);
            return allocate.array();
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    public static int[] a(ByteBuffer byteBuffer) {
        IntBuffer asIntBuffer = byteBuffer.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }
}
