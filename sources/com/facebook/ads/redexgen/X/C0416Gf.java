package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Gf, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0416Gf {
    public static byte[] A07;
    public final double A00;
    public final double A01 = System.currentTimeMillis() / 1000.0d;
    public final EnumC0426Gp A02;
    public final EnumC0427Gq A03;
    public final String A04;
    public final String A05;
    public final Map<String, String> A06;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C0416Gf.A07
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
            int r0 = r0 + (-35)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0416Gf.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A07 = new byte[]{-36, -33, -42, -44, -42, -37, -50, -39, -52, -48, -39, -42, -46, -37, -31, -52, -31, -36, -40, -46, -37, -86, -73, -86, -75, -72, -80, -88, -99, -92, -86, -95, -103, -108, -98, -93, -104, -95, -86, -103, -102, -108, -98, -93, -108, -101, -86, -93, -93, -102, -95};
    }

    public C0416Gf(C0361Eb c0361Eb, String str, double d, String str2, Map<String, String> map, EnumC0426Gp enumC0426Gp, EnumC0427Gq enumC0427Gq, boolean z) {
        this.A05 = str;
        this.A00 = d;
        this.A04 = str2;
        this.A02 = enumC0426Gp;
        this.A03 = enumC0427Gq;
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        if (z) {
            hashMap.put(A00(27, 24, 18), String.valueOf(z));
        }
        String A01 = C0434Gx.A01(str);
        if (!TextUtils.isEmpty(A01) && (z || enumC0427Gq == EnumC0427Gq.A0B)) {
            hashMap.put(A00(0, 21, 74), A01);
        }
        if (A0B()) {
            hashMap.put(A00(21, 6, 38), C0490Jf.A01(c0361Eb.A02().A4H()));
        }
        this.A06 = A01(hashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x004b, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.String> A01(java.util.Map<java.lang.String, java.lang.String> r5) {
        /*
            r4 = 0
            r0 = 0
            r3 = 0
            r0 = 0
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.Set r0 = r5.entrySet()
            java.util.Iterator r1 = r0.iterator()
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L16;
                case 3: goto L22;
                case 4: goto L3c;
                case 5: goto L47;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            java.util.Iterator r1 = (java.util.Iterator) r1
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L20
            r0 = 3
            goto L12
        L20:
            r0 = 5
            goto L12
        L22:
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r0 = r1.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r3 = r0.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r0.getValue()
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L3a
            r0 = 4
            goto L12
        L3a:
            r0 = 2
            goto L12
        L3c:
            java.util.HashMap r2 = (java.util.HashMap) r2
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = (java.lang.String) r4
            r2.put(r3, r4)
            r0 = 2
            goto L12
        L47:
            java.util.HashMap r2 = (java.util.HashMap) r2
            java.util.Map r2 = (java.util.Map) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0416Gf.A01(java.util.Map):java.util.Map");
    }

    public final double A03() {
        return this.A00;
    }

    public final double A04() {
        return this.A01;
    }

    public final EnumC0426Gp A05() {
        return this.A02;
    }

    public final EnumC0427Gq A06() {
        return this.A03;
    }

    public final String A07() {
        return this.A04;
    }

    public final String A08() {
        return this.A05;
    }

    public final Map<String, String> A09() {
        return this.A06;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0016, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0A() {
        /*
            r2 = this;
            r1 = 0
            java.lang.String r0 = r2.A05
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L14
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L16;
                case 4: goto L11;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            r1 = 1
            r0 = 3
            goto La
        L11:
            r1 = 0
            r0 = 3
            goto La
        L14:
            r0 = 4
            goto La
        L16:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0416Gf.A0A():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0B() {
        /*
            r3 = this;
            r2 = 0
            com.facebook.ads.redexgen.X.Gp r1 = r3.A02
            com.facebook.ads.redexgen.X.Gp r0 = com.facebook.ads.redexgen.X.EnumC0426Gp.A04
            if (r1 != r0) goto L12
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L14;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r2 = 1
            r0 = 3
            goto L8
        Lf:
            r2 = 0
            r0 = 3
            goto L8
        L12:
            r0 = 4
            goto L8
        L14:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0416Gf.A0B():boolean");
    }
}
