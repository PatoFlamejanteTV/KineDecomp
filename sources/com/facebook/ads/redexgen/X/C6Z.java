package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.6Z, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C6Z implements C6Y {
    public static byte[] A04;
    public int A00;
    public int A01;
    public int A02;
    public int[] A03;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C6Z.A04
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
            r0 = r0 ^ 85
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6Z.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A04 = new byte[]{44, 1, 25, 15, 21, 20, 64, 16, 15, 19, 9, 20, 9, 15, 14, 19, 64, 13, 21, 19, 20, 64, 2, 5, 64, 14, 15, 14, 77, 14, 5, 7, 1, 20, 9, 22, 5, 30, 39, 54, 43, 34, 110, 42, 39, 61, 58, 47, 32, 45, 43, 110, 35, 59, 61, 58, 110, 44, 43, 110, 32, 33, 32, 99, 32, 43, 41, 47, 58, 39, 56, 43};
    }

    public final void A02() {
        if (this.A03 != null) {
            Arrays.fill(this.A03, -1);
        }
        this.A00 = 0;
    }

    public final void A03(int i, int i2) {
        this.A01 = i;
        this.A02 = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x00ad, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A04(com.facebook.ads.redexgen.X.C01807a r6, boolean r7) {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r0 = 0
            r4.A00 = r0
            int[] r0 = r4.A03
            if (r0 == 0) goto Laa
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L38;
                case 3: goto L2b;
                case 4: goto L22;
                case 5: goto L15;
                case 6: goto Le;
                case 7: goto L42;
                case 8: goto L60;
                case 9: goto L72;
                case 10: goto L82;
                case 11: goto Lad;
                case 12: goto L52;
                case 13: goto L97;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            if (r7 == 0) goto L12
            r0 = 7
            goto La
        L12:
            r0 = 12
            goto La
        L15:
            com.facebook.ads.redexgen.X.6g r3 = (com.facebook.ads.redexgen.X.AbstractC01616g) r3
            boolean r0 = r3.A1Y()
            if (r0 == 0) goto L1f
            r0 = 6
            goto La
        L1f:
            r0 = 11
            goto La
        L22:
            com.facebook.ads.redexgen.X.6g r3 = (com.facebook.ads.redexgen.X.AbstractC01616g) r3
            if (r3 == 0) goto L28
            r0 = 5
            goto La
        L28:
            r0 = 11
            goto La
        L2b:
            com.facebook.ads.redexgen.X.7a r6 = (com.facebook.ads.redexgen.X.C01807a) r6
            com.facebook.ads.redexgen.X.6g r3 = r6.A06
            com.facebook.ads.redexgen.X.2E r0 = r6.A04
            if (r0 == 0) goto L35
            r0 = 4
            goto La
        L35:
            r0 = 11
            goto La
        L38:
            com.facebook.ads.redexgen.X.6Z r4 = (com.facebook.ads.redexgen.X.C6Z) r4
            int[] r1 = r4.A03
            r0 = -1
            java.util.Arrays.fill(r1, r0)
            r0 = 3
            goto La
        L42:
            com.facebook.ads.redexgen.X.7a r6 = (com.facebook.ads.redexgen.X.C01807a) r6
            com.facebook.ads.redexgen.X.6G r0 = r6.A00
            boolean r0 = r0.A0J()
            if (r0 != 0) goto L4f
            r0 = 8
            goto La
        L4f:
            r0 = 9
            goto La
        L52:
            com.facebook.ads.redexgen.X.7a r6 = (com.facebook.ads.redexgen.X.C01807a) r6
            boolean r0 = r6.A1i()
            if (r0 != 0) goto L5d
            r0 = 13
            goto La
        L5d:
            r0 = 9
            goto La
        L60:
            com.facebook.ads.redexgen.X.6Z r4 = (com.facebook.ads.redexgen.X.C6Z) r4
            com.facebook.ads.redexgen.X.7a r6 = (com.facebook.ads.redexgen.X.C01807a) r6
            com.facebook.ads.redexgen.X.6g r3 = (com.facebook.ads.redexgen.X.AbstractC01616g) r3
            com.facebook.ads.redexgen.X.2E r0 = r6.A04
            int r0 = r0.A0C()
            r3.A1v(r0, r4)
            r0 = 9
            goto La
        L72:
            com.facebook.ads.redexgen.X.6Z r4 = (com.facebook.ads.redexgen.X.C6Z) r4
            com.facebook.ads.redexgen.X.6g r3 = (com.facebook.ads.redexgen.X.AbstractC01616g) r3
            int r1 = r4.A00
            int r0 = r3.A00
            if (r1 <= r0) goto L7f
            r0 = 10
            goto La
        L7f:
            r0 = 11
            goto La
        L82:
            com.facebook.ads.redexgen.X.6Z r4 = (com.facebook.ads.redexgen.X.C6Z) r4
            com.facebook.ads.redexgen.X.7a r6 = (com.facebook.ads.redexgen.X.C01807a) r6
            com.facebook.ads.redexgen.X.6g r3 = (com.facebook.ads.redexgen.X.AbstractC01616g) r3
            int r0 = r4.A00
            r3.A00 = r0
            r3.A08 = r7
            com.facebook.ads.redexgen.X.7O r0 = r6.A0r
            r0.A0O()
            r0 = 11
            goto La
        L97:
            com.facebook.ads.redexgen.X.6Z r4 = (com.facebook.ads.redexgen.X.C6Z) r4
            com.facebook.ads.redexgen.X.7a r6 = (com.facebook.ads.redexgen.X.C01807a) r6
            com.facebook.ads.redexgen.X.6g r3 = (com.facebook.ads.redexgen.X.AbstractC01616g) r3
            int r2 = r4.A01
            int r1 = r4.A02
            com.facebook.ads.redexgen.X.7W r0 = r6.A0s
            r3.A1u(r2, r1, r0, r4)
            r0 = 9
            goto La
        Laa:
            r0 = 3
            goto La
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6Z.A04(com.facebook.ads.redexgen.X.7a, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0036, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A05(int r6) {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r2 = 0
            r1 = 0
            int[] r0 = r4.A03
            if (r0 == 0) goto L33
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto L26;
                case 3: goto L1f;
                case 4: goto Ld;
                case 5: goto L19;
                case 6: goto L36;
                case 7: goto L2f;
                case 8: goto L1c;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.6Z r4 = (com.facebook.ads.redexgen.X.C6Z) r4
            int[] r0 = r4.A03
            r0 = r0[r2]
            if (r0 != r6) goto L17
            r0 = 5
            goto L9
        L17:
            r0 = 7
            goto L9
        L19:
            r3 = 1
            r0 = 6
            goto L9
        L1c:
            r3 = 0
            r0 = 6
            goto L9
        L1f:
            if (r2 >= r1) goto L23
            r0 = 4
            goto L9
        L23:
            r0 = 8
            goto L9
        L26:
            com.facebook.ads.redexgen.X.6Z r4 = (com.facebook.ads.redexgen.X.C6Z) r4
            int r0 = r4.A00
            int r1 = r0 * 2
            r2 = 0
            r0 = 3
            goto L9
        L2f:
            int r2 = r2 + 2
            r0 = 3
            goto L9
        L33:
            r0 = 8
            goto L9
        L36:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C6Z.A05(int):boolean");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0007. Please report as an issue. */
    @Override // com.facebook.ads.redexgen.X.C6Y
    public final void A37(int storagePosition, int i) {
        C6Z c6z = this;
        int i2 = 0;
        char c = storagePosition < 0 ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    throw new IllegalArgumentException(A00(0, 37, 53));
                case 3:
                    c = i < 0 ? (char) 4 : (char) 5;
                case 4:
                    throw new IllegalArgumentException(A00(37, 35, 27));
                case 5:
                    c6z = c6z;
                    i2 = c6z.A00 * 2;
                    c = c6z.A03 == null ? (char) 6 : '\b';
                case 6:
                    c6z = c6z;
                    c6z.A03 = new int[4];
                    Arrays.fill(c6z.A03, -1);
                    c = 7;
                case 7:
                    C6Z c6z2 = c6z;
                    c6z2.A03[i2] = storagePosition;
                    c6z2.A03[i2 + 1] = i;
                    c6z2.A00++;
                    return;
                case '\b':
                    c6z = c6z;
                    c = i2 >= c6z.A03.length ? '\t' : (char) 7;
                case '\t':
                    c6z = c6z;
                    int[] iArr = c6z.A03;
                    c6z.A03 = new int[i2 * 2];
                    System.arraycopy(iArr, 0, c6z.A03, 0, iArr.length);
                    c = 7;
            }
        }
    }
}
