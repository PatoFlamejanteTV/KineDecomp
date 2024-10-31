package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;

/* renamed from: com.facebook.ads.redexgen.X.7k, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C01907k {
    public static byte[] A02;

    @VisibleForTesting
    public final C4L<C7Z, C01897j> A00 = new C4L<>();

    @VisibleForTesting
    public final C4N<C7Z> A01 = new C4N<>();

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
            byte[] r1 = com.facebook.ads.redexgen.X.C01907k.A02
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
            r0 = r0 ^ 107(0x6b, float:1.5E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01907k.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A02 = new byte[]{110, 86, 80, 87, 3, 83, 81, 76, 85, 74, 71, 70, 3, 69, 79, 66, 68, 3, 115, 113, 102, 3, 76, 81, 3, 115, 108, 112, 119};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000e. Please report as an issue. */
    private C7C A00(C7Z c7z, int i) {
        C01907k c01907k = this;
        C01897j c01897j = null;
        C7C c7c = null;
        int A08 = c01907k.A00.A08(c7z);
        char c = A08 < 0 ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    return c7c;
                case 3:
                    c01907k = c01907k;
                    c01897j = c01907k.A00.A0B(A08);
                    c = c01897j != null ? (char) 4 : (char) 2;
                case 4:
                    c01897j = c01897j;
                    c = (c01897j.A00 & i) != 0 ? (char) 5 : (char) 2;
                case 5:
                    c01897j = c01897j;
                    c01897j.A00 &= i ^ (-1);
                    c = i == 4 ? (char) 6 : '\t';
                case 6:
                    c01897j = c01897j;
                    c7c = c01897j.A02;
                    c = 7;
                case 7:
                    c01897j = c01897j;
                    c = (c01897j.A00 & 12) == 0 ? '\b' : (char) 2;
                case '\b':
                    c01907k = c01907k;
                    c01897j = c01897j;
                    c01907k.A00.A0A(A08);
                    C01897j.A02(c01897j);
                    c = 2;
                case '\t':
                    c = i == 8 ? '\n' : (char) 11;
                case '\n':
                    c01897j = c01897j;
                    c7c = c01897j.A01;
                    c = 7;
                case 11:
                    throw new IllegalArgumentException(A01(0, 29, 72));
            }
        }
    }

    @Nullable
    public final C7C A03(C7Z c7z) {
        return A00(c7z, 8);
    }

    @Nullable
    public final C7C A04(C7Z c7z) {
        return A00(c7z, 4);
    }

    public final C7Z A05(long j) {
        return this.A01.A08(j);
    }

    public final void A06() {
        this.A00.clear();
        this.A01.A09();
    }

    public final void A07() {
        C01897j.A01();
    }

    public final void A08(long j, C7Z c7z) {
        this.A01.A0B(j, c7z);
    }

    public final void A09(C7Z c7z) {
        C01897j c01897j = this.A00.get(c7z);
        if (c01897j == null) {
            c01897j = C01897j.A00();
            this.A00.put(c7z, c01897j);
        }
        c01897j.A00 |= 1;
    }

    public final void A0A(C7Z c7z) {
        C01897j c01897j = this.A00.get(c7z);
        if (c01897j == null) {
            return;
        }
        c01897j.A00 &= -2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x004d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0B(com.facebook.ads.redexgen.X.C7Z r5) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.4N<com.facebook.ads.redexgen.X.7Z> r0 = r3.A01
            int r0 = r0.A06()
            int r1 = r0 + (-1)
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L43;
                case 3: goto L32;
                case 4: goto L10;
                case 5: goto L20;
                case 6: goto L19;
                case 7: goto L4d;
                case 8: goto L49;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.7k r3 = (com.facebook.ads.redexgen.X.C01907k) r3
            com.facebook.ads.redexgen.X.4N<com.facebook.ads.redexgen.X.7Z> r0 = r3.A01
            r0.A0A(r1)
            r0 = 5
            goto Lc
        L19:
            com.facebook.ads.redexgen.X.7j r2 = (com.facebook.ads.redexgen.X.C01897j) r2
            com.facebook.ads.redexgen.X.C01897j.A02(r2)
            r0 = 7
            goto Lc
        L20:
            com.facebook.ads.redexgen.X.7k r3 = (com.facebook.ads.redexgen.X.C01907k) r3
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            com.facebook.ads.redexgen.X.4L<com.facebook.ads.redexgen.X.7Z, com.facebook.ads.redexgen.X.7j> r0 = r3.A00
            java.lang.Object r2 = r0.remove(r5)
            com.facebook.ads.redexgen.X.7j r2 = (com.facebook.ads.redexgen.X.C01897j) r2
            if (r2 == 0) goto L30
            r0 = 6
            goto Lc
        L30:
            r0 = 7
            goto Lc
        L32:
            com.facebook.ads.redexgen.X.7k r3 = (com.facebook.ads.redexgen.X.C01907k) r3
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            com.facebook.ads.redexgen.X.4N<com.facebook.ads.redexgen.X.7Z> r0 = r3.A01
            java.lang.Object r0 = r0.A07(r1)
            if (r5 != r0) goto L40
            r0 = 4
            goto Lc
        L40:
            r0 = 8
            goto Lc
        L43:
            if (r1 < 0) goto L47
            r0 = 3
            goto Lc
        L47:
            r0 = 5
            goto Lc
        L49:
            int r1 = r1 + (-1)
            r0 = 2
            goto Lc
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01907k.A0B(com.facebook.ads.redexgen.X.7Z):void");
    }

    public final void A0C(C7Z c7z) {
        A0A(c7z);
    }

    public final void A0D(C7Z c7z, C7C c7c) {
        C01897j c01897j = this.A00.get(c7z);
        if (c01897j == null) {
            c01897j = C01897j.A00();
            this.A00.put(c7z, c01897j);
        }
        c01897j.A00 |= 2;
        c01897j.A02 = c7c;
    }

    public final void A0E(C7Z c7z, C7C c7c) {
        C01897j c01897j = this.A00.get(c7z);
        if (c01897j == null) {
            c01897j = C01897j.A00();
            this.A00.put(c7z, c01897j);
        }
        c01897j.A01 = c7c;
        c01897j.A00 |= 8;
    }

    public final void A0F(C7Z c7z, C7C c7c) {
        C01897j c01897j = this.A00.get(c7z);
        if (c01897j == null) {
            c01897j = C01897j.A00();
            this.A00.put(c7z, c01897j);
        }
        c01897j.A02 = c7c;
        c01897j.A00 |= 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x00f8, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0G(com.facebook.ads.redexgen.X.AnonymousClass72 r7) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01907k.A0G(com.facebook.ads.redexgen.X.72):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0025, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0H(com.facebook.ads.redexgen.X.C7Z r4) {
        /*
            r3 = this;
            r2 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.4L<com.facebook.ads.redexgen.X.7Z, com.facebook.ads.redexgen.X.7j> r0 = r3.A00
            java.lang.Object r1 = r0.get(r4)
            com.facebook.ads.redexgen.X.7j r1 = (com.facebook.ads.redexgen.X.C01897j) r1
            if (r1 == 0) goto L23
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L1d;
                case 4: goto L25;
                case 5: goto L20;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.7j r1 = (com.facebook.ads.redexgen.X.C01897j) r1
            int r0 = r1.A00
            r0 = r0 & 1
            if (r0 == 0) goto L1b
            r0 = 3
            goto Ld
        L1b:
            r0 = 5
            goto Ld
        L1d:
            r2 = 1
            r0 = 4
            goto Ld
        L20:
            r2 = 0
            r0 = 4
            goto Ld
        L23:
            r0 = 5
            goto Ld
        L25:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01907k.A0H(com.facebook.ads.redexgen.X.7Z):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0025, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0I(com.facebook.ads.redexgen.X.C7Z r4) {
        /*
            r3 = this;
            r2 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.4L<com.facebook.ads.redexgen.X.7Z, com.facebook.ads.redexgen.X.7j> r0 = r3.A00
            java.lang.Object r1 = r0.get(r4)
            com.facebook.ads.redexgen.X.7j r1 = (com.facebook.ads.redexgen.X.C01897j) r1
            if (r1 == 0) goto L23
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L1d;
                case 4: goto L25;
                case 5: goto L20;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.7j r1 = (com.facebook.ads.redexgen.X.C01897j) r1
            int r0 = r1.A00
            r0 = r0 & 4
            if (r0 == 0) goto L1b
            r0 = 3
            goto Ld
        L1b:
            r0 = 5
            goto Ld
        L1d:
            r2 = 1
            r0 = 4
            goto Ld
        L20:
            r2 = 0
            r0 = 4
            goto Ld
        L23:
            r0 = 5
            goto Ld
        L25:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01907k.A0I(com.facebook.ads.redexgen.X.7Z):boolean");
    }
}
