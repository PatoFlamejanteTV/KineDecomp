package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.HashMap;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public final class GK {
    public static HashMap<String, String> A00;
    public static byte[] A01;

    static {
        A03();
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
            byte[] r1 = com.facebook.ads.redexgen.X.GK.A01
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
            int r0 = r0 + (-106)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GK.A00(int, int, int):java.lang.String");
    }

    public static void A03() {
        A01 = new byte[]{-23, 22, 12, 26, 23, 17, 12, -63, -77, -63, -63, -73, -67, -68, -51, -73, -78, 41, 56, 56, 62, 45, 58, 59, 33, 37, 2, -13, -6, -39, -26, -36, -22, -25, -31, -36, 11, 30, 23, 13, 21, 14, -69, -54, -54, -56, -69, -57, -65, -20, -5, -5, -19, 0, -12, -9, -17, -20, -35, -28, -8, -17, -34, -21, -20, -30, -24, -25, -40, -36, -33, -50, -37, -36, 42, 44, 33, 34, 41};
    }

    public static synchronized Map<String, String> A01(C0361Eb c0361Eb) {
        HashMap hashMap;
        synchronized (GK.class) {
            if (A00 != null) {
                hashMap = new HashMap(A00);
            } else {
                A00 = new HashMap<>();
                A00.put(A00(36, 6, 95), c0361Eb.getPackageName());
                A02(c0361Eb, A00);
                hashMap = new HashMap(A00);
            }
        }
        return hashMap;
    }

    public static synchronized Map<String, String> A02(C0361Eb c0361Eb, Map<String, String> map) {
        synchronized (GK.class) {
            map.put(A00(26, 3, 69), A00(29, 7, 14));
            map.put(A00(57, 11, 47), BuildConfigApi.getVersionName(c0361Eb));
            map.put(A00(24, 2, 104), A00(0, 7, 62));
            map.put(A00(68, 6, 31), C0399Fn.A02);
            C0399Fn c0399Fn = new C0399Fn(c0361Eb);
            map.put(A00(17, 7, 126), c0399Fn.A05());
            map.put(A00(42, 7, 16), c0399Fn.A04());
            map.put(A00(49, 8, 65), String.valueOf(c0399Fn.A03()));
            map.put(A00(74, 5, 115), c0399Fn.A09());
            map.put(A00(7, 10, 4), c0361Eb.A04().A02());
        }
        return map;
    }
}
