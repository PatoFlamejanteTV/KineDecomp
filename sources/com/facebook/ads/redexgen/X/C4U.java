package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.4U, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C4U<T> implements C4T<T> {
    public static byte[] A02;
    public int A00;
    public final Object[] A01;

    static {
        A01();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C4U.A02
            int r0 = r2 + r3
            byte[] r2 = java.util.Arrays.copyOfRange(r1, r2, r0)
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L19;
                case 4: goto L27;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            if (r1 >= r0) goto L17
            r0 = 3
            goto Lc
        L17:
            r0 = 4
            goto Lc
        L19:
            byte[] r2 = (byte[]) r2
            r0 = r2[r1]
            r0 = r0 ^ r4
            r0 = r0 ^ 121(0x79, float:1.7E-43)
            byte r0 = (byte) r0
            r2[r1] = r0
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L27:
            byte[] r2 = (byte[]) r2
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4U.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A02 = new byte[]{107, 87, 90, 31, 82, 94, 71, 31, 79, 80, 80, 83, 31, 76, 86, 69, 90, 31, 82, 74, 76, 75, 31, 93, 90, 31, 1, 31, 15, 4, 41, 55, 32, 36, 33, 60, 101, 44, 43, 101, 49, 45, 32, 101, 53, 42, 42, 41, 100};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4U != com.facebook.ads.internal.androidx.support.v4.util.Pools$SimplePool<T> */
    public C4U(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(A00(0, 29, 70));
        }
        this.A01 = new Object[i];
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x002b, code lost:            return r2;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4U != com.facebook.ads.internal.androidx.support.v4.util.Pools$SimplePool<T> */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A02(T r5) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r0 = 0
            r1 = 0
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L1a;
                case 4: goto Ld;
                case 5: goto L2b;
                case 6: goto L9;
                case 7: goto L28;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            int r1 = r1 + 1
            r0 = 2
            goto L5
        Ld:
            r2 = 1
            r0 = 5
            goto L5
        L10:
            com.facebook.ads.redexgen.X.4U r3 = (com.facebook.ads.redexgen.X.C4U) r3
            int r0 = r3.A00
            if (r1 >= r0) goto L18
            r0 = 3
            goto L5
        L18:
            r0 = 7
            goto L5
        L1a:
            com.facebook.ads.redexgen.X.4U r3 = (com.facebook.ads.redexgen.X.C4U) r3
            java.lang.Object r5 = (java.lang.Object) r5
            java.lang.Object[] r0 = r3.A01
            r0 = r0[r1]
            if (r0 != r5) goto L26
            r0 = 4
            goto L5
        L26:
            r0 = 6
            goto L5
        L28:
            r2 = 0
            r0 = 5
            goto L5
        L2b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4U.A02(java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:            return (T) r3;     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4U != com.facebook.ads.internal.androidx.support.v4.util.Pools$SimplePool<T> */
    @Override // com.facebook.ads.redexgen.X.C4T
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public T A2O() {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r0 = 0
            r0 = 0
            int r0 = r4.A00
            if (r0 <= 0) goto L27
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L29;
                case 4: goto L24;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.4U r4 = (com.facebook.ads.redexgen.X.C4U) r4
            r2 = 0
            int r0 = r4.A00
            int r1 = r0 + (-1)
            java.lang.Object[] r0 = r4.A01
            r3 = r0[r1]
            java.lang.Object[] r0 = r4.A01
            r0[r1] = r2
            int r0 = r4.A00
            int r0 = r0 + (-1)
            r4.A00 = r0
            r0 = 3
            goto L9
        L24:
            r3 = 0
            r0 = 3
            goto L9
        L27:
            r0 = 4
            goto L9
        L29:
            java.lang.Object r3 = (java.lang.Object) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4U.A2O():java.lang.Object");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0009. Please report as an issue. */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4U != com.facebook.ads.internal.androidx.support.v4.util.Pools$SimplePool<T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3 */
    @Override // com.facebook.ads.redexgen.X.C4T
    public boolean A85(T t) {
        C4U<T> c4u = this;
        boolean z = false;
        char c = c4u.A02(t) ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    throw new IllegalStateException(A00(29, 20, 60));
                case 3:
                    c4u = c4u;
                    c = c4u.A00 < c4u.A01.length ? (char) 4 : (char) 6;
                case 4:
                    c4u = c4u;
                    t = t;
                    c4u.A01[c4u.A00] = t;
                    c4u.A00++;
                    z = true;
                    c = 5;
                case 5:
                    return z;
                case 6:
                    z = false;
                    c = 5;
            }
        }
    }
}
