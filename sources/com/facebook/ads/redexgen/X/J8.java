package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;

/* loaded from: assets/audience_network.dex */
public final class J8 extends J5 {
    public static byte[] A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.J8.A00
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
            r0 = r0 ^ 64
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.J8.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A00 = new byte[]{9, 24, 24, 4, 1, 11, 9, 28, 1, 7, 6, 71, 16, 69, 31, 31, 31, 69, 14, 7, 26, 5, 69, 29, 26, 4, 13, 6, 11, 7, 12, 13, 12, 83, 11, 0, 9, 26, 27, 13, 28, 85, 61, 60, 46, 69, 80};
    }

    public J8(String str, JC jc) {
        super(str, null);
        this.A00 = J7.A05;
        this.A02 = str;
        this.A01 = A01(0, 47, 40);
        if (jc != null) {
            this.A03 = jc.A08();
        }
    }

    public J8(String str, @Nullable JC jc, String str2, byte[] bArr) {
        super(str, jc);
        this.A00 = J7.A05;
        this.A01 = str2;
        this.A03 = bArr;
    }
}
