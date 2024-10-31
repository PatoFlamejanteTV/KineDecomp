package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public final class PZ {
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
            byte[] r1 = com.facebook.ads.redexgen.X.PZ.A00
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
            r0 = r0 ^ 96
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PZ.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A00 = new byte[]{33, 14, 4, 18, 15, 9, 4, 33, 32, 51, 44, 38, 32, 26, 40, 42, 33, 32, 41, 8, 20, 25, 1, 25, 26, 20, 29, 39, 22, 25, 21, 29, 113, 103, 113, 113, 107, 109, 108, 93, 107, 102, 61, 33, 13, 36, 55, 32, 23, 20, 24, 26, 23, 30, 65, 81, 64, 87, 87, 92, 109, 69, 91, 86, 70, 90, 8, 24, 9, 30, 30, 21, 36, 19, 30, 18, 28, 19, 15, 6, 23, 23, 56, 9, 6, 10, 2, 19, 8, 17, 8, 23, Byte.MAX_VALUE, 99, 81, 64, 83, 85, 79, 68, 83, 126, 68, 79, 69, 81, 78, 72, 79, 85, 82, 69, 74, 126, 87, 68, 83, 82, 72, 78, 79};
    }

    public static Map<String, String> A01(C0361Eb c0361Eb, String str, String str2) {
        HashMap hashMap = new HashMap();
        C0399Fn c0399Fn = new C0399Fn(c0361Eb);
        int i = c0361Eb.getResources().getDisplayMetrics().widthPixels;
        int i2 = c0361Eb.getResources().getDisplayMetrics().heightPixels;
        hashMap.put(A00(32, 10, 98), c0361Eb.A04().A02());
        hashMap.put(A00(19, 13, 24), str2);
        hashMap.put(A00(94, 16, 65), str);
        hashMap.put(A00(7, 12, 37), String.valueOf(c0399Fn.A08()));
        hashMap.put(A00(54, 12, 82), String.valueOf((int) (i / KE.A01)));
        hashMap.put(A00(66, 13, 27), String.valueOf((int) (i2 / KE.A01)));
        hashMap.put(A00(92, 2, 112), A00(0, 7, 0));
        hashMap.put(A00(42, 6, 50), C0399Fn.A02);
        hashMap.put(A00(48, 6, 27), Locale.getDefault().toString());
        hashMap.put(A00(110, 11, 65), A00(87, 5, 70));
        hashMap.put(A00(79, 8, 7), c0399Fn.A04());
        return hashMap;
    }
}
