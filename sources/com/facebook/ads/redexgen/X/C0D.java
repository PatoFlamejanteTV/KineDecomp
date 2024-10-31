package com.facebook.ads.redexgen.X;

import android.text.TextUtils;

/* renamed from: com.facebook.ads.redexgen.X.0D, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C0D {
    public static byte[] A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C0D.A00
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
            int r0 = r0 + (-90)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0D.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A00 = new byte[]{-52};
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x004a, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String A01(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            r2 = 0
            r0 = 0
            r0 = 46
            int r4 = r6.lastIndexOf(r0)
            r0 = 47
            int r3 = r6.lastIndexOf(r0)
            r0 = -1
            if (r4 == r0) goto L44
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L17;
                case 3: goto L1d;
                case 4: goto L2d;
                case 5: goto L46;
                case 6: goto L3b;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            if (r4 <= r3) goto L1b
            r0 = 3
            goto L13
        L1b:
            r0 = 6
            goto L13
        L1d:
            java.lang.String r6 = (java.lang.String) r6
            int r0 = r4 + 2
            int r1 = r0 + 4
            int r0 = r6.length()
            if (r1 <= r0) goto L2b
            r0 = 4
            goto L13
        L2b:
            r0 = 6
            goto L13
        L2d:
            java.lang.String r6 = (java.lang.String) r6
            int r1 = r4 + 1
            int r0 = r6.length()
            java.lang.String r2 = r6.substring(r1, r0)
            r0 = 5
            goto L13
        L3b:
            r2 = 0
            r1 = 0
            r0 = 4
            java.lang.String r2 = A00(r2, r1, r0)
            r0 = 5
            goto L13
        L44:
            r0 = 6
            goto L13
        L46:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = (java.lang.String) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0D.A01(java.lang.String):java.lang.String");
    }

    public final String A03(String str) {
        String A01 = A01(str);
        String A02 = C0Q.A02(str);
        return TextUtils.isEmpty(A01) ? A02 : A02 + A00(0, 1, 68) + A01;
    }
}
