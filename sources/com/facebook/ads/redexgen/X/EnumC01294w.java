package com.facebook.ads.redexgen.X;

import java.util.Locale;

/* renamed from: com.facebook.ads.redexgen.X.4w, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC01294w {
    A03(A01(37, 3, 95)),
    A04(A01(0, 7, 33));

    public static byte[] A01;
    public String A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.EnumC01294w.A01
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
            int r0 = r0 + (-4)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC01294w.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A01 = new byte[]{-102, -109, -112, -109, -108, -100, -109, 125, -94, -86, -107, -96, -99, -104, 84, -89, -103, -90, -86, -103, -90, 84, -90, -103, -89, -92, -93, -94, -89, -103, 110, 84, 89, -89, 107, 109, 117, -60, -58, -50, -41, -48, -51, -48, -47, -39, -48};
    }

    static {
        A02();
    }

    EnumC01294w(String str) {
        this.A00 = str;
    }

    public static EnumC01294w A00(String str) {
        EnumC01294w enumC01294w = null;
        int i = 0;
        EnumC01294w[] values = values();
        int length = values.length;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    if (i >= length) {
                        c = 6;
                        break;
                    } else {
                        c = 3;
                        break;
                    }
                case 3:
                    str = str;
                    values = values;
                    enumC01294w = values[i];
                    if (!enumC01294w.A00.equals(str)) {
                        c = 5;
                        break;
                    } else {
                        c = 4;
                        break;
                    }
                case 4:
                    return enumC01294w;
                case 5:
                    i++;
                    c = 2;
                    break;
                case 6:
                    throw new IllegalArgumentException(String.format(Locale.US, A01(7, 27, 48), str));
            }
        }
    }
}
