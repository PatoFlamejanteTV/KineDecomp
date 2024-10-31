package com.facebook.ads.redexgen.X;

import java.io.Serializable;

/* renamed from: com.facebook.ads.redexgen.X.2Z, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C2Z implements Serializable {
    public static byte[] A05 = null;
    public static final long serialVersionUID = 351643298236575729L;
    public final String A00;
    public final String A01;
    public final String A02;
    public final String A03;
    public final String A04;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C2Z.A05
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
            r0 = r0 ^ 105(0x69, float:1.47E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2Z.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A05 = new byte[]{125, 118, 110, 120, Byte.MAX_VALUE, Byte.MAX_VALUE, 104, 99, 110, 116, 112, 103, 109, 105, 125, 114, 104, 117, 104, 101, 97};
    }

    public C2Z(C2Y c2y) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        str = c2y.A03;
        this.A03 = str;
        str2 = c2y.A04;
        this.A04 = str2;
        str3 = c2y.A01;
        this.A01 = str3;
        str4 = c2y.A02;
        this.A02 = str4;
        str5 = c2y.A00;
        this.A00 = str5;
    }

    public static String A01(String str, String str2, int i) {
        String updatedString = str.replace(A00(1, 10, 100), str2);
        String quantityString = A00(1, 0, 76);
        if (i > 0) {
            quantityString = i + A00(0, 1, 52);
        }
        return updatedString.replace(A00(11, 10, 117), quantityString);
    }

    public final String A03() {
        return this.A01;
    }

    public final String A04() {
        return this.A02;
    }

    public final String A05() {
        return this.A03;
    }

    public final String A06(String str, int i) {
        return A01(this.A00, str, i);
    }

    public final String A07(String str, int i) {
        return A01(this.A04, str, i);
    }
}
