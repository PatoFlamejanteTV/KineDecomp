package com.facebook.ads.redexgen.X;

import java.util.Locale;

/* loaded from: assets/audience_network.dex */
public class OZ implements LS {
    public static byte[] A01;
    public final /* synthetic */ C0616Oe A00;

    static {
        A01();
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
            byte[] r1 = com.facebook.ads.redexgen.X.OZ.A01
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
            int r0 = r0 + (-94)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.OZ.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{35, 22, 18, 36, -1, 18, 14, 17, 38, 1, 28, 0, 21, 28, 36, -43, -44, -46, 32, -44, -42, -24};
    }

    public OZ(C0616Oe c0616Oe) {
        this.A00 = c0616Oe;
    }

    @Override // com.facebook.ads.redexgen.X.LS
    public final void A6z() {
        C0432Gv c0432Gv;
        String str;
        c0432Gv = this.A00.A09;
        c0432Gv.A02(EnumC0431Gu.A0L, null);
        C0616Oe c0616Oe = this.A00;
        Locale locale = Locale.US;
        String A00 = A00(0, 22, 79);
        str = this.A00.A0I;
        c0616Oe.A0I(String.format(locale, A00, str));
    }
}
