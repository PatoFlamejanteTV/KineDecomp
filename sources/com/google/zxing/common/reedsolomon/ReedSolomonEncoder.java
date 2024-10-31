package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class ReedSolomonEncoder {

    /* renamed from: a */
    private final GenericGF f19087a;

    /* renamed from: b */
    private final List<a> f19088b = new ArrayList();

    public ReedSolomonEncoder(GenericGF genericGF) {
        this.f19087a = genericGF;
        this.f19088b.add(new a(genericGF, new int[]{1}));
    }

    private a a(int i) {
        if (i >= this.f19088b.size()) {
            List<a> list = this.f19088b;
            a aVar = list.get(list.size() - 1);
            for (int size = this.f19088b.size(); size <= i; size++) {
                GenericGF genericGF = this.f19087a;
                aVar = aVar.c(new a(genericGF, new int[]{1, genericGF.a((size - 1) + genericGF.a())}));
                this.f19088b.add(aVar);
            }
        }
        return this.f19088b.get(i);
    }

    public void a(int[] iArr, int i) {
        if (i != 0) {
            int length = iArr.length - i;
            if (length > 0) {
                a a2 = a(i);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                int[] a3 = new a(this.f19087a, iArr2).a(i, 1).b(a2)[1].a();
                int length2 = i - a3.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    iArr[length + i2] = 0;
                }
                System.arraycopy(a3, 0, iArr, length + length2, a3.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}
