package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public final class G5 implements G3, G4 {
    public static byte[] A01;
    public final C0365Ef A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.G5.A01
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
            r0 = r0 ^ 20
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.G5.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{56, 77, 38, 34, 77, 48, 15, 15, 12, 77, 50, 15, 21, 20, 9, 14, 7, 77, 52, 15, 11, 5, 14, 33, 39, 49, 38, 121, 53, 51, 49, 58, 32};
    }

    public G5(C0365Ef c0365Ef) {
        this.A00 = c0365Ef;
    }

    @Override // com.facebook.ads.redexgen.X.G3, com.facebook.ads.redexgen.X.G4
    public final Map<String, String> A4C(boolean z) {
        HashMap hashMap = new HashMap();
        if (!C02379g.A00().A04()) {
            hashMap.put(A00(0, 23, 116), GQ.A00().A02(this.A00, true).A4y());
        }
        hashMap.put(A00(23, 10, 64), GV.A06(new C0399Fn(this.A00), this.A00, z));
        return hashMap;
    }
}
