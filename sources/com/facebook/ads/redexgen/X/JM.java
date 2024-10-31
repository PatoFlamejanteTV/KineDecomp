package com.facebook.ads.redexgen.X;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.facebook.ads.internal.util.activity.AdActivityIntent;

/* loaded from: assets/audience_network.dex */
public final class JM {
    public static byte[] A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.JM.A00
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
            int r0 = r0 + (-52)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JM.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A00 = new byte[]{-33, -40, -27, -37, -29, -36, -23, -53, -32, -28, -36, -59, -29, -16, -87, -10, -94, -11, -10, -29, -12, -10, -94, -61, -9, -26, -21, -25, -16, -27, -25, -48, -25, -10, -7, -15, -12, -19, -61, -27, -10, -21, -8, -21, -10, -5, -80, -94, -49, -29, -19, -25, -94, -11, -9, -12, -25, -94, -10, -22, -29, -10, -94, -21, -10, -87, -11, -94, -21, -16, -94, -5, -15, -9, -12, -94, -61, -16, -26, -12, -15, -21, -26, -49, -29, -16, -21, -24, -25, -11, -10, -80, -6, -17, -18, -94, -24, -21, -18, -25, -80, -119, -123, -124, -72, -89, -84, -88, -79, -90, -88, -111, -88, -73, -70, -78, -75, -82, -100, -87, -102, -100, -98, -81, -92, -79, -92, -81, -76, -81, -94, -98, -80, -115, -78, -87, -98, -72, -60, -60, -64, -61, 20, 16, 5, 29, -46, 11, 19, 19, 11, 16, 9, -46, 7, 19, 17, -98, -86, -86, -90, -98, -85, -95, -81, -84, -90, -95, 107, -90, -85, -79, -94, -85, -79, 107, -96, -98, -79, -94, -92, -84, -81, -74, 107, Byte.MAX_VALUE, -113, -116, -108, -112, 126, Byte.MAX_VALUE, -119, -126, -32, -44, -27, -34, -40, -25, 1, 16, 3, -1, 18, 3, -3, 12, 3, 21, -3, 18, -1, 0, -54, -42, -42, -46, -100, -111, -111, -46, -50, -61, -37, -112, -55, -47, -47, -55, -50, -57, -112, -59, -47, -49, -111, -43, -42, -47, -44, -57, -111, -61, -46, -46, -43, -111, -68, -52, -55, -47, -51, -65, -52, -81, -84, -90, -62, -49, -59, -45, -48, -54, -59, -113, -54, -49, -43, -58, -49, -43, -113, -62, -60, -43, -54, -48, -49, -113, -73, -86, -90, -72, 1, 10, 7, 3, 12, 18, -14, 13, 9, 3, 12, -81, -69, -71, 122, -83, -70, -80, -66, -69, -75, -80, 122, -82, -66, -69, -61, -65, -79, -66, 122, -83, -68, -68, -72, -75, -81, -83, -64, -75, -69, -70, -85, -75, -80, -90, -78, -80, 113, -92, -79, -89, -75, -78, -84, -89, 113, -71, -88, -79, -89, -84, -79, -86};
    }

    private Intent A00(Uri uri) {
        Intent intent = new Intent(A02(258, 26, 45), uri);
        intent.setComponent(null);
        if (Build.VERSION.SDK_INT >= 15) {
            intent.setSelector(null);
        }
        return intent;
    }

    private Intent A01(C0362Ec c0362Ec, Uri uri) {
        Intent A002 = A00(uri);
        A002.addCategory(A02(161, 33, 9));
        A002.addFlags(268435456);
        A002.putExtra(A02(295, 34, 24), c0362Ec.getPackageName());
        A002.putExtra(A02(200, 14, 106), false);
        return A002;
    }

    private void A04(C0362Ec c0362Ec, Uri uri) {
        c0362Ec.startActivity(A01(c0362Ec, uri));
    }

    private final void A05(C0362Ec c0362Ec, Uri uri) throws JL {
        if (!A0A(c0362Ec)) {
            throw new JL();
        }
        Intent A01 = A01(c0362Ec, uri);
        A01.setPackage(A02(329, 19, 15));
        c0362Ec.startActivity(A01);
    }

    private void A06(C0362Ec c0362Ec, Uri uri, String str) {
        AdActivityIntent A04 = JI.A04(c0362Ec);
        A04.addFlags(268435456);
        A04.putExtra(A02(129, 8, 5), IY.A02);
        A04.putExtra(A02(248, 10, 38), uri.toString());
        A04.putExtra(A02(284, 11, 106), str);
        A04.putExtra(A02(0, 11, 67), System.currentTimeMillis());
        try {
            JI.A09(c0362Ec, A04);
        } catch (ActivityNotFoundException e) {
            C0511Kb.A06(c0362Ec, A02(118, 11, 7), C0512Kc.A05, new C0514Ke(e));
            Log.e(A02(101, 17, 15), A02(11, 90, 78), e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0032, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A07(com.facebook.ads.redexgen.X.C0362Ec r3, android.net.Uri r4, java.lang.String r5) {
        /*
            r2 = this;
            r1 = r2
            boolean r0 = A09(r4)
            if (r0 == 0) goto L30
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L18;
                case 4: goto L32;
                case 5: goto L25;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.Ec r3 = (com.facebook.ads.redexgen.X.C0362Ec) r3
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0e(r3)
            if (r0 == 0) goto L16
            r0 = 3
            goto L8
        L16:
            r0 = 5
            goto L8
        L18:
            com.facebook.ads.redexgen.X.JM r1 = (com.facebook.ads.redexgen.X.JM) r1
            com.facebook.ads.redexgen.X.Ec r3 = (com.facebook.ads.redexgen.X.C0362Ec) r3
            android.net.Uri r4 = (android.net.Uri) r4
            java.lang.String r5 = (java.lang.String) r5
            r1.A06(r3, r4, r5)
            r0 = 4
            goto L8
        L25:
            com.facebook.ads.redexgen.X.JM r1 = (com.facebook.ads.redexgen.X.JM) r1
            com.facebook.ads.redexgen.X.Ec r3 = (com.facebook.ads.redexgen.X.C0362Ec) r3
            android.net.Uri r4 = (android.net.Uri) r4
            r1.A04(r3, r4)
            r0 = 4
            goto L8
        L30:
            r0 = 5
            goto L8
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JM.A07(com.facebook.ads.redexgen.X.Ec, android.net.Uri, java.lang.String):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0008. Please report as an issue. */
    public static void A08(JM jm, C0362Ec c0362Ec, Uri uri, String str) {
        boolean z = false;
        char c = A09(uri) ? (char) 2 : (char) 6;
        while (true) {
            switch (c) {
                case 2:
                    uri = uri;
                    c = A02(142, 15, 112).equals(uri.getHost()) ? (char) 3 : (char) 6;
                case 3:
                    z = true;
                    c = 4;
                case 4:
                    uri = uri;
                    c = !A02(194, 6, 63).equals(uri.getScheme()) ? (char) 5 : '\b';
                case 5:
                    c = z ? '\b' : (char) 7;
                case 6:
                    z = false;
                    c = 4;
                case 7:
                    jm.A07(c0362Ec, uri, str);
                    return;
                case '\b':
                    try {
                        jm = jm;
                        c0362Ec = c0362Ec;
                        uri = uri;
                        jm.A05(c0362Ec, uri);
                        return;
                    } catch (JL unused) {
                        jm.A07(c0362Ec, uri, str);
                        return;
                    }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0079, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A09(android.net.Uri r7) {
        /*
            r0 = 0
            r3 = 0
            r6 = 0
            r0 = 0
            r5 = 1
            r4 = 0
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 24
            if (r1 < r0) goto L77
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L61;
                case 3: goto L35;
                case 4: goto L32;
                case 5: goto L26;
                case 6: goto L11;
                case 7: goto L4a;
                case 8: goto L6f;
                case 9: goto L79;
                case 10: goto L73;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            java.lang.String r3 = (java.lang.String) r3
            r2 = 157(0x9d, float:2.2E-43)
            r1 = 4
            r0 = 2
            java.lang.String r0 = A02(r2, r1, r0)
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 != 0) goto L23
            r0 = 7
            goto Ld
        L23:
            r0 = 8
            goto Ld
        L26:
            android.net.Uri r7 = (android.net.Uri) r7
            java.lang.String r3 = r7.getScheme()
            if (r6 == 0) goto L30
            r0 = 6
            goto Ld
        L30:
            r0 = 7
            goto Ld
        L32:
            r6 = r5
            r0 = 5
            goto Ld
        L35:
            android.net.Uri r7 = (android.net.Uri) r7
            android.security.NetworkSecurityPolicy r1 = android.security.NetworkSecurityPolicy.getInstance()
            java.lang.String r0 = r7.getHost()
            boolean r0 = r1.isCleartextTrafficPermitted(r0)
            if (r0 == 0) goto L47
            r0 = 4
            goto Ld
        L47:
            r0 = 10
            goto Ld
        L4a:
            java.lang.String r3 = (java.lang.String) r3
            r2 = 137(0x89, float:1.92E-43)
            r1 = 5
            r0 = 28
            java.lang.String r0 = A02(r2, r1, r0)
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 == 0) goto L5e
            r0 = 8
            goto Ld
        L5e:
            r0 = 9
            goto Ld
        L61:
            android.security.NetworkSecurityPolicy r0 = android.security.NetworkSecurityPolicy.getInstance()
            boolean r0 = r0.isCleartextTrafficPermitted()
            if (r0 != 0) goto L6d
            r0 = 3
            goto Ld
        L6d:
            r0 = 4
            goto Ld
        L6f:
            r4 = r5
            r0 = 9
            goto Ld
        L73:
            r4 = 0
            r6 = r4
            r0 = 5
            goto Ld
        L77:
            r0 = 4
            goto Ld
        L79:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JM.A09(android.net.Uri):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0A(com.facebook.ads.redexgen.X.C0362Ec r7) {
        /*
            r6 = this;
            r0 = 0
            r0 = 0
            r5 = 0
            r2 = 214(0xd6, float:3.0E-43)
            r1 = 34
            r0 = 46
            java.lang.String r0 = A02(r2, r1, r0)
            android.net.Uri r4 = android.net.Uri.parse(r0)
            android.content.Intent r3 = new android.content.Intent
            r2 = 258(0x102, float:3.62E-43)
            r1 = 26
            r0 = 45
            java.lang.String r0 = A02(r2, r1, r0)
            r3.<init>(r0, r4)
            android.content.pm.PackageManager r0 = r7.getPackageManager()
            java.util.List r0 = r0.queryIntentActivities(r3, r5)
            java.util.Iterator r4 = r0.iterator()
            r0 = 2
        L2d:
            switch(r0) {
                case 2: goto L31;
                case 3: goto L3d;
                case 4: goto L5f;
                case 5: goto L62;
                default: goto L30;
            }
        L30:
            goto L2d
        L31:
            java.util.Iterator r4 = (java.util.Iterator) r4
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L3b
            r0 = 3
            goto L2d
        L3b:
            r0 = 5
            goto L2d
        L3d:
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r0 = r4.next()
            android.content.pm.ResolveInfo r0 = (android.content.pm.ResolveInfo) r0
            android.content.pm.ActivityInfo r0 = r0.activityInfo
            android.content.pm.ApplicationInfo r0 = r0.applicationInfo
            java.lang.String r3 = r0.packageName
            r2 = 329(0x149, float:4.61E-43)
            r1 = 19
            r0 = 15
            java.lang.String r0 = A02(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5d
            r0 = 4
            goto L2d
        L5d:
            r0 = 2
            goto L2d
        L5f:
            r5 = 1
            r0 = 5
            goto L2d
        L62:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JM.A0A(com.facebook.ads.redexgen.X.Ec):boolean");
    }
}
