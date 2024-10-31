package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Dq, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public enum EnumC0350Dq {
    A04(0),
    A05(100);

    public static byte[] A01;
    public static final Map<Integer, EnumC0350Dq> A02;
    public int A00;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.EnumC0350Dq.A01
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
            int r0 = r0 + (-56)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EnumC0350Dq.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A01 = new byte[]{-87, -86, -85, -90, -70, -79, -71, -59, -58, -60, -59};
    }

    static {
        A02();
        A02 = new HashMap();
        for (EnumC0350Dq enumC0350Dq : values()) {
            A02.put(Integer.valueOf(enumC0350Dq.A00), enumC0350Dq);
        }
    }

    EnumC0350Dq(int i) {
        this.A00 = i;
    }

    public static EnumC0350Dq A00(int i) {
        EnumC0350Dq enumC0350Dq = A02.get(Integer.valueOf(i));
        return enumC0350Dq == null ? A04 : enumC0350Dq;
    }
}
