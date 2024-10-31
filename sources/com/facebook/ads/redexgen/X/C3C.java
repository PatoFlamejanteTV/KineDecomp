package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.3C, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C3C {
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
            byte[] r1 = com.facebook.ads.redexgen.X.C3C.A00
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
            r0 = r0 ^ 85
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3C.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A00 = new byte[]{0, 1, 31, 12, 26, 29, 7, 22, 20, 1, 18, 7, 26, 28, 29, 12, 22, 1, 1, 28, 1, 12, 30, 28, 23, 22, 12, 24, 22, 10};
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x003c, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.AdSettings.IntegrationErrorMode A00(com.facebook.ads.redexgen.X.C0362Ec r4) {
        /*
            r0 = 0
            com.facebook.ads.internal.settings.MultithreadedBundleWrapper r3 = com.facebook.ads.internal.settings.AdInternalSettings.sSettingsBundle
            r2 = 0
            r1 = 30
            r0 = 6
            java.lang.String r0 = A01(r2, r1, r0)
            java.io.Serializable r1 = r3.getSerializable(r0)
            com.facebook.ads.AdSettings$IntegrationErrorMode r1 = (com.facebook.ads.AdSettings.IntegrationErrorMode) r1
            if (r1 != 0) goto L36
            r0 = 2
        L14:
            switch(r0) {
                case 2: goto L18;
                case 3: goto L1c;
                case 4: goto L26;
                case 5: goto L32;
                case 6: goto L38;
                default: goto L17;
            }
        L17:
            goto L14
        L18:
            com.facebook.ads.AdSettings$IntegrationErrorMode r1 = com.facebook.ads.AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE
            r0 = 3
            goto L14
        L1c:
            com.facebook.ads.AdSettings$IntegrationErrorMode r1 = (com.facebook.ads.AdSettings.IntegrationErrorMode) r1
            com.facebook.ads.AdSettings$IntegrationErrorMode r0 = com.facebook.ads.AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE
            if (r1 != r0) goto L24
            r0 = 4
            goto L14
        L24:
            r0 = 6
            goto L14
        L26:
            com.facebook.ads.redexgen.X.Ec r4 = (com.facebook.ads.redexgen.X.C0362Ec) r4
            boolean r0 = A03(r4)
            if (r0 != 0) goto L30
            r0 = 5
            goto L14
        L30:
            r0 = 6
            goto L14
        L32:
            com.facebook.ads.AdSettings$IntegrationErrorMode r1 = com.facebook.ads.AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CALLBACK_MODE
            r0 = 6
            goto L14
        L36:
            r0 = 3
            goto L14
        L38:
            com.facebook.ads.AdSettings$IntegrationErrorMode r1 = (com.facebook.ads.AdSettings.IntegrationErrorMode) r1
            com.facebook.ads.AdSettings$IntegrationErrorMode r1 = (com.facebook.ads.AdSettings.IntegrationErrorMode) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3C.A00(com.facebook.ads.redexgen.X.Ec):com.facebook.ads.AdSettings$IntegrationErrorMode");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A03(com.facebook.ads.redexgen.X.C0362Ec r2) {
        /*
            r1 = 0
            android.content.pm.ApplicationInfo r0 = r2.getApplicationInfo()
            int r0 = r0.flags
            r0 = r0 & 2
            if (r0 == 0) goto L16
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L18;
                case 4: goto L13;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            r1 = 1
            r0 = 3
            goto Lc
        L13:
            r1 = 0
            r0 = 3
            goto Lc
        L16:
            r0 = 4
            goto Lc
        L18:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3C.A03(com.facebook.ads.redexgen.X.Ec):boolean");
    }
}
