package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.0q, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C00190q extends AbstractC00170o<EnumC00040b> {
    public static byte[] A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C00190q.A00
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
            int r0 = r0 + (-34)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00190q.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A00 = new byte[]{-76, -69, -78, -78};
    }

    public C00190q(String str) {
        super(str);
    }

    public final C00150m A02(@Nullable EnumC00040b enumC00040b) {
        return new C00150m(this, enumC00040b == null ? A00(0, 4, 36) : A00(0, 0, 59) + enumC00040b.A02());
    }
}
