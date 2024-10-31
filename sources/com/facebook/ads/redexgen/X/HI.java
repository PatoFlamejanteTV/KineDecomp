package com.facebook.ads.redexgen.X;

import com.facebook.ads.NativeAdBase;

/* loaded from: assets/audience_network.dex */
public enum HI {
    A05(0, NativeAdBase.MediaCacheFlag.NONE),
    A04(1, NativeAdBase.MediaCacheFlag.ALL);

    public static byte[] A02;
    public final long A00;
    public final NativeAdBase.MediaCacheFlag A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.HI.A02
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
            r0 = r0 ^ 119(0x77, float:1.67E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HI.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A02 = new byte[]{80, 81, 80, 91, 85, 88, 88};
    }

    static {
        A02();
    }

    HI(long j, NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        this.A00 = j;
        this.A01 = mediaCacheFlag;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x002c, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.HI A00(com.facebook.ads.NativeAdBase.MediaCacheFlag r5) {
        /*
            r4 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.HI[] r3 = values()
            int r2 = r3.length
            r1 = 0
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L15;
                case 4: goto L2a;
                case 5: goto L23;
                case 6: goto L27;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            if (r1 >= r2) goto L13
            r0 = 3
            goto Lb
        L13:
            r0 = 6
            goto Lb
        L15:
            com.facebook.ads.NativeAdBase$MediaCacheFlag r5 = (com.facebook.ads.NativeAdBase.MediaCacheFlag) r5
            com.facebook.ads.redexgen.X.HI[] r3 = (com.facebook.ads.redexgen.X.HI[]) r3
            r4 = r3[r1]
            com.facebook.ads.NativeAdBase$MediaCacheFlag r0 = r4.A01
            if (r0 != r5) goto L21
            r0 = 4
            goto Lb
        L21:
            r0 = 5
            goto Lb
        L23:
            int r1 = r1 + 1
            r0 = 2
            goto Lb
        L27:
            r4 = 0
            r0 = 4
            goto Lb
        L2a:
            com.facebook.ads.redexgen.X.HI r4 = (com.facebook.ads.redexgen.X.HI) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HI.A00(com.facebook.ads.NativeAdBase$MediaCacheFlag):com.facebook.ads.redexgen.X.HI");
    }
}
