package com.facebook.ads.redexgen.X;

import android.database.Cursor;

/* renamed from: com.facebook.ads.redexgen.X.Er, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0377Er extends AbstractC0376Eq {
    public static byte[] A00;
    public static final C0375Ep A01;
    public static final C0375Ep A02;
    public static final C0375Ep A03;
    public static final C0375Ep A04;
    public static final C0375Ep A05;
    public static final C0375Ep A06;
    public static final C0375Ep A07;
    public static final C0375Ep A08;
    public static final C0375Ep A09;
    public static final C0375Ep[] A0A;
    public static final String A0B;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0377Er.A00
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
            int r0 = r0 + (-28)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0377Er.A00(int, int, int):java.lang.String");
    }

    public static void A04() {
        A00 = new byte[]{-87, -58, -87, -56, -92, -75, -92, -83, -77, -78, -13, -27, -13, -13, -23, -17, -18, -33, -23, -28, -35, -48, -52, -41, -68, -63, -57, -72, -70, -72, -59, -12, -7, -16, -27, -49, -64, -45, -49, -101, -51, -64, -63, -64, -51, -64, -55, -66, -64, -50, -101, -17, -22, -26, -32, -23, -18, -101, -54, -55, -101, -48, -53, -65, -68, -49, -64, -101, -66, -68, -50, -66, -68, -65, -64, -101, -54, -55, -101, -65, -64, -57, -64, -49, -64, -101, -51, -64, -50, -49, -51, -60, -66, -49, -102, -83, -83, -98, -90, -87, -83, -17, -15, -24, -18, -15, -24, -13, -8, -73, -87, -80, -87, -89, -72, -124, -114, -124, -86, -74, -77, -79, -124, -55, -38, -55, -46, -40, -41, -124, -69, -84, -87, -74, -87, -124, -47, -61, -54, -61, -63, -46, -98, -31, -19, -13, -20, -14, -90, -88, -89, -98, -60, -48, -51, -53, -98, -29, -12, -29, -20, -14, -15, -27, -42, -23, -27, -3, -6, 13, -6, 13, 8, 4, -2, 7, -8, 2, -3, 3, -11, 3, 3, -7, -1, -2, -17, 4, -7, -3, -11, -40, -55, -36, -40, -92, -44, -42, -51, -47, -59, -42, -35, -92, -49, -55, -35, -23, -34, -30, -38, -17, 0, -17, -8, -2, -23, -13, -18};
    }

    static {
        A04();
        A03 = new C0375Ep(0, A00(211, 8, 110), A00(191, 16, 104));
        A08 = new C0375Ep(1, A00(171, 8, 125), A00(35, 59, 95));
        A04 = new C0375Ep(2, A00(101, 8, 99), A00(24, 7, 87));
        A09 = new C0375Ep(3, A00(31, 4, 100), A00(163, 4, 117));
        A07 = new C0375Ep(4, A00(207, 4, 89), A00(20, 4, 111));
        A06 = new C0375Ep(5, A00(179, 12, 116), A00(20, 4, 111));
        A05 = new C0375Ep(6, A00(10, 10, 100), A00(163, 4, 117));
        A02 = new C0375Ep(7, A00(167, 4, 125), A00(163, 4, 117));
        A01 = new C0375Ep(8, A00(94, 7, 29), A00(24, 7, 87));
        A0A = new C0375Ep[]{A03, A08, A04, A09, A07, A06, A05, A02, A01};
        A0B = AbstractC0376Eq.A02(A00(4, 6, 35), A0A);
    }

    public C0377Er(C0382Ew c0382Ew) {
        super(c0382Ew);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0376Eq
    public final String A06() {
        return A00(4, 6, 35);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0376Eq
    public final C0375Ep[] A0A() {
        return A0A;
    }

    public final Cursor A0B() {
        return A05().rawQuery(A00(136, 27, 98), null);
    }

    public final Cursor A0C() {
        return A05().rawQuery(A0B, null);
    }

    public final Cursor A0D(String str) {
        return A05().rawQuery(A00(109, 27, 72) + A03.A01 + A00(0, 4, 109), new String[]{str});
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0072, code lost:            r4 = r4;        r4.put(r1, r3);        r4.put(com.facebook.ads.redexgen.X.C0377Er.A01.A01, (java.lang.Integer) 0);        A05().insertOrThrow(A00(4, 6, 35), r6, r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x009b, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A0E(java.lang.String r8, int r9, java.lang.String r10, double r11, double r13, java.lang.String r15, java.util.Map<java.lang.String, java.lang.String> r16) throws android.database.sqlite.SQLiteException {
        /*
            r7 = this;
            r2 = r16
            r3 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r6 = 0
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r5 = r0.toString()
            android.content.ContentValues r4 = new android.content.ContentValues
            r0 = 9
            r4.<init>(r0)
            com.facebook.ads.redexgen.X.Ep r0 = com.facebook.ads.redexgen.X.C0377Er.A03
            java.lang.String r0 = r0.A01
            r4.put(r0, r5)
            com.facebook.ads.redexgen.X.Ep r0 = com.facebook.ads.redexgen.X.C0377Er.A08
            java.lang.String r0 = r0.A01
            r4.put(r0, r8)
            com.facebook.ads.redexgen.X.Ep r0 = com.facebook.ads.redexgen.X.C0377Er.A04
            java.lang.String r1 = r0.A01
            java.lang.Integer r0 = java.lang.Integer.valueOf(r9)
            r4.put(r1, r0)
            com.facebook.ads.redexgen.X.Ep r0 = com.facebook.ads.redexgen.X.C0377Er.A09
            java.lang.String r0 = r0.A01
            r4.put(r0, r10)
            com.facebook.ads.redexgen.X.Ep r0 = com.facebook.ads.redexgen.X.C0377Er.A07
            java.lang.String r1 = r0.A01
            java.lang.Double r0 = java.lang.Double.valueOf(r11)
            r4.put(r1, r0)
            com.facebook.ads.redexgen.X.Ep r0 = com.facebook.ads.redexgen.X.C0377Er.A06
            java.lang.String r1 = r0.A01
            java.lang.Double r0 = java.lang.Double.valueOf(r13)
            r4.put(r1, r0)
            com.facebook.ads.redexgen.X.Ep r0 = com.facebook.ads.redexgen.X.C0377Er.A05
            java.lang.String r0 = r0.A01
            r4.put(r0, r15)
            com.facebook.ads.redexgen.X.Ep r0 = com.facebook.ads.redexgen.X.C0377Er.A02
            java.lang.String r1 = r0.A01
            if (r2 == 0) goto L70
            r0 = 2
        L5b:
            switch(r0) {
                case 2: goto L5f;
                case 3: goto L72;
                case 4: goto L6c;
                default: goto L5e;
            }
        L5e:
            goto L5b
        L5f:
            java.util.Map r2 = (java.util.Map) r2
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r2)
            java.lang.String r3 = r0.toString()
            r0 = 3
            goto L5b
        L6c:
            r6 = 0
            r3 = r6
            r0 = 3
            goto L5b
        L70:
            r0 = 4
            goto L5b
        L72:
            r2 = r7
            com.facebook.ads.redexgen.X.Er r2 = (com.facebook.ads.redexgen.X.C0377Er) r2
            java.lang.String r5 = (java.lang.String) r5
            android.content.ContentValues r4 = (android.content.ContentValues) r4
            java.lang.String r1 = (java.lang.String) r1
            r4.put(r1, r3)
            com.facebook.ads.redexgen.X.Ep r0 = com.facebook.ads.redexgen.X.C0377Er.A01
            java.lang.String r1 = r0.A01
            r0 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4.put(r1, r0)
            android.database.sqlite.SQLiteDatabase r3 = r2.A05()
            r2 = 4
            r1 = 6
            r0 = 35
            java.lang.String r0 = A00(r2, r1, r0)
            r3.insertOrThrow(r0, r6, r4)
            java.lang.String r5 = (java.lang.String) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0377Er.A0E(java.lang.String, int, java.lang.String, double, double, java.lang.String, java.util.Map):java.lang.String");
    }

    public final boolean A0F(String str) {
        return A05().delete(A00(4, 6, 35), new StringBuilder().append(A03.A01).append(A00(0, 4, 109)).toString(), new String[]{str}) > 0;
    }
}
