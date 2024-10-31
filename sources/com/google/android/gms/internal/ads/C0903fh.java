package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidKeyException;

/* renamed from: com.google.android.gms.internal.ads.fh */
/* loaded from: classes2.dex */
final class C0903fh extends AbstractC0958jh {

    /* renamed from: d */
    private static final byte[] f12162d = new byte[16];

    public C0903fh(byte[] bArr, int i) throws InvalidKeyException {
        super(bArr, i);
    }

    @Override // com.google.android.gms.internal.ads.AbstractC0958jh
    public final int a() {
        return 12;
    }

    @Override // com.google.android.gms.internal.ads.AbstractC0958jh
    public final ByteBuffer a(byte[] bArr, int i) {
        int[] iArr = new int[16];
        int[] iArr2 = AbstractC0958jh.f12227a;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        int[] a2 = AbstractC0958jh.a(ByteBuffer.wrap(this.f12228b.getBytes()));
        int i2 = 4;
        System.arraycopy(a2, 0, iArr, 4, a2.length);
        iArr[12] = i;
        System.arraycopy(AbstractC0958jh.a(ByteBuffer.wrap(bArr)), 0, iArr, 13, 3);
        int[] iArr3 = (int[]) iArr.clone();
        int i3 = 0;
        while (i3 < 10) {
            a(iArr3, 0, i2, 8, 12);
            a(iArr3, 1, 5, 9, 13);
            a(iArr3, 2, 6, 10, 14);
            a(iArr3, 3, 7, 11, 15);
            a(iArr3, 0, 5, 10, 15);
            a(iArr3, 1, 6, 11, 12);
            a(iArr3, 2, 7, 8, 13);
            a(iArr3, 3, 4, 9, 14);
            i3++;
            i2 = 4;
        }
        for (int i4 = 0; i4 < 16; i4++) {
            iArr[i4] = iArr[i4] + iArr3[i4];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(iArr, 0, 16);
        return order;
    }

    private static void a(int[] iArr, int i, int i2, int i3, int i4) {
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = AbstractC0958jh.a(iArr[i4] ^ iArr[i], 16);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = AbstractC0958jh.a(iArr[i2] ^ iArr[i3], 12);
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = AbstractC0958jh.a(iArr[i] ^ iArr[i4], 8);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = AbstractC0958jh.a(iArr[i2] ^ iArr[i3], 7);
    }
}
