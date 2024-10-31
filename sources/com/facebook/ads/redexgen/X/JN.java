package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public final class JN {
    public static boolean A00;
    public static boolean A01;
    public static byte[] A02;
    public static final Map<String, String> A03;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.JN.A02
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
            r0 = r0 ^ 93
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JN.A00(int, int, int):java.lang.String");
    }

    public static void A03() {
        A02 = new byte[]{63, 59, 119, 60, 107, 60, 119, 5, 1, 77, 17, 22, 13, 13, 10, 13, 4, 60, 6, 81, 6, 6, 0, 7, 23};
    }

    static {
        A03();
        A01 = false;
        A00 = false;
        A03 = Collections.synchronizedMap(new HashMap());
    }

    @Nullable
    public static synchronized String A01(String str) {
        String property;
        synchronized (JN.class) {
            if (A04()) {
                property = System.getProperty(A00(0, 7, 4) + str);
            } else {
                property = null;
            }
        }
        return property;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001c, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.String> A02() {
        /*
            r1 = 0
            boolean r0 = A04()
            if (r0 != 0) goto L16
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L18;
                case 4: goto L12;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            java.util.Map r1 = java.util.Collections.emptyMap()
            r0 = 3
            goto L8
        L12:
            java.util.Map<java.lang.String, java.lang.String> r1 = com.facebook.ads.redexgen.X.JN.A03
            r0 = 3
            goto L8
        L16:
            r0 = 4
            goto L8
        L18:
            java.util.Map r1 = (java.util.Map) r1
            java.util.Map r1 = (java.util.Map) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JN.A02():java.util.Map");
    }

    public static synchronized boolean A04() {
        boolean z;
        synchronized (JN.class) {
            if (!A00) {
                A01 = A00(21, 4, 47).equals(System.getProperty(A00(7, 14, 62)));
                A00 = true;
            }
            z = A01;
        }
        return z;
    }

    public static synchronized boolean A05(String str) {
        boolean z;
        synchronized (JN.class) {
            z = !TextUtils.isEmpty(A01(str));
        }
        return z;
    }
}
