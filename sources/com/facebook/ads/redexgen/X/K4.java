package com.facebook.ads.redexgen.X;

import android.support.annotation.VisibleForTesting;
import android.util.Log;
import java.util.Locale;

/* loaded from: assets/audience_network.dex */
public final class K4 {
    public static byte[] A00;

    @VisibleForTesting
    public static final K3 A01 = null;

    static {
        A07();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.K4.A00
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
            int r0 = r0 + (-23)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.K4.A03(int, int, int):java.lang.String");
    }

    public static void A07() {
        A00 = new byte[]{-116, -86, -73, 112, -67, 105, -81, -72, -69, -74, -86, -67, 105, -67, -78, -74, -82, 119, 123, -124, -119, -68, -80, -83, -79, -78, -77};
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001b, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long A00() {
        /*
            r1 = 0
            com.facebook.ads.redexgen.X.K3 r0 = com.facebook.ads.redexgen.X.K4.A01
            if (r0 == 0) goto L19
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1b;
                case 4: goto L13;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.K3 r0 = com.facebook.ads.redexgen.X.K4.A01
            long r1 = r0.currentTimeMillis()
            r0 = 3
            goto L7
        L13:
            long r1 = java.lang.System.currentTimeMillis()
            r0 = 3
            goto L7
        L19:
            r0 = 4
            goto L7
        L1b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.K4.A00():long");
    }

    public static long A01(long j) {
        if (j == -1) {
            return -1L;
        }
        return System.currentTimeMillis() - j;
    }

    public static String A02(double d) {
        try {
            return String.format(Locale.US, A03(18, 4, 63), Double.valueOf(d));
        } catch (Exception e) {
            Log.e(K4.class.getSimpleName(), A03(0, 18, 50), e);
            return A03(22, 5, 104);
        }
    }

    public static String A04(long j) {
        return String.valueOf(A01(j));
    }

    @Deprecated
    public static String A05(long j) {
        return A02(j / 1000.0d);
    }

    public static String A06(long j) {
        return Long.toString(j);
    }
}
