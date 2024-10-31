package com.facebook.ads.redexgen.X;

import com.facebook.ads.NativeAdBase;

/* renamed from: com.facebook.ads.redexgen.X.9A, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C9A implements C3K {
    public static byte[] A03;
    public AnonymousClass96 A00;
    public C0362Ec A01;
    public final NativeAdBase.MediaCacheFlag A02;

    static {
        A03();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C9A.A03
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
            r0 = r0 ^ 41
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C9A.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A03 = new byte[]{108, 119, 114, 119, 118, 110, 119, 103, 104, 125, 96, Byte.MAX_VALUE, 108};
    }

    public C9A(AnonymousClass96 anonymousClass96, C0362Ec c0362Ec, NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        this.A00 = anonymousClass96;
        this.A01 = c0362Ec;
        this.A02 = mediaCacheFlag;
    }

    @Override // com.facebook.ads.redexgen.X.C3K
    public final void A6Y(final C0453Hr c0453Hr) {
        C0465If.A00(new AbstractRunnableC00491u() { // from class: com.facebook.ads.redexgen.X.97
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00491u
            public final void A01() {
                AnonymousClass96 anonymousClass96;
                AnonymousClass96 anonymousClass962;
                anonymousClass96 = C9A.this.A00;
                if (anonymousClass96.A02() == null) {
                    return;
                }
                anonymousClass962 = C9A.this.A00;
                anonymousClass962.A02().onAdError(C0453Hr.A00(c0453Hr));
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0116, code lost:            r2.A0P(new com.facebook.ads.redexgen.X.AnonymousClass99(r3, r15), new com.facebook.ads.redexgen.X.EP(r1, A02(7, 6, 32)));     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0133, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C3K
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A79(java.util.List<com.facebook.ads.redexgen.X.C00371i> r15) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C9A.A79(java.util.List):void");
    }
}
