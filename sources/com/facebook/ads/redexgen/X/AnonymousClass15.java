package com.facebook.ads.redexgen.X;

import android.content.pm.PackageManager;
import android.text.TextUtils;

/* renamed from: com.facebook.ads.redexgen.X.15, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass15 {
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
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass15.A00
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
            r0 = r0 ^ 66
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass15.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A00 = new byte[]{31, 58, 126, 55, 45, 126, 55, 48, 40, 63, 50, 55, 58, 63, 42, 59, 58, 126, 41, 55, 42, 54, 49, 43, 42, 126, 42, 49, 53, 59, 48, 112, 107, 122, 99};
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x003f, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Collection<java.lang.String> A01(org.json.JSONArray r3) {
        /*
            r2 = 0
            r1 = 0
            if (r3 == 0) goto L3b
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L20;
                case 3: goto L1d;
                case 4: goto L3d;
                case 5: goto L15;
                case 6: goto L9;
                case 7: goto L2c;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            org.json.JSONArray r3 = (org.json.JSONArray) r3
            int r0 = r3.length()
            if (r2 >= r0) goto L13
            r0 = 7
            goto L5
        L13:
            r0 = 4
            goto L5
        L15:
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            r2 = 0
            r0 = 6
            goto L5
        L1d:
            r1 = 0
            r0 = 4
            goto L5
        L20:
            org.json.JSONArray r3 = (org.json.JSONArray) r3
            int r0 = r3.length()
            if (r0 != 0) goto L2a
            r0 = 3
            goto L5
        L2a:
            r0 = 5
            goto L5
        L2c:
            org.json.JSONArray r3 = (org.json.JSONArray) r3
            java.util.HashSet r1 = (java.util.HashSet) r1
            java.lang.String r0 = r3.optString(r2)
            r1.add(r0)
            int r2 = r2 + 1
            r0 = 6
            goto L5
        L3b:
            r0 = 3
            goto L5
        L3d:
            java.util.Collection r1 = (java.util.Collection) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass15.A01(org.json.JSONArray):java.util.Collection");
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x00d5, code lost:            return r0;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A03(com.facebook.ads.redexgen.X.C0362Ec r13, com.facebook.ads.redexgen.X.AnonymousClass14 r14, com.facebook.ads.redexgen.X.InterfaceC0422Gl r15) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass15.A03(com.facebook.ads.redexgen.X.Ec, com.facebook.ads.redexgen.X.14, com.facebook.ads.redexgen.X.Gl):boolean");
    }

    public static boolean A04(C0362Ec c0362Ec, String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            c0362Ec.getPackageManager().getPackageInfo(str, 1);
            z = true;
            return true;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            return z;
        }
    }
}
