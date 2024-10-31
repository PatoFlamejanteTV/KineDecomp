package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import java.util.Map;

/* loaded from: assets/audience_network.dex */
public class FF {
    public static byte[] A07;
    public G4 A05;
    public int A04 = 60000;
    public int A03 = 100;
    public int A00 = 10000;
    public int A02 = 8000;
    public int A01 = 3;
    public Map<String, String> A06 = new HashMap();

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
            byte[] r1 = com.facebook.ads.redexgen.X.FF.A07
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
            int r0 = r0 + (-98)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FF.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A07 = new byte[]{45, 65, 88, 73, 77, 85, 77, 0, 82, 69, 84, 82, 73, 69, 83, 0, 77, 85, 83, 84, 0, 66, 69, 0, 66, 69, 84, 87, 69, 69, 78, 0, 17, 0, 65, 78, 68, 0, 17, 24};
    }

    public final FF A02(int i) {
        this.A00 = i;
        return this;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0004. Please report as an issue. */
    public final FF A03(int i) {
        char c = i >= 1 ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    c = i > 18 ? (char) 3 : (char) 4;
                case 3:
                    throw new IllegalArgumentException(A00(0, 40, 126));
                case 4:
                    FF ff = this;
                    ff.A01 = i;
                    return ff;
            }
        }
    }

    public final FF A04(int i) {
        this.A02 = i;
        return this;
    }

    public final FF A05(int i) {
        this.A03 = i;
        return this;
    }

    public final FF A06(int i) {
        this.A04 = i;
        return this;
    }

    public final FF A07(G4 g4) {
        this.A05 = g4;
        return this;
    }

    public final FF A08(Map<String, String> requestHeaders) {
        this.A06 = requestHeaders;
        return this;
    }

    public final F9 A09() {
        return new F9(this.A04, this.A00, this.A02, this.A03, this.A01, this.A06, this.A05);
    }
}
