package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public final class PH {
    public static byte[] A03;
    public final int A00;
    public final int A01;
    public final C2L A02;

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
            byte[] r1 = com.facebook.ads.redexgen.X.PH.A03
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
            r0 = r0 ^ 20
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PH.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A03 = new byte[]{60, 62, 45, 59, 54, 49, 59, 83, 81, 66, 84, 83, 94, 68};
    }

    public PH(int i, int i2, C2L c2l) {
        this.A01 = i;
        this.A00 = i2;
        this.A02 = c2l;
    }

    public final int A02() {
        return this.A01;
    }

    public final C2L A03() {
        return this.A02;
    }

    public final Map<String, String> A04() {
        HashMap hashMap = new HashMap();
        hashMap.put(A00(0, 7, 75), this.A01 + A00(0, 0, 125));
        hashMap.put(A00(7, 7, 36), this.A00 + A00(0, 0, 125));
        return hashMap;
    }
}
