package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Le, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0540Le {
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
            byte[] r1 = com.facebook.ads.redexgen.X.C0540Le.A00
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
            r0 = r0 ^ 59
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0540Le.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A00 = new byte[]{19, 23, 20, 32, 49, 60, 48, 59, 54, 48, 27, 48, 33, 34, 58, 39, 62, 67, 76, 89, 68, 91, 72, 114, 89, 72, 64, 93, 65, 76, 89, 72, 43, 12, 4, 1, 77, 25, 2, 77, 31, 8, 3, 9, 8, 31, 77, 35, 12, 25, 4, 27, 8, 77, 25, 8, 0, 29, 1, 12, 25, 8, 67, 77, 40, 0, 29, 25, 20, 77, 44, 3, 9, 31, 2, 4, 9, 77, 59, 4, 8, 26, 77, 26, 4, 1, 1, 77, 15, 8, 77, 31, 8, 25, 24, 31, 3, 8, 9, 67};
    }

    public static View A00(C0362Ec c0362Ec, Throwable th) {
        A03(c0362Ec, th);
        return new View(c0362Ec);
    }

    public static void A03(C0362Ec c0362Ec, Throwable th) {
        C0511Kb.A06(c0362Ec, A01(17, 15, 22), C0512Kc.A1P, new C0514Ke(th));
        Log.e(A01(0, 17, 110), A01(32, 68, 86), th);
    }
}
