package com.facebook.ads.redexgen.X;

import android.text.TextUtils;

/* loaded from: assets/audience_network.dex */
public final class IW {
    public static byte[] A00;

    static {
        A06();
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
            byte[] r1 = com.facebook.ads.redexgen.X.IW.A00
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
            r0 = r0 ^ 57
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IW.A02(int, int, int):java.lang.String");
    }

    public static void A06() {
        A00 = new byte[]{77, 81, 81, 85, 86, 31, 10, 10, 82, 82, 82, 11, 0, 86, 11, 67, 68, 70, 64, 71, 74, 74, 78, 11, 70, 74, 72, 10, 68, 65, 75, 82, 122, 73, 74, 66, 66, 76, 75, 66, 10, 105, 117, 117, 113, 114, 59, 46, 46, 102, 115, 96, 113, 105, 47, 103, 96, 98, 100, 99, 110, 110, 106, 47, 98, 110, 108, 46, 111, 100, 117, 118, 110, 115, 106, 94, 96, 101, 114, 94, 98, 110, 108, 108, 110, 111, 56, 36, 36, 32, 35, 106, Byte.MAX_VALUE, Byte.MAX_VALUE, 39, 39, 39, 126, 54, 49, 51, 53, 50, 63, 63, 59, 126, 51, 63, 61, Byte.MAX_VALUE, 49, 52, 62, 39, 15, 60, 63, 55, 55, 57, 62, 55, Byte.MAX_VALUE, 43, 55, 55, 51, 48, 121, 108, 108, 52, 52, 52, 109, 37, 34, 32, 38, 33, 44, 44, 40, 109, 32, 44, 46, 108, 34, 39, 45, 52, 28, 48, 58, 45, 32, 22, 10, 10, 14, 13, 68, 81, 81, 25, 12, 31, 14, 22, 80, 24, 31, 29, 27, 28, 17, 17, 21, 80, 29, 17, 19, 81, 72, 71, 77, 71, 75, 77, 71, 74, 78, 71, 71, 73, 71, 78, 79, 81, 28, 11, 25, 13, 117, 105, 105, 109, 110, 39, 50, 50, 122, 111, 124, 109, 117, 51, 56, 110, 51, 123, 124, 126, 120, Byte.MAX_VALUE, 114, 114, 118, 51, 126, 114, 112, 50, 115, 120, 105, 106, 114, 111, 118, 66, 124, 121, 110, 66, 126, 114, 112, 112, 114, 115, 39, 59, 59, 63, 60, 117, 96, 96, 56, 56, 56, 97, 106, 60, 97, 41, 46, 44, 42, 45, 32, 32, 36, 97, 44, 32, 34, 96, 46, 43, 33, 56, 16, 60, 54, 33, 44, 84, 84, 84, 67, 95, 95, 91, 88, 17, 4, 4, 76, 89, 74, 91, 67, 5, 14, 88, 5, 77, 74, 72, 78, 73, 68, 68, 64, 5, 72, 68, 70, 4, 29, 18, 24, 18, 30, 24, 18, 31, 27, 18, 18, 28, 18, 27, 26, 4, 73, 94, 76, 88};
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00() {
        /*
            r0 = 0
            r1 = 0
            java.lang.String r4 = com.facebook.ads.internal.settings.AdInternalSettings.getUrlPrefix()
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L37
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L39;
                case 4: goto L1d;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            r2 = 41
            r1 = 45
            r0 = 56
            java.lang.String r1 = A02(r2, r1, r0)
            r0 = 3
            goto Ld
        L1d:
            java.lang.String r4 = (java.lang.String) r4
            java.util.Locale r3 = java.util.Locale.US
            r2 = 205(0xcd, float:2.87E-43)
            r1 = 48
            r0 = 36
            java.lang.String r2 = A02(r2, r1, r0)
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r0 = 0
            r1[r0] = r4
            java.lang.String r1 = java.lang.String.format(r3, r2, r1)
            r0 = 3
            goto Ld
        L37:
            r0 = 4
            goto Ld
        L39:
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IW.A00():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01() {
        /*
            r0 = 0
            r1 = 0
            java.lang.String r4 = com.facebook.ads.internal.settings.AdInternalSettings.getUrlPrefix()
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L37
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L39;
                case 4: goto L1d;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            r2 = 158(0x9e, float:2.21E-43)
            r1 = 47
            r0 = 71
            java.lang.String r1 = A02(r2, r1, r0)
            r0 = 3
            goto Ld
        L1d:
            java.lang.String r4 = (java.lang.String) r4
            java.util.Locale r3 = java.util.Locale.US
            r2 = 293(0x125, float:4.1E-43)
            r1 = 50
            r0 = 18
            java.lang.String r2 = A02(r2, r1, r0)
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r0 = 0
            r1[r0] = r4
            java.lang.String r1 = java.lang.String.format(r3, r2, r1)
            r0 = 3
            goto Ld
        L37:
            r0 = 4
            goto Ld
        L39:
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IW.A01():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:            r0 = com.facebook.ads.redexgen.X.C0413Gc.A0K(r5);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0046, code lost:            return A05(r1, r0);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(com.facebook.ads.redexgen.X.C0361Eb r5) {
        /*
            r0 = 0
            r1 = 0
            java.lang.String r4 = com.facebook.ads.internal.settings.AdInternalSettings.getUrlPrefix()
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L36
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L38;
                case 4: goto L1d;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            r2 = 86
            r1 = 38
            r0 = 105(0x69, float:1.47E-43)
            java.lang.String r1 = A02(r2, r1, r0)
            r0 = 3
            goto Ld
        L1d:
            java.lang.String r4 = (java.lang.String) r4
            java.util.Locale r3 = java.util.Locale.US
            r2 = 0
            r1 = 41
            r0 = 28
            java.lang.String r2 = A02(r2, r1, r0)
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r0 = 0
            r1[r0] = r4
            java.lang.String r1 = java.lang.String.format(r3, r2, r1)
            r0 = 3
            goto Ld
        L36:
            r0 = 4
            goto Ld
        L38:
            com.facebook.ads.redexgen.X.Eb r5 = (com.facebook.ads.redexgen.X.C0361Eb) r5
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r0 = com.facebook.ads.redexgen.X.C0413Gc.A0K(r5)
            java.lang.String r0 = A05(r1, r0)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IW.A03(com.facebook.ads.redexgen.X.Eb):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:            r0 = com.facebook.ads.redexgen.X.C0413Gc.A0L(r5);        r0 = A05(r1, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:            return r0;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A04(com.facebook.ads.redexgen.X.C0361Eb r5) {
        /*
            r0 = 0
            r1 = 0
            java.lang.String r4 = com.facebook.ads.internal.settings.AdInternalSettings.getUrlPrefix()
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L37
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L39;
                case 4: goto L1d;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            r2 = 124(0x7c, float:1.74E-43)
            r1 = 34
            r0 = 122(0x7a, float:1.71E-43)
            java.lang.String r1 = A02(r2, r1, r0)
            r0 = 3
            goto Ld
        L1d:
            java.lang.String r4 = (java.lang.String) r4
            java.util.Locale r3 = java.util.Locale.US
            r2 = 253(0xfd, float:3.55E-43)
            r1 = 37
            r0 = 118(0x76, float:1.65E-43)
            java.lang.String r2 = A02(r2, r1, r0)
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r0 = 0
            r1[r0] = r4
            java.lang.String r1 = java.lang.String.format(r3, r2, r1)
            r0 = 3
            goto Ld
        L37:
            r0 = 4
            goto Ld
        L39:
            com.facebook.ads.redexgen.X.Eb r5 = (com.facebook.ads.redexgen.X.C0361Eb) r5
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r0 = com.facebook.ads.redexgen.X.C0413Gc.A0L(r5)
            java.lang.String r0 = A05(r1, r0)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IW.A04(com.facebook.ads.redexgen.X.Eb):java.lang.String");
    }

    public static String A05(String str, String str2) {
        return TextUtils.isEmpty(str2) ? str : str.replace(A02(290, 3, 26), str2);
    }
}
