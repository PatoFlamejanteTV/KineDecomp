package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.6E, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C6E {
    public static byte[] A04;
    public int A00;
    public int A01;
    public int A02;
    public Object A03;

    static {
        A02();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C6E.A04
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
            int r0 = r0 - r4
            int r0 = r0 + (-14)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6E.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A04 = new byte[]{120, -68, -122, -89, -94, 90, -95, 104, -77, -68, -44, -49, -108, 113, 72, -21, -18, -18, 89, 89, -111};
    }

    public C6E(int i, int i2, int i3, Object obj) {
        this.A00 = i;
        this.A02 = i2;
        this.A01 = i3;
        this.A03 = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0055, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String A00() {
        /*
            r3 = this;
            r1 = 0
            int r0 = r3.A00
            switch(r0) {
                case 1: goto L41;
                case 2: goto L43;
                case 3: goto L49;
                case 4: goto L45;
                case 5: goto L4b;
                case 6: goto L4d;
                case 7: goto L4f;
                case 8: goto L47;
                default: goto L6;
            }
        L6:
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L2b;
                case 3: goto L51;
                case 4: goto L20;
                case 5: goto L16;
                case 6: goto Lb;
                case 7: goto L36;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            r2 = 10
            r1 = 2
            r0 = 84
            java.lang.String r1 = A01(r2, r1, r0)
            r0 = 3
            goto L7
        L16:
            r2 = 3
            r1 = 2
            r0 = 36
            java.lang.String r1 = A01(r2, r1, r0)
            r0 = 3
            goto L7
        L20:
            r2 = 8
            r1 = 2
            r0 = 56
            java.lang.String r1 = A01(r2, r1, r0)
            r0 = 3
            goto L7
        L2b:
            r2 = 18
            r1 = 2
            r0 = 12
            java.lang.String r1 = A01(r2, r1, r0)
            r0 = 3
            goto L7
        L36:
            r2 = 15
            r1 = 3
            r0 = 124(0x7c, float:1.74E-43)
            java.lang.String r1 = A01(r2, r1, r0)
            r0 = 3
            goto L7
        L41:
            r0 = 7
            goto L7
        L43:
            r0 = 6
            goto L7
        L45:
            r0 = 5
            goto L7
        L47:
            r0 = 4
            goto L7
        L49:
            r0 = 2
            goto L7
        L4b:
            r0 = 2
            goto L7
        L4d:
            r0 = 2
            goto L7
        L4f:
            r0 = 2
            goto L7
        L51:
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6E.A00():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:134:0x00e4, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r6) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6E.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return (((this.A00 * 31) + this.A02) * 31) + this.A01;
    }

    public final String toString() {
        return Integer.toHexString(System.identityHashCode(this)) + A01(20, 1, 40) + A00() + A01(5, 3, 32) + this.A02 + A01(13, 2, 0) + this.A01 + A01(0, 3, 62) + this.A03 + A01(12, 1, 41);
    }
}
