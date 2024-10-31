package com.facebook.ads.redexgen.X;

import android.util.SparseArray;

/* loaded from: assets/audience_network.dex */
public final class P7 {
    public final SparseArray<int[]> A00 = new SparseArray<>();

    public final void A00(int i, int[] iArr) {
        this.A00.put(i, iArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0016, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A01(int r3) {
        /*
            r2 = this;
            r1 = 0
            android.util.SparseArray<int[]> r0 = r2.A00
            int r0 = r0.indexOfKey(r3)
            if (r0 < 0) goto L14
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L16;
                case 4: goto L11;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            r1 = 1
            r0 = 3
            goto La
        L11:
            r1 = 0
            r0 = 3
            goto La
        L14:
            r0 = 4
            goto La
        L16:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.P7.A01(int):boolean");
    }

    public final int[] A02(int i) {
        return this.A00.get(i);
    }
}
