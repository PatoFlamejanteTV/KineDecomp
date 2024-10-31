package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public final class N7 {
    public static byte[] A08;
    public final long A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final String A07;

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
            byte[] r1 = com.facebook.ads.redexgen.X.N7.A08
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
            int r0 = r0 + (-32)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.N7.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A08 = new byte[]{-111, -106, -111, -100, -111, -119, -108, -121, -99, -102, -108, -62, -51, -53, -67, -63, -51, -52, -46, -61, -52, -46, -67, -54, -51, -65, -62, -61, -62, -67, -53, -47, -26, -23, -37, -34, -39, -32, -29, -24, -29, -19, -30, -39, -25, -19, -79, -92, -78, -81, -82, -83, -78, -92, -98, -92, -83, -93, -98, -84, -78, -63, -60, -74, -71, -76, -56, -55, -74, -57, -55, -76, -62, -56, -71, -78, -65, -75, -67, -74, -61, -80, -59, -70, -66, -74, -80, -66, -60, 14, -2, 13, 10, 7, 7, -6, 13, 0, -4, -1, 20, -6, 8, 14, -29, -43, -29, -29, -39, -33, -34, -49, -42, -39, -34, -39, -29, -40, -49, -35, -29};
    }

    public N7(String str, long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.A07 = str;
        this.A01 = j;
        this.A03 = j2;
        this.A04 = j3;
        this.A00 = j4;
        this.A05 = j5;
        this.A02 = j6;
        this.A06 = j7;
    }

    public final Map<String, String> A02() {
        HashMap hashMap = new HashMap(7);
        hashMap.put(A00(0, 11, 8), this.A07);
        hashMap.put(A00(74, 15, 49), String.valueOf(this.A01));
        hashMap.put(A00(61, 13, 53), String.valueOf(this.A03));
        hashMap.put(A00(46, 15, 31), String.valueOf(this.A04));
        hashMap.put(A00(11, 21, 62), String.valueOf(this.A00));
        hashMap.put(A00(89, 15, 123), String.valueOf(this.A05));
        hashMap.put(A00(32, 14, 90), String.valueOf(this.A02));
        hashMap.put(A00(104, 17, 80), String.valueOf(this.A06));
        return hashMap;
    }
}
