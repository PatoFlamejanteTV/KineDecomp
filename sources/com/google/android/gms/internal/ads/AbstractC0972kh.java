package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* renamed from: com.google.android.gms.internal.ads.kh */
/* loaded from: classes2.dex */
abstract class AbstractC0972kh implements zzbjm {
    private final byte[] key;
    private final AbstractC0958jh zzfkj;
    private final AbstractC0958jh zzfkk;

    public AbstractC0972kh(byte[] bArr) throws InvalidKeyException {
        this.key = (byte[]) bArr.clone();
        this.zzfkj = zze(bArr, 1);
        this.zzfkk = zze(bArr, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        this.zzfkj.a();
        if (length <= 2147483619) {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length + this.zzfkj.a() + 16);
            if (allocate.remaining() >= bArr.length + this.zzfkj.a() + 16) {
                int position = allocate.position();
                this.zzfkj.a(allocate, bArr);
                allocate.position(position);
                byte[] bArr3 = new byte[this.zzfkj.a()];
                allocate.get(bArr3);
                allocate.limit(allocate.limit() - 16);
                if (bArr2 == null) {
                    bArr2 = new byte[0];
                }
                byte[] bArr4 = new byte[32];
                this.zzfkk.a(bArr3, 0).get(bArr4);
                int length2 = bArr2.length % 16 == 0 ? bArr2.length : (bArr2.length + 16) - (bArr2.length % 16);
                int remaining = allocate.remaining();
                int i = remaining % 16;
                int i2 = (i == 0 ? remaining : (remaining + 16) - i) + length2;
                ByteBuffer order = ByteBuffer.allocate(i2 + 16).order(ByteOrder.LITTLE_ENDIAN);
                order.put(bArr2);
                order.position(length2);
                order.put(allocate);
                order.position(i2);
                order.putLong(bArr2.length);
                order.putLong(remaining);
                byte[] a2 = C0931hh.a(bArr4, order.array());
                allocate.limit(allocate.limit() + 16);
                allocate.put(a2);
                return allocate.array();
            }
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    abstract AbstractC0958jh zze(byte[] bArr, int i) throws InvalidKeyException;
}
