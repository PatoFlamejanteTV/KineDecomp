package com.facebook.ads.redexgen.X;

import android.util.Log;

/* loaded from: assets/audience_network.dex */
public class G0 implements InterfaceC0410Fz {
    public static byte[] A01;
    public final /* synthetic */ C0365Ef A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.G0.A01
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
            int r0 = r0 + (-64)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.G0.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{-18, -22, -23, 29, 12, 17, 13, 22, 11, 13, -10, 13, 28, 31, 23, 26, 19, -13, 2, -15, 3, -8, -17, 3, -8, -7, -11, -4, -12, -55, -30, -39, -20, -28, -39, -41, -24, -39, -40, -108, -39, -26, -26, -29, -26, -94};
    }

    public G0(C0365Ef c0365Ef) {
        this.A00 = c0365Ef;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0410Fz
    public final void A5N(int i, Throwable th) {
        Log.e(A00(0, 17, 104), A00(29, 17, 52), th);
        C0511Kb.A06(this.A00, A00(17, 12, 80), i, new C0514Ke(th));
    }
}
