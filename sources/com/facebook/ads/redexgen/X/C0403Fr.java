package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Fr, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0403Fr {
    public static byte[] A0F;
    public static final AdPlacementType A0G;
    public static final String A0H;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public AdPlacementType A0B;
    public List<C0401Fp> A0C;
    public boolean A0D;
    public final long A0E = System.currentTimeMillis();

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0403Fr.A0F
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
            r0 = r0 ^ 86
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0403Fr.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A0F = new byte[]{68, 91, 86, 87, 93, 109, 70, 91, 95, 87, 109, 66, 93, 94, 94, 91, 92, 85, 109, 91, 92, 70, 87, 64, 68, 83, 94, 12, 98, 125, 113, 99, 117, 118, 125, 120, 125, 96, 109, 75, 119, 124, 113, 119, Byte.MAX_VALUE, 75, 125, 122, 96, 113, 102, 98, 117, 120, 57, 37, 40, 42, 44, 36, 44, 39, 61, 22, 33, 44, 32, 46, 33, 61, 118, 97, 98, 118, 97, 119, 108, 47, 35, 34, 58, 19, 56, 62, 45, 47, 39, 37, 34, 43, 19, 40, 45, 56, 45, 118, 113, 105, 126, 115, 118, 123, 126, 107, 118, 112, 113, 64, 123, 106, 109, 126, 107, 118, 112, 113, 64, 118, 113, 64, 108, 122, 124, 112, 113, 123, 108, 14, 3, 10, 31, 53, 55, 53, 62, 51, 55, 52, 58, 51, Byte.MAX_VALUE, 96, 108, 126, 104, 107, 96, 101, 96, 125, 112, 86, 106, 97, 108, 106, 98, 86, 125, 96, 106, 98, 108, 123, 110, 113, 125, 111, 121, 122, 113, 116, 113, 108, 97, 71, 123, 112, 125, 123, 115, 71, 113, 118, 113, 108, 113, 121, 116, 71, 124, 125, 116, 121, 97, 102, 113, 114, 102, 113, 103, 124, 75, 96, 124, 102, 113, 103, 124, 123, 120, 112, 25, 102, 77, 79, 67, 75, 76, 31, 54, 72, 117, 125, 100, Byte.MAX_VALUE, 104, 126, 48, 85, 81, 86, 103, 78, 81, 93, 79, 89, 90, 81, 84, 81, 76, 65, 103, 72, 93, 74, 91, 93, 86, 76, 89, 95, 93, 61, 118, 103, 114, 110, 59, 41, 24, 15, 27, 31, 15, 25, 30, 53, 30, 3, 7, 15, 5, 31, 30, 54, 42, 39, 37, 35, 43, 35, 40, 50, 25, 49, 47, 34, 50, 46, 77, 106, 98, 103, 110, 111, 43, Byte.MAX_VALUE, 100, 43, 120, 110, Byte.MAX_VALUE, 43, 104, 100, 100, 96, 98, 110, 37};
    }

    static {
        A02();
        A0H = C0403Fr.class.getSimpleName();
        A0G = AdPlacementType.UNKNOWN;
    }

    public C0403Fr(Map<String, String> map) {
        char c;
        this.A01 = -1;
        this.A00 = -1;
        this.A0B = A0G;
        this.A03 = 1;
        this.A0A = 0;
        this.A04 = 0;
        this.A05 = 20;
        this.A08 = 0;
        this.A09 = 1000;
        this.A06 = 10000;
        this.A07 = 200;
        this.A02 = 3600;
        this.A0D = false;
        this.A0C = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            switch (key.hashCode()) {
                case -1899431321:
                    if (key.equals(A01(77, 18, 26))) {
                        c = '\f';
                        break;
                    }
                    break;
                case -1561601017:
                    if (key.equals(A01(195, 17, 66))) {
                        c = 4;
                        break;
                    }
                    break;
                case -856794442:
                    if (key.equals(A01(28, 26, 66))) {
                        c = '\n';
                        break;
                    }
                    break;
                case -726276175:
                    if (key.equals(A01(262, 15, 60))) {
                        c = 11;
                        break;
                    }
                    break;
                case -634541425:
                    if (key.equals(A01(95, 32, 73))) {
                        c = 5;
                        break;
                    }
                    break;
                case -553208868:
                    if (key.equals(A01(131, 9, 0))) {
                        c = 6;
                        break;
                    }
                    break;
                case 3575610:
                    if (key.equals(A01(127, 4, 44))) {
                        c = 0;
                        break;
                    }
                    break;
                case 700812481:
                    if (key.equals(A01(229, 26, 110))) {
                        c = 1;
                        break;
                    }
                    break;
                case 858630459:
                    if (key.equals(A01(140, 24, 95))) {
                        c = 2;
                        break;
                    }
                    break;
                case 986744879:
                    if (key.equals(A01(0, 27, 100))) {
                        c = '\r';
                        break;
                    }
                    break;
                case 1085444827:
                    if (key.equals(A01(70, 7, 82))) {
                        c = 3;
                        break;
                    }
                    break;
                case 1183549815:
                    if (key.equals(A01(164, 31, 78))) {
                        c = '\t';
                        break;
                    }
                    break;
                case 1503616961:
                    if (key.equals(A01(54, 16, 31))) {
                        c = '\b';
                        break;
                    }
                    break;
                case 2002133996:
                    if (key.equals(A01(277, 15, 16))) {
                        c = 7;
                        break;
                    }
                    break;
            }
            c = 65535;
            switch (c) {
                case 0:
                    this.A0B = AdPlacementType.fromString(entry.getValue());
                    break;
                case 1:
                    this.A03 = Integer.parseInt(entry.getValue());
                    break;
                case 2:
                    this.A0A = Integer.parseInt(entry.getValue());
                    break;
                case 3:
                    this.A04 = Integer.parseInt(entry.getValue());
                    break;
                case 4:
                    this.A05 = Integer.parseInt(entry.getValue());
                    break;
                case 5:
                    this.A02 = Integer.parseInt(entry.getValue());
                    break;
                case 6:
                    this.A0D = Boolean.valueOf(entry.getValue()).booleanValue();
                    break;
                case 7:
                    this.A01 = Integer.parseInt(entry.getValue());
                    break;
                case '\b':
                    this.A00 = Integer.parseInt(entry.getValue());
                    break;
                case '\t':
                    this.A08 = Integer.parseInt(entry.getValue());
                    break;
                case '\n':
                    this.A09 = Integer.parseInt(entry.getValue());
                    break;
                case 11:
                    this.A06 = Integer.parseInt(entry.getValue());
                    break;
                case '\f':
                    this.A0C = C0401Fp.A01(entry.getValue());
                    try {
                        CookieManager cookieManager = CookieManager.getInstance();
                        boolean acceptCookie = cookieManager.acceptCookie();
                        cookieManager.setAcceptCookie(true);
                        for (C0401Fp c0401Fp : this.A0C) {
                            if (c0401Fp.A04()) {
                                cookieManager.setCookie(c0401Fp.A01, c0401Fp.A00 + A01(27, 1, 103) + c0401Fp.A02 + A01(212, 8, 116) + c0401Fp.A01 + A01(220, 9, 91) + c0401Fp.A03() + A01(255, 7, 80));
                            }
                        }
                        if (Build.VERSION.SDK_INT < 21) {
                            CookieSyncManager.getInstance().startSync();
                        }
                        cookieManager.setAcceptCookie(acceptCookie);
                        break;
                    } catch (Exception e) {
                        Log.w(A0H, A01(292, 21, 93), e);
                        break;
                    }
                case '\r':
                    try {
                        this.A07 = Integer.parseInt(entry.getValue());
                        break;
                    } catch (NumberFormatException unused) {
                        this.A07 = 200;
                        break;
                    }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C0403Fr A00(org.json.JSONObject r5) {
        /*
            r4 = 0
            r3 = 0
            r2 = 0
            if (r5 != 0) goto L48
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L3c;
                case 3: goto L4a;
                case 4: goto L2f;
                case 5: goto L23;
                case 6: goto La;
                case 7: goto L3f;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            org.json.JSONObject r5 = (org.json.JSONObject) r5
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.util.HashMap r4 = (java.util.HashMap) r4
            java.lang.Object r1 = r3.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r5.opt(r1)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r4.put(r1, r0)
            r0 = 5
            goto L6
        L23:
            java.util.Iterator r3 = (java.util.Iterator) r3
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L2d
            r0 = 6
            goto L6
        L2d:
            r0 = 7
            goto L6
        L2f:
            org.json.JSONObject r5 = (org.json.JSONObject) r5
            java.util.Iterator r3 = r5.keys()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            r0 = 5
            goto L6
        L3c:
            r2 = 0
            r0 = 3
            goto L6
        L3f:
            java.util.HashMap r4 = (java.util.HashMap) r4
            com.facebook.ads.redexgen.X.Fr r2 = new com.facebook.ads.redexgen.X.Fr
            r2.<init>(r4)
            r0 = 3
            goto L6
        L48:
            r0 = 4
            goto L6
        L4a:
            com.facebook.ads.redexgen.X.Fr r2 = (com.facebook.ads.redexgen.X.C0403Fr) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0403Fr.A00(org.json.JSONObject):com.facebook.ads.redexgen.X.Fr");
    }

    public final int A03() {
        return this.A02 * 1000;
    }

    public final int A04() {
        return this.A03;
    }

    public final int A05() {
        return this.A06;
    }

    public final int A06() {
        return this.A07;
    }

    public final int A07() {
        return this.A08;
    }

    public final int A08() {
        return this.A09;
    }

    public final int A09() {
        return this.A0A;
    }

    public final long A0A() {
        return this.A04 * 1000;
    }

    public final long A0B() {
        return this.A05 * 1000;
    }

    public final long A0C() {
        return this.A0E;
    }

    public final AdPlacementType A0D() {
        return this.A0B;
    }

    public final boolean A0E() {
        return this.A0D;
    }
}
