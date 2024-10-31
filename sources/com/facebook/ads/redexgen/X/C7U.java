package com.facebook.ads.redexgen.X;

import android.view.animation.Interpolator;

/* renamed from: com.facebook.ads.redexgen.X.7U, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C7U {
    public static byte[] A07;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public Interpolator A05;
    public boolean A06;

    static {
        A02();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C7U.A07
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
            int r0 = r0 + (-121)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7U.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A07 = new byte[]{-17, 9, 11, 11, 16, 4, -68, -17, -1, 14, 11, 8, 8, -68, -3, -1, 16, 5, 11, 10, -68, 5, 15, -68, -2, 1, 5, 10, 3, -68, 17, 12, 0, -3, 16, 1, 0, -68, 16, 11, 11, -68, 2, 14, 1, 13, 17, 1, 10, 16, 8, 21, -54, -68, -23, -3, 7, 1, -68, 15, 17, 14, 1, -68, 21, 11, 17, -68, -3, 14, 1, -68, 10, 11, 16, -68, -1, 4, -3, 10, 3, 5, 10, 3, -68, 5, 16, -68, 17, 10, 8, 1, 15, 15, -68, 10, 1, -1, 1, 15, 15, -3, 14, 21, 42, 58, 73, 70, 67, 67, -9, 59, 76, 73, 56, 75, 64, 70, 69, -9, 68, 76, 74, 75, -9, 57, 60, -9, 56, -9, 71, 70, 74, 64, 75, 64, 77, 60, -9, 69, 76, 68, 57, 60, 73, -41, -22, -24, -2, -24, -15, -22, -9, -37, -18, -22, -4, 44, 73, 3, 92, 82, 88, 3, 83, 85, 82, 89, 76, 71, 72, 3, 68, 81, 3, 76, 81, 87, 72, 85, 83, 82, 79, 68, 87, 82, 85, 15, 3, 92, 82, 88, 3, 80, 88, 86, 87, 3, 86, 72, 87, 3, 68, 3, 83, 82, 86, 76, 87, 76, 89, 72, 3, 71, 88, 85, 68, 87, 76, 82, 81};
    }

    public C7U(int i, int i2) {
        this(i, i2, Integer.MIN_VALUE, null);
    }

    public C7U(int i, int i2, int i3, Interpolator interpolator) {
        this.A04 = -1;
        this.A06 = false;
        this.A00 = 0;
        this.A02 = i;
        this.A03 = i2;
        this.A01 = i3;
        this.A05 = interpolator;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0008. Please report as an issue. */
    private void A01() {
        C7U c7u = this;
        char c = c7u.A05 != null ? (char) 2 : (char) 4;
        while (true) {
            switch (c) {
                case 2:
                    c7u = c7u;
                    c = c7u.A01 < 1 ? (char) 3 : (char) 4;
                case 3:
                    throw new IllegalStateException(A00(157, 64, 106));
                case 4:
                    c7u = c7u;
                    c = c7u.A01 < 1 ? (char) 5 : (char) 6;
                case 5:
                    throw new IllegalStateException(A00(104, 41, 94));
                case 6:
                    return;
            }
        }
    }

    public final void A03(int i) {
        this.A04 = i;
    }

    public final void A04(int i, int i2, int i3, Interpolator interpolator) {
        this.A02 = i;
        this.A03 = i2;
        this.A01 = i3;
        this.A05 = interpolator;
        this.A06 = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bc, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A05(com.facebook.ads.redexgen.X.C01807a r7) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7U.A05(com.facebook.ads.redexgen.X.7a):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0012, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A06() {
        /*
            r2 = this;
            r1 = 0
            int r0 = r2.A04
            if (r0 < 0) goto L10
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L12;
                case 4: goto Ld;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            r1 = 1
            r0 = 3
            goto L6
        Ld:
            r1 = 0
            r0 = 3
            goto L6
        L10:
            r0 = 4
            goto L6
        L12:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7U.A06():boolean");
    }
}
