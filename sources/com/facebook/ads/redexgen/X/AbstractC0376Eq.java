package com.facebook.ads.redexgen.X;

import android.database.sqlite.SQLiteDatabase;

/* renamed from: com.facebook.ads.redexgen.X.Eq, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0376Eq {
    public static byte[] A01;
    public final C0382Ew A00;

    static {
        A04();
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
            byte[] r1 = com.facebook.ads.redexgen.X.AbstractC0376Eq.A01
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
            int r0 = r0 + (-126)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0376Eq.A01(int, int, int):java.lang.String");
    }

    public static void A04() {
        A01 = new byte[]{-73, -85, -18, 11, -18, 13, 25, 39, 36, 37, -11, 41, 22, 23, 33, 26, -11, 30, 27, -11, 26, 45, 30, 40, 41, 40, -11, 6, 42, 28, 35, 28, 26, 43, -9, 47, 62, 49, 45, 64, 49, 12, 64, 45, 46, 56, 49, 12, -58, -20, -8, -11, -13, -58, -4, 4, -62, -7, -22, -25, -12, -25, -62};
    }

    public abstract String A06();

    public abstract C0375Ep[] A0A();

    public AbstractC0376Eq(C0382Ew c0382Ew) {
        this.A00 = c0382Ew;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x007a, code lost:            return r6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String A00() {
        /*
            r7 = this;
            r4 = 0
            r6 = 0
            r2 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Ep[] r3 = r7.A0A()
            int r1 = r3.length
            r0 = 1
            if (r1 >= r0) goto L76
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L73;
                case 3: goto L78;
                case 4: goto L67;
                case 5: goto L5c;
                case 6: goto L11;
                case 7: goto L3c;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.Ep[] r3 = (com.facebook.ads.redexgen.X.C0375Ep[]) r3
            java.lang.String r2 = (java.lang.String) r2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r1 = r0.append(r2)
            r0 = r3[r4]
            java.lang.String r0 = r0.A02()
            java.lang.StringBuilder r5 = r1.append(r0)
            r2 = 0
            r1 = 2
            r0 = 13
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.StringBuilder r0 = r5.append(r0)
            java.lang.String r2 = r0.toString()
            int r4 = r4 + 1
            r0 = 5
            goto Ld
        L3c:
            com.facebook.ads.redexgen.X.Ep[] r3 = (com.facebook.ads.redexgen.X.C0375Ep[]) r3
            java.lang.String r2 = (java.lang.String) r2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r1 = r0.append(r2)
            int r0 = r3.length
            int r0 = r0 + (-1)
            r0 = r3[r0]
            java.lang.String r0 = r0.A02()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r6 = r0.toString()
            r0 = 3
            goto Ld
        L5c:
            com.facebook.ads.redexgen.X.Ep[] r3 = (com.facebook.ads.redexgen.X.C0375Ep[]) r3
            int r0 = r3.length
            int r0 = r0 + (-1)
            if (r4 >= r0) goto L65
            r0 = 6
            goto Ld
        L65:
            r0 = 7
            goto Ld
        L67:
            r2 = 27
            r1 = 0
            r0 = 38
            java.lang.String r2 = A01(r2, r1, r0)
            r4 = 0
            r0 = 5
            goto Ld
        L73:
            r6 = 0
            r0 = 3
            goto Ld
        L76:
            r0 = 4
            goto Ld
        L78:
            java.lang.String r6 = (java.lang.String) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0376Eq.A00():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:            r3 = r3;        r3.append(r6[r6.length - 1].A01);        r3.append(A01(48, 6, 40));        r3.append(r5);     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0060, code lost:            return r3.toString();     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(java.lang.String r5, com.facebook.ads.redexgen.X.C0375Ep[] r6) {
        /*
            r0 = 0
            r0 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r2 = 28
            r1 = 7
            r0 = 89
            java.lang.String r0 = A01(r2, r1, r0)
            r3.<init>(r0)
            r4 = 0
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L16;
                case 3: goto L21;
                case 4: goto L3b;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            com.facebook.ads.redexgen.X.Ep[] r6 = (com.facebook.ads.redexgen.X.C0375Ep[]) r6
            int r0 = r6.length
            int r0 = r0 + (-1)
            if (r4 >= r0) goto L1f
            r0 = 3
            goto L12
        L1f:
            r0 = 4
            goto L12
        L21:
            com.facebook.ads.redexgen.X.Ep[] r6 = (com.facebook.ads.redexgen.X.C0375Ep[]) r6
            java.lang.StringBuilder r3 = (java.lang.StringBuilder) r3
            r0 = r6[r4]
            java.lang.String r0 = r0.A01
            r3.append(r0)
            r2 = 0
            r1 = 2
            r0 = 13
            java.lang.String r0 = A01(r2, r1, r0)
            r3.append(r0)
            int r4 = r4 + 1
            r0 = 2
            goto L12
        L3b:
            java.lang.String r5 = (java.lang.String) r5
            com.facebook.ads.redexgen.X.Ep[] r6 = (com.facebook.ads.redexgen.X.C0375Ep[]) r6
            java.lang.StringBuilder r3 = (java.lang.StringBuilder) r3
            int r0 = r6.length
            int r0 = r0 + (-1)
            r0 = r6[r0]
            java.lang.String r0 = r0.A01
            r3.append(r0)
            r2 = 48
            r1 = 6
            r0 = 40
            java.lang.String r0 = A01(r2, r1, r0)
            r3.append(r0)
            r3.append(r5)
            java.lang.String r0 = r3.toString()
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0376Eq.A02(java.lang.String, com.facebook.ads.redexgen.X.Ep[]):java.lang.String");
    }

    public static String A03(String str, C0375Ep[] c0375EpArr, C0375Ep c0375Ep) {
        return A02(str, c0375EpArr) + A01(56, 7, 36) + c0375Ep.A01 + A01(2, 4, 80);
    }

    public final SQLiteDatabase A05() {
        return this.A00.A0E();
    }

    public final void A07(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(A01(35, 13, 110) + A06() + A01(54, 2, 94) + A00() + A01(27, 1, 95));
    }

    public final void A08(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(A01(6, 21, 87) + A06());
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A09() {
        /*
            r4 = this;
            r3 = 0
            r2 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.A05()
            java.lang.String r0 = r4.A06()
            int r0 = r1.delete(r0, r2, r2)
            if (r0 <= 0) goto L1b
            r0 = 2
        L11:
            switch(r0) {
                case 2: goto L15;
                case 3: goto L1d;
                case 4: goto L18;
                default: goto L14;
            }
        L14:
            goto L11
        L15:
            r3 = 1
            r0 = 3
            goto L11
        L18:
            r3 = 0
            r0 = 3
            goto L11
        L1b:
            r0 = 4
            goto L11
        L1d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0376Eq.A09():boolean");
    }
}
