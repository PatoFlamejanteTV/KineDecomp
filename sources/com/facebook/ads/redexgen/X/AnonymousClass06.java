package com.facebook.ads.redexgen.X;

import java.util.Locale;

/* renamed from: com.facebook.ads.redexgen.X.06, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public enum AnonymousClass06 {
    A03(A01(4, 4, 67)),
    A04(A01(35, 4, 120));

    public static byte[] A01;
    public String A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass06.A01
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
            int r0 = r0 + (-68)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass06.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A01 = new byte[]{3, -3, -3, 8, -19, -4, -13, -13, -56, -19, -11, -32, -21, -24, -29, -97, -14, -28, -15, -11, -28, -15, -97, -15, -28, -14, -17, -18, -19, -14, -28, -71, -97, -92, -14, 39, 33, 33, 44, -112, -97, -106, -106};
    }

    static {
        A02();
    }

    AnonymousClass06(String str) {
        this.A00 = str;
    }

    public static AnonymousClass06 A00(String str) {
        AnonymousClass06 anonymousClass06 = null;
        int i = 0;
        AnonymousClass06[] values = values();
        int length = values.length;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    if (i >= length) {
                        c = 6;
                        break;
                    } else {
                        c = 3;
                        break;
                    }
                case 3:
                    str = str;
                    values = values;
                    anonymousClass06 = values[i];
                    if (!anonymousClass06.A00.equals(str)) {
                        c = 5;
                        break;
                    } else {
                        c = 4;
                        break;
                    }
                case 4:
                    return anonymousClass06;
                case 5:
                    i++;
                    c = 2;
                    break;
                case 6:
                    throw new IllegalArgumentException(String.format(Locale.US, A01(8, 27, 59), str));
            }
        }
    }
}
